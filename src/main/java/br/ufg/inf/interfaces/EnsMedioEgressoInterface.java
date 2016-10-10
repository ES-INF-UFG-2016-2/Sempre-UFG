package br.ufg.inf.interfaces;

import java.util.List;

import br.ufg.inf.DAO.HistoricoEnsinoMedioDAO;

public interface EnsMedioEgressoInterface {

	public void salvar(HistoricoEnsinoMedioDAO historicoEnsinoMedio);

    public void alterar(HistoricoEnsinoMedioDAO historicoEnsinoMedio);

    public void deletar(int id_historicoEnsinoMedio);

    public HistoricoEnsinoMedioDAO getById(int id_historicoEnsinoMedio);

    public List<HistoricoEnsinoMedioDAO> getAll();
}
