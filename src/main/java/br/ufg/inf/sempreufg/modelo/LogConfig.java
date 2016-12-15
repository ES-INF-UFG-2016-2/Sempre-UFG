package br.ufg.inf.sempreufg.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
	public class LogConfig {
	private LogLocal local = new LogLocal();
	private LogGatilhos gatilhos = new LogGatilhos();
	private LogItens itens = new LogItens();

	private File arquivoLog;


	public LogGatilhos getGatilhos() {
		return gatilhos;
	}

	public void setGatilhos(LogGatilhos gatilhos) {
		this.gatilhos = gatilhos;
	}

	public LogItens getItens() {
		return itens;
	}

	public void setItens(LogItens itens) {
		this.itens = itens;
	}

	public void gerarArquivoLog( ArrayList<ParametroLog> parametros ) throws IOException
	{
		String line = null;
		FileReader reader = new FileReader(arquivoLog);
		BufferedReader br = new BufferedReader(reader);
		StringBuilder fileContent = new StringBuilder();

		while ((line = br.readLine()) != null)
		{
			Iterator<ParametroLog> 	iterador = parametros.iterator();
			
			while(iterador.hasNext() )
			{
				ParametroLog parametro = iterador.next();
				
				if (line.contains( parametro.getSigla() )) 
				{					
					line = editLinha( line, parametro.getValor() );
					fileContent.append(line + System.getProperty("line.separator"));
				} 
				else 
				{
					fileContent.append(line + System.getProperty("line.separator"));
				}
			}
		}

		FileWriter fw = new FileWriter(arquivoLog);
		BufferedWriter out = new BufferedWriter(fw);
		out.write(fileContent.toString());
		out.close();
	}

	
	public String editLinha(String linha, String valor )
	{
		String[] tokens = linha.split( "=" );
		tokens[1] = valor;
		
		return tokens[0] + " " + tokens[1];
	}


	public File getArquivoLog() {
		return arquivoLog;
	}

	public void setArquivoLog(File arquivoLog) {
		this.arquivoLog = arquivoLog;
	}

	public int configurarLog(ArrayList<ParametroLog> listaParamentros) {
		local.configurarParametros(listaParamentros);
		gatilhos.configurarParametros(listaParamentros);
		itens.configurarParametros(listaParamentros);

		return 0;
	}

	public int carregarConfigFile( String caminho ) throws IOException 
	{
		arquivoLog = new File(caminho);
		//arquivoLog = new File("C:\\Program Files\\PostgreSQL\\9.6\\data\\postgresql.conf");
		return 0;
	}
}
