package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.excecoes.ErroNaConsultaException;
import br.ufg.inf.sempreufg.interfaces.ConsultaServicoInterface;
import br.ufg.inf.sempreufg.modelo.Entidade;
import br.ufg.inf.sempreufg.modelo.Linha;
import br.ufg.inf.sempreufg.modelo.Tabela;
import br.ufg.inf.sempreufg.persistencia.GerenciadorPersistencia;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ConsultaServico implements ConsultaServicoInterface {

    @Override
    public Tabela executaConsultaDeEgressosPredefinida(
        int identificador, String filtroSelecao) throws ErroNaConsultaException {
        return null;
    }

    @Override
    public Tabela executaConsultaDeEgressosAdHoc(
        List<String> colunasABuscar, String filtroSelecao) throws ErroNaConsultaException {

        List<String> entidades = buscarEntidadesDasColunas(colunasABuscar);
        MontadorHQL montadorSQL = new MontadorHQL();
        String consulta = montadorSQL.montarConsulta(colunasABuscar, entidades, filtroSelecao);

//        GerenciadorPersistencia.executaQuery(consulta);
        List<Linha> linhas = new ArrayList<>();
        return new Tabela(linhas);
    }

    private List<String> buscarEntidadesDasColunas(List<String> atributos) {
        List<String> entidades = null;
        try {
            EntityManager entityManager = GerenciadorPersistencia.obtenhaEntityManager();
            entidades = entityManager.createQuery("SELECT DISTINCT entidade.nome FROM Entidade AS entidade" +
                " JOIN entidade.atributos AS atributos WHERE atributos.nome IN (:atributos)", String.class)
                .setParameter("atributos", atributos).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entidades;
    }

}
