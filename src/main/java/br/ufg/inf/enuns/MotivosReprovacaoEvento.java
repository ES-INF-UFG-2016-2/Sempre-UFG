package br.ufg.inf.enuns;

public enum MotivosReprovacaoEvento {
	NAO_RELEVANTE_A_ORGANIZACAO("Evento cadastrado n�o apresenta relevancia para a comunidade academica");
	
	public String menssagem;

	private MotivosReprovacaoEvento(String menssagem) {
		this.menssagem = menssagem;
	}
}
