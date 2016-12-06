package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.ComandoSQL;
import br.ufg.inf.sempreufg.enums.MensagemClienteValores;
import br.ufg.inf.sempreufg.enums.MensagemValores;
import br.ufg.inf.sempreufg.enums.VerbosidadeValores;
import br.ufg.inf.sempreufg.interfaces.LogConfigItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogItens implements LogConfigItem {

    private String nomeAplicacao;
    private boolean tentativasConexao;
    private boolean duracaoComandos;
    private VerbosidadeValores verbosidade;
    private boolean nomeServidor;
    private String comentarioPrefixo;
    private boolean esperaLimite;
    private ComandoSQL comandoSQL;
    private String fusoHorario;

    public String getNomeAplicacao() {
        return nomeAplicacao;
    }

    public void setNomeAplicacao(String nomeAplicacao) {
        this.nomeAplicacao = nomeAplicacao;
    }

    public boolean isTentativasConexao() {
        return tentativasConexao;
    }

    public void setTentativasConexao(boolean tentativasConexao) {
        this.tentativasConexao = tentativasConexao;
    }

    public boolean isDuracaoComandos() {
        return duracaoComandos;
    }

    public void setDuracaoComandos(boolean duracaoComandos) {
        this.duracaoComandos = duracaoComandos;
    }

    public VerbosidadeValores getVersidade() {
        return verbosidade;
    }

    public void setVersidade(VerbosidadeValores versidade) {
        this.verbosidade = versidade;
    }

    public boolean isNomeServidor() {
        return nomeServidor;
    }

    public void setNomeServidor(boolean nomeServidor) {
        this.nomeServidor = nomeServidor;
    }

    public String getComentarioPrefixo() {
        return comentarioPrefixo;
    }

    public void setComentarioPrefixo(String comentarioPrefixo) {
        this.comentarioPrefixo = comentarioPrefixo;
    }

    public boolean isEsperaLimite() {
        return esperaLimite;
    }

    public void setEsperaLimite(boolean esperaLimite) {
        this.esperaLimite = esperaLimite;
    }

    public ComandoSQL getComandoSQL() {
        return comandoSQL;
    }

    public void setComandoSQL(ComandoSQL comandoSQL) {
        this.comandoSQL = comandoSQL;
    }

    public String getFusoHorario() {
        return fusoHorario;
    }

    public void setFusoHorario(String fusoHorario) {
        this.fusoHorario = fusoHorario;
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
    		case "nomeAplicacao":
    			this.nomeAplicacao = param.getValor();
     			
    			break;
    		case "tentativasConexao":
    			
    			if(param.getValor().equalsIgnoreCase("true") )
    				this.tentativasConexao = true;
    			else
    				this.tentativasConexao = false;

    			break;
 
    		case "duracaoComandos":
    			
    			if(param.getValor().equalsIgnoreCase("true") )
    				this.duracaoComandos = true;
    			else
    				this.duracaoComandos = false;
    			
    			break;
    			
    		case "verbosidade":
    			
    			for(VerbosidadeValores valor: VerbosidadeValores.values() )
    			{
    				String string = param.getValor();
    				if( string.equals(valor.name()))
    				{
    					this.verbosidade = valor;
    				}
    			}
    			
    			break;
    			
			case "nomeServidor":
			    		
				if(param.getValor().equalsIgnoreCase("true") )
    				this.nomeServidor = true;
    			else
    				this.nomeServidor = false;
				
			    break;
			
			case "comentarioPrefixo":
				
				this.comentarioPrefixo = param.getValor();
				
				break;    
			    
			case "esperaLimite":
				
				if(param.getValor().equalsIgnoreCase("true") )
    				this.esperaLimite = true;
    			else
    				this.esperaLimite = false;
				
				break;
				
				
			case "comandoSQL":
				
				for(ComandoSQL valor: ComandoSQL.values() )
    			{
    				String string = param.getValor();
    				if( string.equals(valor.name()))
    				{
    					this.comandoSQL = valor;
    				}
    			}
				
				break;
				
			case "fusoHorario":
				
				this.fusoHorario = param.getValor();
				
				break;
    			
    		default:
    			// process
    			break;
    		}
    	}
    }
}
