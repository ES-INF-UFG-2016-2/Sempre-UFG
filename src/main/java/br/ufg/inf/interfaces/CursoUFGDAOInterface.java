package br.ufg.inf.interfaces;

import br.ufg.inf.modelo.CursoUFGStub;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public interface CursoUFGDAOInterface {

    public void salvar(CursoUFGStub cursoUFGStub);

    public void alterar(CursoUFGStub cursoUFGStub);

    public void deletar(int id_cursoUFG);

    public CursoUFGStub getById(int id_cursoUFG);

    public List<CursoUFGStub> getAll();
}
