package br.ufg.inf.modelo;

import java.io.Serializable;

public class HistoricoOutrasIES implements Serializable{

	private static final long serialVersionUID = 3739283243487959325L;

	private Integer mesInicio;
	
	private Integer mesFim;
	
	private Integer anoInicio;
	
	private Integer anoFim;
	
	public Integer getMesInicio() {
		return mesInicio;
	}
	public void setMesInicio(Integer mesInicio) {
		this.mesInicio = mesInicio;
	}
	public Integer getMesFim() {
		return mesFim;
	}
	public void setMesFim(Integer mesFim) {
		this.mesFim = mesFim;
	}
	public Integer getAnoInicio() {
		return anoInicio;
	}
	public void setAnoInicio(Integer anoInicio) {
		this.anoInicio = anoInicio;
	}
	public Integer getAnoFim() {
		return anoFim;
	}
	public void setAnoFim(Integer anoFim) {
		this.anoFim = anoFim;
	}
	
	
}
