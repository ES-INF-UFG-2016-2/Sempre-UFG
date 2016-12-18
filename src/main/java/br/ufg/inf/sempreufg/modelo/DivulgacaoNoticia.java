package br.ufg.inf.sempreufg.modelo;

import java.util.List;

public class DivulgacaoNoticia {
    private int evento_id;
    private List<Usuario> usuarios;

    public DivulgacaoNoticia(int evento_id) {
        this.evento_id = evento_id;
    }
}
