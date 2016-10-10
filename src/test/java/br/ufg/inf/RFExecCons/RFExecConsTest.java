package br.ufg.inf.RFExecCons;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RFExecConsTest {

    private IExecCons consultaEgresso = new RFExecConsMock();

    @org.junit.Before
    public void setUp() throws Exception {

    }


    @Test
    public void TestConsultaPredefinidaComSucesso(){
        int identificador = 1;
        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> resultadoObtido;

        preencheDadosEsperadosConsultaDeEgressosPredefinida(resultadoEsperado);
        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador);

        Assert.assertEquals(resultadoEsperado.toString(), resultadoObtido.toString());

    }

    private void preencheDadosEsperadosConsultaDeEgressosPredefinida(LinkedHashMap<String, String> resultadoEsperado){
        resultadoEsperado.put("NOME", "MARIA EDUARDA;JOAO PEDRO,HELENA PEREIRA");
        resultadoEsperado.put("DATANASCIMENTO", "01/01/1996;10/03/1994;05/09/1990");
        resultadoEsperado.put("CURSO", "MEDICINA;PEDAGOGIA;ENGENHARIA DE PETROLEO");
    }

    @Test
    public void TestConsultaPredefinidaComIdentificadorInexistente(){
        int identificador = 2;
        LinkedHashMap<String, String> resultadoEsperado = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> resultadoObtido;

        resultadoEsperado.put("ERRO", "NAO EXISTE CONSULTA COM O IDENTIFICADOR: " + identificador);
        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador);

        for (Map.Entry<String, String> nomeColuna  : resultadoEsperado.entrySet()) {
            Assert.assertEquals(resultadoEsperado.get(nomeColuna.getValue()), resultadoObtido.get(nomeColuna.getValue()));
        }

    }


    @Test
    public void TestConsultaPredefinidaComRetornoDeErroNaConsulta(){
        int identificador = 3;
        LinkedHashMap<String, String> resultadoObtido;

        resultadoObtido = consultaEgresso.executaConsultaDeEgressosPredefinida(identificador);
        Assert.assertEquals(resultadoObtido.toString(), "{ERRO=NAO FOI POSSIVEL EXECUTAR A CONSULTA.}");
    }




}