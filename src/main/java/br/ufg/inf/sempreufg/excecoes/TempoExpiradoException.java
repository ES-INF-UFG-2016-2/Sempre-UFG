package br.ufg.inf.sempreufg.excecoes;

public class TempoExpiradoException extends RuntimeException{
	
	public TempoExpiradoException(final String campo){
		super(campo);
	}
}
