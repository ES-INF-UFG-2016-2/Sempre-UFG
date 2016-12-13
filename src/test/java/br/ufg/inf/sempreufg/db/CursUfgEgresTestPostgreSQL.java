package br.ufg.inf.sempreufg.db;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class CursUfgEgresTestPostgreSQL{

    private static String sysBar = System.getProperty("file.separator");
    private static String DDLPath = "db" + sysBar + "postgres" + sysBar + "ddl" + sysBar + "RD-CursUfgEgres.sql";
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

    @After
    public void tearDown() throws Exception {
        refazerAlteracoes();
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

    @Test
    public void testaArmazenaAreaDeConhecimentoQualquer() throws SQLException {
        String item = "('EXATAS', 01, 01)";
        String sql = "INSERT INTO area_conhecimento VALUES " + item + ";";

        stmt.executeUpdate(sql);

        sql = "SELECT * FROM area_conhecimento WHERE NOME = 'EXATAS' AND CODIGO = 01 AND SUPER_AREA = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());

    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAreaDeConhecimentoChaveDuplicada() throws SQLException {
        String sql1 = "INSERT INTO area_conhecimento VALUES ('EXATAS',01,01);";
        String sql2 = "INSERT INTO area_conhecimento VALUES ('HUMANAS',01,02);";

        stmt.executeUpdate(sql1);
        stmt.executeUpdate(sql2);
    }

    @Test(expected = SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAreaDeConhecimentoNomeNulo() throws SQLException {
        String sql = "INSERT INTO area_conhecimento VALUES (NULL,01,01);";

        stmt.executeUpdate(sql);

    }

    @Test
    public void testaAltermazenaAreaDeConhecimentoNomeComCaracteresEspeciais() throws SQLException {
        String sql = "INSERT INTO area_conhecimento VALUES ('HU¬MA¬NA$*',01,01);";

        stmt.executeUpdate(sql);

        sql = "SELECT * FROM area_conhecimento WHERE NOME = 'HU¬MA¬NA$*' AND CODIGO = 01 AND SUPER_AREA = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());

    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAreaDeConhecimentoCodigoNulo() throws SQLException {
        String sql = "INSERT INTO area_conhecimento VALUES ('EXATAS', NULL, 01);";
        stmt.executeUpdate(sql);

    }


    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaCursoDaUFGAreaDeConhecimentoNula() throws SQLException {
        String sql = "INSERT INTO curso_da_ufg VALUES ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', NULL);";
        stmt.executeUpdate(sql);

    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaCursoDaUFGNumeroDaResolucaoNegativo() throws SQLException {
        String sql = "INSERT INTO curso_da_ufg VALUES ('Aperfeicoamento', 'CONSUNI', -1, FALSE, 'Vespertino','SAMAMBAIA', 12);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaCursoDaUFGNumeroDaResolucaoNulo() throws SQLException {
        String sql = "INSERT INTO curso_da_ufg VALUES ('Aperfeicoamento', 'CONSUNI', NULL, FALSE, 'Vespertino','SAMAMBAIA',10);";
        stmt.executeUpdate(sql);

    }

    @Test
    public void testaArmazenaHistoricoUfgQualquer() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (201301571, 01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE NUMERO_MATRICULA_CURSO = 201301571 AND MES_DE_INICIO = 01 AND ANO_DE_INICIO = 2013 AND MES_DE_FIM = 12 AND ANO_DE_FIM = 2016 AND TITULO_DO_TRABALHO_FINAL = 'TRABALHO FINAL' AND CURSO = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgMatriculaCursoNula() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (NULL, 01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgMatriculaCursoNegativa() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (-201355571, 01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgMesDeInicioNulo() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (201312571, NULL, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesDeInicioLimiteInferior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (201101571, 01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE NUMERO_MATRICULA_CURSO = 201101571 AND MES_DE_INICIO = 01 AND ANO_DE_INICIO = 2013 AND MES_DE_FIM = 12 AND ANO_DE_FIM = 2016 AND TITULO_DO_TRABALHO_FINAL = 'TRABALHO FINAL' AND CURSO = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaHistoricoUfgMesDeInicioLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (201301571, 12, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE NUMERO_MATRICULA_CURSO = 201301571 AND MES_DE_INICIO = 12 AND ANO_DE_INICIO = 2013 AND MES_DE_FIM = 12 AND ANO_DE_FIM = 2016 AND TITULO_DO_TRABALHO_FINAL = 'TRABALHO FINAL' AND CURSO = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgMesDeInicioAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (202501571, -01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    /**
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgMesDeInicioAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (152201000, 13, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgAnoInicioNulo() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (201303271, 01, NULL, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgAnoInicioLimiteInferior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (152201111, 05, 1960, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE NUMERO_MATRICULA_CURSO = 152201111 AND MES_DE_INICIO = 05 AND ANO_DE_INICIO = 1960 AND MES_DE_FIM = 12 AND ANO_DE_FIM = 2016 AND TITULO_DO_TRABALHO_FINAL = 'TRABALHO FINAL' AND CURSO = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaHistoricoUfgAnoInicioAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (222201000, 09, 1959, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgMesFimNulo() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (222201100, 08, 2000, NULL, 2004, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesFimLimiteInferior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (223201000, 09, 1990, 01, 1994, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesFimLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (224201000, 09, 1996, 12, 1999, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgMesFimAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (223404000, 09, 2012, -10, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgMesFimAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (223205000, 10, 2012, 19, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgAnoFimNulo() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (223206000, 09, 1980, 01, NULL, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgAnoFimLimiteInferior() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (223207000, 09, 1980, 01, 1980, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE NUMERO_MATRICULA_CURSO = 223207000 AND MES_DE_INICIO = 09 AND ANO_DE_INICIO = 1980 AND MES_DE_FIM = 01 AND ANO_DE_FIM = 1980 AND TITULO_DO_TRABALHO_FINAL = 'TRABALHO FINAL' AND CURSO = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaHistoricoUfgTituloTrabalhoFinalNulo() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (223209000, 09, 1980, 01, 1986, NULL, 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE NUMERO_MATRICULA_CURSO = 223209000 AND MES_DE_INICIO = 09 AND ANO_DE_INICIO = 1980 AND MES_DE_FIM = 01 AND ANO_DE_FIM = 1986 AND CURSO = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaHistoricoUfgTituloTrabalhoFinalEmBranco() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (223210000, 09, 1980, 01, 1980, '', 01);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM historico_na_ufg WHERE NUMERO_MATRICULA_CURSO = 223210000 AND MES_DE_INICIO = 09 AND ANO_DE_INICIO = 1980 AND MES_DE_FIM = 01 AND ANO_DE_FIM = 1980 AND TITULO_DO_TRABALHO_FINAL = '' AND CURSO = 01;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgCursoNulo() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (223211000, 02, 1990, 01, 1996, 'TRABALHO FINAL', NULL);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgCursoNegativo() throws SQLException {
        String sql = "INSERT INTO historico_na_ufg VALUES (223007000, 09, 1980, 01, 1980, 'TRABALHO FINAL', -12);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoQualquer() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01, '2016-02-02', 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '2016-02-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoHistoricoNulo() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (NULL , '2016-02-02', 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoHistoricoNegativo() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (-01 , '2016-02-02', 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoDataAvaliacaoNula() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (02 , NULL , 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMotivacaoNula() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (10 , '2016-02-02', NULL, 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLWarning.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMotivacaoInvalida() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '2016-05-02', 'MOTIVACAO INVALIDA', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoNula() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (10 , '2016-02-02', 'Outra', NULL, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (15 , '2016-01-02', 'Outra', 0, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 15 AND DATA_AVALIACAO = '2016-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 0 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (15 , '2016-01-02', 'Outra', 10, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 15 AND DATA_AVALIACAO = '2016-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 10 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (15 , '2016-01-02', 'Outra', -10, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (02 , '2016-01-02', 'Outra', 13, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoNulo() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (11 , '2016-01-02', 'Outra', 8, NULL, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (03 , '2016-01-02', 'Outra', 8, 0, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 03 AND DATA_AVALIACAO = '2016-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 0 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (15 , '2016-01-02', 'Outra', 8, 10, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 15 AND DATA_AVALIACAO = '2016-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 10 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (08 , '1995-01-02', 'Outra', 8, -10, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (04 , '1995-01-02', 'Outra', 8, 15, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoNulo() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (05 , '1995-01-02', 'Outra', 8, 8, NULL, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (06 , '1995-01-02', 'Outra', 8, 8, 0, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 06 AND DATA_AVALIACAO = '1995-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 0 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (07 , '1995-01-02', 'Outra', 8, 8, 10, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 07 AND DATA_AVALIACAO = '1995-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 10 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (20 , '1995-01-02', 'Outra', 8, 8, -10, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (17 , '1995-01-02', 'Outra', 8, 8, 15, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoNula() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (19 , '1995-01-02', 'Outra', 8, 8, 8, NULL, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (06 , '1990-01-02', 'Outra', 8, 8, 8, 0, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 06 AND DATA_AVALIACAO = '1990-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 0 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (07 , '1982-01-02', 'Outra', 8, 8, 8, 10, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 07 AND DATA_AVALIACAO = '1982-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 10 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (09 , '1981-01-02', 'Outra', 8, 8, 8, -10, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (40 , '1990-01-02', 'Outra', 8, 8, 8, 15, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeNula() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (19 , '1999-01-02', 'Outra', 8, 8, 8, 8, NULL, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (06 , '1998-01-02', 'Outra', 8, 8, 8, 8, 0, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 06 AND DATA_AVALIACAO = '1998-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 0 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (07 , '1997-01-02', 'Outra', 8, 8, 8, 8, 10, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 07 AND DATA_AVALIACAO = '1997-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 10 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (09 , '1996-01-02', 'Outra', 8, 8, 8, 8, -10, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (40 , '1995-01-02', 'Outra', 8, 8, 8, 8, 15, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoNula() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (05 , '1999-01-02', 'Outra', 8, 8, 8, 8, 8, NULL, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (18 , '1998-01-02', 'Outra', 8, 8, 8, 8, 8, 0, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 18 AND DATA_AVALIACAO = '1998-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 0 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (07 , '1997-01-02', 'Outra', 8, 8, 8, 8, 8, 10, 'COMENTARIO');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 07 AND DATA_AVALIACAO = '1997-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 10 AND COMENTARIO = 'COMENTARIO';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (09 , '1996-01-02', 'Outra', 8, 8, 8, 8, 8, -10, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (40 , '1995-01-02', 'Outra', 8, 8, 8, 8, 8, 15, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoComentarioNulo() throws SQLException {
        String sql = "INSERT INTO avaliacao_do_curso_pelo_egresso VALUES (01 , '1995-01-02', 'Outra', 8, 8, 8, 8, 8, 8, NULL);";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM avaliacao_do_curso_pelo_egresso WHERE HISTORICO = 01 AND DATA_AVALIACAO = '1995-01-02' AND MOTIVACAO_ESCOLHA = 'Outra' " +
            "AND SATISFACAO_CURSO = 8 AND CONCEITO_GLOBAL_CURSO = 8 AND PREPARACAO_PARA_MERCADO = 8 AND MELHORIA_CAPACIDADE_COMUNICACAO = 8 AND " +
            "CAPACIDADE_ETICA_RESPONSABILIADE = 8 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO = 8;";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test
    public void testaArmazenaRealizacaoDeProgramaAcademicoQualquer() throws SQLException {
        String sql = "INSERT INTO REALIZACAO_DE_PROGRAMA_ACADEMICO VALUES (20101842 , 'Intercambio', '2016-02-01' , '2016-12-01', 'Descricao');";
        stmt.executeUpdate(sql);

        sql = "SELECT * FROM REALIZACAO_DE_PROGRAMA_ACADEMICO WHERE HISTORICO = 20101842 AND TIPO = 'Intercambio' AND DATA_INICIO = '2016-02-01' AND DATA_FIM = '2016-12-01' AND DESCRICAO = 'Descricao';";
        ResultSet resultado = stmt.executeQuery(sql);
        assertEquals(true, resultado.isBeforeFirst());
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaRealizacaoDeProgramaAcademicoHistoricoNulo() throws SQLException {
        String sql = "INSERT INTO REALIZACAO_DE_PROGRAMA_ACADEMICO VALUES (NULL , 'Monitoria', '2016-08-15' , '2016-09-15', 'Descricao');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaRealizacaoDeProgramaAcademicoTipoNulo() throws SQLException {
        String sql = "INSERT INTO REALIZACAO_DE_PROGRAMA_ACADEMICO VALUES (20130151, NULL, '2016-08-15' , '2016-09-15', 'Descricao');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaRealizacaoDeProgramaAcademicoDataInicioNula() throws SQLException {
        String sql = "INSERT INTO REALIZACAO_DE_PROGRAMA_ACADEMICO VALUES (20130149, 'Iniciacao_Cientifica', NULL , '2016-09-15', 'Descricao');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaRealizacaoDeProgramaAcademicoDataFimNula() throws SQLException {
        String sql = "INSERT INTO REALIZACAO_DE_PROGRAMA_ACADEMICO VALUES (20130148, 'Iniciacao_Cientifica', '2016-08-15', NULL, 'Descricao');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaRealizacaoDeProgramaAcademicoDescricaoNula() throws SQLException {
        String sql = "INSERT INTO REALIZACAO_DE_PROGRAMA_ACADEMICO VALUES (20130147, 'Iniciacao_Cientifica', '2016-08-15', '2016-09-15', NULL);";
        stmt.executeUpdate(sql);
    }



}