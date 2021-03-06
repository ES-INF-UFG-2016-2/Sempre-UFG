package br.ufg.inf.sempreufg.modelo;

import java.util.Date;

public class AprovacaoDivulgacaoEvento {

    private Evento evento;
    private Usuario aprovadoPor;
    private boolean divulgacaoAprovada;
    private String parecerSobreDivulgacao;
    private Date dataDoParecer;

    public AprovacaoDivulgacaoEvento() {
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getAprovadoPor() {
        return aprovadoPor;
    }

    public void setAprovadoPor(Usuario aprovadoPor) {
        this.aprovadoPor = aprovadoPor;
    }

    public boolean isDivulgacaoAprovada() {
        return divulgacaoAprovada;
    }

    public void setDivulgacaoAprovada(boolean divulgacaoAprovada) {
        this.divulgacaoAprovada = divulgacaoAprovada;
    }

    public String getParecerSobreDivulgacao() {
        return parecerSobreDivulgacao;
    }

    public void setParecerSobreDivulgacao(String parecerSobreDivulgacao) {
        this.parecerSobreDivulgacao = parecerSobreDivulgacao;
    }

    public Date getDataDoParecer() {
        return dataDoParecer;
    }

    public void setDataDoParecer(Date dataDoParecer) {
        this.dataDoParecer = dataDoParecer;
    }
}
