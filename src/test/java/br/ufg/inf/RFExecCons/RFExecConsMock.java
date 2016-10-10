package br.ufg.inf.RFExecCons;

import java.util.LinkedHashMap;
import java.util.List;

public class RFExecConsMock implements IExecCons {
    @Override
    public LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador) {
        LinkedHashMap<String, String> resultado = new LinkedHashMap<String, String>();

        //realiza consulta

        //preenche a variavel 'resultado'

        if (identificador == 1) {
            resultado.put("NOME", "MARIA EDUARDA;JOAO PEDRO,HELENA PEREIRA");
            resultado.put("DATANASCIMENTO", "01/01/1996;10/03/1994;05/09/1990");
            resultado.put("CURSO", "MEDICINA;PEDAGOGIA;ENGENHARIA DE PETROLEO");
        }else if(identificador == 2){
            resultado.put("ERRO", "NAO EXISTE CONSULTA COM O IDENTIFICADOR: " + identificador);
        } else if(identificador == 3){
            resultado.put("ERRO", "NAO FOI POSSIVEL EXECUTAR A CONSULTA.");
        }

        return resultado;
    }

    @Override
    public LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, List<String> parametros) {
        return null;
    }

    @Override
    public LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(List<String> colunasABuscar) {
        return null;
    }

    @Override
    public LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(List<String> colunasABuscar, List<String> parametros) {
        return null;
    }

    @Override
    public void atualizaDataUltimaConsulta(int identificadorConsulta) {

    }
}
