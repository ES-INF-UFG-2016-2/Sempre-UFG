package br.ufg.inf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CursUfgEgresTest {

    private Connection conexao;
    private DBConnection conexaoMariaDB;
    private Statement stmt;

    @Before
    public void iniciaConexao() throws SQLException {
        try {
            conexao = conexaoMariaDB.getConexao(new Properties());
        } catch (SQLException e) {
            System.out.println("Conexao FALHOU");
            e.printStackTrace();
        }

        stmt = conexao.createStatement();
    }

    @Test
    public void testaCreateTableAreaDeConhecimento() {

        String sql = "CREATE TABLE AREA_DE_CONHECIMENTO\n" +
            "(NOME VARCHAR(300) NOT NULL," +
            "CODIGO INTEGER PRIMARY KEY NOT NULL,\n" +
            "SUPER_AREA INTEGER REFERENCES AREA_DE_CONHECIMENTO (CODIGO)\n" +
            ");";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaCreateTableCursoUFG() {
        String sql = "CREATE TABLE CURSO_DA_UFG\n" +
            "(\n" +
            "NIVEL nivel NOT NULL,\n" +
            "TIPO_DE_RESOLUCAO tipo_resolucao NOT NULL,\n" +
            "NUMERO_DA_RESOLUCAO INTEGER PRIMARY KEY NOT NULL,\n" +
            "E_PRESENCIAL BOOLEAN NOT NULL,\n" +
            "TURNO turno NOT NULL,\n" +
            "UNIDADE_ACADEMICA VARCHAR(200) REFERENCES UNIDADE_ACADEMICA_UFG (NOME) NOT NULL,\n" +
            "AREA_DE_CONHECIMENTO INTEGER REFERENCES AREA_DE_CONHECIMENTO (CODIGO) NOT NULL\n" +
            ");";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaCreateTableHistoricoUFG() {
        String sql = "CREATE TABLE HISTORICO_NA_UFG\n" +
            "(\n" +
            "NUMERO_MATRICULA_CURSO INTEGER PRIMARY KEY NOT NULL,\n" +
            "MES_DE_INICIO INTEGER NOT NULL,\n" +
            "ANO_DE_INICIO INTEGER NOT NULL,\n" +
            "MES_DE_FIM INTEGER NOT NULL,\n" +
            "ANO_DE_FIM INTEGER NOT NULL, \n" +
            "TITULO_DO_TRABALHO_FINAL VARCHAR(500),\n" +
            "CURSO INTEGER REFERENCES CURSO_DA_UFG (NUMERO_DA_RESOLUCAO) NOT NULL\n" +
            ");";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaCreateAvaliacaoCursoPeloEgresso() {
        String sql = "CREATE TABLE AVALIACAO_DO_CURSO_PELO_EGRESSO\n" +
            "(\n" +
            "HISTORICO INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO) NOT NULL,\n" +
            "DATA_AVALIACAO DATE NOT NULL,\n" +
            "MOTIVACAO_ESCOLHA motivacao NOT NULL,\n" +
            "SATISFACAO_CURSO INTEGER NOT NULL,\n" +
            "CHECK (SATISFACAO_CURSO >= 0 AND SATISFACAO_CURSO <=10),\n" +
            "CONCEITO_GLOBAL_CURSO INTEGER NOT NULL,\n" +
            "CHECK (CONCEITO_GLOBAL_CURSO >= 0 AND CONCEITO_GLOBAL_CURSO <=10),\n" +
            "PREPARACAO_PARA_MERCADO INTEGER NOT NULL,\n" +
            "CHECK (PREPARACAO_PARA_MERCADO >= 0 AND PREPARACAO_PARA_MERCADO <=10),\n" +
            "MELHORIA_CAPACIDADE_COMUNICACAO INTEGER NOT NULL,\n" +
            "CHECK (MELHORIA_CAPACIDADE_COMUNICACAO >= 0 AND MELHORIA_CAPACIDADE_COMUNICACAO <=10),\n" +
            "CAPACIDADE_ETICA_RESPONSABILIADE INTEGER NOT NULL,\n" +
            "CHECK (CAPACIDADE_ETICA_RESPONSABILIADE >= 0 AND CAPACIDADE_ETICA_RESPONSABILIADE <=10),\n" +
            "CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO INTEGER NOT NULL,\n" +
            "CHECK (CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO >= 0 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO <=10),\n" +
            "COMENTARIO VARCHAR(300)\n" +
            ");";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaCreateTableRealizacaoProgramaAcademico() {
        String sql = "CREATE TABLE REALIZACAO_DE_PROGRAMA_ACADEMICO\n" +
            "(\n" +
            "HISTORICO INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO) NOT NULL,\n" +
            "TIPO tipo_programa_academico NOT NULL,\n" +
            "DATA_INICIO DATE NOT NULL,\n" +
            "DATA_FIM DATE NOT NULL,\n" +
            "DESCRICAO VARCHAR(300) NOT NULL\n" +
            ");\n";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testaArmazenaAreaDeConhecimentoQualquer() {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO ('EXATAS',01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaAreaDeConhecimentoNomeNulo() {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO ('NULL',01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaAreaDeConhecimentoNomeVazio() {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO ('',01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaAltermazenaAreaDeConhecimentoNomeComCaracteresEspeciais() {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO ('HU¬MA¬NA$*',01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testaArmazenaAreaDeConhecimentoCodigoVazio() {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO ('EXATAS','')";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testaArmazenaAreaDeConhecimentoCodigoNulo() {
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO ('EXATAS', NULL)";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////// CURSO DA UFG /////////////////////////////////
    @Test
    public void testaArmazenaCursoDaUFGQualquer() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGNivelVazio() {
        String sql = "INSERT INTO CURSO_DA_UFG ('', 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGNivelNulo() {
        String sql = "INSERT INTO CURSO_DA_UFG (NULL, 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGTipoVazio(){
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', '', 01, TRUE, 'Matutino','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGTipoNulo() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', NULL, 01, TRUE, 'Matutino','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGNumeroResolucaoString() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', '01', TRUE, 'Matutino','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGNumeroResolucaoNula() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', NULL, TRUE, 'Matutino','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGPresencialString() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, 'TRUE', 'Matutino','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGPresencialNula() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, NULL, 'Matutino','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGTurnoVazio() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, TRUE, '','SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGTurnoNulo() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, TRUE, NULL,'SAMAMBAIA', 01)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGUnidadeAcademicaVazia() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino','')";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGUnidadeAcademicaNula() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino', NULL)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGAreaDeConhecimentoVazia() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', '')";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGAreaDeConhecimentoNula() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', NULL)";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaArmazenaCursoDaUFGAreaDeConhecimentoCodigoString() {
        String sql = "INSERT INTO CURSO_DA_UFG ('Bacharelado', 'CEPEC', 01, TRUE, 'Matutino','SAMAMBAIA', '01')";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void fechaConexao() throws SQLException {
        resetaBanco();

        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexao");
                e.printStackTrace();
            }
        }
    }


    public void resetaBanco() {
        //Limpa dados do banco
    }


}
