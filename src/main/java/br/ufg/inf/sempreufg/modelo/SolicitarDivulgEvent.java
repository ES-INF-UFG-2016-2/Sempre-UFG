package br.ufg.inf.sempreufg.modelo;

public class SolicitarDivulgEvent {

    protected EventoSolicitado eventoSolicitado;
    private boolean aprovado;

    public void enviarSolicitacao(EventoSolicitado evento) {
        this.eventoSolicitado = evento;
    }

    public boolean emailValido() {
        return true;
    }

    public EventoSolicitado getEvento() {
        return eventoSolicitado;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
}
