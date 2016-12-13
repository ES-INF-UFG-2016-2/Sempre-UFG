package br.ufg.inf.sempreufg.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.interfaces.EgressoDaoInterface;
import br.ufg.inf.sempreufg.modelo.CursoOutrasIES;
import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoOutrasIES;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.InstituicaoEnsino;
import br.ufg.inf.sempreufg.modelo.Residencia;

public class EgressoDao implements EgressoDaoInterface<Egresso>{

	@Override
	public void inserir(Egresso entity) {
	}

	@Override
	public List<Egresso> select(String sql, Map<String, Object> parametros) {
		return criarListaEgressoMock();
	}

	@Override
	public List<Egresso> select(String sql) {
		return criarListaEgressoMock();
	}

	@Override
	public List<Egresso> selectAll() {
		return criarListaEgressoMock();
	}

	@Override
	public Egresso buscarById(int id) {
		return null;
	}

	public List<Egresso> criarListaEgressoMock(){
		List<Egresso> egressos = new ArrayList<Egresso>();

		for (int i = 0; i < 10; i++) {
			Egresso egresso = new Egresso("546546",
					  "Everton Jose",
					  "Maria",
					  LocalDate.of(1993, 12, 24),
					  Sexo.MASCULINO,
					  "email@gmail.com",
					  "emailAlternativo@gmail.com",
					  new BitSet(),
					  new BitSet(),
					  VisibilidadeDados.PUBLICO,
					  new Residencia(),
					  new InstituicaoEnsino(),
					  new HistoricoOutrasIES(),
					  new ArrayList<CursoOutrasIES>(),
					  new ArrayList<CursoUFG>(),
					  new ArrayList<HistoricoUFG>());
			
			egressos.add(egresso);
		}

		return egressos;
	}
}
