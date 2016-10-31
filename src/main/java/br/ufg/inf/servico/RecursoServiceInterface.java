package br.ufg.inf.servico;

import br.ufg.inf.modelo.Recurso;
import br.ufg.inf.modelo.Usuario;

public interface RecursoServiceInterface {

	Boolean isUsuarioPossuiAcessoRecurso(Usuario usuario, Recurso recurso);

}
