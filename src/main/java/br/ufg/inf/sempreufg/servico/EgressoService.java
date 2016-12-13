package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.dao.EgressoDAO;
import br.ufg.inf.sempreufg.enums.NomeCampos;
import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;


public class EgressoService implements EgressoServiceInterface {

    static EgressoDAO egressoDAO;

    @Override
    public void atualizarEgresso(Egresso egresso) {
        egressoDAO = new EgressoDAO();
        egressoDAO.atualizar(egresso);
    }

    @Override
    public Egresso getEgresso(int id) {
        egressoDAO = new EgressoDAO();
        Egresso egresso = null;
        try {
            egresso = egressoDAO.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return egresso;
    }

    @Override
    public void removerEgresso(int id) throws Exception {
        try {
            egressoDAO = new EgressoDAO();
            egressoDAO.deletar(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível remover o Egresso!");
        }
    }

    @Override
    public Egresso converterXmlParaEgresso(InputStream content) {
        Egresso egresso = new Egresso();
        return egresso;
    }

    @Override
    public boolean egressoEValido(Egresso egresso) {
        return false;
    }

    @Override
    public List<Egresso> buscarDadosEgressoViaWebService() {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> buscarDadosEgressoPeloPeriodoConclusaoCurso(Date dataInicial, Date dataFinal) {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> buscarDadosEgressoPeloIdentificadorEgresso(List<Integer> identificadores) {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> buscarDadosEgressoPeloCurso(List<Integer> identificadores) {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> buscarDadosEgressoPelaUnidadeAcademica(List<Integer> identificadores) {
        return criarListaEgressoMock();
    }

    public List<Egresso> criarListaEgressoMock() {
        List<Egresso> egressos = new ArrayList<Egresso>();

        for (int i = 0; i < 10; i++) {
            Egresso egresso = new Egresso("Everton Jose",
                "Maria",
                new Date(),
                Sexo.MASCULINO,
                "emailAlternativo@gmail.com",
                new BitSet(),
                new BitSet(),
                VisibilidadeDados.PUBLICO,
                new ArrayList<HistoricoUFG>(),
                new LocalizacaoGeografica());
            egressos.add(egresso);
        }

        return egressos;
    }

    @Override
    public List<Egresso> consultarEgressoPorConsultaPreDefinida(String string) {
        return new ExecultarConsultasMock().criarListaEgresso();
    }

    @Override
    public List<Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros) {
        return new ExecultarConsultasMock().criarListaEgresso();
    }

}
