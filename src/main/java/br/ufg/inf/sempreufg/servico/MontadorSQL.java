package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.AtributoDaTabela;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MontadorSQL {

    private static Map<String, String> clausulaWherePorEntidade = new HashMap<>();
    private static Map<String, AtributoDaTabela> campoPorAtributoDaTabela = new HashMap<>();

    /* FIXME: Atualmente a estrutura espera que o front-end envie uma lista de campos, por exemplo nome_do_curso,
    *  para que possamos identificar quais são os joins necessários para concluir a busca.
    *  A ideia de melhoria seria substituir o mapa que está fixo por uma busca e montagem dinâmica dos joins
    *  necessários para a consulta.
    *
    * */

    MontadorSQL() {
        clausulaWherePorEntidade.put("nome_do_curso", " join historico_na_ufg on historico_na_ufg.id_egresso = egresso.id" +
            " join curso_da_ufg on historico_na_ufg.curso = curso_da_ufg.numero_da_resolucao" +
            " join instancia_administrativa_ufg on curso_da_ufg.instancia_administrativa = instancia_administrativa_ufg.sigla_instancia");
        AtributoDaTabela atributoDaTabela = new AtributoDaTabela("instancia_administrativa_ufg", "nome");
        campoPorAtributoDaTabela.put("nome_do_curso", atributoDaTabela);
    }

    String montarConsulta(List<String> campos, String filtroSelecao) {
        String atributos = obtenhaAtributos(campos);
        StringBuilder consulta = new StringBuilder();
        consulta.append(montarProjecaoSQL(atributos));
        consulta.append(montarSelecaoSQL());
        consulta.append(montarJoinSQL(campos));
        consulta.append(adicionarClausulaAnd(filtroSelecao));
        return consulta.toString();
    }

    private String obtenhaAtributos(List<String> campos) {
        List<String> atributos = new ArrayList<>();
        for (String campo : campos) {
            AtributoDaTabela atributoDaTabela = campoPorAtributoDaTabela.get(campo);
            atributos.add(atributoDaTabela.toString());
        }
        return removeColchetes(atributos.toString());
    }

    private String montarJoinSQL(List<String> entidades) {
        StringBuilder clauseWhere = new StringBuilder();
        for (String entidade : entidades) {
            clauseWhere.append(clausulaWherePorEntidade.get(entidade));
        }
        return clauseWhere.toString();
    }

    private String montarProjecaoSQL(String atributos) {
        return "SELECT " + atributos;
    }

    private String montarSelecaoSQL() {
        return " from egresso ";
    }

    private String adicionarClausulaAnd(String clausula) {
        return " AND (" + clausula + ")";
    }

    private String removeColchetes(String texto) {
        return texto.replace("[", "").replace("]", "");
    }
}
