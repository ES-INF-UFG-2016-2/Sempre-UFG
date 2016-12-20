package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.Entidade;

import java.util.List;

/**
 * Created by Marcos on 15/12/2016.
 */
public interface EntidadeDAOInterface {
    public Entidade salvar(Entidade entidade);

    public Entidade alterar(Entidade entidade);

    public Boolean deletar(Entidade entidade);

    Entidade getById(String id);

    List<Entidade> getAll();
}
