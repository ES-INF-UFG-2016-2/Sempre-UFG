package br.ufg.inf.sempreufg.factory;

import java.sql.SQLException;

import br.ufg.inf.sempreufg.enums.TipoBanco;
import br.ufg.inf.sempreufg.interfaces.BackupBancoInterface;
import br.ufg.inf.sempreufg.modelo.BackupBancoMariaDb;
import br.ufg.inf.sempreufg.modelo.BackupBancoPostegres;


public class FabricaBackup {
	public static BackupBancoInterface criarBackup(TipoBanco tipo) throws ClassNotFoundException, SQLException{
		switch (tipo) {
		case MARIA_DB:
			return new BackupBancoMariaDb();
		case POSTEGRESQL:
			return new BackupBancoPostegres();
		default:
			break;
		}
		return null;
	}
}
