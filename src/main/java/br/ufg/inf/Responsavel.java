package br.ufg.inf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Responsavel extends Usuario {

	private List inst_admin = new ArrayList();

	public List getInst_admin() {
		return inst_admin;
	}

	public void setInst_admin(List inst_admin) {
		this.inst_admin = inst_admin;
	}

	public Responsavel(List inst_admin) {
		super();
		setInst_admin(inst_admin);

		System.out.println("Responsavel criado.");

	}

	public String avaliaSolicitacao(Integer id_evento, boolean div_aprov) {

		// Lista de eventos tem tamanho 50;
		int length = 50;

		if (id_evento < 0) {
			throw new IllegalArgumentException("id_evento não pode ser menor que 0.");
		} else if (id_evento > length - 1) {

			throw new IllegalArgumentException("id_evento não pode ser maior que lista.length().");
		} else if (!(id_evento instanceof Integer)) {

			throw new IllegalArgumentException("Tipo de id_evento deve ser Integer.");
		} else if (id_evento == null) {

			throw new IllegalArgumentException("id_evento não pode ser null.");
		}

		// BD retorna objeto Evento após consulta com id_evento

		Evento evento = new Evento(0, null, null, null, 0, null, "palestra", "Ambos", "fora_DE_Escopo");

		// A divulgação é aprovada ou rejeitada
		boolean div_aprovada = div_aprov;

		String parecer = "abc";
		Date data = new Date();
		Avaliacao avaliacao = new Avaliacao(evento, div_aprovada, parecer, data);

		if (avaliacao.isAprovada()) {
			System.out.println("Divulgacao aprovada.");
			return divulgaEventoEgresso(evento.getId(), inst_admin);
		}

		else {
			System.out.println("Divulgacao rejeitada.");
			return encaminhaAvaliacao(avaliacao.getParecer(), avaliacao.getEvento().getId_solicitante());

		}
	}

	public String encaminhaAvaliacao(String parecer, int id_solicitante) {

		return "Parecer encaminhado às partes interessadas.";

	}

	// RF-DivulgEventEgres
	public String divulgaEventoEgresso(int id_evento, List cursos) {

		return "Evento divulgado aos egressos.";
	}
}
