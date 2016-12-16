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

import br.ufg.inf.sempreufg.dao.LogConfigDAO;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
	public class LogConfig {
	private LogLocal local = new LogLocal();
	private LogItens itens = new LogItens();
	private LogGatilhos gatilhos = new LogGatilhos();
	ArrayList<ParametroLog> lista;
	LogConfigDAO logConfigDAO = new LogConfigDAO();

	private File arquivoLog;

	public ArrayList<ParametroLog> getListaParametros()
	{
		return lista;
	}
	

	public void gerarArquivoLog( ArrayList<ParametroLog> parametros )
	{
		try
		{
			String line = null;
			FileReader reader = new FileReader(arquivoLog);
			BufferedReader br = new BufferedReader(reader);
			StringBuilder fileContent = new StringBuilder();
	
			while ((line = br.readLine()) != null)
			{
				Iterator<ParametroLog> 	iterador = parametros.iterator();
				String line2 = null;
				
				while(iterador.hasNext() )
				{
					ParametroLog parametro = iterador.next();
					
					if (line.contains( "#" + parametro.getSigla().toLowerCase() + " " )) 
					{					
						//System.out.println( line );

						line2 = editLinha( line, parametro.getValor() );
					} 
				}
				
				if(line2 != null )
					fileContent.append( line2 + System.getProperty( "line.separator"));
				else
					fileContent.append( line + System.getProperty( "line.separator"));
			}
	
			FileWriter fw = new FileWriter(arquivoLog);
			BufferedWriter out = new BufferedWriter(fw);
			out.write(fileContent.toString());
			out.close();
		} catch (Exception e )
		{
			e.printStackTrace();
		}
	}

	
	public String editLinha(String linha, String valor )
	{
		String[] tokens = linha.split( "=" );
		tokens[1] = valor;
		
		return tokens[0] + "= " + tokens[1];
	}


	public File getArquivoLog() 
	{
		return arquivoLog;
	}

	public void setArquivoLog(File arquivoLog)
	{
		this.arquivoLog = arquivoLog;
	}

	public int configurarLog(ArrayList<ParametroLog> listaParamentros)
	{
		local.configurarParametros(listaParamentros);
		gatilhos.configurarParametros(listaParamentros);
		itens.configurarParametros(listaParamentros);
		
		lista = new ArrayList<ParametroLog>(local.getParametros());
		lista.addAll( gatilhos.getParametros());
		lista.addAll( itens.getParametros() );	
		
		carregarConfigFile();
		gerarArquivoLog(lista);
		logConfigDAO.persistirParametros(lista);
		
		
		return 0;
	}

	public int carregarConfigFile( )
	{
		String caminho = logConfigDAO.getCaminhoArquivoDeConfiguracao();
		
		arquivoLog = new File( caminho );
		return 0;
	}
}
