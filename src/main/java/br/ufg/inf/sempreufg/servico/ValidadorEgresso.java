package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.interfaces.ValidadorEgressoInterface;
import br.ufg.inf.sempreufg.modelo.Egresso;

public class ValidadorEgresso implements ValidadorEgressoInterface {

    @Override
    public boolean validaEgresso(Egresso egresso) {

        return false;
    }
}
