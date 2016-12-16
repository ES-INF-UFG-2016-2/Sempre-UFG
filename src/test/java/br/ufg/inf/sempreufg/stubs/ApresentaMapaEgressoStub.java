package br.ufg.inf.sempreufg.stubs;

import br.ufg.inf.sempreufg.interfaces.ApresentaMapaEgressoInterface;
import br.ufg.inf.sempreufg.interfaces.Planilha;

public class ApresentaMapaEgressoStub implements ApresentaMapaEgressoInterface {

    @Override
    public boolean apresentaMapa(Planilha planilhaDeResultados) {
        if (planilhaDeResultados == null){
            throw new IllegalArgumentException("Nenhuma planilha de resultados foi passada.");
        }
        return false;
    }

    @Override
    public int contaResultadosPlanilha(Planilha planilhaDeResultados) {
        if (planilhaDeResultados == null){
            throw new IllegalArgumentException("Nenhuma planilha de resultados foi passada.");
        }
        return 0;
    }

    @Override
    public int contaResultadosPlanilhaPorCidade(Planilha planilhaDeResultados, String cidade) {
        if (planilhaDeResultados == null){
            throw new IllegalArgumentException("Nenhuma planilha de resultados foi passada.");
        }
        return 0;
    }
}
