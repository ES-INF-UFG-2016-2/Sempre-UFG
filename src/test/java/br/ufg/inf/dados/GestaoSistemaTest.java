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
            executaSqlComStatement("TRUNCATE TABLE PARAMETRO;");
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
    public void testInserirNaTabelaSempreUfgComSucesso() {
        int idUsuario = 123;
        inserirUsuarioTeste(idUsuario);
        boolean inseriuComSucesso;
        try {
            inserirTabelaSempreUFG("Sempre UFG", idUsuario);
            inseriuComSucesso = true;
        } catch (SQLException e) {
            inseriuComSucesso = false;
        }
        Assert.assertTrue(inseriuComSucesso);
    }

    @Test
    public void testInserirNaTabelaSempreUfgComMesmoNomeDeveLancarExcecao() {
        int idUsuario = 123;
        inserirUsuarioTeste(idUsuario);
        boolean lancouExcecao;
        String nomeSistema = "Mesmo nome";
        try {
            inserirTabelaSempreUFG(nomeSistema, idUsuario);
            inserirTabelaSempreUFG(nomeSistema, idUsuario);
            lancouExcecao = true;
        } catch (SQLException e) {
            lancouExcecao = false;
        }
        Assert.assertTrue(lancouExcecao);
    }

    @Test
    public void testInsercaoNaTabelaSempreUFGSemParametrosObrigatoriosLancaExcecao() {
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
    public void testInsercaoNaTabelaSempreUfgComUsuarioInexistenteLancaExcecao() {
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
    public void testInserirNaTabelaSempreUfgComUsuarioNaoExistenteDeveLancarExcecao() {
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
    public void testInserirDoisRegistrosNaTabelaSempreUFGLancaExcecao() {
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

    @Test
    public void testInserirParametroSemRegistroNaTabelaSempreUFG() {
        String sigla = "sigla";
        String nomeSistema = "Sistema não existente";
        String tipo = "Backup";
        String descricao = "Descrição do parâmetro";
        String valor = "Valor do parâmetro";

        boolean lancouExcecao = false;
        try {
            inserirNaTabelaParametro(sigla, nomeSistema, tipo, descricao, valor);
        } catch (SQLException e) {
            lancouExcecao = true;
        }
        Assert.assertTrue(lancouExcecao);
    }

    @Test
    public void testInserirMultiplosParametrosComSucesso() {
        String nomeSistema = "sistema";
        int idUsuario = 123;
        boolean usuarioCadastrado = inserirUsuarioTeste(idUsuario);
        boolean tabelaSempreUfgCriada = inserirTabelaSempreUfgTeste(nomeSistema, idUsuario);

        boolean inseriuParametroComSucesso;
        try {
            inserirNaTabelaParametro("sigla", nomeSistema, "Backup", "Descrição do parâmetro", "Valor do parâmetro");
            inserirNaTabelaParametro("segundo", nomeSistema, "Log", "Descrição do parâmetro", "Valor do parâmetro");
            inseriuParametroComSucesso = true;
        } catch (SQLException e) {
            inseriuParametroComSucesso = false;
        }
        Assert.assertTrue("Erro ao inserir usuário para teste.", usuarioCadastrado);
        Assert.assertTrue("Erro ao inserir na tabela Sempre UFG para teste.", tabelaSempreUfgCriada);
        Assert.assertTrue(inseriuParametroComSucesso);
    }

    @Test
    public void testInserirParametroComTipoInvalidoDeveLancarExcecao() {
        String nomeSistema = "sistema";
        int idUsuario = 123;
        boolean usuarioCadastrado = inserirUsuarioTeste(idUsuario);
        boolean tabelaSempreUfgCriada = inserirTabelaSempreUfgTeste(nomeSistema, idUsuario);

        boolean lancouExcecao;
        String tipoInvalido = "teste";
        try {
            inserirNaTabelaParametro("sigla", nomeSistema, tipoInvalido, "Descrição", "Valor");
            lancouExcecao = false;
        } catch (SQLException e) {
            lancouExcecao = true;
        }
        Assert.assertTrue("Erro ao inserir usuário para teste.", usuarioCadastrado);
        Assert.assertTrue("Erro ao inserir na tabela Sempre UFG para teste.", tabelaSempreUfgCriada);
        Assert.assertTrue("Erro ao inserir parâmetro com tipo inválido.", lancouExcecao);
    }

    @Test
    public void testInserirParametroComIdentificadorJaExistente() {
        String nomeSistema = "sistema";
        int idUsuario = 123;
        boolean usuarioCadastrado = inserirUsuarioTeste(idUsuario);
        boolean tabelaSempreUfgCriada = inserirTabelaSempreUfgTeste(nomeSistema, idUsuario);

        boolean lancouExcecao;
        String sigla = "sigla";
        try {
            inserirNaTabelaParametro(sigla, nomeSistema, "Backup", "Descrição", "Valor");
            inserirNaTabelaParametro(sigla, nomeSistema, "Log", "Outra descrição", "Outro valor");
            lancouExcecao = false;
        } catch (SQLException e) {
            lancouExcecao = true;
        }
        Assert.assertTrue("Erro ao inserir usuário para teste.", usuarioCadastrado);
        Assert.assertTrue("Erro ao inserir na tabela Sempre UFG para teste.", tabelaSempreUfgCriada);
        Assert.assertTrue("Erro ao inserir parâmetro com tipo inválido.", lancouExcecao);
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

    private static boolean inserirTabelaSempreUfgTeste(String nomeSistema, int idUsuario) {
        boolean resultado = false;
        try {
            inserirTabelaSempreUFG(nomeSistema, idUsuario);
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
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

    private static void inserirNaTabelaParametro(String sigla, String nomeSistema, String tipo, String descricao,
                                                 String valor) throws SQLException {
        String inserirParametroSQL = "INSERT INTO PARAMETRO (sigla_parametro, nome_sistema, tipo, descricao_parametro," +
            " valor ) VALUES (?,?,?,?,?);";
        PreparedStatement preparedStatement = conexaoBD.prepareStatement(inserirParametroSQL);
        preparedStatement.setString(1, sigla);
        preparedStatement.setString(2, nomeSistema);
        preparedStatement.setString(3, tipo);
        preparedStatement.setString(4, descricao);
        preparedStatement.setString(5, valor);
        preparedStatement.execute();
    }

    private static boolean inserirUsuarioTeste(int idUsuario) {
        boolean resultado;
        try {
            inserirUsuario(idUsuario, "teste@teste.com", "123", "Usuário de teste", 123456789);
            resultado = true;
        } catch (SQLException e) {
            resultado = false;
        }
        return resultado;
    }

    private static void executaSqlComStatement(String sql) throws SQLException {
        Statement statement = conexaoBD.createStatement();
        statement.executeQuery(sql);
    }

}
