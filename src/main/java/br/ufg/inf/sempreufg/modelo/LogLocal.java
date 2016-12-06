package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.ComandoSQL;
import br.ufg.inf.sempreufg.enums.MensagemClienteValores;
import br.ufg.inf.sempreufg.enums.MensagemValores;
import br.ufg.inf.sempreufg.interfaces.LogConfigItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogLocal implements LogConfigItem {

    private MensagemClienteValores nivelMensagemCliente;
    private MensagemValores nivelMensagemLog;
    private ComandoSQL tipoComandosSQL;
    private int duracaoComando;

    public MensagemClienteValores getNivelMensagemCliente() {
        return nivelMensagemCliente;
    }

    public void setNivelMensagemCliente(MensagemClienteValores nivelMensagemCliente) {
        this.nivelMensagemCliente = nivelMensagemCliente;
    }

    public MensagemValores getNivelMensagemLog() {
        return nivelMensagemLog;
    }

    public void setNivelMensagemLog(MensagemValores nivelMensagemLog) {
        this.nivelMensagemLog = nivelMensagemLog;
    }

    public ComandoSQL getTipoComandosSQL() {
        return tipoComandosSQL;
    }

    public void setTipoComandosSQL(ComandoSQL tipoComandosSQL) {
        this.tipoComandosSQL = tipoComandosSQL;
    }

    public int getDuracaoComando() {
        return duracaoComando;
    }

    public void setDuracaoComando(int duracaoComando) {
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
    		case "nivelMensagemCliente":
    			    			
    			for(MensagemClienteValores valor: MensagemClienteValores.values() )
    			{
    				String string = param.getValor();
    				if( string.equals(valor.name()))
    				{
    					this.nivelMensagemCliente = valor;
    				}
    			}
    			
    			
    			break;
    		case "nivelMensagemLog":

    			for(MensagemValores valor: MensagemValores.values() )
    			{
    				String string = param.getValor();
    				if( string.equals(valor.name()))
    				{
    					this.nivelMensagemLog = valor;
    				}
    			}
    			
    			break;
    		case "tipoComandosSQL":
    			
    			for(ComandoSQL valor: ComandoSQL.values() )
    			{
    				String string = param.getValor();
    				if( string.equals(valor.name()))
    				{
    					this.tipoComandosSQL = valor;
    				}
    			}
    			
    			break;
    		case "duracaoComando":

    		if(ehNumerico( param.getValor() ) )
    		{
    			int duracao = Integer.parseInt( param.getValor() );
    			
    			if(duracao >= 0 )
    				this.duracaoComando = duracao;
    		}
    			
    		default:
    			// process
    			break;
    		}
    	}
    	
    	
    }
}
