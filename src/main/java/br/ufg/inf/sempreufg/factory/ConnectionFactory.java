package br.ufg.inf.sempreufg.factory;

import java.sql.Connection;
import java.sql.SQLException;

import br.ufg.inf.sempreufg.enums.TipoBanco;

public class ConnectionFactory {
	public Connection getConnection(TipoBanco tipoBanco) throws ClassNotFoundException, SQLException{
		switch (tipoBanco) {
		case MARIA_DB:
			return new ConnectionFactoryMariaDb().getConnection();
		case POSTEGRESQL:
			return new ConnectionFactoryPostegres().getConnection();
		}
		return null;
	}
}
