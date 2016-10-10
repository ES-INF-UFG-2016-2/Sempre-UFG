package br.ufg.inf;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufg.inf.DAO.HistoricoEnsinoMedioDAO;
import br.ufg.inf.modelo.HistoricoEnsinoMedio;

public class EnsMedioEgresTest {

	private HistoricoEnsinoMedio historico;
	
	@BeforeClass
	public void PreparaHistorico() {
		
		historico = new HistoricoEnsinoMedio();
		historico.setMesInicio("02");
		historico.setAnoInicio("2010");
		historico.setMesFim("12");
		historico.setAnoFim("2013");
	}

}
