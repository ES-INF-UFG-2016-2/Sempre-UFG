package br.ufg.inf.sempreufg.modelo;

public class MensagemManutencao
{
	private String dataInicial;
	private String dataFinal;
	private String horaInicial;
	private String horaFinal;
	private String abrangencia;
	private String motivo;
	private String mensagem;
	
	public MensagemManutencao(String dataInicial, String dataFinal, String horaInicial, String horaFinal,
			String abrangencia, String motivo, String mensagem )
	{
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.abrangencia = abrangencia;
		this.motivo = motivo;
		this.mensagem = mensagem;
	}

	public String getDataInicial() 
	{
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) 
	{
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() 
	{
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) 
	{
		this.dataFinal = dataFinal;
	}

	public String getHoraInicial() 
	{
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) 
	{
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() 
	{
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) 
	{
		this.horaFinal = horaFinal;
	}

	public String getAbrangencia() 
	{
		return abrangencia;
	}

	public void setAbrangencia(String abrangencia) 
	{
		this.abrangencia = abrangencia;
	}

	public String getMotivo()
	{
		return motivo;
	}

	public void setMotivo(String motivo)
	{
		this.motivo = motivo;
	}

	public String getMensagem() 
	{
		return mensagem;
	}

	public void setMensagem(String mensagem)
	{
		this.mensagem = mensagem;
	}
	
	
}
