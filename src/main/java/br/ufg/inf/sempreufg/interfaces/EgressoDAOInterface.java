package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.Egresso;

import java.sql.SQLException;
import java.util.List;

public interface EgressoDAOInterface {

    public Egresso salvar(Egresso egresso) throws SQLException;

    public boolean alterar(Egresso egresso) throws SQLException;

    public boolean deletar(int id_Egresso) throws SQLException;

    public Egresso getById(int id_Egresso) throws SQLException;

    public List<Egresso> getAll() throws SQLException;
}
