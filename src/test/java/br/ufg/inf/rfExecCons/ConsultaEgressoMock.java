package test.java.br.ufg.inf.rfExecCons;

import main.java.br.ufg.inf.consulta.IConsultaEgresso;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class ConsultaEgressoMock implements IConsultaEgresso {
    private Date ultimaConsulta;

    @Override
    public LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, List<String> parametros) {

        LinkedHashMap<String, String> resultado = new LinkedHashMap<>();

        switch (identificador){
            case 1: resultadoDesejadoParaConsultaDeEgressoPredefinidaComSucesso(resultado);
            case 2: resultadoParaConsultaDeEgressoPredefinidaComIdentificadorInexistente(resultado, 2);
            case 3: resultadoDesejadoParaConsultaDeEgressoPredefinidaComFalha(resultado, 3);
            default: return null;
        }
    }

    @Override
    public LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(List<String> colunasABuscar, List<String> parametros) {
        return null;
    }

    @Override
    public void atualizaDataUltimaConsulta(int identificadorConsulta) {
        ultimaConsulta.setTime(System.currentTimeMillis());
    }

    public Date getUltimaConsulta() {
        return ultimaConsulta;
    }

    public void setUltimaConsulta(Date ultimaConsulta) {
        this.ultimaConsulta = ultimaConsulta;
    }

    private LinkedHashMap<String, String> resultadoDesejadoParaConsultaDeEgressoPredefinidaComSucesso(LinkedHashMap<String, String> resultado) {
        resultado.put("NOME", "MARIA EDUARDA;JOAO PEDRO,HELENA PEREIRA");
        resultado.put("DATANASCIMENTO", "01/01/1996;10/03/1994;05/09/1990");
        resultado.put("CURSO", "MEDICINA;PEDAGOGIA;ENGENHARIA DE PETROLEO");

        return resultado;
    }

    private LinkedHashMap<String, String> resultadoParaConsultaDeEgressoPredefinidaComIdentificadorInexistente(LinkedHashMap<String, String> resultado, int identificador) {
        resultado.put("ERRO", "NAO EXISTE CONSULTA COM O IDENTIFICADOR: " + identificador);
        return resultado;
    }

    private LinkedHashMap<String, String> resultadoDesejadoParaConsultaDeEgressoPredefinidaComFalha(LinkedHashMap<String, String> resultado, int identificador) {
        resultado.put("ERRO", "NAO FOI POSSIVEL EXECUTAR A CONSULTA.");
        return resultado;
    }
}
