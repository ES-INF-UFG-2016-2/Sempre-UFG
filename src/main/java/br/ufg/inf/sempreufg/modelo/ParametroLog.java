package br.ufg.inf.sempreufg.modelo;

public class ParametroLog
{
	String sigla;
        String tipo;
	String valor;
	String descricao;
        String IdSempreUFG;
	
	public ParametroLog()
	{
            this.tipo = "LOG";
            this.IdSempreUFG = "1";
            this.descricao = "lorem ipsum";
	}
	
	public ParametroLog(String sg, String vl )
	{
	    	this.tipo = "LOG";
            this.IdSempreUFG = "1";	
            this.sigla = sg;
            this.valor = vl;
            this.descricao = "lorem ipsum";
	}
	
    public String getIdSempreUFG()
    {
        return IdSempreUFG;
    }
    
    public boolean temValorNumerico()  
    {  
          try {  
            double d = Double.parseDouble(sigla);  
          }  
          catch(NumberFormatException nfe){  
            return false;  
          }  
          
          return true;  
    }
    
    public boolean temValorNumericoPositivo()
    {
    	try {  
            double d = Double.parseDouble(valor); 
            if( d <= 0 )
            	return false;
          }  
          catch(NumberFormatException nfe){  
            return false;  
          }  
          return true; 
    }
    
    public boolean temValorNumericoNaoNegativo()
    {
    	try {  
            double d = Double.parseDouble(valor); 
            if( d < 0 )
            	return false;
          }  
          catch(NumberFormatException nfe){  
            return false;  
          }  
          return true; 
    }
    
    public boolean ehBooleano()
    {
    	if( valor.toLowerCase().equals( "true") || valor.toLowerCase().equals( "false"))
    		return true;
    	
    	return false;
    }
        
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

        public String getTipo() {
        return tipo;
        }
}
