package br.ufg.inf.sempreufg.modelo;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;

public class LogConfigTest 
{
	LogLocal local = new LogLocal();
	LogGatilhos gatilhos = new LogGatilhos();
	LogItens itens = new LogItens();
	LogConfig config = new LogConfig();
	
	ParametroLog parametro = new ParametroLog();
	ArrayList<ParametroLog> lista = new ArrayList<ParametroLog>();
	
	
	@Test
	public void configurarLogTest()
	{
		lista.add( new ParametroLog("tipoComandosSQL", "DDL") );
		lista.add( new ParametroLog("diretorioLog", "C:user") );

		config.configurarLog(lista);
		
		assertEquals("DDL", config.getLocal().getTipoComandosSQL().name() );
		assertEquals("C:user", config.getGatilhos().getDiretorioLog() );
	}
	
	@Test
	public void gerarArquivoLogTest() throws IOException
	{
		config.carregarConfigFile();
		assertTrue(config.getArquivoLog() != null );
	}

}
