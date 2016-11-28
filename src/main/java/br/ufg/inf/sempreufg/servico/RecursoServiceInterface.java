package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.Recurso;
import br.ufg.inf.sempreufg.modelo.Usuario;

public interface RecursoServiceInterface {

	Boolean isUsuarioPossuiAcessoRecurso(Usuario usuario, Recurso recurso);

}
