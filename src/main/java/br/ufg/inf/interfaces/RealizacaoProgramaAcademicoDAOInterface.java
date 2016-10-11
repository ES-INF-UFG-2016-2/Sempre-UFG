package br.ufg.inf.interfaces;

import br.ufg.inf.modelo.RealizacaoProgramaAcademicoStub;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public interface RealizacaoProgramaAcademicoDAOInterface {

    public void salvar(RealizacaoProgramaAcademicoStub realizacaoProgramaAcademicoStub);

    public void alterar(RealizacaoProgramaAcademicoStub realizacaoProgramaAcademicoStub);

    public void deletar(int id_realizacaoProgramaAcademico);

    public RealizacaoProgramaAcademicoStub getById(int id_realizacaoProgramaAcademico);

    public List<RealizacaoProgramaAcademicoStub> getAll();
}

