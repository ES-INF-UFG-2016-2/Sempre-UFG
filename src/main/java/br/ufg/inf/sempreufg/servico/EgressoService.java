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
        // Verificar próximo passo (retorno do método atualizaEgresso) junto ao projetista:
        return new Egresso();
        //O retorno do método alterar (EgressoDAO é boolean ao passo que o acima retorna o egresso alterado(?)
    }

    @Override
    public Egresso getEgresso(String nome) {
        return new Egresso();
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
