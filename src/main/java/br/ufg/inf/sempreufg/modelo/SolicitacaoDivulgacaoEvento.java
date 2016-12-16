package br.ufg.inf.sempreufg.modelo;

import javax.persistence.*;

@Entity
// Não há DDL para esta entidade! @Table(name = "")
public class SolicitacaoDivulgacaoEvento {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="user_enrollment")
    @SequenceGenerator(name="user_enrollment", initialValue=100, sequenceName="SOLICITAVCAO_DIVULGACAO_EVENTO_ID_SEQUENCE", allocationSize=1)
    private int id;
    private int id_evento;
    private int id_usuario;
    private boolean aprovado;

    public SolicitacaoDivulgacaoEvento(){}

    public SolicitacaoDivulgacaoEvento(int id_evento, int id_usuario) {
        this.id_evento = id_evento;
        this.id_usuario = id_usuario;
        this.aprovado = false;
    }

    public int getId() {
        return id;
    }

    public int getEvento() {
        return id_evento;
    }

    public void setEvento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getUsuario() {
        return id_usuario;
    }

    public void setUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
}
