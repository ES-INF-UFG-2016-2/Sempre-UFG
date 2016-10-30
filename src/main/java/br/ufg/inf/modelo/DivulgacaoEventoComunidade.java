package br.ufg.inf.modelo;

import java.util.List;

public class DivulgacaoEventoComunidade {

    private Evento evento;
    private List<Usuario> usuarios;

    public DivulgacaoEventoComunidade(Evento evento) {
        this.evento = evento;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

}