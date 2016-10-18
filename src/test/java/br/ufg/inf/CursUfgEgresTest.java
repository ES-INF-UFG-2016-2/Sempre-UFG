package br.ufg.inf;

import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Properties;

public class CursUfgEgresTest {

    private static Connection conexao;
    private static DBConnection conexaoMariaDB;
    private static Statement stmt;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        iniciaConexao();
    }

    public static void iniciaConexao() throws Exception {
        conexaoMariaDB = new DBConnection();
        try {
            conexao = conexaoMariaDB.getConexao(new Properties());
        } catch (SQLException e) {
            System.out.println("Conexao FALHOU");
            e.printStackTrace();
        }

        stmt = conexao.createStatement();

    }

    @Before
    public void setUp(){
        criaTabelasDoBanco();
    }

    public static void criaTabelasDoBanco(){
        createTableAreaDeConhecimento();
        createTableCursoUFG();
        createTableHistoricoUFG();
        createTableRealizacaoProgramaAcademico();
        createAvaliacaoCursoPeloEgresso();
    }


    public static void createTableAreaDeConhecimento() {

        String sql = "CREATE TABLE AREA_DE_CONHECIMENTO " +
            "(NOME VARCHAR(300) NOT NULL," +
            "CODIGO INTEGER UNSIGNED PRIMARY KEY NOT NULL," +
            "SUPER_AREA INTEGER UNSIGNED REFERENCES AREA_DE_CONHECIMENTO (CODIGO));";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createTableCursoUFG() {
        String sql = "CREATE TABLE CURSO_DA_UFG" +
            "(NIVEL ENUM('Bacharelado', 'Licenciatura', 'Aperfeicoamento', 'Especializacao', 'Mestrado', 'Doutorado') NOT NULL," +
            "TIPO_DE_RESOLUCAO ENUM('CEPEC', 'CONSUNI') NOT NULL," +
            "NUMERO_DA_RESOLUCAO INTEGER UNSIGNED PRIMARY KEY NOT NULL," +
            "E_PRESENCIAL BOOLEAN NOT NULL," +
            "TURNO ENUM('Matutino', 'Vespertino', 'Integral') NOT NULL," +
            "UNIDADE_ACADEMICA VARCHAR(200) NOT NULL REFERENCES UNIDADE_ACADEMICA_UFG (NOME)," +
            "AREA_DE_CONHECIMENTO INTEGER UNSIGNED NOT NULL REFERENCES AREA_DE_CONHECIMENTO (CODIGO));";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createTableHistoricoUFG() {
        String sql = "CREATE TABLE HISTORICO_NA_UFG" +
            "(NUMERO_MATRICULA_CURSO INTEGER UNSIGNED PRIMARY KEY NOT NULL," +
            "MES_DE_INICIO INTEGER UNSIGNED NOT NULL," +
            "ANO_DE_INICIO INTEGER UNSIGNED NOT NULL," +
            "MES_DE_FIM INTEGER UNSIGNED NOT NULL," +
            "ANO_DE_FIM INTEGER UNSIGNED NOT NULL, " +
            "TITULO_DO_TRABALHO_FINAL VARCHAR(500)," +
            "CURSO INTEGER UNSIGNED NOT NULL REFERENCES CURSO_DA_UFG (NUMERO_DA_RESOLUCAO)," +
            "CHECK (HISTORICO_NA_UFG.MES_DE_INICIO < 13)," +
            "CHECK (HISTORICO_NA_UFG.ANO_DE_INICIO > 1959)," +
            "CHECK (HISTORICO_NA_UFG.MES_DE_FIM < 13)," +
            "CHECK (HISTORICO_NA_UFG.ANO_DE_FIM > HISTORICO_NA_UFG.ANO_DE_INICIO));";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createAvaliacaoCursoPeloEgresso() {
        String sql = "CREATE TABLE AVALIACAO_DO_CURSO_PELO_EGRESSO" +
            "(HISTORICO INTEGER UNSIGNED NOT NULL REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO)," +
            "DATA_AVALIACAO DATE NOT NULL," +
            "MOTIVACAO_ESCOLHA ENUM('Qualidade/Reputacao do Curso', 'Qualidade/Reputacao da IES', 'Gratuidade', 'Outra') NOT NULL," +
            "SATISFACAO_CURSO INTEGER UNSIGNED NOT NULL," +
            "CHECK (AVALIACAO_DO_CURSO_PELO_EGRESSO.SATISFACAO_CURSO <=10)," +
            "CONCEITO_GLOBAL_CURSO INTEGER UNSIGNED NOT NULL," +
            "CHECK (AVALIACAO_DO_CURSO_PELO_EGRESSO.CONCEITO_GLOBAL_CURSO <=10)," +
            "PREPARACAO_PARA_MERCADO INTEGER UNSIGNED NOT NULL," +
            "CHECK (AVALIACAO_DO_CURSO_PELO_EGRESSO.PREPARACAO_PARA_MERCADO <=10)," +
            "MELHORIA_CAPACIDADE_COMUNICACAO INTEGER UNSIGNED NOT NULL," +
            "CHECK (AVALIACAO_DO_CURSO_PELO_EGRESSO.MELHORIA_CAPACIDADE_COMUNICACAO <=10)," +
            "CAPACIDADE_ETICA_RESPONSABILIADE INTEGER UNSIGNED NOT NULL," +
            "CHECK (AVALIACAO_DO_CURSO_PELO_EGRESSO.CAPACIDADE_ETICA_RESPONSABILIADE <=10)," +
            "CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO INTEGER UNSIGNED NOT NULL," +
            "CHECK (AVALIACAO_DO_CURSO_PELO_EGRESSO.CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO <=10)," +
            "COMENTARIO VARCHAR(300));";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createTableRealizacaoProgramaAcademico() {
        String sql = "CREATE TABLE REALIZACAO_DE_PROGRAMA_ACADEMICO" +
            "(HISTORICO INTEGER UNSIGNED NOT NULL REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO)," +
            "TIPO ENUM('Iniciacao_Cientifica', 'Monitoria', 'Extensao', 'Intercambio') NOT NULL," +
            "DATA_INICIO DATE NOT NULL," +
            "DATA_FIM DATE NOT NULL," +
            "DESCRICAO VARCHAR(300) NOT NULL);";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testaArmazenaAreaDeConhecimentoQualquer() {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO VALUES ('EXATAS',01,01);";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test(expected = SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAreaDeConhecimentoNomeNulo() throws SQLException {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO VALUES (NULL,01,01);";

        stmt.executeUpdate(sql);

    }

    /**
     * Verificar este teste
     */
    @Test
    public void testaAltermazenaAreaDeConhecimentoNomeComCaracteresEspeciais() {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO VALUES ('HU¬MA¬NA$*',01,01);";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAreaDeConhecimentoCodigoNulo() throws SQLException {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO VALUES ('EXATAS', NULL, 01);";
        stmt.executeUpdate(sql);

    }

///////////////////////////////////// CURSO_DA_UFG /////////////////////////////////////////////////////

    /**
     * Rever teste
     */
    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaCursoDaUFGAreaDeConhecimentoNula() throws SQLException {
        String sql = "INSERT INTO CURSO_DA_UFG VALUES ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', NULL);";
        stmt.executeUpdate(sql);

    }

    /**
     * Rever teste
     */
    @Test
    public void testaArmazenaCursoDaUFGAreaDeConhecimentoCodigoString() {
        String sql = "INSERT INTO CURSO_DA_UFG VALUES ('Bacharelado', 'CEPEC', 01, FALSE, 'Matutino','SAMAMBAIA', '01');";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGNumeroDaResolucaoNegativo() {
        String sql = "INSERT INTO CURSO_DA_UFG VALUES ('Aperfeicoamento', 'CONSUNI', -1, FALSE, 'Vespertino','SAMAMBAIA', 12);";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaCursoDaUFGNumeroNulo() throws SQLException {
        String sql = "INSERT INTO CURSO_DA_UFG VALUES ('Aperfeicoamento', 'CONSUNI', NULL, FALSE, 'Vespertino','SAMAMBAIA',10);";
        stmt.executeUpdate(sql);

    }

////////////////////////////////////////// HISTORICO_NA_UFG ///////////////////////////////////////////////////////

    @Test
    public void testaArmazenaHistoricoUfgQualquer() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (201301571, 01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgMatriculaCursoNula() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (NULL, 01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    /**
     * Rever Teste
     *
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgMatriculaCursoNegativa() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (-201355571, 01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgMesDeInicioNulo() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (201312571, NULL, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesDeInicioLimiteInferior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (201101571, 01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesDeInicioLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (201301571, 12, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }


    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgMesDeInicioAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (202501571, -01, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }


    /**
     * Verificar teste
     *
     * @throws SQLException
     */
    @Test
    public void testaArmazenaHistoricoUfgMesDeInicioAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (152201000, 13, 2013, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgAnoInicioNulo() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (201303271, 01, NULL, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgAnoInicioLimiteInferior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (152201111, 05, 1960, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);

    }

    /**
     * Rever teste
     *
     * @throws SQLException
     */
    @Test
    public void testaArmazenaHistoricoUfgAnoInicioAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (222201000, 09, 1959, 12, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgMesFimNulo() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (222201100, 08, 2000, NULL, 2004, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesFimLimiteInferior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223201000, 09, 1990, 01, 1994, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgMesFimLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (224201000, 09, 1996, 12, 1999, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }


    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgMesFimAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223404000, 09, 2012, -10, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    /**
     * Rever teste
     *
     * @throws SQLException
     */
    @Test
    public void testaArmazenaHistoricoUfgMesFimAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223205000, 10, 2012, 19, 2016, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgAnoFimNulo() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223206000, 09, 1980, 01, NULL, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgAnoFimLimiteInferior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223207000, 09, 1980, 01, 1980, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    /**
     * Rever teste
     *
     * @throws SQLException
     */
    @Test
    public void testaArmazenaHistoricoUfgAnoFimAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223208000, 09, 1980, 01, 1978, 'TRABALHO FINAL', 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgTituloTrabalhoFinalNulo() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223209000, 09, 1980, 01, 1986, NULL, 01);";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaHistoricoUfgTituloTrabalhoFinalEmBranco() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223210000, 09, 1980, 01, 1980, '', 01);";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaHistoricoUfgCursoNulo() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223211000, 02, 1990, 01, 1996, 'TRABALHO FINAL', NULL);";
        stmt.executeUpdate(sql);
    }

    /**
     * Rever teste
     *
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaHistoricoUfgCursoNegativo() throws SQLException {
        String sql = "INSERT INTO HISTORICO_NA_UFG VALUES (223007000, 09, 1980, 01, 1980, 'TRABALHO FINAL', -12);";
        stmt.executeUpdate(sql);
    }

    ///////////////////////////////////////// AVALIACAO_DO_CURSO_PELO_EGRESSO //////////////////////////////////////////////

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoQualquer() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (01, '2016-02-02', 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoHistoricoNulo() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (NULL , '2016-02-02', 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }


    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoHistoricoNegativo() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (-01 , '2016-02-02', 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoDataAvaliacaoNula() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (02 , NULL , 'Outra', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMotivacaoNula() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (10 , '2016-02-02', NULL, 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    /**
     * Verificar se esse teste procede lançando exceção warning
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMotivacaoInvalida() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (01 , '2016-05-02', 'MOTIVACAO INVALIDA', 8, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoNula() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (10 , '2016-02-02', 'Outra', NULL, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (15 , '2016-01-02', 'Outra', 0, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (15 , '2016-01-02', 'Outra', 10, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (15 , '2016-01-02', 'Outra', -10, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    /**
     * Verificar esse teste.
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoSatisfacaoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (02 , '2016-01-02', 'Outra', 13, 8, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoNulo() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (11 , '2016-01-02', 'Outra', 8, NULL, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (03 , '2016-01-02', 'Outra', 8, 0, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (15 , '2016-01-02', 'Outra', 8, 10, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (08 , '1995-01-02', 'Outra', 8, -10, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    /**
     * Verificar esse teste.
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoConceitoGlobalCursoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (04 , '1995-01-02', 'Outra', 8, 15, 8, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoNulo() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (05 , '1995-01-02', 'Outra', 8, 8, NULL, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (06 , '1995-01-02', 'Outra', 8, 8, 0, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (07 , '1995-01-02', 'Outra', 8, 8, 10, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (20 , '1995-01-02', 'Outra', 8, 8, -10, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    /**
     * Verificar esse teste
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoPreparacaoParaMercadoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (17 , '1995-01-02', 'Outra', 8, 8, 15, 8, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoNula() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (19 , '1995-01-02', 'Outra', 8, 8, 8, NULL, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (06 , '1990-01-02', 'Outra', 8, 8, 8, 0, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (07 , '1982-01-02', 'Outra', 8, 8, 8, 10, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (09 , '1981-01-02', 'Outra', 8, 8, 8, -10, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    /**
     * Verificar esse teste
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoMelhoriaCapacidadeComunicacaoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (40 , '1990-01-02', 'Outra', 8, 8, 8, 15, 8, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeNula() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (19 , '1999-01-02', 'Outra', 8, 8, 8, 8, NULL, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (06 , '1998-01-02', 'Outra', 8, 8, 8, 8, 0, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (07 , '1997-01-02', 'Outra', 8, 8, 8, 8, 10, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (09 , '1996-01-02', 'Outra', 8, 8, 8, 8, -10, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    /**
     * Verificar esse teste
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeEticaResponsabilidadeAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (40 , '1995-01-02', 'Outra', 8, 8, 8, 8, 15, 8, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLIntegrityConstraintViolationException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoNula() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (05 , '1999-01-02', 'Outra', 8, 8, 8, 8, 8, NULL, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (18 , '1998-01-02', 'Outra', 8, 8, 8, 8, 8, 0, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (07 , '1997-01-02', 'Outra', 8, 8, 8, 8, 8, 10, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoAbaixoLimiteInferior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (09 , '1996-01-02', 'Outra', 8, 8, 8, 8, 8, -10, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    /**
     * Verificar esse teste
     * @throws SQLException
     */
    @Test(expected = java.sql.SQLDataException.class)
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoCapacidadeHabilidadesAreaConhecimentoAcimaLimiteSuperior() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (40 , '1995-01-02', 'Outra', 8, 8, 8, 8, 8, 15, 'COMENTARIO');";
        stmt.executeUpdate(sql);
    }

    @Test
    public void testaArmazenaAvaliacaoDoCursoPeloEgressoComentarioNulo() throws SQLException {
        String sql = "INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO VALUES (01 , '1995-01-02', 'Outra', 8, 8, 8, 8, 8, 8, NULL);";
        stmt.executeUpdate(sql);
    }


    //////////////////////////////////////// REALIZACAO_DE_PROGRAMA_ACADEMICO //////////////////////////////////////////////

    @Test
    public void testaArmazenaRealizacaoDeProgramaAcademicoQualquer() throws SQLException {
        String sql = "INSERT INTO REALIZACAO_DE_PROGRAMA_ACADEMICO VALUES (20101842 , 'Intercambio', '2016-02-01' , '2016-12-01', 'Descricao');";
        stmt.executeUpdate(sql);
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    @After
    public void tearDown() throws Exception {
        limpaBanco();
    }

    public static void limpaBanco() throws Exception {
        try {
            stmt.execute("DROP TABLE AREA_DE_CONHECIMENTO, CURSO_DA_UFG, HISTORICO_NA_UFG, AVALIACAO_DO_CURSO_PELO_EGRESSO, REALIZACAO_DE_PROGRAMA_ACADEMICO;");
            conexao.commit();
        } catch (SQLException e){
            conexao.rollback();
            throw new Exception(e);
        }
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

        if (conexao != null) {
            try {
                conexao.close();
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Erro ao ENCERRAR conexao!");
                e.printStackTrace();
            }
        }
    }

}
