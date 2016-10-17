package main.java.br.ufg.inf.consulta;

import main.java.br.ufg.inf.excecoes.ErroNaConsultaException;
import main.java.br.ufg.inf.excecoes.IdentificadorInexistenteExepction;
import main.java.br.ufg.inf.excecoes.ParametrosErradosException;

import java.util.LinkedHashMap;
import java.util.List;

public interface IConsultaEgresso {
    LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, LinkedHashMap<String, String> parametros) throws IdentificadorInexistenteExepction, ParametrosErradosException, ErroNaConsultaException;
    LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(LinkedHashMap<String, String> colunasABuscar, LinkedHashMap<String, String> parametros);
    void atualizaDataUltimaConsulta(int identificadorConsulta);

}