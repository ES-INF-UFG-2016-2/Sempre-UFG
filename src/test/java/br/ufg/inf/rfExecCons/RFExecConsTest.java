package test.java.br.ufg.inf.rfExecCons;

import main.java.br.ufg.inf.Curso;
import main.java.br.ufg.inf.Egresso;
import main.java.br.ufg.inf.consulta.IConsultaEgresso;
import main.java.br.ufg.inf.excecoes.ColunaInexistenteException;
import main.java.br.ufg.inf.excecoes.ErroNaConsultaException;
import main.java.br.ufg.inf.excecoes.IdentificadorInexistenteExepction;
import main.java.br.ufg.inf.excecoes.ParametrosErradosException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RFExecConsTest {

    private IConsultaEgresso consultaEgresso = new ConsultaEgressoMock();

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
        Assert.assertEquals(((ConsultaEgressoMock)consultaEgresso).getUltimaConsulta(), new Date());

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
        Assert.assertEquals(((ConsultaEgressoMock)consultaEgresso).getUltimaConsulta(), new Date());
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
        preencheDadosEsperadosConsultaDeEgressosPredefinidaComParametros(resultadoEsperado);

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
        preencheDadosEsperadosConsultaDeEgressosPredefinidaComParametros(resultadoEsperado);

        // supondo uma consulta adhoc que retorne o nome e a data de nascimento do egresso pelo curso e sexo
        //recebe o tipo do parâmetro e os valores do parâmetro
        //supondo que a consulta espere um sexo e seja passado uma ano de nascimento
        LinkedHashMap parametros = new LinkedHashMap();
        parametros.put("CURSO", "MEDICINA");
        parametros.put("SEXO", "1990");

        consultaEgresso.executaConsultaDeEgressosAdHoc(colunasABuscar, parametros);
    }


    private void criaEgressos() throws ParseException {
        Egresso egressoI = new Egresso();
        egressoI.setNome("MARIA EDUARDA");
        egressoI.setDataNascimento(geraData("dd/mm/aaa","01/01/1996"));
        egressoI.setCurso(criaCurso("MEDICINA"));

        Egresso egressoII = new Egresso();
        egressoII.setNome("JOAO PEDRO");
        egressoII.setDataNascimento(geraData("dd/mm/aaa","10/03/1994"));
        egressoII.setCurso(criaCurso("PEDAGOGIA"));

        Egresso egressoIII = new Egresso();
        egressoIII.setNome("HELEN PEREIRA");
        egressoIII.setDataNascimento(geraData("dd/mm/aaa","05/09/1990"));
        egressoIII.setCurso(criaCurso("ENGENHARIA DE PETROLEO"));

    }

    private Curso criaCurso(String nomeCurso) {
        Curso curso = new Curso();
        curso.setNome(nomeCurso);
        return curso;
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
