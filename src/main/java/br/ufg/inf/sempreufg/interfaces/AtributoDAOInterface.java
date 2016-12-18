package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.Atributo;

import java.util.List;

/**
 * Created by Marcos on 15/12/2016.
 */
public interface AtributoDAOInterface {
    public Atributo salvar(Atributo atributo);

    public Atributo alterar(Atributo atributo);

    public Boolean deletar(Atributo atributo);

    public Atributo getById(String id);

    public List<Atributo> getAll();
}
