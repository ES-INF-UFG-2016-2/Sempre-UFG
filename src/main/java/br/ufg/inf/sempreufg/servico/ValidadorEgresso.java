package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.dao.EgressoDAO;
import br.ufg.inf.sempreufg.interfaces.ValidadorEgressoInterface;
import br.ufg.inf.sempreufg.modelo.Egresso;

public class ValidadorEgresso implements ValidadorEgressoInterface {

    @Override
    public boolean validaEgresso(int id) {

        EgressoDAO egressoDAO = new EgressoDAO();
        Egresso egresso = null;

        try {
            egresso = egressoDAO.getById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (egresso == null) return false;
        else return true;
    }
}
