package br.ufg.inf;

public class CursoDaUFG {

	private enum Tipos {
		BACHARELADO, LICENCIATURA, APERFEIÇOAMENTO, ESPECIALIZACAO, MESTRADO, DOUTORADO
	};

	private Tipos tipo;

	private enum Resolucoes {
		CEPEC, CONSUNI
	};

	private Resolucoes resolucao;
	private int num_resolucao;
	private boolean presencial;

	private enum Turnos {
		MATUTINO, VESPERTINO, INTEGRAL
	};

	private Turnos turno;

}
