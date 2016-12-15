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
    
    public void setParametro( ParametroLog parametro)
    {
    	if( parametro.getSigla().equals("CLIENT_MIN_MESSAGES"))
    		nivelMensagemCliente = parametro;
    	else if ( parametro.getSigla().equals("LOG_MIN_MESSAGES"))
    		nivelMensagemLog = parametro;
    	else if ( parametro.getSigla().equals("LOG_STATEMENT"))
    		tipoComandosSQL = parametro;
    	else if ( parametro.getSigla().equals("LOG_MIN_DURATION_STATEMENT"))
    		duracaoComando = parametro;
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
