package br.ufg.inf.modelo;

public class Atributo {
	
	private Integer id;
	
	private Integer antecessor;
	
	private String nome;

	private String tituloDaQuestao;
	
	private String tituloDoCampo;
	
	private Integer entidade;

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

	public String getTituloDaQuestao() {
		return tituloDaQuestao;
	}

	public void setTituloDaQuestao(String tituloDaQuestao) {
		this.tituloDaQuestao = tituloDaQuestao;
	}

	public String getTituloDoCampo() {
		return tituloDoCampo;
	}

	public void setTituloDoCampo(String tituloDoCampo) {
		this.tituloDoCampo = tituloDoCampo;
	}

	public Integer getEntidade() {
		return entidade;
	}

	public void setEntidade(Integer entidade) {
		this.entidade = entidade;
	}
	
}
