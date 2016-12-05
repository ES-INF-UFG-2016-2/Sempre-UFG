package br.ufg.inf.sempreufg.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Entidade {

    private Long id;
    @Id
    @Column(name = "nome_entidade")
    private String nome;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "nome_entidade")
    private List<Atributo> atributos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }
}
