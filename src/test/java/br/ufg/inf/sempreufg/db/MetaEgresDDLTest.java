package br.ufg.inf.sempreufg.db;

import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class MetaEgresDDLTest extends DDLEspecification {

    @Test
    public void testaConexaoComMariaDB() {
        assertNotNull(conexaoBD);
    }

    @Test
    public void testaSeTabelaEntidadeExiste() {
        boolean tabelaExiste = verificaSeTabelaExiste("entidade");
        assertTrue(tabelaExiste);
    }

    @Test
    public void testaSeTabelaAtributoExiste() {
        boolean tabelaExiste = verificaSeTabelaExiste("atributo");
        assertTrue(tabelaExiste);
    }

    @Test
    public void testInserirNaTabelaEntidadeSemSucessoraComSucesso() {
        boolean resultado = false;

        try {
            inserirNaTabelaEntidadeSemSucessora("nomeEntidade", "id", "titoloQuestoes", "tituloCampos");
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    @Test
    public void testInserirNaTabelaInserirMultiplosAtributosNaEntidadeComSucesso() {
        boolean resultado = false;
        String nomeEntidade = "nomeEntidade";
        String nomeAtributo = "atributo1";
        try {
            inserirNaTabelaEntidadeSemSucessora(nomeEntidade, "id", "titoloQuestoes", "tituloCampos");
            inserirAtributoSemSucessorPadrao(nomeAtributo, nomeEntidade);
            inserirAtributoComSucessorPadrao("segundo Atributo", nomeEntidade, nomeAtributo);
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    @Test
    public void testInserirNaTabelaDuasEntidadesSemSucessoraDeveLancarExcecao() {
        boolean resultado = false;
        try {
            inserirEntidadeSemSucessoraPadrao("entidade1");
            inserirEntidadeSemSucessoraPadrao("entidade2");
        } catch (SQLException e) {
            resultado = true;
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    @Test
    public void testInserirNaTabelaEntidadeComMesmoIdentificadorDeveLancarExcecao() {
        boolean resultado = false;
        String nomeEntidade = "entidade";
        try {
            inserirEntidadeSemSucessoraPadrao(nomeEntidade);
            inserirEntidadeComSucessoraPadrao(nomeEntidade, nomeEntidade);
        } catch (SQLException e) {
            resultado = true;
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    @Test
    public void testInsercaoNaTabelaEntidadeSemCamposObrigatoriosELancaExcecao() {
        boolean resultado = false;
        try {
            executaSqlComStatement("INSERT INTO entidade (nome_entidade, id_interno, titulo_grupo_questoes," +
                "titulo_grupo_campos, entidade_sucessora) VALUES (null, null, null, null, null)");
        } catch (SQLException e) {
            resultado = true;
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    @Test
    public void testInserirAgrupamentoNaTabelaEntidade() {
        //Relacionamento de agrupamento não implementado
        assertTrue(false);
    }

    @Test
    public void testInserirNaTabelaAtributoComEntidadeInexistenteDeveLancarExcecao() {
        boolean resultado = false;
        String nomeEntidade = "Entidade";
        try {
            inserirAtributoSemSucessor("Nome", "Id_Interno", "Título Questão", "Título Campo", nomeEntidade);
        } catch (SQLException e) {
            resultado = true;
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    @Test
    public void testInserirNaTabelaAtributoSemSucessorComSucesso() {
        boolean resultado = false;
        String nomeEntidade = "Entidade";
        try {
            inserirEntidadeSemSucessoraPadrao(nomeEntidade);
            inserirAtributoSemSucessor("Nome", "Id_Interno", "Título Questão", "Título Campo", nomeEntidade);
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    @Test
    public void testInserirNaTabelaDoisAtributosSemSucessorParaMesmaEntidadeDeveLancarExcecao() {
        boolean resultado = false;
        String nomeEntidade = "entidade";
        try {
            inserirEntidadeSemSucessoraPadrao(nomeEntidade);
            inserirAtributoSemSucessor("Primeiro Atributo", "Id_Interno", "Título Questão", "Título Campo", nomeEntidade);
            inserirAtributoSemSucessor("Segundo Atributo", "Id_Interno", "Título Questão", "Título Campo", nomeEntidade);
        } catch (SQLException e) {
            resultado = true;
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    @Test
    public void testInserirNaTabelaAtributoComMesmoIdentificadorDeveLancarExcecao() {
        boolean resultado = false;
        String nomeAtributo = "Mesmo nome";
        try {
            inserirAtributoSemSucessor(nomeAtributo, "Id_Interno", "Título Questão", "Título Campo", "");
            inserirAtributoSemSucessor(nomeAtributo, "Id_Interno", "Título Questão", "Título Campo", "");
        } catch (SQLException e) {
            resultado = true;
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    @Test
    public void testInsercaoNaTabelaAtributoComAtributoDesviandoParaOutroComSucesso() {
        //Tabela desvia para não foi criada
        assertTrue(false);
    }

    @Test
    public void testInsercaoNaTabelaAtributoSemCamposObrigatoriosELancaExcecao() {
        boolean resultado = false;
        try {
            executaSqlComStatement("INSERT INTO atributo (" +
                "nome_atributo, identificador_interno, titulo_da_questao, titulo_do_campo,atributo_sucessor, nome_entidade)" +
                "VALUES (null,null,'tituloQuestoes','tituloCampos','atributo1','nomeEntidade');");
        } catch (SQLException e) {
            resultado = true;
            e.printStackTrace();
        }
        assertTrue(resultado);
    }

    private PreparedStatement montaPreparedStatamentDaEntidade(String nomeEntidade, String idInterno, String tituloGrupoQuestoes,
                                                               String tituloGrupoCampos) throws SQLException {
        String inserirEntidade = "INSERT INTO entidade (nome_entidade, id_interno, titulo_grupo_questoes," +
            " titulo_grupo_campos, entidade_sucessora) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = conexaoBD.prepareStatement(inserirEntidade);
        preparedStatement.setString(1, nomeEntidade);
        preparedStatement.setString(2, idInterno);
        preparedStatement.setString(3, tituloGrupoQuestoes);
        preparedStatement.setString(4, tituloGrupoCampos);
        return preparedStatement;
    }

    private void inserirNaTabelaEntidadeSemSucessora(String nomeEntidade, String idInterno, String tituloGrupoQuestoes,
                                                     String tituloGrupoCampos) throws SQLException {
        PreparedStatement preparedStatement = montaPreparedStatamentDaEntidade(nomeEntidade, idInterno,
            tituloGrupoQuestoes, tituloGrupoCampos);
        preparedStatement.setNull(5, 0);
        preparedStatement.execute();
    }

    private void inserirNaTabelaEntidadeComSucessora(String nomeEntidade, String idInterno, String tituloGrupoQuestoes,
                                                     String tituloGrupoCampos, String nomeEntidadeSucessora) throws SQLException {
        PreparedStatement preparedStatement = montaPreparedStatamentDaEntidade(nomeEntidade, idInterno,
            tituloGrupoQuestoes, tituloGrupoCampos);
        preparedStatement.setString(5, nomeEntidadeSucessora);
        preparedStatement.execute();
    }

    private void inserirEntidadeSemSucessoraPadrao(String nomeEntidade) throws SQLException {
        inserirNaTabelaEntidadeSemSucessora(nomeEntidade, "id", "titulo_questoes", "titulo_campos");
    }

    private void inserirEntidadeComSucessoraPadrao(String nomeEntidade, String nomeEntidadeSucessora) throws SQLException {
        inserirNaTabelaEntidadeComSucessora(nomeEntidade, "id", "titulo_questoes", "titulo_campos", nomeEntidadeSucessora);
    }

    private PreparedStatement montaPreparedStatamentDoAtributo(String nomeAtributo, String idInterno, String tituloQuestao, String tituloCampo,
                                                               String nomeEntidade) throws SQLException {
        String inserirAtributo = "INSERT INTO atributo (nome_atributo, identificador_interno, titulo_da_questao, titulo_do_campo," +
            "atributo_sucessor, nome_entidade) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = conexaoBD.prepareStatement(inserirAtributo);
        preparedStatement.setString(1, nomeAtributo);
        preparedStatement.setString(2, idInterno);
        preparedStatement.setString(3, tituloQuestao);
        preparedStatement.setString(4, tituloCampo);
        preparedStatement.setString(6, nomeEntidade);
        return preparedStatement;
    }

    private void inserirAtributoSemSucessor(String nomeAtributo, String idInterno, String tituloQuestao, String tituloCampo,
                                            String nomeEntidade) throws SQLException {
        PreparedStatement preparedStatement = montaPreparedStatamentDoAtributo(nomeAtributo, idInterno, tituloQuestao, tituloCampo,
            nomeEntidade);
        preparedStatement.setNull(5, 0);
        preparedStatement.execute();
    }

    private void inserirAtributoComSucessor(String nomeAtributo, String idInterno, String tituloQuestao, String tituloCampo,
                                            String nomeEntidade, String nomeAtributoSucessor) throws SQLException {
        PreparedStatement preparedStatement = montaPreparedStatamentDoAtributo(nomeAtributo, idInterno, tituloQuestao, tituloCampo,
            nomeEntidade);
        preparedStatement.setString(5, nomeAtributoSucessor);
        preparedStatement.execute();
    }

    private void inserirAtributoSemSucessorPadrao(String nomeAtributo, String nomeEntidade) throws SQLException {
        inserirAtributoSemSucessor(nomeAtributo, "idInterno", "tituloQuestoes", "tituloCampos", nomeEntidade);
    }

    private void inserirAtributoComSucessorPadrao(String nomeAtributo, String nomeEntidade,
                                                  String nomeAtributoSucessor) throws SQLException {
        inserirAtributoComSucessor(nomeAtributo, "idInterno", "tituloQuestoes", "tituloCampos",
            nomeEntidade, nomeAtributoSucessor);
    }
}
