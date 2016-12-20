package br.ufg.inf.sempreufg.db;

import org.junit.After;
import org.junit.BeforeClass;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaEgresDDLTestPostgres extends MetaEgresDDLTest {

    @BeforeClass
    public static void setupTest() {
        try {
            Class.forName("org.postgresql.Driver");
            conexaoBD = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sempreufg", "root", "admin");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe do Postgres não encontrada.");
        } catch (SQLException e) {
            System.out.println("A conexão com o banco de dados falhou.");
        }
    }

    @After
    public void limpaTabelas() {
        try {
            executaSqlComStatement("TRUNCATE TABLE entidade CASCADE;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
