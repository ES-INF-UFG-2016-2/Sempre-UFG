package br.ufg.inf.db;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaEgresDDLTestPostgres {

    private static Connection conexaoBD;

    @BeforeClass
    public static void setupTest() {
        try {
            Class.forName("org.postgresql.Driver");
            conexaoBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/sempreUFG", "root", "admin");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe do Postgres não encontrada.");
        } catch (SQLException e) {
            System.out.println("A conexão com o banco de dados falhou.");
        }
    }

    @After
    public void limpaTabelas() {

    }

    @Test
    public void testaConexaoComPostgres() {
        Assert.assertNotNull(conexaoBD);
    }

    @Test
    public void testaSeTabelaEntidadeExiste() {

    }

    @Test
    public void testaSeTabelaAtributoExiste() {

    }

    @Test
    public void testInserirNaTabelaEntidadeComSucesso() {

    }

    @Test
    public void testInserirNaTabelaEntidadeComMesmoIdentificadorDeveLancarExcecao() {

    }

    @Test
    public void testInsercaoNaTabelaEntidadeSemCamposObrigatoriosELancaExcecao() {

    }

    @Test
    public void testBuscaEntidadeInexistenteELancaExcecao() {

    }

    @Test
    public void testInserirMultiplosDadosComSucessoNaTabelaEntidade() {

    }

    @Test
    public void testInserirDadoComTipoInvalidoDeveLancarExcecaoNaTebalaEntidade() {

    }

    @Test
    public void testInserirDadoComIdentificadorJaExistenteNaTabelaEntidade() {

    }

    @Test
    public void testInserirNaTabelaAtributoComSucesso() {

    }

    @Test
    public void testInserirNaTabelaAtributoComMesmoIdentificadorDeveLancarExcecao() {

    }

    @Test
    public void testInsercaoNaTabelaAtributoSemCamposObrigatoriosELancaExcecao() {

    }

    @Test
    public void testBuscaAtributoInexistenteELancaExcecao() {

    }

    @Test
    public void testInserirMultiplosDadosComSucessoNaTabelaAtributo() {

    }

    @Test
    public void testInserirDadoComTipoInvalidoDeveLancarExcecaoNaTebalaAtributo() {

    }

    @Test
    public void testInserirDadoComIdentificadorJaExistenteNaTabelaAtributo() {

    }

    private static boolean verificaSeTabelaExiste(String nomeTabela) {
        return true;
    }

    private static void inserirNaTabelaAtributo(int idUsuario, String email, String senha, String nomeSocial, int CPF) throws SQLException {

    }

    private static void inserirNaTabelaEntidade(String sigla, String nomeSistema, String tipo, String descricao,
                                                String valor) throws SQLException {

    }


    private static void executaSqlComStatement(String sql) throws SQLException {

    }
}
