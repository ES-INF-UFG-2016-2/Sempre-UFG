package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.ParametrosBackupBanco;

import java.util.List;


public interface BackupBancoInterface {
	void realizarBackup(ParametrosBackupBanco parametros);
	boolean caminhoBackupEValido(String caminho) throws IllegalArgumentException;
	void criarBackup(String caminho, String caminhoPadraoParaExecucao);
	void salvarParametrosBackupBanco(ParametrosBackupBanco parametros);
	List<ParametrosBackupBanco> consultarParametrosBackupBanco();
}
