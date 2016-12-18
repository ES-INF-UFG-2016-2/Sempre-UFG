package br.ufg.inf.sempreufg.modelo;

import java.util.Date;

/**
 * Created by Marcos on 16/12/2016.
 */
public class RespAprovaDivulgacaoEvento {
    private String id;

    private Usuario usuario;

    private Evento evento;

    public RespAprovaDivulgacaoEvento() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
