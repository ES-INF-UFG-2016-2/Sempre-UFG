package test.java.br.ufg.inf.rfExecCons;

import main.java.br.ufg.inf.consulta.IConsultaEgresso;
import main.java.br.ufg.inf.Curso;
import main.java.br.ufg.inf.Egresso;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class RFExecConsTest {

    private IConsultaEgresso consultaEgresso = new ConsultaEgressoMock();

    @Before
    public void setUp() throws Exception {


    }


    @Test
    public void TestConsultaPredefinidaSemParametrosComSucesso(){
        int identificador = 1;
        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<>();
        LinkedHashMap<String, String> resultadoObtido;

        preencheDadosEsperadosConsultaDeEgressosPredefinida(resultadoEsperado);
        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, null);

        Assert.assertEquals(resultadoEsperado.toString(), resultadoObtido.toString());

    }

    @Test
    public void TestConsultaPredefinidaComParametrosComSucesso(){
        int identificador = 1;
        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<>();
        LinkedHashMap<String, String> resultadoObtido;

        preencheDadosEsperadosConsultaDeEgressosPredefinida(resultadoEsperado);
        String parametros = "CURSO=MEDICINA AND NOME=MARIA";

        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, null);

        Assert.assertEquals(resultadoEsperado.toString(), resultadoObtido.toString());

    }

    private void preencheDadosEsperadosConsultaDeEgressosPredefinida(LinkedHashMap<String, String> resultadoEsperado){
        resultadoEsperado.put("NOME", "MARIA EDUARDA;JOAO PEDRO;HELENA PEREIRA");
        resultadoEsperado.put("DATANASCIMENTO", "01/01/1996;10/03/1994;05/09/1990");
        resultadoEsperado.put("CURSO", "MEDICINA;PEDAGOGIA;ENGENHARIA DE PETROLEO");
    }

    @Test
    public void TestConsultaPredefinidaComIdentificadorInexistente(){
        int identificador = 2;
        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<>();
        LinkedHashMap<String, String> resultadoObtido;

        resultadoEsperado.put("ERRO", "NAO EXISTE CONSULTA COM O IDENTIFICADOR: " + identificador);
        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, null);

        for (Map.Entry<String, String> nomeColuna  : resultadoEsperado.entrySet()) {
            Assert.assertEquals(resultadoEsperado.get(nomeColuna.getValue()), resultadoObtido.get(nomeColuna.getValue()));
        }

    }

    @Test
    public void TestConsultaPredefinidaComRetornoDeErroNaConsulta(){
        int identificador = 3;
        LinkedHashMap<String, String> resultadoObtido;

        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador, null);
        Assert.assertEquals(resultadoObtido.toString(), "{ERRO=NAO FOI POSSIVEL EXECUTAR A CONSULTA.}");
    }





    private void criaEgressos(){
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

    private Curso criaCurso(String nomeCurso){
        Curso curso = new Curso();
        curso.setNome(nomeCurso);
        return curso;
    }

    private Date geraData(){
        return new Date();
    }

}