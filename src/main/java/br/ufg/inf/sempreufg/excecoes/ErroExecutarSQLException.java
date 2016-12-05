package br.ufg.inf.sempreufg.excecoes;

public class ErroExecutarSQLException extends RuntimeException{
	
	public ErroExecutarSQLException(final String campo){
		super(campo);
	}
}
