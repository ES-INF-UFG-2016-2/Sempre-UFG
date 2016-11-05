package br.ufg.inf.abstratas;

import java.sql.Connection;
import java.util.List;

import br.ufg.inf.dao.BackupBancoDao;
import br.ufg.inf.interfaces.BackupBancoInterface;
import br.ufg.inf.modelo.ParametrosBackupBanco;

public abstract class AbstractBackupBanco implements BackupBancoInterface{
	
	protected Connection con;

	@Override
	public boolean caminhoBackupEValido(String caminho) throws IllegalArgumentException {
		if (caminho.isEmpty()) {
			new IllegalArgumentException("Não foi definido caminho padrão para ser salvo o backup do banco");
		}
		return true;
	}

	@Override
	public void salvarParametrosBackupBanco(ParametrosBackupBanco parametros) {
		BackupBancoDao backupBancoDao = new BackupBancoDao(getCon());
		backupBancoDao.salvarParametrosBackupBanco(parametros);
	}

	@Override
	public List<ParametrosBackupBanco> consultarParametrosBackupBanco() {
		BackupBancoDao backupBancoDao = new BackupBancoDao(getCon());
		return backupBancoDao.consultarParametrosBackupBanco();
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
