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
public class LogGatilhos implements LogConfigItem{
    private String destinoLog;
    private String diretorioLog;
    private String nomeArquivo;
    private int tempoDeVidaLog;
    private int tamanhoMaximoLog;

    public String getDestinoLog() {
        return destinoLog;
    }

    public void setDestinoLog(String destinoLog) {
        this.destinoLog = destinoLog;
    }

    public String getDiretorioLog() {
        return diretorioLog;
    }

    public void setDiretorioLog(String diretorioLog) {
        this.diretorioLog = diretorioLog;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public int getTempoDeVidaLog() {
        return tempoDeVidaLog;
    }

    public void setTempoDeVidaLog(int tempoDeVidaLog) {
        this.tempoDeVidaLog = tempoDeVidaLog;
    }

    public int getTamanhoMaximoLog() {
        return tamanhoMaximoLog;
    }

    public void setTamanhoMaximoLog(int tamanhoMaximoLog) {
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
    	
    	while(iterador.hasNext() )
    	{
    		ParametroLog param = iterador.next();
    		
    		switch(param.getSigla() )
    		{
    		case "destinoLog":
    			    			
    			this.destinoLog = param.getValor();
    			
    			break;
    		case "diretorioLog":

    			this.diretorioLog = param.getValor();
    			
    			break;
    		case "nomeArquivo":
    			
    			this.nomeArquivo = param.getValor();
    			
    			break;
    		case "tempoDeVidaLog":
    			
    			if(ehNumerico( param.getValor() ))
    			{
    				int tempo = Integer.parseInt( param.getValor() );
    				if( tempo >= 0 )
    					this.tempoDeVidaLog = tempo;
    			}
    	
    		
    		case "tamanhoMaximoLog":

        		if(ehNumerico(param.getValor() ))
        		{
        			int tamanho = Integer.parseInt( param.getValor());
        			if( tamanho >= 0 )
        				this.tamanhoMaximoLog = tamanho;
        		}
    			
    		default:
    			// process
    			break;
    		}
    	}
    }
}
