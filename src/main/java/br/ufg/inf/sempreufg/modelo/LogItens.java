package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.ComandoSQL;
import br.ufg.inf.sempreufg.enums.MensagemClienteValores;
import br.ufg.inf.sempreufg.enums.ParametrosLogging;
import br.ufg.inf.sempreufg.enums.VerbosidadeValores;
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
    	duracaoComandos.setSigla(ParametrosLogging.LOG_DURATION.name());
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
    	{
    		setNomeAplicacao(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_CONNECTIONS"))
    	{
    		setTentativasConexao(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_DURATION"))
    	{
    		setDuracaoComandos(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_ERROR_VERBOSITY"))
    	{
    		setVerbosidade(parametro);
    	}
    	else if( parametro.getSigla().equals("LOG_HOSTNAME"))
    	{
    		setNomeServidor(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_LINE_PREFIX"))
    	{
    		setComentarioPrefixo(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_LOCK_WAITS"))
    	{
    		setEsperaLimite(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_STATEMENT"))
    	{
    		setComandoSQL(parametro);
    	}
    	else if ( parametro.getSigla().equals("LOG_TIMEZONE"))
    	{
    		setFusoHorario(parametro);
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

	public void setNomeAplicacao(ParametroLog nomeAplicacao) {
		this.nomeAplicacao = nomeAplicacao;
		
		if(nomeAplicacao.getValor().length() > 64 )
			this.nomeAplicacao.setValor( "Default Name");
	}

	public void setTentativasConexao(ParametroLog tentativasConexao) {
		this.tentativasConexao = tentativasConexao;
		
		if(!tentativasConexao.ehBooleano())
			this.tentativasConexao.setValor("false");
	}

	public void setDuracaoComandos(ParametroLog duracaoComandos) {
		this.duracaoComandos = duracaoComandos;
		
		if(!duracaoComandos.ehBooleano() )
			this.duracaoComandos.setValor("false");
	}

	public void setVerbosidade(ParametroLog verbosidade) {
		this.verbosidade = verbosidade;
		
		if( !VerbosidadeValores.contains( verbosidade.getValor()) )
			this.verbosidade.setValor( VerbosidadeValores.DEFAULT.name());	
	}

	public void setNomeServidor(ParametroLog nomeServidor) {
		this.nomeServidor = nomeServidor;
		
		if(!nomeServidor.ehBooleano() )
			this.nomeServidor.setValor( "false");
	}

	public void setComentarioPrefixo(ParametroLog comentarioPrefixo) {
		this.comentarioPrefixo = comentarioPrefixo;
	}

	public void setEsperaLimite(ParametroLog esperaLimite) {
		this.esperaLimite = esperaLimite;
		
		if(!esperaLimite.ehBooleano() )
			this.esperaLimite.setValor( "false");
	}

	public void setComandoSQL(ParametroLog comandoSQL) {
		this.comandoSQL = comandoSQL;
		
		if(!ComandoSQL.contains( comandoSQL.getValor()))
			this.comandoSQL.setValor( ComandoSQL.NONE.name());
	}

	public void setFusoHorario(ParametroLog fusoHorario) {
		this.fusoHorario = fusoHorario;
	}
    
    
	
}
