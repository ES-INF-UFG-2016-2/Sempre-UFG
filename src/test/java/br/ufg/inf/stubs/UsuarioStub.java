package br.ufg.inf.stubs;

import java.util.Arrays;

import br.ufg.inf.modelo.Papel;
import br.ufg.inf.modelo.Usuario;

/**
 * @author Bruno Martins de Carvalho
 *
 */
public class UsuarioStub extends Usuario {

	public UsuarioStub(final Papel... papeis) {
		super.getListaPapel().addAll(Arrays.asList(papeis));
	}

}
