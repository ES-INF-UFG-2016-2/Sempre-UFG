package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.Tabela;
import br.ufg.inf.sempreufg.excecoes.ErroNaConsultaException;

import java.util.List;

public interface ConsultaServicoInterface {
    Tabela executaConsultaDeEgressosPredefinida(
        int identificador, String filtroSelecao) throws ErroNaConsultaException;

    Tabela executaConsultaDeEgressosAdHoc(
        List<String> colunasABuscar, String filtroSelecao) throws ErroNaConsultaException;

    //TODO: Implementar obter consultas
    //List<Consulta> obterConsultasPreDefinidas();
}
