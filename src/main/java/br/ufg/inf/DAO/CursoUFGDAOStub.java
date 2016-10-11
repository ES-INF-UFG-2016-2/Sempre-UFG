package br.ufg.inf.DAO;

import br.ufg.inf.modelo.CursoUFGStub;
import br.ufg.inf.interfaces.CursoUFGDAOInterface;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class CursoUFGDAOStub implements CursoUFGDAOInterface{
    @Override
    public void salvar(CursoUFGStub cursoUFGStub) {

    }

    @Override
    public void alterar(CursoUFGStub CursoUFGStub) {

    }

    @Override
    public void deletar(int id_cursoUFG) {

    }

    @Override
    public CursoUFGStub getById(int id_cursoUFG) {
        return null;
    }

    @Override
    public List<CursoUFGStub> getAll() {
        return null;
    }
}
