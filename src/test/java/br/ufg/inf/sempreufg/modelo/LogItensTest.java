package br.ufg.inf.sempreufg.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;
import br.ufg.inf.sempreufg.enums.ParametrosLogging;
import org.junit.Before;

public class LogItensTest 
{
	LogItens logItens = new LogItens();
	ArrayList<ParametroLog> lista = new ArrayList<ParametroLog>();
        
	@Before
	public void setUp() throws Exception
	{
        lista.add(new ParametroLog(ParametrosLogging.APPLICATION_NAME.name(),"True" ));
        lista.add(new ParametroLog(ParametrosLogging.LOG_CONNECTIONS.name(), "True"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_DURATION.name(), "200"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_ERROR_VERBOSITY.name(), "TERSE"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_HOSTNAME.name(), "True"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_LINE_PREFIX.name(), "abc"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_LOCK_WAITS.name(), "20"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_STATEMENT.name(), "DDL"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_TIMEZONE.name(), "20/10/2016"));
        
        logItens.configurarParametros(lista);
	}
	
	@After
	public void tearDown() throws Exception
	{
		//lista.clear();
	}
	
	@Test
	public void testnomeAplicacao() 
	{
		assertEquals("True", logItens.getNomeAplicacao().getValor() );
	}
	
	
	@Test
	public void testTentativasConeccao()
	{
		assertEquals("True", logItens.getTentativasConexao().getValor());
	}
	
	@Test
	public void testDuracaoComandos()
	{
		assertEquals("200", logItens.getDuracaoComandos().getValor());
	}
	
	@Test
	public void testVerbosidade()
	{
		assertEquals("TERSE", logItens.getVerbosidade().getValor() );
	}
	
	@Test
	public void testNomeServidor() 
	{
		assertEquals("True", logItens.getNomeServidor().getValor() );
	}
	
	@Test
	public void testComentarioPrefixo() 
	{
		assertEquals("abc", logItens.getComentarioPrefixo().getValor() );
	}
	
	@Test
	public void testEsperaLimite() 
	{
		assertEquals("20", logItens.getEsperaLimite().getValor() );
	}
	
	@Test
	public void testComandoSQL() 
	{
		assertEquals("DDL", logItens.getComandoSQL().getValor() );
	}
	
	@Test
	public void testFusoHorario() 
	{
		assertEquals("20/10/2016", logItens.getFusoHorario().getValor() );
	}

}
