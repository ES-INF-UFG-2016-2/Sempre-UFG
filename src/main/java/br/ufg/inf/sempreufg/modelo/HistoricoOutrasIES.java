package br.ufg.inf.sempreufg.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="historicooutrasies")
public class HistoricoOutrasIES implements Serializable{

	private static final long serialVersionUID = 3739283243487959325L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
