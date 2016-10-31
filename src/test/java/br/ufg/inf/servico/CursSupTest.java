package br.ufg.inf.servico;

import br.ufg.inf.enums.NiveisCurso;
import br.ufg.inf.enums.Regional;
import br.ufg.inf.enums.TipoInstituicao;
import br.ufg.inf.enums.TipoResolucao;
import br.ufg.inf.enums.Turno;
import br.ufg.inf.modelo.AreaDeConhecimento;
import br.ufg.inf.modelo.CursoOutrasIES;
import br.ufg.inf.modelo.CursoUFG;
import br.ufg.inf.modelo.LocalizacaoGeografica;
import br.ufg.inf.modelo.RegionalUFG;
import br.ufg.inf.modelo.UnidadeAcademica;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author JuliannyAS
 */
public class CursSupTest {

    CursSup cursSup;

    private LocalizacaoGeografica localizacaoEsperada;
    private RegionalUFG regionalEsperada;
    private UnidadeAcademica unidadeAcademicaEsperada;
    private AreaDeConhecimento areaConhecimentoEsperada;
    private CursoUFG cursoUfgEsperada;
    private CursoOutrasIES cursoOutraIesEsperada;

    @Before
    public void setUp() {

        cursSup = new CursSup();

        //Cria os objetos ESPERADOS referentes as entidades da visão de cursos superiores
        localizacaoEsperada = insereValoresEsperadosLocalizacaoValidos();
        regionalEsperada = insereValoresEsperadosRegional();
        unidadeAcademicaEsperada = insereValoresEsperadosUnidadeAcademica();
        areaConhecimentoEsperada = insereValoresEsperadosAreaDeConhecimento();
        cursoUfgEsperada = insereValoresEsperadosCursoUFG();
        cursoOutraIesEsperada = insereValoresEsperadosCursoOutraIES();
    }

    @Test
    public void testCursoUfgPertenceAreaDeConhecimento() {

        boolean inserida;

        try {

            String idAntigo = cursoUfgEsperada.getArea_de_conhecimento().getId();
            AreaDeConhecimento segundaAreaConhecimento = new AreaDeConhecimento("biologica932", "biologica", 932);
            cursoUfgEsperada.setArea_de_conhecimento(segundaAreaConhecimento);

            assertNotEquals(idAntigo, cursoUfgEsperada.getArea_de_conhecimento().getId());
            inserida = true;

        } catch (Exception e) {

            inserida = false;
        }

        assertTrue("minimo uma e no maximo uma area de conhecimento por curso na ufg.", inserida);
    }

    @Test
    public void testCursoOutraIesPertenceAreaDeConhecimento() {

        boolean inserida;

        try {

            String idAntigo = cursoUfgEsperada.getArea_de_conhecimento().getId();
            AreaDeConhecimento segundaAreaConhecimento = new AreaDeConhecimento("biologica932", "biologica", 932);
            cursoUfgEsperada.setArea_de_conhecimento(segundaAreaConhecimento);

            assertNotEquals(idAntigo, cursoUfgEsperada.getArea_de_conhecimento().getId());
            inserida = true;

        } catch (Exception e) {

            inserida = false;
        }

        assertTrue("maximo uma area de conhecimento por curso na ufg.", inserida);
    }

    @Test
    public void testUnidadeAcademicaPertenceRegionalUFG() {

        boolean inserida;

        try {
            int idAntigo = unidadeAcademicaEsperada.getRegional().getId();
            RegionalUFG segundaRegional = new RegionalUFG(2, Regional.APARECIDA_DE_GOIÂNIA, new LocalizacaoGeografica(null, null, null, null, null));
            unidadeAcademicaEsperada.setRegional(segundaRegional);

            assertNotEquals(idAntigo, unidadeAcademicaEsperada.getRegional().getId());
            inserida = true;

        } catch (Exception e) {

            inserida = false;
        }

        assertTrue("minimo uma e no maximo uma regional por unidade academica.", inserida);
    }

    @Test
    public void testRetornaCursosSuperioresSucesso() {

        assertTrue("Cursos superiores retornados.", cursSup.getTodosCursosSuperiores());
    }

    @Test
    public void testLocalizacaoGeograficaValido() {
        
        assertEquals(localizacaoEsperada.hashCode(), cursSup.getLocalizacaoPorIdentificador(localizacaoEsperada.getId()).hashCode());
    }

    @Test
    public void testLocalizacaoGeograficaNull() {

        assertNull("Retornou localização vazia.", cursSup.getLocalizacaoPorIdentificador(localizacaoEsperada.getId()));
    }

    @Test
    public void testLocalizacaoGeograficaInvalido() {

        //modifica o nome da unidade federativa
        localizacaoEsperada.setNomeDaUnidadeFederativa("RJ");

        assertEquals(localizacaoEsperada, cursSup.getLocalizacaoPorIdentificador(localizacaoEsperada.getId()));
    }

    @Test
    public void testUnidadeAcademicaValido() {

        assertEquals(unidadeAcademicaEsperada, cursSup.getUnidadeAcademicaPorIdentificador(unidadeAcademicaEsperada.getId()));
    }

    @Test
    public void testUnidadeAcademicaNull() {

        assertNull("Retornou unidade academica vazia.", cursSup.getUnidadeAcademicaPorIdentificador(unidadeAcademicaEsperada.getId()));
    }

    @Test
    public void testUnidadeAcademicaInvalido() {

        //restaga o identificador original antes da sua alteração
        int idUnidadeAcademica = unidadeAcademicaEsperada.getId();

        //modifica unidade academica pertecente
        unidadeAcademicaEsperada.setNome("Faculdade de História");

        assertEquals(unidadeAcademicaEsperada, cursSup.getUnidadeAcademicaPorIdentificador(idUnidadeAcademica));
    }

    @Test
    public void testRegionalValido() {

        assertEquals(regionalEsperada, cursSup.getRegionalPorIdentificador(regionalEsperada.getId()));
    }

    @Test
    public void testRegionalNull() {

        assertNull("Retornou regional vaiza.", cursSup.getRegionalPorIdentificador(regionalEsperada.getId()));
    }

    @Test
    public void testRegionalInvalido() {

        //restaga o identificador original antes da sua alteração
        int idRegional = regionalEsperada.getId();

        //modifica a regional que compoem o id
        regionalEsperada.setRegional(Regional.JATAÍ);

        //modifica a regional
        assertEquals(regionalEsperada, cursSup.getRegionalPorIdentificador(idRegional));
    }

    @Test
    public void testAreaDeConhecimentoValido() {

        assertEquals(areaConhecimentoEsperada, cursSup.getAreaDeConhecimentoPorIdentificador(areaConhecimentoEsperada.getId()));
    }

    @Test
    public void testAreaDeConhecimentoNull() {

        assertNull("Retornou area de conhecimento vazio.", cursSup.getAreaDeConhecimentoPorIdentificador(areaConhecimentoEsperada.getId()));
    }

    @Test
    public void testAreaDeConhecimentoInvalido() {

        //restaga o identificador original antes da sua alteração
        String idAreaConhecimento = areaConhecimentoEsperada.getId();

        //modifica o nome da area
        areaConhecimentoEsperada.setNomeArea("Humanas");

        assertEquals(areaConhecimentoEsperada, cursSup.getAreaDeConhecimentoPorIdentificador(idAreaConhecimento));
    }

    @Test
    public void testCursoUFGValido() {

        assertEquals(cursoUfgEsperada, cursSup.getCursoUFGPorIdentificador(cursoUfgEsperada.getNum_resolucao()));
    }

    @Test
    public void testCursoUFGNull() {

        assertNull("Retornou curso da ufg vazio.", cursSup.getCursoUFGPorIdentificador(cursoUfgEsperada.getNum_resolucao()));
    }

    @Test
    public void testCursoUFGInvalido() {

        //modifica o turno do curso
        cursoUfgEsperada.setTurno(Turno.MATUTINO);

        assertEquals(cursoUfgEsperada, cursSup.getCursoUFGPorIdentificador(cursoUfgEsperada.getNum_resolucao()));
    }

    @Test
    public void testCursoOutraIESValido() {

        assertEquals(cursoOutraIesEsperada, cursSup.getCursoOutraIESPorIdentificador(cursoOutraIesEsperada.getId()));
    }

    @Test
    public void testCursoOutraIESNull() {

        assertNull("Retornou curso de outra ies vazio.", cursSup.getCursoOutraIESPorIdentificador(cursoOutraIesEsperada.getId()));
    }

    @Test
    public void testCursoOutraIESInvalido() {

        //modifica o nome do curso da outra ies
        cursoOutraIesEsperada.setNomeDoCurso("Sem nome");

        assertEquals(cursoOutraIesEsperada, cursSup.getCursoOutraIESPorIdentificador(cursoOutraIesEsperada.getId()));
    }

    public LocalizacaoGeografica insereValoresEsperadosLocalizacaoValidos() {

        String id = "3";
        String nomeDaCidade = "Goiânia";
        String nomeDaUnidadeFederativa = "Goiás";
        String nomeDoPais = "Brasil";
        String siglaDaUnidadeFederativa = "GO";
        float longitude = 12312;

        LocalizacaoGeografica localizacao = new LocalizacaoGeografica(id, nomeDaCidade, nomeDaUnidadeFederativa, nomeDoPais, siglaDaUnidadeFederativa);
        localizacao.setLongitude(longitude);

        return localizacao;
    }

    public RegionalUFG insereValoresEsperadosRegional() {

        int id = 1;
        RegionalUFG regional = new RegionalUFG(id, Regional.GOIÂNIA_CÂMPUS_SAMAMBAIA, this.localizacaoEsperada);

        return regional;
    }

    public UnidadeAcademica insereValoresEsperadosUnidadeAcademica() {

        int id = 3;
        String nome = "Faculdade de Letras";

        UnidadeAcademica unidade = new UnidadeAcademica(id, nome, this.localizacaoEsperada, this.regionalEsperada);

        return unidade;
    }

    public AreaDeConhecimento insereValoresEsperadosAreaDeConhecimento() {

        String nomeArea = "Exatas";
        int codigoArea = 4;
        String id = "Exatas4";
        AreaDeConhecimento area = new AreaDeConhecimento(id, nomeArea, codigoArea);

        return area;
    }

    public CursoUFG insereValoresEsperadosCursoUFG() {

        NiveisCurso nivel = NiveisCurso.BACHARELADO;
        TipoResolucao tipoResolucao = TipoResolucao.CONSUNI;
        int numResolucao = 32;
        boolean ePresencial = true;
        Turno turno = Turno.INTEGRAL;
        CursoUFG cursoUfg = new CursoUFG(nivel, tipoResolucao, numResolucao, ePresencial, turno, this.areaConhecimentoEsperada, this.unidadeAcademicaEsperada);

        return cursoUfg;
    }

    public CursoOutrasIES insereValoresEsperadosCursoOutraIES() {

        String nomeCurso = "Rede de Computadores";
        NiveisCurso nivel = NiveisCurso.BACHARELADO;
        String unidade = "Faculdade de Tecnologia";
        String iesCurso = "Universidade Paulista";
        TipoInstituicao tipoInstituicao = TipoInstituicao.Particular;
        String url = "www.unip.com.br";
        String id = nomeCurso;

        CursoOutrasIES cursoOutraIes = new CursoOutrasIES(id, nomeCurso, unidade, iesCurso, iesCurso, nivel, tipoInstituicao, this.areaConhecimentoEsperada);
        cursoOutraIes.setUrl(url);
        cursoOutraIes.setUnidadeAcademia(unidade);

        return cursoOutraIes;
    }
}
