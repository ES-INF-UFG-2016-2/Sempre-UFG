package br.ufg.inf.interfaces;

import br.ufg.inf.modelo.HistoricoUFGStub;

import java.util.List;

/**
 * Created by user1 on 09/10/2016.
 */
public interface HistoricoUFGDAOInterface {

    public void salvar(HistoricoUFGStub historicoUFGStub);

    public void alterar(HistoricoUFGStub historicoUFGStub);

    public void deletar(int id_historicoUFG);

    public HistoricoUFGStub getById(int id_historicoUFG);

    public List<HistoricoUFGStub> getAll();

}
