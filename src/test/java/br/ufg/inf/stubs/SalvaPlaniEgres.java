package br.ufg.inf.stubs;

import br.ufg.inf.interfaces.Planilha;
import br.ufg.inf.interfaces.SalvaPlaniEgresInterface;

import java.io.File;
import java.io.IOException;

public class SalvaPlaniEgres implements SalvaPlaniEgresInterface 
{

	public void salvaPlaniEgres(Planilha planilha, String nomeDoArquivo, String caminhoDoArquivo)
	{
		if(planilha == null ) {	}
		
		else if(nomeDoArquivo == "arquivo.odf" && caminhoDoArquivo.contains(" "))
		{
			caminhoDoArquivo = caminhoDoArquivo.trim();
			
			String caminho = caminhoDoArquivo + File.separator + nomeDoArquivo;
			File file = new File(caminho);
			
			try {
				file.createNewFile();
			} catch (IOException e) { e.printStackTrace(); }	
		}
		else if(nomeDoArquivo == "arquivo.odf" )
		{
			String caminho = caminhoDoArquivo + File.separator + nomeDoArquivo;
			
			File file = new File(caminho);
			File path = new File(caminhoDoArquivo);
			
			if( path.exists() && path.isDirectory() )
			{
				try {
					file.createNewFile();
				} catch (IOException e) { e.printStackTrace(); }
			}
			
			else
			{				
				path.mkdir();
				try {
					file.createNewFile();
				} catch (IOException e) { e.printStackTrace(); }
			}
		}
		else if(nomeDoArquivo == "arquivo" )
		{
			nomeDoArquivo = nomeDoArquivo + ".odf";
			String caminho = caminhoDoArquivo + File.separator + nomeDoArquivo;
			
			File file = new File(caminho);
			try {
				file.createNewFile();
			} catch (IOException e) { e.printStackTrace(); }
		}
	}
}
