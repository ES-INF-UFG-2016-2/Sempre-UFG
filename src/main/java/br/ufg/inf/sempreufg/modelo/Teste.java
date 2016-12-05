package br.ufg.inf.sempreufg.modelo;

import java.util.ArrayList;

import br.ufg.inf.sempreufg.enums.TipoParametros;

public class Teste 
{

	
	 public static void main (String[] args)
	 {
		 ParametroLog paramt = new ParametroLog();
		 
		 String sigla = "DEBUG1";
		 
		 paramt.setSigla(sigla);
		 
		 String valor = "LOG";
		 paramt.setValor(valor);
		 
		 TipoParametros t = TipoParametros.BACKUP;
		 paramt.setTipo(t);
		 
		 String descricaoParametro = "dp";
		 paramt.setDescricaoParametro(descricaoParametro);
		  
		 LogLocal maroto = new LogLocal();
		 ArrayList<ParametroLog> variavel = new ArrayList<>();
		 
		 variavel.add(paramt);
		 maroto.configurarParametros(variavel);
	 }
	
}
