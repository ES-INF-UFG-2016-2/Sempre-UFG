package br.ufg.inf.sempreufg.servico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class PlanilhaEgresso {

	static String path_projeto = System.getProperty("user.dir");

	
	
	public static void salvaPlaniEgres(File planilha, String nome_plani,
								String path_fornecido){
	
		String path_planilha = path_projeto+File.separator+path_fornecido;
		File path_rename = new File(path_planilha);
		path_rename.mkdir();
		
		
		planilha.getAbsoluteFile().renameTo(new File(path_planilha+File.separator+nome_plani+".ods"));
			
		
				
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(planilha));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main (String args[]) {
		
		
		
		String path_fornecido = "planilhas";
		File planilha = new File("planilha.ods");
		salvaPlaniEgres(planilha, "Planilha Egressos", path_fornecido);
		
		
		
		
	}
	

}
