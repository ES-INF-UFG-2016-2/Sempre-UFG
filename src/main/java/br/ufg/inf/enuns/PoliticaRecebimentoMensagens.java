package br.ufg.inf.enuns;

public enum PoliticaRecebimentoMensagens {
    CADA_EVENTO(1), DIARIA(2), SEMANAL(3), MENSAL(4), NAO_RECEBE(5);

    private int valor;

    private PoliticaRecebimentoMensagens(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void mudarPolitica(int valor) {
        this.valor = valor;
    }
}
