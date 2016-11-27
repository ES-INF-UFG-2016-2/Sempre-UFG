package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.Egresso;

import java.util.List;

public interface EgressoDAOInterface {

    public Egresso salvar(Egresso egresso);

    public boolean alterar(Egresso egresso);

    public boolean deletar(int id_egresso);

    public Egresso getById(int id_egresso);

    public List<Egresso> getAll();
}
