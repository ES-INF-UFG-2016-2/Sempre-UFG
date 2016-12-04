package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.Egresso;

public interface EgressoServiceInterface {

    Egresso atualizaEgresso(Egresso egresso) throws Exception;
    Egresso getEgresso(String nome);
    void removeEgresso(Egresso egresso) throws Exception;
}
