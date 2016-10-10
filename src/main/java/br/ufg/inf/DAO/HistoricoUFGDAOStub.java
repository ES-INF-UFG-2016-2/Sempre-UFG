package br.ufg.inf.DAO;

import br.ufg.inf.modelo.HistoricoUFG;
import br.ufg.inf.interfaces.HistoricoUFGDAOInterface;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class HistoricoUFGDAOStub implements HistoricoUFGDAOInterface{
    @Override
    public void salvar(HistoricoUFG historicoUFG) {

    }

    @Override
    public void alterar(HistoricoUFG historicoUFG) {

    }

    @Override
    public void deletar(int id_historicoUFG) {

    }

    @Override
    public HistoricoUFG getById(int id_historicoUFG) {
        return null;
    }

    @Override
    public List<HistoricoUFG> getAll() {
        return null;
    }
}
