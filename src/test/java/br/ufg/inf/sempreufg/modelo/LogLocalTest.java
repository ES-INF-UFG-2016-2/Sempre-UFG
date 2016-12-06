package br.ufg.inf.sempreufg.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;import br.ufg.inf.sempreufg.enums.MensagemValores;

public class LogLocalTest 
{
	LogLocal logLocal = new LogLocal();
	ParametroLog parametro = new ParametroLog();
	ArrayList<ParametroLog> lista = new ArrayList<ParametroLog>();
	
	@After
	public void tearDown() throws Exception
	{
		lista.clear();
	}
	
	@Test
	public void testNivelMensagemCliente() 
	{
		
		parametro.setSigla( "nivelMensagemCliente");
		parametro.setValor("DEBUG1");
		
		
		lista.add(parametro);
		
		logLocal.configurarParametros(lista);
		
		assertEquals("DEBUG1", logLocal.getNivelMensagemCliente().name() );
	}
	
	@Test
	public void testNivelMensagemLog()
	{
		parametro.setSigla("nivelMensagemLog");
		parametro.setValor("WARNING");
		lista.add(parametro);
		logLocal.configurarParametros(lista);
		
		assertEquals("WARNING", logLocal.getNivelMensagemLog().name());
	}
	
	@Test
	public void testTipoComandoSQL()
	{
		parametro.setSigla("tipoComandosSQL");
		parametro.setValor("DDL");
		lista.add(parametro);
		logLocal.configurarParametros(lista);
		
		assertEquals("DDL", logLocal.getTipoComandosSQL().name());
	}
	
	@Test
	public void testDuracaoComando()
	{
		parametro.setSigla( "duracaoComando");
		parametro.setValor( "10");
		lista.add(parametro);
		logLocal.configurarParametros(lista);
		
		assertEquals(10, logLocal.getDuracaoComando() );
	}

}
