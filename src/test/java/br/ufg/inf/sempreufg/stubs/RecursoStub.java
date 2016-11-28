package br.ufg.inf.sempreufg.stubs;

import br.ufg.inf.sempreufg.modelo.Recurso;

public class RecursoStub extends Recurso {

	public RecursoStub(final String idRecurso, final String siglaRecurso, final String descricao) {
		super.setIdRecurso(idRecurso);
		super.setSiglaRecurso(siglaRecurso);
		super.setDescricao(descricao);
	}
}
