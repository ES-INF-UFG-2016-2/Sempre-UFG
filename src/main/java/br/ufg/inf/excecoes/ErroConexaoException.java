package br.ufg.inf.excecoes;

public class ErroConexaoException extends RuntimeException{

	public ErroConexaoException(final String erro){
		super(erro);
	}
}
