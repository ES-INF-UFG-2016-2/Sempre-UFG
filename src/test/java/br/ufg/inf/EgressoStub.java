package br.ufg.inf;

import java.util.Date;

/**
 * Created by Leonardo on 09/10/2016.
 */
public class EgressoStub {

	private String id;
	private String nome;
	private String nomeMae;
	private Date dataNascimento;
	private String sexo;
	private String emailAlternativo;
	private String visibilidadeDados;

	public EgressoStub(String id, String nome, String nomeMae, Date dataNascimento, String sexo, String emailAlternativo, String visibilidadeDados) {
		this.id = id;
		this.nome = nome;
		this.nomeMae = nomeMae;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.emailAlternativo = emailAlternativo;
		this.visibilidadeDados = visibilidadeDados;
	}

	public EgressoStub(String nome, String nomeMae, Date dataNascimento, String sexo, String emailAlternativo, String visibilidadeDados) {
		this.nome = nome;
		this.nomeMae = nomeMae;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.emailAlternativo = emailAlternativo;
		this.visibilidadeDados = visibilidadeDados;
	}

	public String pegarId() {
		return id;
	}

    public void mudarId(String id) {
        this.id = id;
    }

    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EgressoStub that = (EgressoStub) o;

		if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
		if (nomeMae != null ? !nomeMae.equals(that.nomeMae) : that.nomeMae != null) return false;
		if (dataNascimento != null ? !dataNascimento.equals(that.dataNascimento) : that.dataNascimento != null)
			return false;
		if (sexo != null ? !sexo.equals(that.sexo) : that.sexo != null) return false;
		if (emailAlternativo != null ? !emailAlternativo.equals(that.emailAlternativo) : that.emailAlternativo != null)
			return false;
		return visibilidadeDados != null ? visibilidadeDados.equals(that.visibilidadeDados) : that.visibilidadeDados == null;

	}

}
