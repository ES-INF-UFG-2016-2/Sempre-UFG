package br.ufg.inf.dados;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesCreator {

	public static void main(String[] args) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("src/test/resources/config.properties");

			prop.setProperty("database", "jdbc:postgresql://localhost:5432/AprovDivulgInfoDB");
			prop.setProperty("dbuser", "postgres");
			prop.setProperty("dbpassword", "admin");
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}