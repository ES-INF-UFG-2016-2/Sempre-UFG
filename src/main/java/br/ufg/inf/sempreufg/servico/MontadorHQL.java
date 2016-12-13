package br.ufg.inf.sempreufg.servico;

import java.util.List;

public class MontadorHQL {

    public String montarConsulta(List<String> atributos, List<String> entidades, String filtroSelecao) {
        String consultaHQL = montadorProjecao(atributos) +
            montadorEntidades(entidades) + montadorClausulaWhere(filtroSelecao);
        return consultaHQL;
    }

    private String montadorProjecao(List<String> atributos) {
        return "SELECT " + removeColchetes(atributos.toString()) + " FROM ";
    }

    private String montadorEntidades(List<String> entidades) {
        return removeColchetes(entidades.toString());
    }

    private String montadorClausulaWhere(String filtroSelecao) {
        return " WHERE " + filtroSelecao;
    }

    private String removeColchetes(String texto) {
        return texto.replace("[", "").replace("]", "");
    }
}
