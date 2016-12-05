package br.ufg.inf.sempreufg.modelo;

public class SolicitacaoDivulgacaoEvento {

    private int id;
    private Evento evento;
    private Usuario usuario;
    private boolean aprovado;

    public SolicitacaoDivulgacaoEvento(){}

    public SolicitacaoDivulgacaoEvento(int id, Evento evento, Usuario usuario) {
        this.id = id;
        this.evento = evento;
        this.usuario = usuario;
        this.aprovado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
