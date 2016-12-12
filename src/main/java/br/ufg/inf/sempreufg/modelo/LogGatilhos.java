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
public class LogGatilhos implements LogConfigItem 
{
    private ParametroLog nivelMensagemCliente;
    private ParametroLog nivelMensagemLog;
    private ParametroLog tipoComandosSQL;
    private ParametroLog duracaoComando;
    
    public LogGatilhos()
    {
    	nivelMensagemCliente.setSigla(ParametrosLogging.CLIENT_MIN_MESSAGES.name() );
    	nivelMensagemLog.setSigla( ParametrosLogging.LOG_MIN_MESSAGES.name());
    	tipoComandosSQL.setSigla(ParametrosLogging.LOG_STATEMENT.name());
    	duracaoComando.setSigla(ParametrosLogging.LOG_MIN_DURATION_STATEMENT.name());
    }
    
    public ArrayList<ParametroLog> getParametros()
    {
    	ArrayList<ParametroLog> parametros = new ArrayList<ParametroLog>();
    	
    	parametros.add(nivelMensagemCliente);
    	parametros.add(nivelMensagemLog);
    	parametros.add(tipoComandosSQL);
    	parametros.add(duracaoComando);
    	
    	return parametros;
   }

    public ParametroLog getNivelMensagemCliente() {
        return nivelMensagemCliente;
    }

    public void setNivelMensagemCliente(ParametroLog nivelMensagemCliente) {
        this.nivelMensagemCliente = nivelMensagemCliente;
    }

    public ParametroLog getNivelMensagemLog() {
        return nivelMensagemLog;
    }

    public void setNivelMensagemLog(ParametroLog nivelMensagemLog) {
        this.nivelMensagemLog = nivelMensagemLog;
    }

    public ParametroLog getTipoComandosSQL() {
        return tipoComandosSQL;
    }

    public void setTipoComandosSQL(ParametroLog tipoComandosSQL) {
        this.tipoComandosSQL = tipoComandosSQL;
    }

    public ParametroLog getDuracaoComando() {
        return duracaoComando;
    }

    public void setDuracaoComando(ParametroLog duracaoComando) {
        this.duracaoComando = duracaoComando;
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
    	
    	while(iterador.hasNext() )
    	{
    		ParametroLog param = iterador.next();
    		    		
    		
    		switch(param.getSigla() )
    		{
    		case "CLIENT_MIN_MESSAGES":
    			    			
    			for(MensagemClienteValores valor: MensagemClienteValores.values() )
    			{
    				String string = param.getValor();
    				if( string.equals(valor.name()))
    				{
    					this.nivelMensagemCliente = param;
    				}
    			}
    			
    			
    			break;
    		case "LOG_MIN_MESSAGES":

    			for(MensagemValores valor: MensagemValores.values() )
    			{
    				String string = param.getValor();
    				if( string.equals(valor.name()))
    				{
    					this.nivelMensagemLog = param;
    				}
    			}
    			
    			break;
    		case "LOG_STATEMENT":
    			
    			for(ComandoSQL valor: ComandoSQL.values() )
    			{
    				String string = param.getValor();
    				if( string.equals(valor.name()))
    				{
    					this.tipoComandosSQL = param;
    				}
    			}
    			
    			break;
    		case "LOG_MIN_DURATION_STATEMENT":

    		if(ehNumerico( param.getValor() ) )
    		{
    			int duracao = Integer.parseInt( param.getValor() );
    			
    			if(duracao >= 0 )
    				this.duracaoComando = param;
    		}
    			
    		default:
    			// process
    			break;
    		}
    	}
    	
    	
    }
}
