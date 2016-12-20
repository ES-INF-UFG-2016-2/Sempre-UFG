package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.MensagemClienteValores;
import br.ufg.inf.sempreufg.enums.MensagemValores;
import br.ufg.inf.sempreufg.enums.NivelMensagensCliente;
import br.ufg.inf.sempreufg.enums.ParametrosLogging;
import br.ufg.inf.sempreufg.interfaces.LogConfigItem;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogGatilhos implements LogConfigItem 
{
	private ParametroLog nivelMensagemCliente = new ParametroLog();
    private ParametroLog nivelMensagemLog = new ParametroLog();
    private ParametroLog tipoComandosSQL = new ParametroLog();
    private ParametroLog duracaoComando = new ParametroLog();
    
    public LogGatilhos()
    {
    	nivelMensagemCliente.setSigla(ParametrosLogging.CLIENT_MIN_MESSAGES.name() );
    	nivelMensagemLog.setSigla( ParametrosLogging.LOG_MIN_MESSAGES.name());
    	tipoComandosSQL.setSigla(ParametrosLogging.LOG_MIN_ERROR_STATEMENT.name());
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
    	{
    		setNivelMensagemCliente(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_MIN_MESSAGES"))
    	{
    		setNivelMensagemLog(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_MIN_ERROR_STATEMENT"))
    	{
    		setTipoComandosSQL(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_MIN_DURATION_STATEMENT"))
    	{
    		setDuracaoComando(parametro);
    	}
    }
    
    @Override
    public void configurarParametros(ArrayList<ParametroLog> parametros) 
    {
    	Iterator<ParametroLog> iterador = parametros.iterator();

    	while(iterador.hasNext() )
    	{
    		ParametroLog param = iterador.next();

    		setParametro( param );
    	}
    }
    
    public ParametroLog getNivelMensagemCliente() {
		return nivelMensagemCliente;
	}

	public ParametroLog getNivelMensagemLog() {
		return nivelMensagemLog;
	}

	public ParametroLog getTipoComandosSQL() {
		return tipoComandosSQL;
	}

	public ParametroLog getDuracaoComando() {
		return duracaoComando;
	}

	public void setNivelMensagemCliente(ParametroLog nivelMensagemCliente) {
		this.nivelMensagemCliente = nivelMensagemCliente;
		
		if( !MensagemClienteValores.contains( nivelMensagemCliente.getValor()) )
			this.nivelMensagemCliente.setValor( MensagemClienteValores.NOTICE.name());			
	}

	public void setNivelMensagemLog(ParametroLog nivelMensagemLog) {
		this.nivelMensagemLog = nivelMensagemLog;
		
		if( !MensagemValores.contains( nivelMensagemLog.getValor()))
			this.nivelMensagemCliente.setValor(MensagemValores.WARNING.name());

	}

	public void setTipoComandosSQL(ParametroLog tipoComandosSQL) {
		this.tipoComandosSQL = tipoComandosSQL;
		
		if(!MensagemValores.contains( tipoComandosSQL.getValor()))
			this.tipoComandosSQL.setValor(MensagemValores.ERROR.name());
	}

	public void setDuracaoComando(ParametroLog duracaoComando) {
		this.duracaoComando = duracaoComando;
		
		if(!duracaoComando.temValorNumericoNaoNegativo() )
			this.duracaoComando.setValor("0");
	}
	
	
}
