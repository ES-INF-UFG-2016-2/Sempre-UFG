package br.ufg.inf.sempreufg.stubs;

import java.util.Arrays;

import br.ufg.inf.sempreufg.modelo.Papel;
import br.ufg.inf.sempreufg.modelo.Recurso;

public class PapelStub extends Papel {

	public PapelStub(final Recurso... recursos) {
		super.getListaRecurso().addAll(Arrays.asList(recursos));
	}
}
