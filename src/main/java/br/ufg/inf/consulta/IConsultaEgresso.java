package main.java.br.ufg.inf.consulta;

import java.util.LinkedHashMap;
import java.util.List;

public interface IConsultaEgresso {
    LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, LinkedHashMap<String, String> parametros);
    LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(LinkedHashMap<String, String> colunasABuscar, LinkedHashMap<String, String> parametros);
    void atualizaDataUltimaConsulta(int identificadorConsulta);

}