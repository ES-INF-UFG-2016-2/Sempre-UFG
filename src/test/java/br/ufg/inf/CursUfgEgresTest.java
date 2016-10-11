package br.ufg.inf;

import br.ufg.inf.interfaces.AreaDeConhecimentoDAOInterface;
import br.ufg.inf.modelo.AreaDeConhecimentoStub;
import org.junit.*;

public class CursUfgEgresTest {

    @Before
    public void iniciaConexao(){
        //Limpa Banco

    }

    @Test
    public void testaCreateTableAreaDeConhecimento() {
        String sql = "CREATE TABLE AREA_DE_CONHECIMENTO\n" +
            "(\n" +
            "NOME   \t\t\tVARCHAR(300)     \t\tNOT NULL,\n" +
            "CODIGO     \t\t\tINTEGER\t    \t\tPRIMARY KEY  NOT NULL,\n" +
            "SUPER_AREA\t\tINTEGER REFERENCES AREA_DE_CONHECIMENTO (CODIGO)\n" +
            ");";


    }

    @Test
    public void testaCreateTableCursoUFG() {
        String sql = "CREATE TABLE CURSO_DA_UFG\n" +
            "(\n" +
            "NIVEL \t \t\t\t\tnivel   \t\t\t\tNOT NULL,\n" +
            "TIPO_DE_RESOLUCAO\t\ttipo_resolucao \t\t\tNOT NULL,\n" +
            "NUMERO_DA_RESOLUCAO\t\tINTEGER \t\t\tPRIMARY KEY NOT NULL,\n" +
            "E_PRESENCIAL \t\t\tBOOLEAN \t\t\tNOT NULL,\n" +
            "TURNO \t\t\t\tturno \t\t\t\tNOT NULL,\n" +
            "UNIDADE_ACADEMICA \t\tVARCHAR(200) REFERENCES UNIDADE_ACADEMICA_UFG (NOME) NOT NULL,\n" +
            "AREA_DE_CONHECIMENTO INTEGER REFERENCES AREA_DE_CONHECIMENTO (CODIGO) NOT NULL\n" +
            ");";


    }

    @Test
    public void testaCreateTableHistoricoUFG() {
        String sql = "CREATE TABLE HISTORICO_NA_UFG\n" +
            "(\n" +
            "NUMERO_MATRICULA_CURSO\tINTEGER\t\tPRIMARY KEY NOT NULL,\n" +
            "MES_DE_INICIO \t\t\tINTEGER\t\tNOT NULL,\n" +
            "ANO_DE_INICIO \t\t\tINTEGER\t\tNOT NULL,\n" +
            "MES_DE_FIM \t\t\t\tINTEGER\t\tNOT NULL,\n" +
            "ANO_DE_FIM \t\t\t\tINTEGER\t\tNOT NULL,  \n" +
            "TITULO_DO_TRABALHO_FINAL \tVARCHAR(500),\n" +
            "CURSO INTEGER REFERENCES CURSO_DA_UFG (NUMERO_DA_RESOLUCAO) NOT NULL\n" +
            ");";


    }

    @Test
    public void testaCreateAvaliacaoCursoPeloEgresso() {
        String sql = "CREATE TABLE AVALIACAO_DO_CURSO_PELO_EGRESSO\n" +
            "(\n" +
            "HISTORICO INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO) NOT NULL,\n" +
            "DATA_AVALIACAO \t\t\t\t\t\tDATE \t\tNOT NULL,\n" +
            "MOTIVACAO_ESCOLHA\t\t\t\t\tmotivacao\tNOT NULL,\n" +
            "SATISFACAO_CURSO\t\t\t\t\tINTEGER\tNOT NULL,\n" +
            "CHECK (SATISFACAO_CURSO >= 0 AND SATISFACAO_CURSO <=10),\n" +
            "CONCEITO_GLOBAL_CURSO\t\t\t\tINTEGER\tNOT NULL,\n" +
            "CHECK (CONCEITO_GLOBAL_CURSO >= 0 AND CONCEITO_GLOBAL_CURSO <=10),\n" +
            "PREPARACAO_PARA_MERCADO \t\t\t\tINTEGER\tNOT NULL,\n" +
            "CHECK (PREPARACAO_PARA_MERCADO >= 0 AND PREPARACAO_PARA_MERCADO <=10),\n" +
            "MELHORIA_CAPACIDADE_COMUNICACAO \t\t INTEGER\tNOT NULL,\n" +
            "CHECK (MELHORIA_CAPACIDADE_COMUNICACAO >= 0 AND MELHORIA_CAPACIDADE_COMUNICACAO <=10),\n" +
            "CAPACIDADE_ETICA_RESPONSABILIADE \t\t INTEGER \tNOT NULL,\n" +
            "CHECK (CAPACIDADE_ETICA_RESPONSABILIADE >= 0 AND CAPACIDADE_ETICA_RESPONSABILIADE <=10),\n" +
            "CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO \t INTEGER \tNOT NULL,\n" +
            "CHECK (CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO >= 0 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO <=10),\n" +
            "COMENTARIO \t\t\t\t\t\tVARCHAR(300)\n" +
            ");";


    }

    @Test
    public void testaCreateTableRealizacaoProgramaAcademico() {
        String sql = "CREATE TABLE REALIZACAO_DE_PROGRAMA_ACADEMICO\n" +
            "(\n" +
            "HISTORICO INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO) NOT NULL,\n" +
            "TIPO \t\t\t\t\ttipo_programa_academico \tNOT NULL,\n" +
            "DATA_INICIO \t\t\tDATE \t\t\t\tNOT NULL,\n" +
            "DATA_FIM \t\t\t\tDATE \t\t\t\tNOT NULL,\n" +
            "DESCRICAO \t\t\t\tVARCHAR(300) \t\tNOT NULL\n" +
            ");\n";


    }

    @Test
    public void testaArmazenaAreaDeConhecimentoQualquer() {
        String sql= "INSERT INTO AREA_DE_CONHECIMENTO ('EXATAS',01)";
        AreaDeConhecimentoStub areaDeConhecimentoStub = new AreaDeConhecimentoStub("EXATAS", 01);
        AreaDeConhecimentoDAOInterface.salvar(areaDeConhecimentoStub);
    }

    @Test
    public void testaArmazenaAreaDeConhecimentoNomeNulo() {
        String sql= "INSERT INTO AREA_DE_CONHECIMENTO ('NULL',01)";
        AreaDeConhecimentoStub areaDeConhecimentoStub = new AreaDeConhecimentoStub("NULL", 01);
        AreaDeConhecimentoDAOInterface.salvar(areaDeConhecimentoStub);
    }

    @Test
    public void testaArmazenaAreaDeConhecimentoNomeVazio() {
        String sql= "INSERT INTO AREA_DE_CONHECIMENTO ('',01)";
        AreaDeConhecimentoStub areaDeConhecimentoStub = new AreaDeConhecimentoStub("", 01);
        AreaDeConhecimentoDAOInterface.salvar(areaDeConhecimentoStub);
    }

    @Test
    public void testaAltermazenaAreaDeConhecimentoNomeComCaracteresEspeciais(){
        String sql= "INSERT INTO AREA_DE_CONHECIMENTO ('HU¬MA¬NA$*',01)";
        AreaDeConhecimentoStub areaDeConhecimentoStub = new AreaDeConhecimentoStub("HU¬MA¬NA$'", 01);
        AreaDeConhecimentoDAOInterface.salvar(areaDeConhecimentoStub);
    }

    /*
    @Test
    public void testaArmazenaAreaDeConhecimentoCodigoVazio() {
        String sql= "INSERT INTO AREA_DE_CONHECIMENTO (EXATAS,'')";
        AreaDeConhecimentoStub areaDeConhecimentoStub = new AreaDeConhecimentoStub("EXATAS",);
        AreaDeConhecimentoDAOStub.salvar(areaDeConhecimentoStub);
    }

    @Test
    public void testaArmazenaAreaDeConhecimentoNulo() {
        String sql= "INSERT INTO AREA_DE_CONHECIMENTO (EXATAS, NULL)";
        AreaDeConhecimentoStub areaDeConhecimentoStub = new AreaDeConhecimentoStub("EXATAS", null);
        AreaDeConhecimentoDAOStub.salvar(areaDeConhecimentoStub);
    }
*/
}
