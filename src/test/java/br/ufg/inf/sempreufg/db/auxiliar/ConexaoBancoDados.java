package br.ufg.inf.sempreufg.db.auxiliar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {

	public static Connection conn = null;

	public static Connection getConnection() {
		if (conn != null)
			return conn;

		return getConnection("sempreufg");

	}

	public static Connection getConnection(String username) {

		String drivepostgre = "org.postgresql.Driver";
		String drivemariadb = "org.mariadb.jdbc.Driver";
		
		String headpostgre = "jdbc:postgresql://localhost:5432";
		String headmariadb = "jdbc:mariadb://localhost:3306";
		
		try {
			Class.forName(drivemariadb);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			 return DriverManager.getConnection(headmariadb + "/sempreufg", username, "sempreufg");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
