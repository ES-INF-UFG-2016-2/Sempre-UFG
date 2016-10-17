package main.java.br.ufg.inf.excecoes;

public class IdentificadorInexistenteExepction extends ErroNaConsultaException {
    public IdentificadorInexistenteExepction(String mensagem){
        super(mensagem);
    }
}
