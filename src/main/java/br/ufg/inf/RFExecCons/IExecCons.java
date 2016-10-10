package br.ufg.inf.RFExecCons;

import java.util.LinkedHashMap;
import java.util.List;

public interface IExecCons {

    LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador);
    LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, List<String> parametros);
    LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(List<String> colunasABuscar);
    LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(List<String> colunasABuscar, List<String> parametros);
    void atualizaDataUltimaConsulta(int identificadorConsulta);

}
