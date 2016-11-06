package br.ufg.inf.stubs;

import br.ufg.inf.modelo.Papel;
import br.ufg.inf.modelo.Recurso;
import br.ufg.inf.modelo.Usuario;
import br.ufg.inf.servico.RecursoServiceInterface;

public class RecursoServiceStub implements RecursoServiceInterface {

	@Override
	public Boolean isUsuarioPossuiAcessoRecurso(Usuario usuario, Recurso recurso) {
		Boolean possuiAcesso = Boolean.FALSE;

		for (Papel papel : usuario.getListaPapel()) {
			if (papel.getListaRecurso().contains(recurso)) {
				possuiAcesso = Boolean.TRUE;
				break;
			}
		}

		return possuiAcesso;
	}

}
