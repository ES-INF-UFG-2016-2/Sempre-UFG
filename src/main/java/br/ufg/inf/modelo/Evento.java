package br.ufg.inf.modelo;

import java.util.Date;

public class Evento {

	private int id;
	private String assunto;
	private String des_evento;
	private Date data_solicitacao;
	private int id_solicitante;
	private Date data_expiracao;

	protected static enum Tipos {
		NOTICIA, PALESTRA, CURSO, EMPREGO, DIVERSOS
	};

	protected static enum Formas {
		MENSAGEM, NOTICIA, AMBOS, NENHUMA
	};

	protected static enum Escopos {
		EGRESSOS, COMUNIDADE, FORA_DE_ESCOPO
	};

	private Tipos tipo_evento;
	private Formas forma;
	private Escopos escopo;

	public Evento() {

	}

	public Evento(int id, String assunto, String des_evento, Date data_solicitacao, int id_solicitante,
			Date data_expiracao, String ev, String f, String esc) {

		super();
		this.id = id;
		this.assunto = assunto;
		this.des_evento = des_evento;
		this.data_solicitacao = data_solicitacao;
		this.id_solicitante = id_solicitante;
		this.data_expiracao = data_expiracao;

		for (Escopos escopo : Escopos.values()) {
			if (escopo.toString().equalsIgnoreCase(esc)) {
				setEsc(escopo);
				break;
			}
		}
		for (Tipos evento : Tipos.values()) {
			if (evento.toString().equalsIgnoreCase(ev)) {
				setEvento(evento);
				break;
			}
		}
		for (Formas forma : Formas.values()) {
			if (forma.toString().equalsIgnoreCase(f)) {
				setForma(forma);
				break;
			}
		}


	}

	public Tipos getEvento() {
		return tipo_evento;
	}

	public void setEvento(Tipos evento) {
		this.tipo_evento = evento;
	}

	public Formas getForma() {
		return forma;
	}

	public void setForma(Formas forma) {
		this.forma = forma;
	}

	public Escopos getEsc() {
		return escopo;
	}

	public void setEsc(Escopos esc) {
		this.escopo = esc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDes_evento() {
		return des_evento;
	}

	public void setDes_evento(String des_evento) {
		this.des_evento = des_evento;
	}

	public Date getData_solicitacao() {
		return data_solicitacao;
	}

	public void setData_solicitacao(Date data_solicitacao) {
		this.data_solicitacao = data_solicitacao;
	}

	public int getId_solicitante() {
		return id_solicitante;
	}

	public void setId_solicitante(int id_solicitante) {
		this.id_solicitante = id_solicitante;
	}

	public Date getData_expiracao() {
		return data_expiracao;
	}

	public void setData_expiracao(Date data_expiracao) {
		this.data_expiracao = data_expiracao;
	}

}
