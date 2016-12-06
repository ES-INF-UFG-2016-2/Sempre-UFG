package br.ufg.inf.sempreufg.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

public class LogGatilhosTest {

	LogLocal logLocal = new LogLocal();
	LogGatilhos logGatilhos = new LogGatilhos();
	ParametroLog parametro = new ParametroLog();
	ArrayList<ParametroLog> lista = new ArrayList<ParametroLog>();
	
	@After
	public void tearDown() throws Exception
	{
		//lista.clear();
	}
	
	@Test
	public void testDestinoLog()
	{
		ParametroLog parametro = new ParametroLog();
		parametro.setSigla("destinoLog");
		parametro.setValor( "C:User");
		
		lista.add(parametro);
		logGatilhos.configurarParametros(lista);
		
		assertEquals("C:User", logGatilhos.getDestinoLog());
	}
	
	@Test
	public void testDiretorioLog() 
	{
		ParametroLog parametro = new ParametroLog();
		parametro.setSigla("diretorioLog");
		parametro.setValor("C:System");
		
		lista.add(parametro);
		logGatilhos.configurarParametros(lista);
		
		assertEquals("C:System", logGatilhos.getDiretorioLog());
	}
	
	@Test
	public void testNomeArquivo() 
	{
		ParametroLog parametro = new ParametroLog();
		parametro.setSigla("nomeArquivo");
		parametro.setValor("MeuLog");
		
		lista.add(parametro);
		logGatilhos.configurarParametros(lista);
		
		assertEquals("MeuLog", logGatilhos.getNomeArquivo());
	}
	
	@Test
	public void testTempoDeVidaLog() 
	{
		ParametroLog parametro = new ParametroLog();
		parametro.setSigla("tempoDeVidaLog");
		parametro.setValor("10");
		
		lista.add(parametro);
		logGatilhos.configurarParametros(lista);
		
		assertEquals(10, logGatilhos.getTempoDeVidaLog());
	}
	
	@Test
	public void testtamanhoMaximoLog() 
	{
		ParametroLog parametro = new ParametroLog();
		parametro.setSigla("tamanhoMaximoLog");
		parametro.setValor("1000");
		
		lista.add(parametro);
		logGatilhos.configurarParametros(lista);
		
		assertEquals(1000, logGatilhos.getTamanhoMaximoLog());
	}

}
