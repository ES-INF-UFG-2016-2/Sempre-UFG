package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.dao.EgressoDAO;
import br.ufg.inf.sempreufg.interfaces.EgressoServiceInterface;
import br.ufg.inf.sempreufg.modelo.Egresso;

import java.sql.SQLException;

public class EgressoService implements EgressoServiceInterface {

    static EgressoDAO egressoDAO;

    @Override
    public Egresso atualizaEgresso(Egresso egresso) throws Exception {
       egressoDAO = new EgressoDAO();
        try {
            egressoDAO.alterar(egresso);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível alterar o Egresso!");
        }

       return egressoDAO.getById(egresso.getId());
    }

    @Override
    public Egresso getEgresso(int id) {
        egressoDAO = new EgressoDAO();
        Egresso egresso = null;
        try {
            egresso = egressoDAO.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return egresso;
    }

    @Override
    public void removeEgresso(Egresso egresso) throws Exception {
        egressoDAO = new EgressoDAO();
        try {
            egressoDAO.deletar(egresso);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível remover o Egresso!");
        }
    }
}
