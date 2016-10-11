package main.java.br.ufg.inf.consulta;

import java.util.LinkedHashMap;
import java.util.List;


public interface IConsultaEgresso {
    LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, List<String> parametros);
    LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(List<String> colunasABuscar, List<String> parametros);
    void atualizaDataUltimaConsulta(int identificadorConsulta);

}
