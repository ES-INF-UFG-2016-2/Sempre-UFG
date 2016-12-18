package br.ufg.inf.sempreufg.db;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class CursUfgEgresTestPostgreSQL {

    private static Connection conexao;
    private static Statement stmt;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        estabelecerConexao();
    }

    public static void estabelecerConexao() throws Exception {
        conexao = ConexaoBanco.getConnection();
        conexao.setAutoCommit(false);
        stmt = conexao.createStatement();
    }

    public static void refazerAlteracoes() throws Exception {
        try {
            conexao.rollback();
        } catch (SQLException e) {
            System.err.println("Erro ao LIMPAR BANCO!");
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

        if (conexao != null) {
            try {
                conexao.close();
                stmt.close();
            } catch (SQLException e) {
                System.err.println("Erro ao ENCERRAR conexao!");
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        refazerAlteracoes();
    }

    private void criarAreaDeConhecimentoQualquer() throws SQLException {
        String item = "('EXATAS', 01)";
        String criaAreaDeConhecimentoQualquer = "INSERT INTO area_conhecimento VALUES " + item + ";";

        stmt.executeUpdate(criaAreaDeConhecimentoQualquer);
    }

    private void criarInstanciaAdministrativaUFGQualquer() throws SQLException {
        String item = "('INSTANCIA', 'nome_instancia', 'REGIONAL', '2016-02-02', NULL, 'email@email.com', 'url.com')";
        String criaInstanciaAdministrativaUFGQualquer = "INSERT INTO instancia_administrativa_ufg VALUES " + item + ";";

        stmt.executeUpdate(criaInstanciaAdministrativaUFGQualquer);
    }

    private void criarLocalizacaoGeograficaQualquer() throws SQLException {
        String item = "(01, 'nome_cidade_qualquer', 'nome_unidade_federativa_qualquer', 'nome_pais_qualquer', 'GO')";
        String criaLocalizacaoGeografica = "INSERT INTO localizacao_geografica VALUES " + item + ";";

        stmt.executeUpdate(criaLocalizacaoGeografica);
    }

    private void criarUnidadeAcademicaRegionalQualquer() throws SQLException {
        String item = "(01, 'regional_qualquer', 01)";
        String criaUnidadeAcademicaRegional = "INSERT INTO regional_ufg VALUES " + item + ";";

        stmt.executeUpdate(criaUnidadeAcademicaRegional);
    }

    private void criarUnidadeAcademicaUFGQualquer() throws SQLException {
        String item = "(01, 'unidade_academica_qualquer', 01, 01)";
        String criaUnidadeAcademicaUFG = "INSERT INTO unidade_academica_ufg VALUES " + item + ";";

        stmt.executeUpdate(criaUnidadeAcademicaUFG);
    }

    private void criarHistoricoUFGQualquer() throws SQLException {
        String item = "(01, 03, 2013, 12, 2016, 'TRABALHO_FINAL', 01, 01)";
        String criaHistoricoUFGQualquer = "INSERT INTO historico_na_ufg VALUES " + item + ";";
        stmt.executeUpdate(criaHistoricoUFGQualquer);
    }

    private void criarEgressoQualquer() throws SQLException {
        String item = "(01, 'nome_egresso', 'nome_mae', '1995-05-03', NULL, NULL, 'Público', 'feminino')";
        String criaEgressoQualquer = "INSERT INTO egresso VALUES " + item + ";";

        stmt.executeUpdate(criaEgressoQualquer);
    }

    private void criarCursoUfgQualquer() throws SQLException {
        String item = "('APERFEICOAMENTO', 'CONSUNI', 01, FALSE, 'VESPERTINO', 01 ,'EXATAS', 01, 'INSTANCIA')";
        String criaCursoUfgQualquer = "INSERT INTO curso_da_ufg VALUES " + item + ";";

        stmt.executeUpdate(criaCursoUfgQualquer);
    }

    private void criarRealizacaoProgramaAcademicoQualquer() throws SQLException {
        String item = "(01, 'Monitoria', '2013-03-01', '2016-12-01', 'descricao_qualquer')";
        String criaRealizacaoDeProgramaAcademicoQualquer = "INSERT INTO realizacao_de_programa_academico VALUES " + item + ";";

        stmt.executeUpdate(criaRealizacaoDeProgramaAcademicoQualquer);
    }

    @Test
    public void testaArmazenaAreaDeConhecimentoQualquer() throws SQLException {
        criarAreaDeConhecimentoQualquer();
        String sql;
        sql = "SELECT * FROM area_conhecimento WHERE nome_area = 'EXATAS' AND codigo_area = 01";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());

    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAreaDeConhecimentoChaveDuplicada() throws SQLException {
        String sql1 = "INSERT INTO area_conhecimento VALUES ('EXATAS',01,01);";
        String sql2 = "INSERT INTO area_conhecimento VALUES ('EXATAS',01,02);";

        stmt.executeUpdate(sql1);
        stmt.executeUpdate(sql2);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAreaDeConhecimentonome_areaNulo() throws SQLException {
        String sql = "INSERT INTO area_conhecimento VALUES (NULL,01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaAltermazenaAreaDeConhecimentonome_areaComCaracteresEspeciais() throws SQLException {
        String sql = "INSERT INTO area_conhecimento VALUES ('HU¬MA¬NA$*',01);";

        stmt.executeUpdate(sql);

        sql = "SELECT * FROM area_conhecimento WHERE nome_area = 'HU¬MA¬NA$*' AND codigo_area = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());

    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAreaDeConhecimentocodigo_areaNulo() throws SQLException {
        String sql = "INSERT INTO area_conhecimento VALUES ('EXATAS', NULL);";
        stmt.executeUpdate(sql);

    }


    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaCursoDaUFGNomeAreaDeConhecimentoNula() throws SQLException {
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();

        String sql = "INSERT INTO curso_da_ufg VALUES ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', NULL, 01, 'INSTANCIA');";
        stmt.executeUpdate(sql);

    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaCursoDaUFGCodigoAreaDeConhecimentoNula() throws SQLException {
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();

        String sql = "INSERT INTO curso_da_ufg VALUES ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', 'nome_area_conhecimento_qualquer', NULL, 'INSTANCIA');";
        stmt.executeUpdate(sql);

    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaCursoDaUFGInstanciaAdministrativaNula() throws SQLException {
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();

        String sql = "INSERT INTO curso_da_ufg VALUES ('Bacharelado', 'CEPEC', 01, TRUE, 'MATUTINO', 01, 'EXATAS', 01, NULL);";
        stmt.executeUpdate(sql);

    }

    @Test
    public void testaArmazenaCursoDaUFGNumeroDaResolucaoNegativo() throws SQLException {
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();

        String sql = "INSERT INTO curso_da_ufg VALUES ('APERFEICOAMENTO', 'CONSUNI', -1, FALSE, 'VESPERTINO', 01 ,'EXATAS', 01, 'INSTANCIA');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaCursoDaUFGNumeroDaResolucaoNulo() throws SQLException {
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();

        String sql = "INSERT INTO curso_da_ufg VALUES ('APERFEICOAMENTO', 'CONSUNI', NULL, FALSE, 'VESPERTINO', 01 ,'EXATAS', 01, 'INSTANCIA');";
        stmt.executeUpdate(sql);

    }

    @Test
    public void testaArmazenaHistoricoUfgQualquer() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "SELECT * FROM historico_na_ufg WHERE numero_matricula_curso = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaHistoricoUfgMatriculaCursoNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (NULL, 03, 2013, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMatriculaCursoNegativa() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (-201355571, 03, 2013, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaHistoricoUfgMesDeInicioNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();


        String sql = "INSERT INTO historico_na_ufg VALUES (201312571, NULL, 2013, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesDeInicioLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (201101571, 01, 2013, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE numero_matricula_curso = 201101571 AND mes_de_inicio = 01 AND ano_de_inicio = 2013 AND mes_de_fim = 12 AND ano_de_fim = 2016 AND titulo_do_trabalho_final = 'TRABALHO FINAL' AND curso = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaHistoricoUfgMesDeInicioLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (201301571, 12, 2013, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE numero_matricula_curso = 201301571 AND mes_de_inicio = 12 AND ano_de_inicio = 2013 AND mes_de_fim = 12 AND ano_de_fim = 2016 AND titulo_do_trabalho_final = 'TRABALHO FINAL' AND curso = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaHistoricoUfgMesDeInicioAbaixoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (202501571, 0, 2013, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesDeInicioAcimaLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (152201000, 13, 2013, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaHistoricoUfgAnoInicioNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (201303271, 01, NULL, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgAnoInicioLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (152201111, 05, 1960, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE numero_matricula_curso = 152201111;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaHistoricoUfgAnoInicioAbaixoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (222201000, 09, 1959, 12, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaHistoricoUfgMesFimNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (222201100, 08, 2000, NULL, 2004, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesFimLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (223201000, 09, 1990, 01, 1994, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesFimLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (224201000, 09, 1996, 12, 1999, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesFimAbaixoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (223404000, 09, 2012, -10, 2016, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesFimAcimaLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (223205000, 10, 2012, 19, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaHistoricoUfgAnoFimNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (223206000, 09, 1980, 01, NULL, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgAnoFimLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (223207000, 09, 1980, 01, 1980, 'TRABALHO FINAL', 01, 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE numero_matricula_curso = 223207000;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaHistoricoUfgTituloTrabalhoFinalNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (223209000, 09, 1980, 01, 1986, NULL, 01, 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE numero_matricula_curso = 223209000 AND mes_de_inicio = 09 AND ano_de_inicio = 1980 AND mes_de_fim = 01 AND ano_de_fim = 1986 AND curso = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaHistoricoUfgTituloTrabalhoFinalEmBranco() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (223210000, 09, 1980, 01, 1980, '', 01, 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE numero_matricula_curso = 223210000;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }


    @Test
    public void testaArmazenaHistoricoUfgCursoNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (223211000, 02, 1990, 01, 1996, 'TRABALHO FINAL', NULL, 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaHistoricoUfgCursoNegativo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO historico_na_ufg VALUES (223007000, 09, 1980, 01, 1980, 'TRABALHO FINAL', -01, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoQualquer() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01, '2016-02-02', 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '2016-02-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    /**
     * NÃO FOI DEFINIDA UMA PRIMARY KEY PARA A TABELA avaliacao_do_curso_pelo_egresso
     *
     * @throws SQLException
     */
    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoHistoricoNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (NULL , '2016-02-02', 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoHistoricoNegativo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (-01 , '2016-02-02', 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoDataAvaliacaoNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (02 , NULL , 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMotivacaoNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (10 , '2016-02-02', NULL, 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMotivacaoInvalida() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '2016-05-02', 'MOTIVACAO INVALIDA', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (10 , '2016-02-02', 'Outra', NULL, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '2016-01-02', 'Outra', 0, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '2016-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 0 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '2016-01-02', 'Outra', 10, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '2016-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 10 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoAbaixoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '2016-01-02', 'Outra', -1, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoAcimaLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '2016-01-02', 'Outra', 12, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '2016-01-02', 'Outra', 8, NULL, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '2016-01-02', 'Outra', 8, 0, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '2016-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 0 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '2016-01-02', 'Outra', 8, 10, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '2016-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 10 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoAbaixoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, -10, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoAcimaLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 15, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, NULL, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, 0, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1995-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 0 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, 10, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1995-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 10 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoAbaixoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, -10, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoAcimaLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, 15, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, 8, NULL, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1990-01-02', 'Outra', 8, 8, 8, 0, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1990-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 0 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1982-01-02', 'Outra', 8, 8, 8, 10, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1982-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 10 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoAbaixoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1981-01-02', 'Outra', 8, 8, 8, -10, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoAcimaLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1990-01-02', 'Outra', 8, 8, 8, 15, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1999-01-02', 'Outra', 8, 8, 8, 8, NULL, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1998-01-02', 'Outra', 8, 8, 8, 8, 0, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1998-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 0 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1997-01-02', 'Outra', 8, 8, 8, 8, 10, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1997-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 10 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeAbaixoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1996-01-02', 'Outra', 8, 8, 8, 8, -10, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeAcimaLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, 8, 8, 15, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1999-01-02', 'Outra', 8, 8, 8, 8, 8, NULL, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1998-01-02', 'Outra', 8, 8, 8, 8, 8, 0, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1998-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 0 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1997-01-02', 'Outra', 8, 8, 8, 8, 8, 10, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1997-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 10 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoAbaixoLimiteInferior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1996-01-02', 'Outra', 8, 8, 8, 8, 8, -10, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoAcimaLimiteSuperior() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, 8, 8, 8, 15, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoComentarioNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();

        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, 8, 8, 8, 8, NULL);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1995-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_curso = 8 AND CONCEITO_GLOBAL_curso = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaRealizacaoDeProgramaAcademicoQualquer() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();
        criarRealizacaoProgramaAcademicoQualquer();

        String sql = "INSERT INTO realizacao_de_programa_academico VALUES (01 , 'Intercambio', '2016-02-01' , '2016-12-01', 'Descricao');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM realizacao_de_programa_academico WHERE HISTORICO = 01 AND TIPO = 'Intercambio' AND DATA_INICIO = '2016-02-01' AND DATA_FIM = '2016-12-01' AND DESCRICAO = 'Descricao';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaRealizacaoDeProgramaAcademicoHistoricoNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();
        criarRealizacaoProgramaAcademicoQualquer();

        String sql = "INSERT INTO realizacao_de_programa_academico VALUES (NULL , 'Monitoria', '2016-08-15' , '2016-09-15', 'Descricao');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaRealizacaoDeProgramaAcademicoTipoNulo() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();
        criarRealizacaoProgramaAcademicoQualquer();

        String sql = "INSERT INTO realizacao_de_programa_academico VALUES (01, NULL, '2016-08-15' , '2016-09-15', 'Descricao');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaRealizacaoDeProgramaAcademicoDataInicioNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();
        criarRealizacaoProgramaAcademicoQualquer();

        String sql = "INSERT INTO realizacao_de_programa_academico VALUES (01, 'Iniciacao_Cientifica', NULL , '2016-09-15', 'Descricao');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaRealizacaoDeProgramaAcademicoDataFimNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();
        criarRealizacaoProgramaAcademicoQualquer();

        String sql = "INSERT INTO realizacao_de_programa_academico VALUES (01, 'Iniciacao_Cientifica', '2016-08-15', NULL, 'Descricao');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = org.postgresql.util.PSQLException.class)
    public void testaArmazenaRealizacaoDeProgramaAcademicoDescricaoNula() throws SQLException {
        criarEgressoQualquer();
        criarAreaDeConhecimentoQualquer();
        criarLocalizacaoGeograficaQualquer();
        criarUnidadeAcademicaRegionalQualquer();
        criarUnidadeAcademicaUFGQualquer();
        criarInstanciaAdministrativaUFGQualquer();
        criarCursoUfgQualquer();
        criarHistoricoUFGQualquer();
        criarRealizacaoProgramaAcademicoQualquer();

        String sql = "INSERT INTO realizacao_de_programa_academico VALUES (20130147, 'Iniciacao_Cientifica', '2016-08-15', '2016-09-15', NULL);";
        stmt.executeUpdate(sql);
    }

}
