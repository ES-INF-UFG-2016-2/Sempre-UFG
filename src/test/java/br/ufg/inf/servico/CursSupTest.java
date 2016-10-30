package br.ufg.inf.servico;

import br.ufg.inf.enums.Nivel;
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

/**
 *
 * @author JuliannyAS
 */
public class CursSupTest {

    CursSup curSup = new CursSup();

    //Cria os objetos ESPERADOS referentes as entidades da visão de cursos superiores
    private LocalizacaoGeografica localizacaoEsperada = insereValoresEsperadosLocalizacaoValidos();
    private RegionalUFG regionalEsperada = insereValoresEsperadosRegional();
    private UnidadeAcademica unidadeAcademicaEsperada = insereValoresEsperadosUnidadeAcademica();
    private AreaDeConhecimento areaConhecimentoEsperada = insereValoresEsperadosAreaDeConhecimento();
    private CursoUFG cursoUfgEsperada = insereValoresEsperadosCursoUFG();
    private CursoOutrasIES cursoOutraIesEsperada = insereValoresEsperadosCursoOutraIES();

    @Test
    public void testLocalizacaoGeograficaValido() {

        assertEquals(localizacaoEsperada, curSup.getLocalizacaoPorIdentificador(localizacaoEsperada.getId()));
    }

    @Test
    public void testLocalizacaoGeograficaInvalido() {

        //modifica o nome da unidade federativa
        localizacaoEsperada.setNomeDaUnidadeFederativa("RJ");

        assertEquals(localizacaoEsperada, curSup.getLocalizacaoPorIdentificador(localizacaoEsperada.getId()));
    }

    @Test
    public void testUnidadeAcademicaValido() {

        assertEquals(unidadeAcademicaEsperada, curSup.getUnidadeAcademicaPorIdentificador(unidadeAcademicaEsperada.getId()));
    }

    @Test
    public void testUnidadeAcademicaInvalido() {
        
         //restaga o identificador original antes da sua alteração
        int idUnidadeAcademica=  unidadeAcademicaEsperada.getId();
        
        //modifica unidade academica pertecente
        unidadeAcademicaEsperada.setNome("Faculdade de História");
        
        assertEquals(unidadeAcademicaEsperada, curSup.getUnidadeAcademicaPorIdentificador(idUnidadeAcademica));
    }

    @Test
    public void testRegionalValido() {

        assertEquals(regionalEsperada, curSup.getRegionalPorIdentificador(regionalEsperada.getId()));
    }

    @Test
    public void testRegionalInvalido() {

        //restaga o identificador original antes da sua alteração
        int idRegional = regionalEsperada.getId();
        
        //modifica a regional que compoem o id
        regionalEsperada.setRegional(Regional.JATAÍ);
        
        //modifica a regional
        assertEquals(regionalEsperada, curSup.getRegionalPorIdentificador(idRegional));
    }

    @Test
    public void testAreaDeConhecimentoValido() {

        assertEquals(areaConhecimentoEsperada, curSup.getAreaDeConhecimentoPorIdentificador(areaConhecimentoEsperada.getId()));
    }

    @Test
    public void testAreaDeConhecimentoInvalido() {

        //restaga o identificador original antes da sua alteração
        String idAreaConhecimento = areaConhecimentoEsperada.getId();

        //modifica o nome da area
        areaConhecimentoEsperada.setNomeArea("Humanas");

        assertEquals(areaConhecimentoEsperada, curSup.getAreaDeConhecimentoPorIdentificador(idAreaConhecimento));
    }

    @Test
    public void testCursoUFGValido() {

        assertEquals(cursoUfgEsperada, curSup.getCursoUFGPorIdentificador(cursoUfgEsperada.getNum_resolucao()));
    }

    @Test
    public void testCursoUFGInvalido() {

        //modifica o turno do curso
        cursoUfgEsperada.setTurno(Turno.MATUTINO);

        assertEquals(cursoUfgEsperada, curSup.getCursoUFGPorIdentificador(cursoUfgEsperada.getNum_resolucao()));
    }

    @Test
    public void testCursoOutraIESValido() {

        assertEquals(cursoOutraIesEsperada, curSup.getCursoOutraIESPorIdentificador(cursoOutraIesEsperada.getId()));
    }

    @Test
    public void testCursoOutraIESInvalido() {

        //modifica o nome do curso da outra ies
        cursoOutraIesEsperada.setNomeDoCurso("Sem nome");

        assertEquals(cursoOutraIesEsperada, curSup.getCursoOutraIESPorIdentificador(cursoOutraIesEsperada.getId()));
    }

    public LocalizacaoGeografica insereValoresEsperadosLocalizacaoValidos() {

        LocalizacaoGeografica localizacao = new LocalizacaoGeografica();
        String nomeDaCidade = "Goiânia";
        String nomeDaUnidadeFederativa = "Goiás";
        String nomeDoPais = "Brasil";
        String siglaDaUnidadeFederativa = "GO";
        float longitude = 12312;

        localizacao.setNomeDaCidade(nomeDaCidade);
        localizacao.setNomeDaUnidadeFederativa(nomeDaUnidadeFederativa);
        localizacao.setNomeDoPais(nomeDoPais);
        localizacao.setSiglaDaUnidadeFederativa(siglaDaUnidadeFederativa);
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

        Nivel nivel = Nivel.BACHARELADO;
        TipoResolucao tipoResolucao = TipoResolucao.CONSUNI;
        int numResolucao = 32;
        boolean ePresencial = true;
        Turno turno = Turno.INTEGRAL;
        CursoUFG cursoUfg = new CursoUFG(nivel, tipoResolucao, numResolucao, ePresencial, turno, this.areaConhecimentoEsperada, this.unidadeAcademicaEsperada);

        return cursoUfg;
    }

    public CursoOutrasIES insereValoresEsperadosCursoOutraIES() {

        String nomeCurso = "Rede de Computadores";
        Nivel nivel = Nivel.BACHARELADO;
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
