package br.ufg.inf.sempreufg.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
// Não há DDL para esta entidade! @Table(name = "")
public class DivulgacaoEventoComunidade {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="<id_row>")
    @SequenceGenerator(name="<id_row>", initialValue=1, sequenceName="DIVULGACAO_EVENTO_COMUNIDADE_ID_SEQUENCE", allocationSize=1)
    private int id;
    private Evento evento;
    private List<Usuario> usuarios;

    public DivulgacaoEventoComunidade(){}

    public DivulgacaoEventoComunidade(Evento evento, List<Usuario> usuarios) {
        this.evento = evento;
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(this.usuarios);
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
