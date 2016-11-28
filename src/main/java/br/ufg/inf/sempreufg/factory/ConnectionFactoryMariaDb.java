package br.ufg.inf.sempreufg.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryMariaDb {
	private Connection con;

	public Connection getConnection() throws ClassNotFoundException, SQLException{
		if (con == null) {
			criarConexao();
		}

		return con;
	}

	private void criarConexao() throws SQLException, ClassNotFoundException{
		Class.forName("org.mariadb.jdbc.Driver");
		this.con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sempre_ufg", "root", "senha");
	}
}
