package br.ufg.inf.dados;

import ch.unibe.jexample.Given;
import org.junit.After;
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
        } catch (SQLException e) {
            System.out.println("A conexão com o banco de dados falhou.");
        }
    }

    @After
    public void limpaTabelas() {
        try {
            executaSqlComStatement("TRUNCATE TABLE SempreUFG");
        } catch (SQLException e) {
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

    @Test
    public void testaInsercaoNaTabelaSempreUFGSemParametrosObrigatoriosLancaExcecao() {
        String queryInserirSempreUFG = "INSERT INTO SempreUFG (nome_sistema) VALUES(?);";
        boolean lancouExcecao = false;
        try {
            PreparedStatement preparedStatement = conexaoBD.prepareStatement(queryInserirSempreUFG);
            preparedStatement.setString(1, "Nome do sistema teste");
            preparedStatement.execute();
        } catch (SQLException e) {
            lancouExcecao = true;
        }
        Assert.assertTrue(lancouExcecao);
    }

    @Test
    public void testaInsercaoNaTabelaSempreUfgComUsuarioInexistenteLancaExcecao() {
        String queryInserirSempreUFG = "INSERT INTO SempreUFG (nome_sistema, timestamp_isstalacao, id_Usuario) " +
            "VALUES('Sempre UFG', now(), 123);";

        boolean lancouExcecao = false;
        try {
            executaSqlComStatement(queryInserirSempreUFG);
        } catch (SQLException e) {
            lancouExcecao = true;
            e.printStackTrace();
        }
        Assert.assertTrue(lancouExcecao);
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

    private static void executaSqlComStatement(String sql) throws SQLException {
        Statement statement = conexaoBD.createStatement();
        statement.executeQuery(sql);
    }

}
