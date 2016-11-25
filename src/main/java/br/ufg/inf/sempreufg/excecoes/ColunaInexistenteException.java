package br.ufg.inf.sempreufg.excecoes;

public class ColunaInexistenteException extends ErroNaConsultaException {
    public ColunaInexistenteException(String mensagem){
        super(mensagem);
    }
}
