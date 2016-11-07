package br.ufg.inf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	public static Connection conn = null;

	public static Connection getConnection(){
		if(conn != null) return conn;

		return getConnection("sempreufg");

	}


	public static Connection getConnection(String username){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sempreufg", username,"sempreufg");
		} catch (SQLException e) {
			e.printStackTrace();
			return conn;
		}
		return conn;
	}

}
