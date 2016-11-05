package br.ufg.inf.interfaces;

import java.util.List;

import br.ufg.inf.modelo.ParametrosBackupBanco;


public interface BackupBancoInterface {
	void realizarBackup(ParametrosBackupBanco parametros);
	boolean caminhoBackupEValido(String caminho) throws IllegalArgumentException;
	void criarBackup(String caminho, String caminhoPadraoParaExecucao);
	void salvarParametrosBackupBanco(ParametrosBackupBanco parametros);
	List<ParametrosBackupBanco> consultarParametrosBackupBanco(); 
}
