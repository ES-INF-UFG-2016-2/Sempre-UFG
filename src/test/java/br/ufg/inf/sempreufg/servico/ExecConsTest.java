package br.ufg.inf.sempreufg.servico;


import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.Turnos;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.excecoes.ColunaInexistenteException;
import br.ufg.inf.sempreufg.excecoes.ErroNaConsultaException;
import br.ufg.inf.sempreufg.excecoes.IdentificadorInexistenteExepction;
import br.ufg.inf.sempreufg.excecoes.ParametrosErradosException;
import br.ufg.inf.sempreufg.interfaces.ConsultaEgressoInterface;
import br.ufg.inf.sempreufg.modelo.CursoOutrasIES;
import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoOutrasIES;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.InstituicaoEnsino;
import br.ufg.inf.sempreufg.modelo.Residencia;
import br.ufg.inf.sempreufg.stubs.ConsultaEgressoMock;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class ExecConsTest {

    private ConsultaEgressoInterface consultaEgresso = new ConsultaEgressoMock();

    private static boolean setUpIsDone = false;

    public void setUp() throws ParseException {
        if (setUpIsDone) {
            return;
        }
        criaEgressos();
        setUpIsDone = true;
    }


    @Test
    public void TestConsultaPredefinidaSemParametrosComSucesso() throws ErroNaConsultaException {
        int identificador = 1;
        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> resultadoObtido;

        preencheDadosEsperadosConsultaDeEgressosPredefinidaSemParametros(resultadoEsperado);
        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, null);

        Assert.assertEquals(resultadoEsperado.toString(), resultadoObtido.toString());
        Assert.assertEquals(((ConsultaEgressoMock) consultaEgresso).getUltimaConsulta().toString(), (new Date()).toString());

    }

    @Test
    public void TestConsultaPredefinidaComParametrosMultiplosComSucesso() throws ErroNaConsultaException {
        int identificador = 2;
        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> resultadoObtido;

        preencheDadosEsperadosConsultaDeEgressosPredefinidaComParametros(resultadoEsperado);
        LinkedHashMap parametros = new LinkedHashMap();

        // supondo uma consulta pré-definida que verifique o nome e a data de nascimento do egresso pelo curso,
        // ano de nascimento e sexo

        //recebe o tipo do parâmetro e os valores do parâmetro

        parametros.put("CURSO", "MEDICINA");
        parametros.put("ANO_NASCIMENTO", "1990");
        parametros.put("SEXO", "MASCULINO");

        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, parametros);
        Assert.assertEquals(resultadoEsperado.toString(), resultadoObtido.toString());
        Assert.assertEquals(((ConsultaEgressoMock) consultaEgresso).getUltimaConsulta().toString(), (new Date()).toString());
    }

    @Test(expected = IdentificadorInexistenteExepction.class)
    public void TestConsultaPredefinidaComIdentificadorInexistente() throws ErroNaConsultaException {
        int identificador = 3;
        consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, null);
    }

    @Test(expected = ErroNaConsultaException.class)
    public void TestConsultaPredefinidaComRetornoDeErroNaConsulta() throws ErroNaConsultaException {
        int identificador = 4;
        consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, null);
    }

    @Test(expected = ParametrosErradosException.class)
    public void TestConsultaPredefinidaComParametrosIncompativeis() throws ErroNaConsultaException {
        int identificador = 5;
        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<String, String>();

        preencheDadosEsperadosConsultaDeEgressosPredefinidaComParametros(resultadoEsperado);
        LinkedHashMap parametros = new LinkedHashMap();

        // supondo uma consulta pré-definida que verifique o nome e a data de nascimento do egresso pelo curso,
        // ano de nascimento e sexo
        //recebe o tipo do parâmetro e os valores do parâmetro
        //supondo que a consulta espere um sexo e seja passado uma ano de nascimento
        parametros.put("CURSO", "MEDICINA");
        parametros.put("SEXO", "1990");

        consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, parametros);
    }


    @Test
    public void TestConsultaAdHocSemParametrosComSucesso() throws ErroNaConsultaException {
        List<String> colunasABuscar = new ArrayList<String>();
        preencheColunasABuscarDaConsultaHadHoc(colunasABuscar);

        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<String, String>();
        preencheDadosEsperadosConsultaDeEgressosAdHocSemParametros(resultadoEsperado);

        LinkedHashMap<String, String> resultadoObtido;
        resultadoObtido = consultaEgresso.executaConsultaDeEgressosAdHoc(colunasABuscar, null);

        Assert.assertEquals(resultadoEsperado.toString(), resultadoObtido.toString());

    }

    @Test
    public void TestConsultaAdHocComParametrosMultiplosComSucesso() throws ErroNaConsultaException {
        List<String> colunasABuscar = new ArrayList<String>();
        preencheColunasABuscarDaConsultaHadHoc(colunasABuscar);

        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<String, String>();
        preencheDadosEsperadosConsultaDeEgressosAdHocComParametros(resultadoEsperado);

        // supondo uma consulta ad hoc que retorne o nome, a data de nascimento e o curso,
        // dos egressos do sexo feminino
        // recebe o tipo do parâmetro e os valores do parâmetro

        LinkedHashMap parametros = new LinkedHashMap();
        parametros.put("SEXO", "FEMININO");

        LinkedHashMap<String, String> resultadoObtido;
        resultadoObtido = consultaEgresso.executaConsultaDeEgressosAdHoc(colunasABuscar, parametros);

        Assert.assertEquals(resultadoEsperado.toString(), resultadoObtido.toString());
    }

    @Test(expected = ColunaInexistenteException.class)
    public void TestConsultaAdHocComRetornoDeErroNaConsulta() throws ErroNaConsultaException {
        List<String> colunasABuscar = new ArrayList<String>();
        colunasABuscar.add("TESTE");
        preencheColunasABuscarDaConsultaHadHoc(colunasABuscar);

        consultaEgresso.executaConsultaDeEgressosAdHoc(colunasABuscar, null);
    }

    @Test(expected = ParametrosErradosException.class)
    public void TestConsultaAdHocComParametrosErrados() throws ErroNaConsultaException {
        List<String> colunasABuscar = new ArrayList<String>();
        preencheColunasABuscarDaConsultaHadHoc(colunasABuscar);

        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<String, String>();
        preencheDadosEsperadosConsultaDeEgressosAdHocComParametros(resultadoEsperado);

        // supondo uma consulta adhoc que retorne o nome e a data de nascimento do egresso pelo curso e sexo
        //recebe o tipo do parâmetro e os valores do parâmetro
        //supondo que a consulta espere um sexo e seja passado uma ano de nascimento
        LinkedHashMap parametros = new LinkedHashMap();
        parametros.put("CURSO", "MEDICINA");
        parametros.put("SEXO", "1990");

        consultaEgresso.executaConsultaDeEgressosAdHoc(colunasABuscar, parametros);
    }


    private void criaEgressos() throws ParseException {

        Egresso egressoI = new Egresso("546546"
        		                     , "MARIA EDUARDA"
        		                     , "MARIA MATILDA"
        		                     , geraLocalData("dd/mm/aaa", "01/01/1996")
        		                     , Sexo.FEMININO
        		                     , "mariaeduarda@gmail.com"
        		                     , ""
        		                     , null
        		                     , null
        		                     , VisibilidadeDados.PUBLICO
        		                     , new Residencia()
        		                     , new InstituicaoEnsino()
        		                     , new HistoricoOutrasIES()
        		                     , new ArrayList<CursoOutrasIES>()
        		                     , new ArrayList<CursoUFG>()
        		                     , criaListaHistoricoUfg("MEDICINA"));
        
        Egresso egressoII = new Egresso("4589763"
        							  , "JOAO PEDRO"
        							  , "JOANA PEDRA"
        							  , geraLocalData("dd/mm/aaa", "10/03/1994")
        							  , Sexo.MASCULINO
        							  ,"joao_pedrinho2008@hotmail.com"
        							  , ""
        							  , null
        							  , null
        							  , VisibilidadeDados.PRIVADO
        							  , new Residencia()
    						          , new InstituicaoEnsino()
						              , new HistoricoOutrasIES()
						              , new ArrayList<CursoOutrasIES>()
						              , new ArrayList<CursoUFG>() 
						              , criaListaHistoricoUfg("PEDAGOGIA"));

        Egresso egressoIII = new Egresso( "1235987"
        								, "HELENA PEREIRA"
        								, "MARIANA PEREIRA"
        								, geraLocalData("dd/mm/aaa", "05/09/1990")
        								, Sexo.MASCULINO
        								, "heleninha123@gmail.com"
        								, ""
        								, null
        								, null
        								, VisibilidadeDados.SO_EGRESSOS
        								, new Residencia()
        								, new InstituicaoEnsino()
        								, new HistoricoOutrasIES()
        								, new ArrayList<CursoOutrasIES>()
        								, new ArrayList<CursoUFG>()  
        								, criaListaHistoricoUfg("ENGENHARIA DE PETROLEO"));

    }

    private LocalDate geraLocalData(String string, String string2) {
		return null;
	}


	private List<HistoricoUFG> criaListaHistoricoUfg(String nomeCurso) {
        HistoricoUFG graduacaoI = new HistoricoUFG(123, 3, 3, 2010, 2016, criaCurso("MEDICINA"), null);
        List<HistoricoUFG> listaHistoricoUfg = new ArrayList<>();
        listaHistoricoUfg.add(graduacaoI);
        return listaHistoricoUfg;
    }

    private CursoUFG criaCurso(String nomeCurso) {
        CursoUFG cursoUFG = new CursoUFG(null, null, 1, true, Turnos.INTEGRAL, null);
        cursoUFG.setNome(nomeCurso);
        return cursoUFG;
    }

    private void preencheDadosEsperadosConsultaDeEgressosPredefinidaSemParametros(LinkedHashMap<String, String> resultadoEsperado) {
        resultadoEsperado.put("NOME", "MARIA EDUARDA;JOAO PEDRO;HELENA PEREIRA");
        resultadoEsperado.put("DATANASCIMENTO", "01/01/1996;10/03/1994;05/09/1990");
        resultadoEsperado.put("CURSO", "MEDICINA;PEDAGOGIA;ENGENHARIA DE PETROLEO");
    }

    private void preencheDadosEsperadosConsultaDeEgressosPredefinidaComParametros(LinkedHashMap<String, String> resultadoEsperado) {
        resultadoEsperado.put("NOME", "MARIA EDUARDA");
        resultadoEsperado.put("DATANASCIMENTO", "01/01/1996");
    }

    private Date geraData(String formato, String data) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
        return simpleDateFormat.parse(data);
    }

    private void preencheDadosEsperadosConsultaDeEgressosAdHocSemParametros(LinkedHashMap<String, String> resultadoEsperado) {
        resultadoEsperado.put("NOME", "MARIA EDUARDA;JOAO PEDRO;HELENA PEREIRA");
        resultadoEsperado.put("DATANASCIMENTO", "01/01/1996;10/03/1994;05/09/1990");
        resultadoEsperado.put("CURSO", "MEDICINA;PEDAGOGIA;ENGENHARIA DE PETROLEO");
    }

    private void preencheDadosEsperadosConsultaDeEgressosAdHocComParametros(LinkedHashMap<String, String> resultadoEsperado) {
        resultadoEsperado.put("NOME", "MARIA EDUARDA");
        resultadoEsperado.put("DATANASCIMENTO", "01/01/1996");
    }

    private void preencheColunasABuscarDaConsultaHadHoc(List<String> colunasABuscar) {
        colunasABuscar.add("NOME_EGRESSO");
        colunasABuscar.add("DATANASCIMENTO_EGRESSO");
        colunasABuscar.add("CURSO_EGRESSO");
    }
}
