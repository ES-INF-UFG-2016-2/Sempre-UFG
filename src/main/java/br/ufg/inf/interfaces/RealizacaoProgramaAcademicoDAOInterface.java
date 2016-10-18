package br.ufg.inf.interfaces;

import br.ufg.inf.modelo.RealizacaoProgramaAcademico;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public interface RealizacaoProgramaAcademicoDAOInterface {

    public void salvar(RealizacaoProgramaAcademico realizacaoProgramaAcademico);

    public void alterar(RealizacaoProgramaAcademico realizacaoProgramaAcademico);

    public void deletar(int id_realizacaoProgramaAcademico);

    public RealizacaoProgramaAcademico getById(int id_realizacaoProgramaAcademico);

    public List<RealizacaoProgramaAcademico> getAll();
}

