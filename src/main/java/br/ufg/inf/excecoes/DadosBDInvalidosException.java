package br.ufg.inf.excecoes;

public class DadosBDInvalidosException extends RuntimeException{
	
	public DadosBDInvalidosException(final String erro){
		super(erro);
	}
}
