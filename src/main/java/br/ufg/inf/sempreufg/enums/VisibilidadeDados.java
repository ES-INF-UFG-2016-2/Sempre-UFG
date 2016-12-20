package br.ufg.inf.sempreufg.enums;

/**
 * Created by user1 on 09/10/2016.
 */
public enum VisibilidadeDados {
	PUBLICO("Público"), PRIVADO("Privado"), SO_EGRESSOS("Só Egressos");

	private String nome;

	VisibilidadeDados(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
