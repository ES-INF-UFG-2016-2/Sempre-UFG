package br.ufg.inf.modelo;

import br.ufg.inf.interfaces.AprovDivulgEventInterface;

import java.util.ArrayList;
import java.util.List;

public class AprovDivulgEvent implements AprovDivulgEventInterface {

	private static List lista_intancias = new ArrayList();
	private static Responsavel responsavel = new Responsavel(lista_intancias);
	private int id_evento;
	private boolean sol_aprov;

	public  AprovDivulgEvent(int id, boolean sol_aprov)  {

		this.id_evento = id;
		this.sol_aprov = sol_aprov;
	

	}
	
	public String getResultado(){
		
		int tamanho_lista = 50;
		List lista_de_eventos = new ArrayList();
		
		for (int i = 0; i < tamanho_lista; i++) {
			lista_de_eventos.add(i);
			
		}

		 if (this.id_evento <= 0) {
			return "Id nao pode ser menor que 1.";
		} else if (!lista_de_eventos.contains(this.id_evento)) {
			return "Nao existe evento com id correspondente.";
		} else {

			return responsavel.avaliaSolicitacao(this.id_evento, this.sol_aprov);
		}
		
	}

}