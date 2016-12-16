package br.ufg.inf.sempreufg.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public abstract class DDLEspecification {


    protected static Connection conexaoBD;

    /* Este método deveria estar em uma super classe geral para os testes de DDL */
    protected void executaSqlComStatement(String sql) throws SQLException {
        Statement statement = conexaoBD.createStatement();
        statement.execute(sql);
    }

    /* Este método deveria estar em uma super classe geral para os testes de DDL */
    protected static boolean verificaSeTabelaExiste(String nomeTabela) {
        boolean tabelaExiste = false;
        try {
            String query = "SELECT * FROM " + nomeTabela;
            Statement statement = conexaoBD.createStatement();
            statement.executeQuery(query);
            tabelaExiste = true;
        } catch (SQLSyntaxErrorException sql) {
            System.out.println("A tabela não existe.");
            sql.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao executar comando.");
            e.printStackTrace();
        }
        return tabelaExiste;
    }
}
