package br.ufg.inf.modelo;

import java.util.Date;

public class Avaliacao {

	private Evento evento = new Evento();
	private boolean div_aprovada;
	private String parecer;
	private Date data;

	public Avaliacao(Evento evento, boolean div_aprovada, String parecer, Date data) {
		super();
		this.div_aprovada = div_aprovada;
		this.parecer = parecer;
		this.data = data;
		this.evento = evento;


	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public boolean isAprovada() {
		return div_aprovada;
	}

	public void setDiv_aprovada(boolean div_aprovada) {
		this.div_aprovada = div_aprovada;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
