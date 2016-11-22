package br.ufg.inf.sempreufg.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstanciaAdm {

	private String sigla;
	private String nome_instanciaAdm;

	private enum Tipos {
		REGIONAL, UNIDADE, CURSO
	};

	private Tipos tipo;
	private Date data_criacao = new Date();
	private Date data_enc = new Date();
	private String email;
	private String url_inst;
	private List instancias = new ArrayList();

}
