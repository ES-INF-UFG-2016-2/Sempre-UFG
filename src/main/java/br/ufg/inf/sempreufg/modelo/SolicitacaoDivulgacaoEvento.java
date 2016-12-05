package br.ufg.inf.sempreufg.modelo;

public class SolicitacaoDivulgacaoEvento {

    private Evento evento;
    private Usuario usuario;
    private boolean aprovado;

    public SolicitacaoDivulgacaoEvento(){}

    public SolicitacaoDivulgacaoEvento(Evento evento, Usuario usuario) {
        this.evento = evento;
        this.usuario = usuario;
        this.aprovado = false;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
}
