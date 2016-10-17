package test.java.br.ufg.inf.rfExecCons;

import main.java.br.ufg.inf.Curso;
import main.java.br.ufg.inf.Egresso;
import main.java.br.ufg.inf.consulta.IConsultaEgresso;
import main.java.br.ufg.inf.excecoes.ErroNaConsultaException;
import main.java.br.ufg.inf.excecoes.IdentificadorInexistenteExepction;
import main.java.br.ufg.inf.excecoes.ParametrosErradosException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedHashMap;

public class RFExecConsTest {

    private IConsultaEgresso consultaEgresso = new ConsultaEgressoMock();

    private static boolean setUpIsDone = false;

    public void setUp() {
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

    }

    @Test
    public void TestConsultaPredefinidaComParametroUnicoComSucesso() throws ErroNaConsultaException {
        int identificador = 4;
        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> resultadoObtido;

        preencheDadosEsperadosConsultaDeEgressosPredefinidaComParametros(resultadoEsperado);
        LinkedHashMap parametros = new LinkedHashMap();

        //supondo uma consulta pré-definida que verifique o nome e a data de nascimento do egresso pelo curso
        //recebe o tipo do parâmetro e os valores do parâmetro

        parametros.put("CURSO", "MEDICINA");

        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, parametros);

        Assert.assertEquals(resultadoEsperado.toString(), resultadoObtido.toString());
    }

    @Test
    public void TestConsultaPredefinidaComParametrosMultiplosComSucesso() throws ErroNaConsultaException {
        int identificador = 5;
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
    }

    @Test(expected = IdentificadorInexistenteExepction.class)
    public void TestConsultaPredefinidaComIdentificadorInexistente() throws ErroNaConsultaException {
        int identificador = 2;
        consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, null);
    }

    @Test(expected = ErroNaConsultaException.class)
    public void TestConsultaPredefinidaComRetornoDeErroNaConsulta() throws ErroNaConsultaException {
        int identificador = 3;
        consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, null);
    }

    @Test(expected = ParametrosErradosException.class)
    public void TestConsultaPredefinidaComParametrosErrados() throws ErroNaConsultaException {
        int identificador = 6;
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


    private void criaEgressos() {
        Egresso egressoI = new Egresso();
        egressoI.setNome("MARIA EDUARDA");
        egressoI.setDataNascimento(geraData());
        egressoI.setCurso(criaCurso("MEDICINA"));

        Egresso egressoII = new Egresso();
        egressoII.setNome("JOAO PEDRO");
        egressoII.setDataNascimento(geraData());
        egressoII.setCurso(criaCurso("PEDAGOGIA"));

        Egresso egressoIII = new Egresso();
        egressoIII.setNome("HELEN PEREIRA");
        egressoIII.setDataNascimento(geraData());
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

    private Date geraData() {
        return new Date();
    }

}
