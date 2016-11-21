package java.br.ufg.inf.db;;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaEgresDDLTestMariaDB {

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
            executaSqlComStatement("TRUNCATE TABLE ENTIDADE;");
            executaSqlComStatement("TRUNCATE TABLE ATRIBUTO;");
            executaSqlComStatement("TRUNCATE TABLE DESVIARPARA;");
            executaSqlComStatement("SET FOREIGN_KEY_CHECKS=1;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaConexaoComMariaDB() {
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
