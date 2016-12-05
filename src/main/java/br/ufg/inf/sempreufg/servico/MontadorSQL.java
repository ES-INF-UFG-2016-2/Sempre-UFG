package br.ufg.inf.sempreufg.servico;

import java.util.List;

public class MontadorSQL {

    public String montarConsulta(List<String> atributos, String filtroSelecao) {
        String consulta = montadorProjecaoSQL(atributos);
        consulta += "TABLE ";
        consulta += filtroSelecao;
        return consulta;
    }

    private String montadorJoinSQL(String tableName, String primaryKeyProperty, String joinedTable,
                                   String foreignKeyProperty) {
        String joinQuery = "JOIN 'params.tableName' ON " +
            "'params.tableName'.'params.primaryKeyProperty' = 'params.joinedTable'.'params.foreignKeyProperty'";

        joinQuery = joinQuery.replace("'params.tableName'", tableName);
        joinQuery = joinQuery.replace("'params.propertyName'", primaryKeyProperty);
        joinQuery = joinQuery.replace("'params.joinedTable'", joinedTable);
        joinQuery = joinQuery.replace("'params.foreignKeyProperty'", foreignKeyProperty);
        return joinQuery;
    }

    private String montadorProjecaoSQL(List<String> atributos) {
        return "SELECT " + removeColchetes(atributos.toString()) + " FROM ";
    }

    private String removeColchetes(String texto) {
        return texto.replace("[", "").replace("]", "");
    }

}
