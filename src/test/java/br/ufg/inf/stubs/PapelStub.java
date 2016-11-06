package br.ufg.inf.stubs;

import java.util.Arrays;

import br.ufg.inf.modelo.Papel;
import br.ufg.inf.modelo.Recurso;

public class PapelStub extends Papel {

	public PapelStub(final Recurso... recursos) {
		super.getListaRecurso().addAll(Arrays.asList(recursos));
	}
}
