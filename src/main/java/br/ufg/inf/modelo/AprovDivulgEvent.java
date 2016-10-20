package br.ufg.inf.modelo;

import br.ufg.inf.interfaces.AprovDivulgEventInterface;

import java.util.ArrayList;
import java.util.List;

public class AprovDivulgEvent implements AprovDivulgEventInterface {

	private static List lista = new ArrayList();
	private static Responsavel r = new Responsavel(lista);

	public AprovDivulgEvent() {


	}

	public String aprovDivulgEvent(int id, boolean div_aprov) {

	

		try {
			return r.avaliaSolicitacao(id, div_aprov);
		} catch (Exception e) {

			return e.getMessage();
		}

	}

	public static void main(String args[]) {

	}

	

	public static List getLista() {
		return lista;
	}

	public static void setLista(List lista) {
		AprovDivulgEvent.lista = lista;
	}

	public static Responsavel getR() {
		return r;
	}

	public static void setR(Responsavel r) {
		AprovDivulgEvent.r = r;
	}

}
