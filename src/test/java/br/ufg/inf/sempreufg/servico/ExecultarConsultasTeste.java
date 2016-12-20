package br.ufg.inf.sempreufg.servico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.ufg.inf.sempreufg.dao.ConnectionFactory;
import br.ufg.inf.sempreufg.dao.EgressoDAO;
import br.ufg.inf.sempreufg.enums.NomeCampos;
import br.ufg.inf.sempreufg.interfaces.EgressoDAOInterface;

import br.ufg.inf.sempreufg.modelo.Egresso;

public class ExecultarConsultasTeste {

    @Test
    public void testaConsultaPorAdHocDiretoDao() {
        try {
            Connection con = new ConnectionFactory().getConnection();

            Map<NomeCampos, String> adHocPreDefinido = criarParametrosAdHoc();
            StringBuilder sql = criarSqlQueryDeAcordoComMapAdHoc(adHocPreDefinido);

            EgressoDAOInterface<Egresso> egressoDao = new EgressoDAO();
            List<Egresso> egressos = egressoDao.select(sql.toString());

            List<Egresso> egressosTeste = realizarConsulta(sql.toString());
            Assert.assertTrue(listasSaoIguais(egressos, egressosTeste));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaConsultaPorAdHocPorServico() {
        try {
            Connection con = new ConnectionFactory().getConnection();

            Map<NomeCampos, String> adHocPreDefinido = criarParametrosAdHoc();
            StringBuilder sql = criarSqlQueryDeAcordoComMapAdHoc(adHocPreDefinido);

            EgressoServiceInterface egressoService = new EgressoService();
            List<Egresso> egressos = egressoService.consultaPorAdHoc(adHocPreDefinido);

            List<Egresso> egressosTeste = realizarConsulta(sql.toString());
            Assert.assertTrue(listasSaoIguais(egressos, egressosTeste));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testeConsultarPorConsultaPreDefinidaDiretoDao() {
        StringBuilder sql = new StringBuilder();
        ConsultaPreDefinidaService consultaPreDefinida = new ConsultaPreDefinidaService();
        String consulta = consultaPreDefinida.obterConsultaPreDefinida();
        sql.append(consulta);

        EgressoDAOInterface<Egresso> egressoDao = new EgressoDAO();
        List<Egresso> egressos = egressoDao.select(sql.toString());

        List<Egresso> egressosTeste = realizarConsulta(sql.toString());
        Assert.assertTrue(listasSaoIguais(egressos, egressosTeste));
    }

    @Test
    public void testeConsultarPorConsultaPreDefinidaPorSerico() {
        StringBuilder sql = new StringBuilder();
        ConsultaPreDefinidaService consultaPreDefinida = new ConsultaPreDefinidaService();
        String consulta = consultaPreDefinida.obterConsultaPreDefinida();
        sql.append(consulta);

        EgressoServiceInterface egressoService = new EgressoService();
        List<Egresso> egressos = egressoService.consultarEgressoPorConsultaPreDefinida(sql.toString());

        List<Egresso> egressosTeste = realizarConsulta(sql.toString());
        Assert.assertTrue(listasSaoIguais(egressos, egressosTeste));
    }

    private List<Egresso> realizarConsulta(String string) {
        return new ExecultarConsultasMock().criarListaEgresso();
    }

    public boolean listasSaoIguais(List<Egresso> consulta, List<Egresso> consultaTeste) {
        int i = 0;
        for (i = 0; i < consultaTeste.size(); i++) {
            Long cpf = consultaTeste.get(i).getCpf();
            if (!consulta.stream().anyMatch(x -> x.getCpf() == cpf)) {
                return false;
            }
        }
        return true;
    }

    private StringBuilder criarSqlQueryDeAcordoComMapAdHoc(Map<NomeCampos, String> adHocPreDefinido) {
        StringBuilder sql = new StringBuilder();
        sql.append("Select ");

        String query = criarStringSelect(adHocPreDefinido);
        sql.append(query);

        sql.append(" where 1=1 ");
        query = juntarClausulasAnd(adHocPreDefinido);
        sql.append(query);

        return sql;
    }

    public String criarStringSelect(Map<NomeCampos, String> adHocPreDefinido) {
        String query = "";

        for (Map.Entry<NomeCampos, String> adhoc : adHocPreDefinido.entrySet()) {
            query = query + (adhoc.getKey().toString() + ", ");
        }

        return query.substring(0, (query.length() - 2));
    }

    public String juntarClausulasAnd(Map<NomeCampos, String> parametros) {
        String query = "";
        for (Map.Entry<NomeCampos, String> adhoc : parametros.entrySet()) {
            if (!adhoc.getValue().toString().isEmpty()) {
                String and = criarClausulaAndUnica(adhoc.getKey().toString(), adhoc.getValue());
                query = query + and;
            }
        }

        return query;
    }

    public String criarClausulaAndUnica(String nomeCampo, String parametros) {
        String and = "";
        String itens = quebrarStringParaClausulaIn(parametros);
        and = and + ("and " + nomeCampo + " in ( " + itens + ") ");

        return and;
    }

    public String quebrarStringParaClausulaIn(String valores) {
        String[] params = valores.split(";");

        String itens = "";
        for (String param : params) {
            itens = itens + param + ",";
        }
        return itens.substring(0, itens.length() - 1);
    }

    public Map<NomeCampos, String> criarParametrosAdHoc() {
        Map<NomeCampos, String> adHocPreDefinido = new HashMap<NomeCampos, String>();
        adHocPreDefinido.put(NomeCampos.NOME, "Rodrigo;Rafael;Ricardo;Vanessa;Paula;Leticia;Bruna");
        adHocPreDefinido.put(NomeCampos.CPF, "");
        adHocPreDefinido.put(NomeCampos.CURSO, "Engenharia de Software;Ciencias Contabeis");

        return adHocPreDefinido;
    }
}
