package br.ufg.inf.modelo;

import java.util.List;

public class Entidade {
	
	private Integer id;
	
	private Integer antecessor;
	
	private String nome;
	
	private String tituloGrupoDeQuestoes;
	
	private String tituloGrupoDeCampos;
	
	private List<Atributo> atributos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAntecessor() {
		return antecessor;
	}

	public void setAntecessor(Integer antecessor) {
		this.antecessor = antecessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTituloGrupoDeQuestoes() {
		return tituloGrupoDeQuestoes;
	}

	public void setTituloGrupoDeQuestoes(String tituloGrupoDeQuestoes) {
		this.tituloGrupoDeQuestoes = tituloGrupoDeQuestoes;
	}

	public String getTituloGrupoDeCampos() {
		return tituloGrupoDeCampos;
	}

	public void setTituloGrupoDeCampos(String tituloGrupoDeCampos) {
		this.tituloGrupoDeCampos = tituloGrupoDeCampos;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
}
