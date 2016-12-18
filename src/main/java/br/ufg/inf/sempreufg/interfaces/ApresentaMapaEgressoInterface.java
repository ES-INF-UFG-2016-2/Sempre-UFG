package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;

public interface ApresentaMapaEgressoInterface {
    public boolean apresentaMapa(Planilha planilhaDeResultados);
    public int contaResultadosPlanilha(Planilha planilhaDeResultados);
    public int contaResultadosPlanilhaPorCidade(Planilha planilha, String cidade);
}
