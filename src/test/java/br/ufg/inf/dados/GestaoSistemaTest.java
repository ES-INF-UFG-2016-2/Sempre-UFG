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
            executaSqlComStatement("SET FOREIGN_KEY_CHECKS=0;");
            executaSqlComStatement("TRUNCATE TABLE SEMPREUFG;");
            executaSqlComStatement("TRUNCATE TABLE USUARIO;");
            executaSqlComStatement("SET FOREIGN_KEY_CHECKS=1;");
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
        boolean tabelaExiste = verificaSeTabelaExiste("SEMPREUFG");
        Assert.assertTrue(tabelaExiste);
    }

    @Given("testaConexaoComBancoDeDados")
    @Test
    public void testaSeTabelaParametroExiste() {
        boolean tabelaExiste = verificaSeTabelaExiste("PARAMETRO");
        Assert.assertTrue(tabelaExiste);
    }

    @Given("testaConexaoComBancoDeDados")
    @Test
    public void testaSeTabelaBackupExiste() {
        boolean tabelaExiste = verificaSeTabelaExiste("BACKUP");
        Assert.assertTrue(tabelaExiste);
    }

    @Given("testaConexaoComBancoDeDados")
    @Test
    public void testaSeTabelaRestauracaoExiste() {
        boolean tabelaExiste = verificaSeTabelaExiste("RESTAURACAO");
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
        String queryInserirSempreUFG = "INSERT INTO SEMPREUFG (nome_sistema, timestamp_isstalacao, id_Usuario) " +
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

    @Given("testaSeTabelaSempreUFGExiste")
    @Test
    public void testaInserirNaTabelaSempreUfgComUsuarioNaoExistenteDeveLancarExcecao() {
        boolean lancouExcecao = false;
        try {
            inserirTabelaSempreUFG("Sempre UFG", 12345);
        } catch (SQLException e) {
            lancouExcecao = true;
            e.printStackTrace();
        }
        Assert.assertTrue(lancouExcecao);
    }

    @Given("testaSeTabelaSempreUFGExiste")
    @Test
    public void testaInserirDoisRegistrosNaTabelaSempreUFGLancaExcecao() {
        int idUsuario = 1234567;
        boolean usuarioCadastradoComSucesso;
        try {
            inserirUsuario(idUsuario, "teste1@teste.com", "1234", "Usuário Teste 1", 123456789);
            usuarioCadastradoComSucesso = true;
        } catch (SQLException e) {
            usuarioCadastradoComSucesso = false;
        }

        boolean lancouExcecao = false;
        try {
            inserirTabelaSempreUFG("SempreUFG", idUsuario);
            inserirTabelaSempreUFG("Segundo Sistema", idUsuario);
        } catch (SQLException e) {
            lancouExcecao = true;
            e.printStackTrace();
        }
        Assert.assertTrue("Erro ao cadastrar usuário", usuarioCadastradoComSucesso);
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

    private static void inserirTabelaSempreUFG(String nomeSistema, int idUsuario) throws SQLException {
        String queryInserirSempreUFG = "INSERT INTO SEMPREUFG (nome_sistema, timestamp_isstalacao, id_Usuario) " +
            "VALUES(?,?,?);";
        PreparedStatement preparedStatement = conexaoBD.prepareStatement(queryInserirSempreUFG);
        preparedStatement.setString(1, nomeSistema);
        preparedStatement.setDate(2, new Date(1));
        preparedStatement.setInt(3, idUsuario);
        preparedStatement.execute();
    }

    private static void inserirUsuario(int idUsuario, String email, String senha, String nomeSocial, int CPF) throws SQLException {
        String inserirUsuarioSQL = "insert into USUARIO (idUsuario, email_principal,  senha,  nome_social,  CPF," +
            "  recebe_divulgacao, timestamp_cadastramento) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conexaoBD.prepareStatement(inserirUsuarioSQL);
        preparedStatement.setInt(1, idUsuario);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, senha);
        preparedStatement.setString(4, nomeSocial);
        preparedStatement.setInt(5, CPF);
        preparedStatement.setString(6, "mensal");
        preparedStatement.setDate(7, new Date(1));
        preparedStatement.execute();

    }

    private static void executaSqlComStatement(String sql) throws SQLException {
        Statement statement = conexaoBD.createStatement();
        statement.executeQuery(sql);
    }

}
