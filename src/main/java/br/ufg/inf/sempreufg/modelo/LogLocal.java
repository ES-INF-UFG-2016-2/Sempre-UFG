package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.ComandoSQL;
import br.ufg.inf.sempreufg.enums.MensagemClienteValores;
import br.ufg.inf.sempreufg.enums.MensagemValores;
import br.ufg.inf.sempreufg.enums.ParametrosLogging;
import br.ufg.inf.sempreufg.interfaces.LogConfigItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogLocal implements LogConfigItem
{
    private ParametroLog destinoLog; //String
    private ParametroLog diretorioLog; // String
    private ParametroLog nomeArquivo; // String
    private ParametroLog tempoDeVidaLog; // int
    private ParametroLog tamanhoMaximoLog; // int

    public LogLocal()
    {
    	destinoLog.setSigla( ParametrosLogging.LOG_DESTINATION.name());
    	diretorioLog.setSigla(ParametrosLogging.LOG_DIRECTORY.name());
    	nomeArquivo.setSigla(ParametrosLogging.LOG_FILENAME.name());
    	tempoDeVidaLog.setSigla(ParametrosLogging.LOG_DURATION.name());
    }
    
    public ParametroLog getDestinoLog()
    {
        return destinoLog;
    }
    
    public ArrayList<ParametroLog> getParametros()
    {
    	ArrayList<ParametroLog> parametros = new ArrayList<ParametroLog>();
    	
    	parametros.add(destinoLog);
    	parametros.add(diretorioLog);
    	parametros.add(nomeArquivo);
    	parametros.add(tempoDeVidaLog);
    	parametros.add(tamanhoMaximoLog);
    	
    	return parametros;
   }
    
    public void setParametro( ParametroLog parametro)
    {
    	if( parametro.getSigla().equals("LOG_DESTINATION"))
    		destinoLog = parametro;
    	else if ( parametro.getSigla().equals("LOG_FILENAME"))
    		diretorioLog = parametro;
    	else if ( parametro.getSigla().equals("LOG_DIRECTORY"))
    		nomeArquivo = parametro;
    	else if ( parametro.getSigla().equals("LOG_DURATION"))
    		tempoDeVidaLog = parametro;
    }

    public void setDestinoLog(ParametroLog destinoLog) {
        this.destinoLog = destinoLog;
    }

    public ParametroLog getDiretorioLog() {
        return diretorioLog;
    }

    public void setDiretorioLog(ParametroLog diretorioLog) {
        this.diretorioLog = diretorioLog;
    }

    public ParametroLog getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(ParametroLog nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public ParametroLog getTempoDeVidaLog() {
        return tempoDeVidaLog;
    }

    public void setTempoDeVidaLog(ParametroLog tempoDeVidaLog) {
        this.tempoDeVidaLog = tempoDeVidaLog;
    }

    public ParametroLog getTamanhoMaximoLog() {
        return tamanhoMaximoLog;
    }

    public void setTamanhoMaximoLog(ParametroLog tamanhoMaximoLog) {
        this.tamanhoMaximoLog = tamanhoMaximoLog;
    }

    public boolean ehNumerico(String str )
    {
    	try
    	{
    		int numero = Integer.parseInt( str );
    	}
    	catch(NumberFormatException nfe )
    	{
    		return false;
    	}
    	return true;
    }
    
    
    @Override
    public void configurarParametros(ArrayList<ParametroLog> parametros) 
    {
    	Iterator<ParametroLog> iterador = parametros.iterator();
    	Iterator<ParametroLog> iterador2 = getParametros().iterator();
    	
    	while(iterador.hasNext() )
    	{
    		ParametroLog param = iterador.next();
    		
    		while( iterador2.hasNext() )
    		{
    			ParametroLog param2 = iterador.next();
    			if( param.getSigla().equals( param2.sigla))
    			{
    				setParametro( param );
    			}
    		}
    	}
    }
}
