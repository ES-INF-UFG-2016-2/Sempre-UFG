package br.ufg.inf.sempreufg.modelo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.sempreufg.enums.ParametrosLogging;

public class LogConfigTest 
{
	LogConfig config = new LogConfig();
	ArrayList<ParametroLog> lista = new ArrayList<ParametroLog>();
	ArrayList<ParametroLog> listaConfig = new ArrayList<ParametroLog>();
	
	@Before
	public void setUp() throws Exception
	{
        // log itens
		lista.add(new ParametroLog(ParametrosLogging.APPLICATION_NAME.name(),"True" ));
        lista.add(new ParametroLog(ParametrosLogging.LOG_CONNECTIONS.name(), "True"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_DURATION.name(), "200"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_ERROR_VERBOSITY.name(), "TERSE"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_HOSTNAME.name(), "True"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_LINE_PREFIX.name(), "abc"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_LOCK_WAITS.name(), "20"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_STATEMENT.name(), "DDL"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_TIMEZONE.name(), "20/10/2016"));
        
        // log local
        lista.add(new ParametroLog(ParametrosLogging.LOG_DESTINATION.name(),"c:/joao" ));
        lista.add(new ParametroLog(ParametrosLogging.LOG_DIRECTORY.name(), "c:/home"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_FILENAME.name(), "meuBackup"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_ROTATION_AGE.name(), "200"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_ROTATION_SIZE.name(), "200") );
        
        // log gatilhos
        lista.add(new ParametroLog(ParametrosLogging.CLIENT_MIN_MESSAGES.name(),"DEBUG1" ));
        lista.add(new ParametroLog(ParametrosLogging.LOG_MIN_MESSAGES.name(), "DEBUG3"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_MIN_ERROR_STATEMENT.name(), "DDL"));
        lista.add(new ParametroLog(ParametrosLogging.LOG_MIN_DURATION_STATEMENT.name(), "200"));
        
        config.configurarLog(lista);

	}
	
	@Test
	public void testParametrosNaoNulos()
	{
		Iterator<ParametroLog> iterador = config.getListaParametros().iterator();
		
		while( iterador.hasNext() ) 
		{
			String sigla = ( iterador.next().getSigla() );
			
			assertNotEquals(null, sigla);
		}
		
	}
	
	/*
	@Test
	public void testCarregarConfigFile()
	{
		File caminho = config.getArquivoLog();
		
		assertTrue( caminho.exists() );
	}*/
	
	/*
	@Test
	public void configurarLogTest()
	{
		listaConfig = config.getListaParametros();
		
		Iterator<ParametroLog> iteradorListaConfig = listaConfig.iterator();
		Iterator<ParametroLog> iteradorLista;
		
		while(iteradorListaConfig.hasNext() )
		{
			ParametroLog itemListaConfig = iteradorListaConfig.next();
			iteradorLista = lista.iterator();
			
			while(iteradorLista.hasNext() )
			{
				ParametroLog itemLista = iteradorLista.next();
				
				if( (itemListaConfig.getSigla().equals(itemLista.getSigla())))
				{
					assertEquals(itemListaConfig.getValor(), itemLista.getValor() );		
				}
			}
			
		}
	}*/
	

}
