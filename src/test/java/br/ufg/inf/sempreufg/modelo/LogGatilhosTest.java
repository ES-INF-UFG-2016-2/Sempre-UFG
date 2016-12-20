package br.ufg.inf.sempreufg.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;
import br.ufg.inf.sempreufg.enums.ParametrosLogging;
import org.junit.Before;

public class LogGatilhosTest 
{
	LogGatilhos logGatilhos = new LogGatilhos();
	ArrayList<ParametroLog> lista = new ArrayList<ParametroLog>();
        
	@Before
	public void setUp() throws Exception
	{
        lista.add(new ParametroLog(ParametrosLogging.CLIENT_MIN_MESSAGES.name(),"DEBUG1" ));
        lista.add(new ParametroLog(ParametrosLogging.LOG_MIN_MESSAGES.name(), "DEBUG3"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_MIN_ERROR_STATEMENT.name(), "ERROR"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_MIN_DURATION_STATEMENT.name(), "200"));
        
        logGatilhos.configurarParametros(lista);
	}
	
	@After
	public void tearDown() throws Exception
	{
		//lista.clear();
	}
	
	@Test
	public void testNivelMensagemCliente() 
	{
		assertEquals("DEBUG1", logGatilhos.getNivelMensagemCliente().getValor() );
	}
	
	
	@Test
	public void testNivelMensagemLog()
	{
		assertEquals("DEBUG3", logGatilhos.getNivelMensagemLog().getValor());
	}
	
	@Test
	public void testTipoComandoSQL()
	{
		assertEquals("ERROR", logGatilhos.getTipoComandosSQL().getValor());
	}
	
	@Test
	public void testDuracaoComando()
	{
		assertEquals("200", logGatilhos.getDuracaoComando().getValor() );
	}

}
