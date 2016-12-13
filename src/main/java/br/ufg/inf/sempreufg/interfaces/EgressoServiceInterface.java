package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.Egresso;

public interface EgressoServiceInterface {

    Egresso atualizaEgresso(Egresso egresso) throws Exception;
    Egresso getEgresso(int id);
    void removeEgresso(Egresso egresso) throws Exception;
}
