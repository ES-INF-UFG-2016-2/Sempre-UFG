package br.ufg.inf;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.SalvaPlaniEgres;
import br.ufg.inf.Planilha;

public class SalvaPlaniEgresTest
{
	SalvaPlaniEgresInterface instancia;
	Planilha planilha;
	String diretorioDeUsuario;
	File file;
	
	@Before
	public void setUp() throws Exception 
	{
		instancia = new SalvaPlaniEgres();
		diretorioDeUsuario = System.getProperty("user.home");
	}
	
	@After
	public void tearDown() throws Exception
	{
		file.delete();
	}
	

	// Todos os parametros são válidos
	@Test
	public void testValido() 
	{
		String nomeArquivo = "arquivo.odf";
		String caminho = diretorioDeUsuario;
		
		instancia.salvaPlaniEgres(planilha, nomeArquivo, caminho);
		
		String caminhoAbsoluto = caminho + File.separator + nomeArquivo;
		file = new File( caminhoAbsoluto );
		
		Assert.assertTrue( file.exists() ); 
	}
	
	// Todos os parametros são válidos, mas o nome do arquivo nao inclui a extensão odf.
	@Test
	public void testArquivoSemExtensao() 
	{
		String nomeArquivo = "arquivo";
		String caminho = diretorioDeUsuario;
		
		instancia.salvaPlaniEgres(planilha, nomeArquivo, caminho);
		
		nomeArquivo = nomeArquivo + ".odf";
		String caminhoAbsoluto = caminho + File.separator + nomeArquivo;
		file = new File( caminhoAbsoluto );
		
		Assert.assertTrue( file.exists() ); 
	}
	
	// Planilha é nula
	@Test
	public void testPlanilhaNula() 
	{
		String nomeArquivo = "arquivo.odf";
		String caminho = diretorioDeUsuario;
		
		instancia.salvaPlaniEgres(null, nomeArquivo, caminho);
		
		String caminhoAbsoluto = caminho + File.separator + nomeArquivo;
		file = new File( caminhoAbsoluto );
		
		Assert.assertFalse( "Arquivo criado com planilha nula",  file.exists() ); 
	}
	
	//caminho do arquivo não é válido
	@Test
	public void testCaminhoInvalido()
	{
		String nomeArquivo = "arquivo.odf";
		String caminho = "@@@@@@@";

		
		instancia.salvaPlaniEgres(planilha, nomeArquivo, caminho);
		
		String caminhoAbsoluto = diretorioDeUsuario + File.separator + nomeArquivo;
		file = new File( caminhoAbsoluto );
		
		Assert.assertFalse( file.exists() );		
	}
	
	@Test
	public void testArquivoExtensaoInvalida()
	{
		String nomeArquivo = "arquivo.ppt";
		String caminho = diretorioDeUsuario;
		
		instancia.salvaPlaniEgres(planilha, nomeArquivo, caminho);
		
		String caminhoAbsoluto = caminho + File.separator + nomeArquivo;
		file = new File( caminhoAbsoluto );
		
		Assert.assertFalse( file.exists() ); 
	}
	
	@Test
	public void testCaminhoIniciaComEspaco()
	{
		String nomeArquivo = "arquivo.odf";
		String caminho = " " + diretorioDeUsuario;
		
		instancia.salvaPlaniEgres(planilha, nomeArquivo, caminho);
		
		String caminhoAbsoluto = caminho + File.separator + nomeArquivo;
		file = new File( caminhoAbsoluto );
		
		Assert.assertFalse( file.exists() );
	}
	
	//Gera um diretório inexistente e testa se programa cria o diretorio e o arquivo.
	@Test
	public void testCaminhoInexistente()
	{
		String nomeArquivo = "arquivo.odf";
		String diretorioAdicional = "folder";
		int complemento = 1;
		String caminho; 
		
		do
		{
			diretorioAdicional = diretorioAdicional + complemento;
			caminho = diretorioDeUsuario + File.separator + diretorioAdicional;
			file = new File( caminho );
			complemento++;			
		}while (file.exists() && file.isDirectory());

		instancia.salvaPlaniEgres(planilha, caminho, nomeArquivo);
		
		String caminhoAbsoluto = caminho + File.separator + nomeArquivo; 
		file = new File( caminhoAbsoluto );
		
		Assert.assertTrue( file.exists() );
	}
}
