package br.ufg.inf.sempreufg.excecoes;

public class IdentificadorInexistenteExepction extends ErroNaConsultaException {
    public IdentificadorInexistenteExepction(String mensagem){
        super(mensagem);
    }
}
