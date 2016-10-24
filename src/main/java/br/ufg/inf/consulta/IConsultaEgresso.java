package main.java.br.ufg.inf.consulta;

import main.java.br.ufg.inf.excecoes.ErroNaConsultaException;

import java.util.LinkedHashMap;
import java.util.List;

public interface IConsultaEgresso {
    LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, LinkedHashMap<String, String> parametros) throws ErroNaConsultaException;
    LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(List<String> colunasABuscar, LinkedHashMap<String, String> parametros) throws ErroNaConsultaException;
    void atualizaDataUltimaConsulta(int identificadorConsulta);

}