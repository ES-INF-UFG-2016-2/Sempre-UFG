package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.CursoUFG;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public interface CursoUFGDAOInterface {

    public void salvar(CursoUFG cursoUFG);

    public void alterar(CursoUFG cursoUFG);

    public void deletar(int id_cursoUFG);

    public CursoUFG getById(int id_cursoUFG);

    public List<CursoUFG> getAll();
}
