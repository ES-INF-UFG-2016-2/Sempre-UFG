import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalvaPlaniEgresTest
{
	String CaminhoParaArquivo;
	String caminho;
	Planilha planilha;
	String nomeDoArquivo;
	
	
	@Before
	public void setUp() throws Exception 
	{
		caminho = "C:";
		planilha = new Planilha();
		nomeDoArquivo = "Arquivo.txt"; 
		
		CaminhoParaArquivo = "C:\\Arquivo.txt";
	}

	@Test
	public void test() 
	{
		salvaPlaniEgres( planilha, nomeDoArquivo, caminho );
		
		File file = new File( CaminhoParaArquivo );
		assertTrue( file.exists() );
	}

	private void salvaPlaniEgres(Planilha planilha2, String nomeDoArquivo2, String caminho2)
	{
		//throw new UnsupportedOperationException("Not yet implemented");	
	}

}
