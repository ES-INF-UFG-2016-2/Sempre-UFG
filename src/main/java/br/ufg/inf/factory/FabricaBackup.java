package br.ufg.inf.factory;

import java.sql.SQLException;

import br.ufg.inf.enums.TipoBanco;
import br.ufg.inf.interfaces.BackupBancoInterface;
import br.ufg.inf.modelo.BackupBancoMariaDb;
import br.ufg.inf.modelo.BackupBancoPostegres;


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
