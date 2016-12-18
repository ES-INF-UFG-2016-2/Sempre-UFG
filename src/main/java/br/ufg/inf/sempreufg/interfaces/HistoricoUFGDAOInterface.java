package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.HistoricoUFG;

import java.util.List;

/**
 * Created by user1 on 09/10/2016.
 */
public interface HistoricoUFGDAOInterface {

    public void salvar(HistoricoUFG historicoUFG);

    public void alterar(HistoricoUFG historicoUFG);

    public void deletar(int id_historicoUFG);

    public HistoricoUFG getById(int id_historicoUFG);

    public List<HistoricoUFG> getAll();

}
