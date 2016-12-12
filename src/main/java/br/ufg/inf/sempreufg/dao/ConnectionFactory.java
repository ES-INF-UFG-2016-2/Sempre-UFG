package br.ufg.inf.sempreufg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private Connection con;

	public Connection getConnection() throws ClassNotFoundException, SQLException{
		if (con == null) {
			criarConexao();
		}

		return con;
	}

	private void criarConexao() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sempre_ufg", "postgres", "");
	}
}
