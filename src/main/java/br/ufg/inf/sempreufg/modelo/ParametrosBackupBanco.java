package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.MedidasTempo;

public class ParametrosBackupBanco {

	private String diretorioPadraoExecucaoBackup;
	private String diretorioBackup;
	private MedidasTempo unidade;
	private int tempo;

	public String getDiretorioPadraoExecucaoBackup() {
		return diretorioPadraoExecucaoBackup;
	}
	public void setDiretorioPadraoExecucaoBackup(String diretorioPadraoExecucaoBackup) {
		this.diretorioPadraoExecucaoBackup = diretorioPadraoExecucaoBackup;
	}
	public String getDiretorioBackup() {
		return diretorioBackup;
	}
	public void setDiretorioBackup(String diretorioBackup) {
		this.diretorioBackup = diretorioBackup;
	}
	public MedidasTempo getUnidade() {
		return unidade;
	}
	public void setUnidade(MedidasTempo unidade) {
		this.unidade = unidade;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
}
