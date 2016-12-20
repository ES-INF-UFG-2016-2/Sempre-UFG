package br.ufg.inf.sempreufg.db;

import org.junit.After;
import org.junit.BeforeClass;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaEgresDDLTestMariaDB extends MetaEgresDDLTest {

    @BeforeClass
    public static void setupTest() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexaoBD = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sempreufg", "root", "admin");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe do Maria DB não encontrada.");
        } catch (SQLException e) {
            System.out.println("A conexão com o banco de dados falhou.");
        }
    }

    @After
    public void limpaTabelas() {
        try {
            executaSqlComStatement("SET FOREIGN_KEY_CHECKS=0;");
            executaSqlComStatement("TRUNCATE TABLE entidade;");
            executaSqlComStatement("TRUNCATE TABLE atributo;");
            executaSqlComStatement("SET FOREIGN_KEY_CHECKS=1;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
