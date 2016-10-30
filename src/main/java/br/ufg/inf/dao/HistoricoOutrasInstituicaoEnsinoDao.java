package br.ufg.inf.dao;

import java.util.List;
import java.util.Map;

import br.ufg.inf.interfaces.HistoricoOutrasIntituicaoEnsinoDaoInterface;
import br.ufg.inf.modelo.HistoricoOutrasIES;

public class HistoricoOutrasInstituicaoEnsinoDao implements HistoricoOutrasIntituicaoEnsinoDaoInterface<HistoricoOutrasIES>{

	@Override
	public void inserir(HistoricoOutrasIES entity) {
		
	}

	@Override
	public List<HistoricoOutrasIES> select(String sql, Map<String, Object> parametros) {
		return null;
	}

	@Override
	public List<HistoricoOutrasIES> select(String sql) {
		return null;
	}

	@Override
	public List<HistoricoOutrasIES> selectAll() {
		return null;
	}

	@Override
	public HistoricoOutrasIES buscarById(int id) {
		return null;
	}
}
