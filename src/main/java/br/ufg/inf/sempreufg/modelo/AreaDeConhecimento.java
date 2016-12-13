package br.ufg.inf.sempreufg.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */

@Entity
public class AreaDeConhecimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
    private String nome;
    private int codigo;

    public AreaDeConhecimento(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
