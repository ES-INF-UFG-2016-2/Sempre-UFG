package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.ParametrosLogging;
import br.ufg.inf.sempreufg.interfaces.LogConfigItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogItens implements LogConfigItem {

    private ParametroLog nomeAplicacao = new ParametroLog();
    private ParametroLog tentativasConexao = new ParametroLog();
    private ParametroLog duracaoComandos = new ParametroLog();
    private ParametroLog verbosidade = new ParametroLog();
    private ParametroLog nomeServidor = new ParametroLog();
    private ParametroLog comentarioPrefixo = new ParametroLog();
    private ParametroLog esperaLimite = new ParametroLog();
    private ParametroLog comandoSQL = new ParametroLog();
    private ParametroLog fusoHorario = new ParametroLog();
    
    public LogItens()
    {
    	nomeAplicacao.setSigla( ParametrosLogging.APPLICATION_NAME.name());
    	tentativasConexao.setSigla(ParametrosLogging.LOG_CONNECTIONS.name());
    	duracaoComandos.setSigla(ParametrosLogging.LOG_MIN_DURATION_STATEMENT.name());
    	verbosidade.setSigla(ParametrosLogging.LOG_ERROR_VERBOSITY.name());
    	nomeServidor.setSigla( ParametrosLogging.LOG_HOSTNAME.name());
    	comentarioPrefixo.setSigla(ParametrosLogging.LOG_LINE_PREFIX.name());
    	esperaLimite.setSigla(ParametrosLogging.LOG_LOCK_WAITS.name());
    	comandoSQL.setSigla(ParametrosLogging.LOG_STATEMENT.name());
    	fusoHorario.setSigla(ParametrosLogging.LOG_TIMEZONE.name());
    }
    
    public ArrayList<ParametroLog> getParametros()
    {
    	ArrayList<ParametroLog> parametros = new ArrayList<ParametroLog>();
    	
    	parametros.add(nomeAplicacao);
    	parametros.add(tentativasConexao);
    	parametros.add(duracaoComandos);
    	parametros.add(verbosidade);
    	parametros.add(nomeServidor);
    	parametros.add(comentarioPrefixo);
    	parametros.add(esperaLimite);
    	parametros.add(comandoSQL);
    	parametros.add(fusoHorario);
    	
    	return parametros;
   }
    
    public void setParametro( ParametroLog parametro)
    {
    	if( parametro.getSigla().equals("APPLICATION_NAME"))
    		nomeAplicacao = parametro;
    	else if ( parametro.getSigla().equals("LOG_CONNECTIONS"))
    		tentativasConexao = parametro;
    	else if ( parametro.getSigla().equals("LOG_MIN_DURATION_STATEMENT"))
    		duracaoComandos = parametro;
    	else if ( parametro.getSigla().equals("LOG_ERROR_VERBOSITY"))
    		verbosidade = parametro;
    	else if( parametro.getSigla().equals("LOG_HOSTNAME"))
    		nomeServidor = parametro;
    	else if ( parametro.getSigla().equals("LOG_LINE_PREFIX"))
    		comentarioPrefixo = parametro;
    	else if ( parametro.getSigla().equals("LOG_LOCK_WAITS"))
    		esperaLimite = parametro;
    	else if ( parametro.getSigla().equals("LOG_STATEMENT"))
    		comandoSQL = parametro;
    	else if ( parametro.getSigla().equals("LOG_TIMEZONE"))
    		fusoHorario = parametro;
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

	public ParametroLog getNomeAplicacao() {
		return nomeAplicacao;
	}

	public ParametroLog getTentativasConexao() {
		return tentativasConexao;
	}

	public ParametroLog getDuracaoComandos() {
		return duracaoComandos;
	}

	public ParametroLog getVerbosidade() {
		return verbosidade;
	}

	public ParametroLog getNomeServidor() {
		return nomeServidor;
	}

	public ParametroLog getComentarioPrefixo() {
		return comentarioPrefixo;
	}

	public ParametroLog getEsperaLimite() {
		return esperaLimite;
	}

	public ParametroLog getComandoSQL() {
		return comandoSQL;
	}

	public ParametroLog getFusoHorario() {
		return fusoHorario;
	}
    
    
}
