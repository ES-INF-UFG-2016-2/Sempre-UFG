package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.excecoes.ErroNaConsultaException;

import java.util.LinkedHashMap;
import java.util.List;

public interface ConsultaEgressoInterface {
    LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, LinkedHashMap<String, String> parametros) throws ErroNaConsultaException;
    LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(List<String> colunasABuscar, LinkedHashMap<String, String> parametros) throws ErroNaConsultaException;
    void atualizaDataUltimaConsulta(int identificadorConsulta);

}
