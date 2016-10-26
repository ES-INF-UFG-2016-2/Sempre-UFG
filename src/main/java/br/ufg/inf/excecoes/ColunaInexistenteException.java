package br.ufg.inf.excecoes;

public class ColunaInexistenteException extends ErroNaConsultaException {
    public ColunaInexistenteException(String mensagem){
        super(mensagem);
    }
}
