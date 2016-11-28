package br.ufg.inf.sempreufg.servico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.ufg.inf.sempreufg.dao.BackupBancoDao;
import br.ufg.inf.sempreufg.enums.TipoBanco;
import br.ufg.inf.sempreufg.factory.ConnectionFactory;
import br.ufg.inf.sempreufg.factory.FabricaBackup;
import br.ufg.inf.sempreufg.interfaces.BackupBancoInterface;
import br.ufg.inf.sempreufg.modelo.ParametrosBackupBanco;

public class BackupBancoService{

	private TipoBanco tipoBanco;
	private BackupBancoInterface backupBanco;
	private ParametrosBackupBanco parametros;
	private BackupBancoDao backupBancoDao;

	public BackupBancoService(TipoBanco tipoBanco) {
		super();
		this.tipoBanco = tipoBanco;
		try {
			setBackupBanco(FabricaBackup.criarBackup(getTipoBanco()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void realizarBackup(){
		getBackupBanco().realizarBackup(getParametros());
	}

	public void salvarParametrosBackup(ParametrosBackupBanco parametrosBackupBanco){
		try {
			Connection con = new ConnectionFactory().getConnection(getTipoBanco());
			new BackupBancoDao(con).salvarParametrosBackupBanco(parametrosBackupBanco);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerParametros(){
		try {
			Connection con = new ConnectionFactory().getConnection(getTipoBanco());
			new BackupBancoDao(con).removerParametros();;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean existeParametrosBancoCadastrados() {
		List<ParametrosBackupBanco> parametros = getBackupBanco().consultarParametrosBackupBanco();
		return !parametros.isEmpty();
	}

	public List<ParametrosBackupBanco> consultarParametrosBackupBanco() {
		return getBackupBanco().consultarParametrosBackupBanco();
	}

	public TipoBanco getTipoBanco() {
		return tipoBanco;
	}

	public void setTipoBanco(TipoBanco tipoBanco) {
		this.tipoBanco = tipoBanco;
	}

	public BackupBancoInterface getBackupBanco() {
		return backupBanco;
	}

	public void setBackupBanco(BackupBancoInterface backupBanco) {
		this.backupBanco = backupBanco;
	}

	public ParametrosBackupBanco getParametros() {
		if (this.parametros == null) {
			setParametros(consultarParametrosBackupBanco().get(0));
		}
		return parametros;
	}

	public void setParametros(ParametrosBackupBanco parametros) {
		this.parametros = parametros;
	}

	public BackupBancoDao getBackupBancoDao() {
		return backupBancoDao;
	}

	public void setBackupBancoDao(BackupBancoDao backupBancoDao) {
		this.backupBancoDao = backupBancoDao;
	}
}
