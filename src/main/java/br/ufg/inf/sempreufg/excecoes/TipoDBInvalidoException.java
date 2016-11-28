package br.ufg.inf.sempreufg.excecoes;

public class TipoDBInvalidoException extends RuntimeException {

	public TipoDBInvalidoException(final String campo) {
		super(campo);
	}
}
