package br.ufg.inf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AprovDivulgEvent implements AprovDivulgEventInterface {

	private static List lista = new ArrayList();
	private static Responsavel r = new Responsavel(lista);
	private static int instancia = 0;
	
	public AprovDivulgEvent() {
		
		System.out.println(instancia);
		instancia++;
			
	}

	public String aprovDivulgEvent(int id, boolean div_aprov) {

		// Scanner sc = new Scanner(System.in);

		try {
			return r.avaliaSolicitacao(id, div_aprov);
		} catch (Exception e) {
			System.out.println("ERRO!");

			return e.getMessage();
		}

	}

	public static void main(String args[]) {

	}
	
	private String testeAA(){
	
		return "AAAA";
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
