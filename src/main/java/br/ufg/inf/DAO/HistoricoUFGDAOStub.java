package br.ufg.inf.DAO;

import br.ufg.inf.modelo.HistoricoUFGStub;
import br.ufg.inf.interfaces.HistoricoUFGDAOInterface;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class HistoricoUFGDAOStub implements HistoricoUFGDAOInterface{
    @Override
    public void salvar(HistoricoUFGStub historicoUFGStub) {

    }

    @Override
    public void alterar(HistoricoUFGStub historicoUFGStub) {

    }

    @Override
    public void deletar(int id_historicoUFG) {

    }

    @Override
    public HistoricoUFGStub getById(int id_historicoUFG) {
        return null;
    }

    @Override
    public List<HistoricoUFGStub> getAll() {
        return null;
    }
}
