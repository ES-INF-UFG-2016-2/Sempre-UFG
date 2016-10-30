package br.ufg.inf.dao;

import java.util.List;
import java.util.Map;

import br.ufg.inf.interfaces.ResidenciaDaoInterface;
import br.ufg.inf.modelo.Residencia;

public class ResidenciaDao implements ResidenciaDaoInterface<Residencia>{

	@Override
	public void inserir(Residencia entity) {
	}

	@Override
	public List<Residencia> select(String sql, Map<String, Object> parametros) {
		return null;
	}

	@Override
	public List<Residencia> select(String sql) {
		return null;
	}

	@Override
	public List<Residencia> selectAll() {
		return null;
	}

	@Override
	public Residencia buscarById(int id) {
		return null;
	}
}
