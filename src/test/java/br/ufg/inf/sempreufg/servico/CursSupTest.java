package br.ufg.inf.servico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CursSupTest {

    Connection con;
    String sql;

    @Before
    public void setUp() {

        try {

            con = DriverManager.getConnection("jdbc:mariadb://localhost/SempreUFG", "admin", "admin");

        } catch (SQLException e) {

            System.out.println("Conexão com o banco MariaDB não criada!");
        }
    }

    @Test
    public void testInsereLocalizacaoGeograficaComCamposOpcionais() {

        int id_localizacao = 1;
        String cidade = "Catalão";
        String unidade_federativa = "GO";
        String pais = "Brasil";
        String sigla = "GO";
        float latitude = 321343004;
        float longitude = 03520220043;

        boolean inseriu = insereLocalizacaoGeografica(id_localizacao, cidade, unidade_federativa, pais, sigla, latitude, longitude);
        assertTrue(inseriu);
    }

    @Test
    public void testInsereLocalizacaoGeograficaSemCamposOpcionais() {

        int id_localizacao = 2;
        String cidade = "Jataí";
        String unidade_federativa = "GO";
        String pais = "Brasil";
        String sigla = "GO";

        boolean inseriu = insereLocalizacaoGeografica(id_localizacao, cidade, unidade_federativa, pais, sigla, 0, 0);
        assertTrue(inseriu);
    }

    @Test
    public void testInsereLocalizacaoGeograficaComIdentificadorLocalizacaoDuplicado() {

        int id_localizacao = 1;
        String cidade = "Inhumas";
        String unidade_federativa = "GO";
        String pais = "Brasil";
        String sigla = "GO";
        float longitude = 03571043;

        boolean inseriu = insereLocalizacaoGeografica(id_localizacao, cidade, unidade_federativa, pais, sigla, 0, longitude);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereRegionalUFGComCamposCorretos() {

        int id = 1;
        String nome_regional = "Goiânia-Câmpus Samambaia";
        int id_localizacao = 1;

        boolean inseriu = insereRegionalUFG(id, nome_regional, id_localizacao);
        assertTrue(inseriu);
    }

    @Test
    public void testInsereRegionalUFGComIdentificadorLocalizacaoInexiste() {

        int id = 2;
        String nome_regional = "Goiás";
        int id_localizacao = 4;

        boolean inseriu = insereRegionalUFG(id, nome_regional, id_localizacao);
        assertFalse("Regional não inserida por não existir a localizacao informada.", inseriu);
    }

    @Test
    public void testInsereRegionalUFGComIdentificadorRegionalDuplicado() {

        int id = 1;
        String nome_regional = "Catalão";
        int id_localizacao = 1;

        boolean inseriu = insereRegionalUFG(id, nome_regional, id_localizacao);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereUnidadeAcademicaComCamposCorretos() {

        int id_unidade = 1;
        String nome_unidade = "INF";
        int id_localizacao = 1;
        int id_regional = 1;

        boolean inseriu = insereUnidadeAcademica(id_unidade, nome_unidade, id_localizacao, id_regional);
        assertTrue(inseriu);
    }

    @Test
    public void testInsereUnidadeAcademicaComIdentificadorLocalizacaoInexistente() {

        int id_unidade = 1;
        String nome_unidade = "INF";
        int id_localizacao = 7;
        int id_regional = 1;

        boolean inseriu = insereUnidadeAcademica(id_unidade, nome_unidade, id_localizacao, id_regional);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereUnidadeAcademicaComIdentificadorRegionalInexistente() {

        int id_unidade = 1;
        String nome_unidade = "INF";
        int id_localizacao = 1;
        int id_regional = 8;

        boolean inseriu = insereUnidadeAcademica(id_unidade, nome_unidade, id_localizacao, id_regional);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereUnidadeAcademicaComIndentificadorUnidadeDuplicado() {

        int id_unidade = 1;
        String nome_unidade = "INF";
        int id_localizacao = 1;
        int id_regional = 1;

        boolean inseriu = insereUnidadeAcademica(id_unidade, nome_unidade, id_localizacao, id_regional);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereAreaDeConhecimentoPrincipalComCamposCorretos() {

        String nome_area = "Ciências Exatas e da Terra";
        int codigo_area = 10000003;

        boolean inseriu = insereLinhaAreaDeConhecimentoPrincial(nome_area, codigo_area);
        assertTrue(inseriu);
    }

    @Test
    public void testInsereAreaDeConhecimentoPrincipalComIdentificadorNomeAreaDuplicado() {

        String nome_area = "Ciências Exatas e da Terra";
        int codigo_area = 1011003;

        boolean inseriu = insereLinhaAreaDeConhecimentoPrincial(nome_area, codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereAreaDeConhecimentoPrincipalComIdentificadorCodigoAreaDuplicado() {

        String nome_area = "Ciências Biológicas";
        int codigo_area = 10000003;

        boolean inseriu = insereLinhaAreaDeConhecimentoPrincial(nome_area, codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereAreaDeConhecimentoSubAreaComCamposCorretos() {

        String nome_area = "Matemática";
        int codigo_area = 10100008;
        String fk_nome_area = "Ciências Exatas e da Terra";
        int fk_codigo_area = 10000003;

        boolean inseriu = insereLinhaAreaDeConhecimentoSubArea(nome_area, codigo_area, fk_nome_area, fk_codigo_area);
        assertTrue(inseriu);
    }

    @Test
    public void testInsereAreaDeConhecimentoSubAreaComIdentificadorNomeDuplicado() {

        String nome_area = "Matemática";
        int codigo_area = 10102000;
        String fk_nome_area = "Ciências Exatas e da Terra";
        int fk_codigo_area = 10000003;

        boolean inseriu = insereLinhaAreaDeConhecimentoSubArea(nome_area, codigo_area, fk_nome_area, fk_codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereAreaDeConhecimentoSubAreaComIdentificadorCodigoDuplicado() {

        String nome_area = "Geometria e Topologia";
        int codigo_area = 10100008;
        String fk_nome_area = "Ciências Exatas e da Terra";
        int fk_codigo_area = 10000003;

        boolean inseriu = insereLinhaAreaDeConhecimentoSubArea(nome_area, codigo_area, fk_nome_area, fk_codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereAreaDeConhecimentoSubAreaComIdentificadorNomeAreaPrincialInexistente() {

        String nome_area = "Geometria e Topologia";
        int codigo_area = 10103007;
        String fk_nome_area = "Ciências Biológicas";
        int fk_codigo_area = 10000003;

        boolean inseriu = insereLinhaAreaDeConhecimentoSubArea(nome_area, codigo_area, fk_nome_area, fk_codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereAreaDeConhecimentoSubAreaComIdentificadorCodigoAreaPrincialInexistente() {

        String nome_area = "Geometria e Topologia";
        int codigo_area = 10103007;
        String fk_nome_area = "Ciências Exatas e da Terra";
        int fk_codigo_area = 10303030;

        boolean inseriu = insereLinhaAreaDeConhecimentoSubArea(nome_area, codigo_area, fk_nome_area, fk_codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereAreaDeConhecimentoSubAreaSemAreaPrincipalIdentificada() {

        String nome_area = "Geometria e Topologia";
        int codigo_area = 10103007;

        boolean inseriu = insereLinhaAreaDeConhecimentoSubArea(nome_area, codigo_area, null, 0);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereCursoDaUFGComCamposCorretos() {

        String nivel = "Bacharelado";
        String tipo_resolucao = "CONSUNI";
        int num_resolucao = 32;
        boolean ePresencial = true;
        String turno = "Integral";
        int id_unidade_academica = 1;
        String id_nome_area = "Ciências Exatas e da Terra";
        int id_codigo_area = 10000003;

        boolean inseriu = insereCursoDaUFG(nivel, tipo_resolucao, num_resolucao, ePresencial, turno, id_unidade_academica, id_nome_area, id_codigo_area);
        assertTrue(inseriu);
    }

    @Test
    public void testInsereCursoDaUFGComIdentificadorUnidadeAcadmeicaInexistente() {

        String nivel = "Licenciatura";
        String tipo_resolucao = "CONSUNI";
        int num_resolucao = 22;
        boolean ePresencial = true;
        String turno = "Matutino";
        int id_unidade_academica = 5;
        String id_nome_area = "Ciências Exatas e da Terra";
        int id_codigo_area = 10000003;

        boolean inseriu = insereCursoDaUFG(nivel, tipo_resolucao, num_resolucao, ePresencial, turno, id_unidade_academica, id_nome_area, id_codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereCursoDaUFGComIdentificadorAreaConhecimentoNomeInexistente() {

        String nivel = "Licenciatura";
        String tipo_resolucao = "CONSUNI";
        int num_resolucao = 22;
        boolean ePresencial = true;
        String turno = "Matutino";
        int id_unidade_academica = 1;
        String id_nome_area = "Ciências Humanas";
        int id_codigo_area = 10000003;

        boolean inseriu = insereCursoDaUFG(nivel, tipo_resolucao, num_resolucao, ePresencial, turno, id_unidade_academica, id_nome_area, id_codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereCursoDaUFGComIdentificadorAreaConhecimentoCodigoInexistente() {

        String nivel = "Licenciatura";
        String tipo_resolucao = "CONSUNI";
        int num_resolucao = 22;
        boolean ePresencial = true;
        String turno = "Matutino";
        int id_unidade_academica = 5;
        String id_nome_area = "Matemática";
        int id_codigo_area = 10100008;

        boolean inseriu = insereCursoDaUFG(nivel, tipo_resolucao, num_resolucao, ePresencial, turno, id_unidade_academica, id_nome_area, id_codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereCursoDaUFGComIdentificadorNumeroResolucaoDuplicado() {

        String nivel = "Licenciatura";
        String tipo_resolucao = "CEPEC";
        int num_resolucao = 32;
        boolean ePresencial = true;
        String turno = "Vespertino";
        int id_unidade_academica = 1;
        String id_nome_area = "Matemática";
        int id_codigo_area = 10100008;

        boolean inseriu = insereCursoDaUFG(nivel, tipo_resolucao, num_resolucao, ePresencial, turno, id_unidade_academica, id_nome_area, id_codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testInsereCursoDeOutraIESComCamposOpcionaisIncluindoAreaConhecimentoCorretos() {

        int id_curso_ies = 1;
        String nome_curso = "Enfermagen";
        String nivel = "Bacharelado";
        String nome_unidade_academica = "Falcudade de Saúde";
        String ies_curso = "UNIP";
        String tipo_instituicao = "Particular";
        String url = "www.unip.edu.br";
        String id_nome_area = "Ciências Exatas e da Terra";
        int id_codigo_area = 10000003;

        boolean inseriu = insereCursoDeOutraIES(id_curso_ies, nome_curso, nivel, nome_unidade_academica, ies_curso, tipo_instituicao, url, id_nome_area, id_codigo_area);
        assertTrue(inseriu);
    }
    
    @Test
    public void testInsereCursoDeOutraIESComCamposOpcionaisSemAreaConhecimentoCorretos() {

        int id_curso_ies = 2;
        String nome_curso = "Biologia";
        String nivel = "Bacharelado";
        String nome_unidade_academica = "Falculdade Ciencias Biologicas";
        String ies_curso = "Uni-Anhaguera";
        String tipo_instituicao = "Particular";
        String url = "www.unianhanguera.edu.br";

        boolean inseriu = insereCursoDeOutraIES(id_curso_ies, nome_curso, nivel, nome_unidade_academica, ies_curso, tipo_instituicao, url, null, 0);
        assertTrue(inseriu);
    }
    
    @Test
    public void testInsereCursoDeOutraIESSemCamposOpcionaisCorretos() {

        int id_curso_ies = 3;
        String nome_curso = "Matematica";
        String nivel = "Bacharelado";
        String ies_curso = "Universidade Estadual de Goiás";
        String tipo_instituicao = "Estadual";

        boolean inseriu = insereCursoDeOutraIES(id_curso_ies, nome_curso, nivel, null, ies_curso, tipo_instituicao, null, null, 0);
        assertTrue(inseriu);
    }
    
    @Test
    public void testInsereCursoDeOutraIESComCamposOpcionaisIncluindoAreaConhecimentoComIdentificadorIESDuplicado() {

        int id_curso_ies = 2;
        String nome_curso = "Letras";
        String nivel = "Bacharelado";
        String nome_unidade_academica = "Falcudade de Letras";
        String ies_curso = "UNIP";
        String tipo_instituicao = "Particular";
        String url = "www.unip.edu.br";

        boolean inseriu = insereCursoDeOutraIES(id_curso_ies, nome_curso, nivel, nome_unidade_academica, ies_curso, tipo_instituicao, url, null, 0);
        assertFalse(inseriu);
    }
    
    @Test
    public void testInsereCursoDeOutraIESComCamposOpcionaisIncluindoAreaConhecimentoComIdentificadorNomeInexistente() {

        int id_curso_ies = 4;
        String nome_curso = "Enfermagen";
        String nivel = "Bacharelado";
        String nome_unidade_academica = "Falcudade de Saúde";
        String ies_curso = "UNIP";
        String tipo_instituicao = "Particular";
        String url = "www.unip.edu.br";
        String id_nome_area = "Algebra";
        int id_codigo_area = 10000003;

        boolean inseriu = insereCursoDeOutraIES(id_curso_ies, nome_curso, nivel, nome_unidade_academica, ies_curso, tipo_instituicao, url, id_nome_area, id_codigo_area);
        assertFalse(inseriu);
    }
    
    @Test
    public void testInsereCursoDeOutraIESComCamposOpcionaisIncluindoAreaConhecimentoComIdentificadorCodigoInexistente() {

        int id_curso_ies = 4;
        String nome_curso = "Enfermagen";
        String nivel = "Bacharelado";
        String ies_curso = "UNIP";
        String tipo_instituicao = "Particular";
        String id_nome_area = "Matemática";
        int id_codigo_area = 10100033;

        boolean inseriu = insereCursoDeOutraIES(id_curso_ies, nome_curso, nivel, null, ies_curso, tipo_instituicao, null, id_nome_area, id_codigo_area);
        assertFalse(inseriu);
    }

    @Test
    public void testExisteParaTabelaCursoUFG() {

        boolean existe = existeTabela("curso_ufg");
        assertTrue("Foi criada a tabela para Curso da UFG", existe);
    }

    @Test
    public void testExisteTabelaParaCursoOutraIES() {

        boolean existe = existeTabela("curso_outra_ies");
        assertTrue("Foi criada a tabela para Curso de outra IES", existe);
    }

    @Test
    public void testExisteTabelaParaAreaDeConhecimento() {

        boolean existe = existeTabela("area_conhecimento");
        assertTrue("Foi criada a tabela para area de conhecimento", existe);
    }

    @Test
    public void testExisteTabelaParaUnidadeAcademica() {

        boolean existe = existeTabela("unidade_academica_ufg");
        assertTrue("Foi criada a tabela para unidade academica", existe);
    }

    @Test
    public void testExisteTabelaParaRegionalUFG() {

        boolean existe = existeTabela("regional_ufg");
        assertTrue("Foi criada a tabela para regional da UFG", existe);
    }

    @Test
    public void testExisteTabelaParaLocalizacaoGeografica() throws SQLException {

        boolean existe = existeTabela("localizacao_geografica");
        assertTrue("Foi criada a tabela para localizacao geografica", existe);
    }

    private boolean existeTabela(String nomeTabela) {

        sql = "SELECT * FROM " + nomeTabela;
        boolean resultado = true;

        try {
            Statement stmt = con.createStatement();
            stmt.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(CursSupTest.class
                    .getName()).log(Level.SEVERE, null, ex);
            resultado = false;
        }

        return resultado;
    }

    public boolean existeLinhaParaId(String id) {

        sql = "SELECT id FROM SempreUFG WHERE id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursSupTest.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private boolean insereLocalizacaoGeografica(int id, String cidade, String unidade_federativa, String pais, String sigla, float latitude, float longitude) {

        boolean existeIdentificadorLocalizacao = existeLinhaParaId(Integer.toString(id));

        boolean resultado = true;

        if (!existeIdentificadorLocalizacao) {

            sql = "INSERT INTO localizacao_geografica VALUES (?,?,?,?,?,?,?)";

            try {
                PreparedStatement stmt = this.con.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.setString(2, cidade);
                stmt.setString(3, unidade_federativa);
                stmt.setString(4, pais);
                stmt.setString(5, sigla);
                stmt.setFloat(6, latitude);
                stmt.setFloat(7, longitude);
                stmt.execute();
                stmt.close();
                stmt.executeQuery();

            } catch (SQLException e) {
                Logger.getLogger(CursSupTest.class
                        .getName()).log(Level.SEVERE, null, e);

                resultado = false;
            }
        } else {
            System.out.println("Existe localizacao no banco de dados para este identificador.");
            resultado = false;
        }

        return resultado;
    }

    private boolean insereRegionalUFG(int id, String nome_regional, int id_localizacao) {

        boolean existeIdentificadorRegional = existeLinhaParaId(Integer.toString(id));
        boolean existeIdentificadorLocalizacao = existeLinhaParaId(Integer.toString(id_localizacao));

        boolean resultado = true;

        if (!existeIdentificadorRegional && existeIdentificadorLocalizacao) {

            sql = "INSERT INTO regional_ufg VALUES (?,?,?)";

            try {
                PreparedStatement stmt = this.con.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.setString(2, nome_regional);
                stmt.setInt(3, id_localizacao);
                stmt.execute();
                stmt.close();
                stmt.executeQuery();

            } catch (SQLException e) {
                Logger.getLogger(CursSupTest.class
                        .getName()).log(Level.SEVERE, null, e);

                resultado = false;
            }
        } else if (!existeIdentificadorLocalizacao) {

            System.out.println("Não existe um identificador no banco de dados para esta localizacao.");
            resultado = false;

        } else if (existeIdentificadorRegional) {

            System.out.println("Existe uma regional no banco de dados com este identificador.");
            resultado = false;
        }

        return resultado;
    }

    private boolean insereUnidadeAcademica(int id_unidade, String nome_unidade, int id_localizacao, int id_regional) {

        boolean existeIdentificadorUnidade = existeLinhaParaId(Integer.toString(id_unidade));
        boolean existeIdentificadorLocalizacao = existeLinhaParaId(Integer.toString(id_localizacao));
        boolean existeIdentificadorRegional = existeLinhaParaId(Integer.toString(id_regional));

        boolean resultado = true;

        if (!existeIdentificadorUnidade && existeIdentificadorLocalizacao && existeIdentificadorRegional) {

            sql = "INSERT INTO unidade_academica_ufg VALUES (?,?,?)";

            try {
                PreparedStatement stmt = this.con.prepareStatement(sql);

                stmt.setInt(1, id_unidade);
                stmt.setString(2, nome_unidade);
                stmt.setInt(3, id_localizacao);
                stmt.setInt(4, id_regional);
                stmt.execute();
                stmt.close();
                stmt.executeQuery();

            } catch (SQLException e) {
                Logger.getLogger(CursSupTest.class
                        .getName()).log(Level.SEVERE, null, e);

                resultado = false;
            }
        } else if (!existeIdentificadorLocalizacao) {
            System.out.println("Não existe um identificador no banco de dados para esta localizacao.");
            resultado = false;
        } else if (!existeIdentificadorRegional) {
            System.out.println("Não existe um identificador no banco de dados para esta regional.");
            resultado = false;
        } else if (existeIdentificadorUnidade) {
            System.out.println("Existe um identificador no banco de dados para esta unidade academica.");
            resultado = false;
        }

        return resultado;
    }

    private boolean insereLinhaAreaDeConhecimentoPrincial(String nome_area, int codigo_area) {

        boolean existeIdentificadorNome = existeLinhaParaId(nome_area);
        boolean existeIdentificadorCodigo = existeLinhaParaId(Integer.toString(codigo_area));
        boolean resultado = true;

        if (!existeIdentificadorNome && !existeIdentificadorCodigo) {

            sql = "INSERT INTO area_conhecimento VALUES (?,?,?,?)";

            try {
                PreparedStatement stmt = this.con.prepareStatement(sql);

                stmt.setString(1, nome_area);
                stmt.setInt(2, codigo_area);
                stmt.setString(3, null);
                stmt.setInt(4, 0);
                stmt.execute();
                stmt.close();
                stmt.executeQuery();

            } catch (SQLException e) {
                Logger.getLogger(CursSupTest.class
                        .getName()).log(Level.SEVERE, null, e);

                resultado = false;
            }
        } else {
            System.out.println("Existe area de conhecimento no banco de dados para estes identificadores.");
            resultado = false;
        }

        return resultado;
    }

    private boolean insereLinhaAreaDeConhecimentoSubArea(String nome_area, int codigo_area, String fk_nome_area, int fk_codigo_area) {

        boolean existeIdentificadorNome = existeLinhaParaId(nome_area);
        boolean existeIdentificadorCodigo = existeLinhaParaId(Integer.toString(codigo_area));
        boolean existeIdentificadorNomeFK = existeLinhaParaId(fk_nome_area);
        boolean existeIdentificadorCodigoFK = existeLinhaParaId(Integer.toString(fk_codigo_area));
        boolean resultado = true;

        if (!existeIdentificadorNome && !existeIdentificadorCodigo
                && existeIdentificadorNomeFK && existeIdentificadorCodigoFK) {

            sql = "INSERT INTO area_conhecimento VALUES (?,?,?,?)";

            try {
                PreparedStatement stmt = this.con.prepareStatement(sql);

                stmt.setString(1, nome_area);
                stmt.setInt(2, codigo_area);
                stmt.setString(3, fk_nome_area);
                stmt.setInt(4, fk_codigo_area);
                stmt.execute();
                stmt.close();
                stmt.executeQuery();

            } catch (SQLException e) {
                Logger.getLogger(CursSupTest.class
                        .getName()).log(Level.SEVERE, null, e);

                resultado = false;
            }
        } else if (existeIdentificadorNome || existeIdentificadorCodigo) {

            System.out.println("Existe area de conhecimento no banco de dados para estes identificadores.");
            resultado = false;

        } else if (!existeIdentificadorNomeFK || !existeIdentificadorCodigoFK) {

            System.out.println("Não existe area de conhecimento no banco de dados para estes identificadores estrangueiros.");
            resultado = false;

        } else if (fk_nome_area == null || fk_codigo_area == 0) {

            System.out.println("Identificadores de area de conhecimento princial nulos.");
            resultado = false;
        }

        return resultado;
    }

    private boolean insereCursoDaUFG(String nivel, String tipo_resolucao, int num_resolucao, boolean ePresencial, String turno, int id_unidade_academica, String id_nome_area, int id_codigo_area) {

        boolean existeIdentificadorUnidade = existeLinhaParaId(Integer.toString(id_unidade_academica));
        boolean existeIdentificadorNomeAreaConhecimento = existeLinhaParaId(id_nome_area);
        boolean existeIdentificadorCodigoAreaConhecimento = existeLinhaParaId(Integer.toString(id_codigo_area));
        boolean existeIdentificadorNumResolucao = existeLinhaParaId(Integer.toString(num_resolucao));
        boolean resultado = true;

        if (!existeIdentificadorNumResolucao && existeIdentificadorUnidade
                && existeIdentificadorNomeAreaConhecimento && existeIdentificadorCodigoAreaConhecimento) {

            sql = "INSERT INTO curso_ufg VALUES (?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement stmt = this.con.prepareStatement(sql);

                stmt.setString(1, nivel);
                stmt.setString(2, tipo_resolucao);
                stmt.setInt(3, num_resolucao);
                stmt.setBoolean(4, ePresencial);
                stmt.setString(5, turno);
                stmt.setInt(6, id_unidade_academica);
                stmt.setString(7, id_nome_area);
                stmt.setInt(8, id_codigo_area);
                stmt.execute();
                stmt.close();
                stmt.executeQuery();

            } catch (SQLException e) {
                Logger.getLogger(CursSupTest.class
                        .getName()).log(Level.SEVERE, null, e);

                resultado = false;
            }
        } else if (existeIdentificadorNumResolucao) {

            System.out.println("Existe no banco de dados para este identificador um numero de resolução.");
            resultado = false;

        } else if (!existeIdentificadorUnidade) {

            System.out.println("Não existe unidade academica no banco de dados para este identificador estrangueiro.");
            resultado = false;

        } else if (!existeIdentificadorNomeAreaConhecimento) {

            System.out.println("Não existe area de conhecimento no banco de dados para este identificador estrangueiro.");
            resultado = false;
        } else if (!existeIdentificadorCodigoAreaConhecimento) {

            System.out.println("Não existe area de conhecimento no banco de dados para este identificador estrangueiro.");
            resultado = false;
        }

        return resultado;
    }

    private boolean insereCursoDeOutraIES(int id_curso_ies, String nome_curso, String nivel, String nome_unidade_academica, String ies_curso, String tipo_instituicao, String url, String id_nome_area, int id_codigo_area) {

        boolean existeIdentificadorIES = existeLinhaParaId(Integer.toString(id_curso_ies));
        boolean existeIdentificadorNomeAreaConhecimento = existeLinhaParaId(id_nome_area);
        boolean existeIdentificadorCodigoAreaConhecimento = existeLinhaParaId(Integer.toString(id_codigo_area));
        boolean resultado = true;

        if (!existeIdentificadorIES && existeIdentificadorNomeAreaConhecimento 
                && existeIdentificadorCodigoAreaConhecimento) {

            sql = "INSERT INTO curso_outra_ies VALUES (?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement stmt = this.con.prepareStatement(sql);
                
                stmt.setInt(1, id_curso_ies);
                stmt.setString(2, nome_curso);
                stmt.setString(3, nivel);
                stmt.setString(4, nome_unidade_academica);
                stmt.setString(5, ies_curso);
                stmt.setString(6, tipo_instituicao);
                stmt.setString(7, url);
                stmt.setString(8, id_nome_area);
                stmt.setInt(9, id_codigo_area);
                stmt.execute();
                stmt.close();
                stmt.executeQuery();

            } catch (SQLException e) {
                Logger.getLogger(CursSupTest.class
                        .getName()).log(Level.SEVERE, null, e);

                resultado = false;
            }
        } else if (existeIdentificadorIES) {

            System.out.println("Existe no banco de dados para este identificador um curso de outra ies.");
            resultado = false;

        } else if (!existeIdentificadorNomeAreaConhecimento) {

            System.out.println("Não existe area de conhecimento no banco de dados para este identificador estrangueiro.");
            resultado = false;

        } else if (!existeIdentificadorCodigoAreaConhecimento) {

            System.out.println("Não existe area de conhecimento no banco de dados para este identificador estrangueiro.");
            resultado = false;
        }

        return resultado;
    }
}
