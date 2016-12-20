package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.Egresso;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface EgressoDaoInterface<T extends Serializable> extends IDao<T>{

    public int salvar(Egresso egresso) throws Exception;

    public void atualizar(Egresso egressoAtualizado) throws SQLException;

    public void deletar(int id) throws SQLException;

    public Egresso getById(int id) throws Exception;

    public List<Egresso> getAll() throws SQLException;

}
