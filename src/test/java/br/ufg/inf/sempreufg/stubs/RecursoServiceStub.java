package br.ufg.inf.sempreufg.stubs;

import br.ufg.inf.sempreufg.modelo.Papel;
import br.ufg.inf.sempreufg.modelo.Recurso;
import br.ufg.inf.sempreufg.modelo.Usuario;
import br.ufg.inf.sempreufg.servico.RecursoServiceInterface;

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
