package br.ufg.inf.dados;

import ch.unibe.jexample.Given;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

public class GestaoSistemaTest {

    private static Connection conexaoBD;

    @BeforeClass
    public static void setupTest() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexaoBD = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sempreufg", "root", "admin");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe do Maria DB não encontrada.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("A conexão com o banco de dados falhou.");
            e.printStackTrace();
        }
    }

    @Test
    public void testaConexaoComBancoDeDados() {
        Assert.assertNotNull(conexaoBD);
    }

    @Given("testaConexaoComBancoDeDados")
    @Test
    public void testaSeTabelaSempreUFGExiste() {
        boolean tabelaExiste = verificaSeTabelaExiste("SempreUFG");
        Assert.assertTrue(tabelaExiste);
    }

    @Given("testaConexaoComBancoDeDados")
    @Test
    public void testaSeTabelaParametroExiste() {
        boolean tabelaExiste = verificaSeTabelaExiste("Parametro");
        Assert.assertTrue(tabelaExiste);
    }

    @Given("testaConexaoComBancoDeDados")
    @Test
    public void testaSeTabelaBackupExiste() {
        boolean tabelaExiste = verificaSeTabelaExiste("Backup");
        Assert.assertTrue(tabelaExiste);
    }

    @Given("testaConexaoComBancoDeDados")
    @Test
    public void testaSeTabelaRestauracaoExiste() {
        boolean tabelaExiste = verificaSeTabelaExiste("Restauracao");
        Assert.assertTrue(tabelaExiste);
    }


    private static boolean verificaSeTabelaExiste(String nomeTabela) {
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
