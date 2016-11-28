package br.ufg.inf.sempreufg.stubs;

import java.util.Arrays;

import br.ufg.inf.sempreufg.modelo.Papel;
import br.ufg.inf.sempreufg.modelo.Usuario;

/**
 * @author Bruno Martins de Carvalho
 *
 */
public class UsuarioStub extends Usuario {

	public UsuarioStub(final Papel... papeis) {
		super.getListaPapel().addAll(Arrays.asList(papeis));
	}

}
