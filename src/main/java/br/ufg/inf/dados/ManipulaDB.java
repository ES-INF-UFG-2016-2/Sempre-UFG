package br.ufg.inf.dados;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ManipulaDB {

	private static String url;
	private static String usuarioDB;
	private static String senhaDB;

	public ManipulaDB() throws IOException {

		Properties props = new Properties();
		FileInputStream file = new FileInputStream("src/test/resources/config.properties");
		props.load(file);
		url = props.getProperty("database");
		usuarioDB = props.getProperty("dbuser");
		senhaDB = props.getProperty("dbpassword");
	}

	public Connection criaConexao() {

		try {
			Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}