package br.ufg.inf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.ufg.inf.interfaces.InstituicaoEnsinoDaoInterface;
import br.ufg.inf.modelo.InstituicaoEnsino;

public class InstituicaoEnsinoDao implements InstituicaoEnsinoDaoInterface<InstituicaoEnsino>{

	@Override
	public void inserir(InstituicaoEnsino entity) {
		
	}

	@Override
	public List<InstituicaoEnsino> select(String sql, Map<String, Object> parametros) {
		return criarListaInstituicaoEnsinoMock();
	}

	@Override
	public List<InstituicaoEnsino> select(String sql) {
		return criarListaInstituicaoEnsinoMock();
	}

	@Override
	public List<InstituicaoEnsino> selectAll() {
		return criarListaInstituicaoEnsinoMock();
	}

	@Override
	public InstituicaoEnsino buscarById(int id) {
		return null;
	}
	
	public List<InstituicaoEnsino> criarListaInstituicaoEnsinoMock(){
		
		List<InstituicaoEnsino> intituicoesEnsino = new ArrayList<InstituicaoEnsino>();
		
		for (int i = 0; i < 10; i++) {
			InstituicaoEnsino instituicaoEnsino = new InstituicaoEnsino();
			intituicoesEnsino.add(instituicaoEnsino);
		}
		
		return intituicoesEnsino;
	}
}
