package br.ufg.inf.sempreufg.modelo;

import javax.persistence.*;

@Entity
// Não há DDL para esta entidade! @Table(name = "")
public class SolicitacaoDivulgacaoEvento {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="user_enrollment")
    @SequenceGenerator(name="user_enrollment", initialValue=100, sequenceName="SOLICITAVCAO_DIVULGACAO_EVENTO_ID_SEQUENCE", allocationSize=1)
    private int id;
    private Evento evento;
    private Usuario usuario;
    private boolean aprovado;

    public SolicitacaoDivulgacaoEvento(){}

    public SolicitacaoDivulgacaoEvento(Evento evento, Usuario usuario) {
        this.evento = evento;
        this.usuario = usuario;
        this.aprovado = false;
    }

    public int getId() {
        return id;
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
