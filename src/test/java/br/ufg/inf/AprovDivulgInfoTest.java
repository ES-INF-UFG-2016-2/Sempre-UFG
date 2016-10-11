package br.ufg.inf;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AprovDivulgInfoTest {

	// conexão com db
	static String url = "jdbc:postgresql://localhost:5432/AprovDivulgInfoDB";
	static String usuarioDB = "postgres";
	static String senhaDB = "admin";

	// usuario
	static String email = "email";
	static String senha = "senha";
	static String nome = "nome";
	static String cpf = "00000000001";
	static String recebe_divulgacao = "DIARIA";
	static Date timestamp_de_cadastramento = new Date(0000, 00, 00);
	static Date timestamp_de_ultima_atualizacao = new Date(0000, 00, 00);
	static Date timestamp_de_exclusao_logica = new Date(0000, 00, 00);

	// aprovacao_de_divulgacao
	static int id_aprovacao = -1;
	static boolean aprovada = false;
	static String parecer = "parecer sobre divulgacao";
	static Date data_aprovacao_ou_rejeicao = new Date(0000, 00, 00);

	// curso_da_ufg
	static String nivel = "MESTRADO";
	static String tipo_de_resolucao = "CEPEC";
	static int numero_da_resolucao = 2;
	static boolean presencial = false;
	static String turno = "INTEGRAL";

	@Test
	public void testDriverPostgresql1() throws SQLException, ClassNotFoundException {

		Class.forName("org.postgresql.Driver");

	}

	@Test
	public void testConnectionDB() throws SQLException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);

	}

	@Test
	public void testTableUsuario() throws SQLException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);

		// Checks if table usuario exists in DB
		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "usuario", null);
		if (tables.next()) {
			// Table exists
			System.out.println("Table usuario existe.");
		} else {
			System.out.println("ERRO: usuario");
		}
		conn.close();

	}

	@Test
	public void testTableAprov() throws SQLException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);

		// Checks if table aprovacao_de_divulgacao exists in DB
		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "aprovacao_de_divulgacao", null);
		if (tables.next()) {
			// Table exists
			System.out.println("Table aprovacao_de_divulgacao existe.");
		} else {
			System.out.println("ERRO: aprovacao_de_divulgacao");
		}
		conn.close();

	}

	@Test
	public void testTableCursos() throws SQLException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);

		// Checks if table curso_da_ufg exists in DB
		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "curso_da_ufg", null);
		if (tables.next()) {
			// Table exists
			System.out.println("Table curso_da_ufg existe.");
		} else {
			System.out.println("ERRO: curso_da_ufg");
		}
		conn.close();

	}

	@Test
	public void testEnumNivel() throws SQLException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("nivel")) {

				System.out.println("Enum NIVEL existe.");
			}
		}

	}

	@Test
	public void testEnumRecebe_Divulg() throws SQLException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("recebe_divulgacao")) {

				System.out.println("Enum recebe_divulgacao existe.");
			}
		}

	}

	@Test
	public void testEnumTipo_de_resolucao() throws SQLException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("tipo_de_resolucao")) {

				System.out.println("Enum tipo_de_resolucao existe.");
			}
		}

	}

	@Test
	public void testEnumTurno() throws SQLException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("turno")) {

				System.out.println("Enum Turno existe.");
			}
		}

	}

	@Test
	@Ignore
	public void testInsertUsuario()
			throws SQLException, FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();
		File file = new File("imagem.png");
		FileInputStream fis = new FileInputStream(file);

		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha_criptografada = hexString.toString();

		String user_data = "INSERT INTO usuario" + " (email_principal," + "senha, nome_social,"
				+ " cpf,foto_pessoal, recebe_divulgacao,"
				+ "timestamp_de_cadastramento,timestamp_de_ultima_atualizacao," + "timestamp_de_exclusao_logica)"
				+ " values" + "(?,?,?,?,?,CAST(? AS recebe_divulgacao),?,?,?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setString(1, email);
		ps.setString(2, senha);
		ps.setString(3, nome);
		ps.setString(4, cpf);
		ps.setBinaryStream(5, null, 0);
		ps.setString(6, recebe_divulgacao); // CAST AS recebe_divulgacao type in
											// SQL
		ps.setDate(7, timestamp_de_cadastramento);
		ps.setDate(8, timestamp_de_ultima_atualizacao);
		ps.setDate(9, timestamp_de_exclusao_logica);

		try {
			ps.executeQuery();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	@Test
	@Ignore
	public void testInsertAprov() throws SQLException, FileNotFoundException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();

		String user_data = "INSERT INTO aprovacao_de_divulgacao" + " (id, divulgacao_aprovada,"
				+ " parecer_sobre_divulgacao, data_aprovacao_ou_rejeicao)" + " values" + "(?,?,?,?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setInt(1, id_aprovacao);
		ps.setBoolean(2, aprovada);
		ps.setString(3, parecer);
		ps.setDate(4, data_aprovacao_ou_rejeicao);

		try {
			if (id_aprovacao < 1) {
				System.out.println("Identificador não pode ser menor que 0.");

			} else {
				ps.executeQuery();
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	@Test
	@Ignore
	public void testInsertCurso() throws SQLException, FileNotFoundException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();

		String user_data = "INSERT INTO curso_da_ufg" + " (nivel," + " tipo_de_resolucao, numero_da_resolucao, "
				+ "presencial, turno)" + " values" + "(CAST(? AS nivel)," + "CAST(? AS tipo_de_resolucao),?,?,"
				+ "CAST(? AS turno));";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setString(1, nivel);
		ps.setString(2, tipo_de_resolucao);
		ps.setInt(3, numero_da_resolucao);
		ps.setBoolean(4, presencial);
		ps.setString(5, turno);

		try {
			ps.executeQuery();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	@Test
	@Ignore
	public void testTruncate() throws SQLException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm1 = conn.createStatement();
		Statement stm2 = conn.createStatement();
		Statement stm3 = conn.createStatement();

		String data1 = "TRUNCATE usuario;";
		String data2 = "TRUNCATE aprovacao_de_divulgacao;";
		String data3 = "TRUNCATE curso_da_ufg;";

		try {
			stm1.execute(data1);
			stm2.execute(data2);
			stm3.execute(data3);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	@Test
	public void testBuscaUsuario()
			throws SQLException, FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {

		testInsertUsuario();

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();

		String busca = "SELECT * FROM public.usuario " + "ORDER BY (email_principal, cpf);";

		PreparedStatement ps1 = conn.prepareStatement(busca);
		ResultSet rs = ps1.executeQuery();

		while (rs.next()) {

			assertEquals(rs.getString(1), email);
			assertEquals(rs.getString(2), senha);
			assertEquals(rs.getString(3), nome);
			assertEquals(rs.getString(4), cpf);
			assertEquals(rs.getBinaryStream(5), null);
			assertEquals(rs.getString(6), recebe_divulgacao);
			assertEquals(rs.getDate(7), timestamp_de_cadastramento);
			assertEquals(rs.getDate(8), timestamp_de_ultima_atualizacao);
			assertEquals(rs.getDate(9), timestamp_de_exclusao_logica);

		}

	}

	@Test
	public void testBuscaAprovacao() throws SQLException, FileNotFoundException {

		testInsertAprov();

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();

		String busca = "SELECT * FROM public.aprovacao_de_divulgacao " + "ORDER BY (id);";

		PreparedStatement ps1 = conn.prepareStatement(busca);
		ResultSet rs = ps1.executeQuery();

		while (rs.next()) {

			assertEquals(rs.getInt(1), id_aprovacao);
			assertEquals(rs.getBoolean(2), aprovada);
			assertEquals(rs.getString(3), parecer);
			assertEquals(rs.getDate(4), data_aprovacao_ou_rejeicao);

		}

	}

	@Test
	public void testBuscaCurso() throws SQLException, FileNotFoundException {

		testInsertCurso();

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();

		String busca = "SELECT * FROM public.curso_da_ufg " + "ORDER BY (numero_da_resolucao);";

		PreparedStatement ps1 = conn.prepareStatement(busca);
		ResultSet rs = ps1.executeQuery();

		while (rs.next()) {

			assertEquals(rs.getString(1), nivel);
			assertEquals(rs.getString(2), tipo_de_resolucao);
			assertEquals(rs.getInt(3), numero_da_resolucao);
			assertEquals(rs.getBoolean(4), presencial);
			assertEquals(rs.getString(5), turno);

		}

	}

	@Test

	public void testUsuarioCpfInvalido() throws SQLException, FileNotFoundException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();
		File file = new File("imagem.png");
		FileInputStream fis = new FileInputStream(file);

		String user_data = "INSERT INTO usuario" + " (email_principal," + "senha, nome_social,"
				+ " cpf,foto_pessoal, recebe_divulgacao,"
				+ "timestamp_de_cadastramento,timestamp_de_ultima_atualizacao," + "timestamp_de_exclusao_logica)"
				+ " values" + "(?,md5(?),?,?,?,CAST(? AS recebe_divulgacao),?,?,?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setString(1, email);
		ps.setString(2, senha);
		ps.setString(3, nome);
		ps.setString(4, "123123123123");
		// ps.setBinaryStream(5, fis, (int) file.length());
		ps.setBinaryStream(5, null, 0);
		ps.setString(6, recebe_divulgacao); // CAST AS recebe_divulgacao type in
											// SQL
		ps.setDate(7, timestamp_de_cadastramento);
		ps.setDate(8, timestamp_de_ultima_atualizacao);
		ps.setDate(9, timestamp_de_exclusao_logica);

		try {
			ps.executeQuery();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	@Test
	public void testSenhaUsuario()
			throws SQLException, FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();
		File file = new File("imagem.png");
		FileInputStream fis = new FileInputStream(file);
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha_criptografada = hexString.toString();

		String busca = "SELECT * FROM public.usuario " + "ORDER BY (email_principal, cpf);";

		PreparedStatement ps1 = conn.prepareStatement(busca);
		ResultSet rs = ps1.executeQuery();

		while (rs.next()) {

			assertEquals(rs.getString("senha"), senha);
		}

	}

	@Test
	@Ignore
	public void testInsertAprovIdInvalido() throws SQLException, FileNotFoundException {

		Connection conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
		Statement stm = conn.createStatement();
		int id_ = -1;
		String user_data = "INSERT INTO aprovacao_de_divulgacao" + " (id, divulgacao_aprovada,"
				+ " parecer_sobre_divulgacao, data_aprovacao_ou_rejeicao)" + " values" + "(?,?,?,?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setInt(1, id_);
		ps.setBoolean(2, aprovada);
		ps.setString(3, parecer);
		ps.setDate(4, data_aprovacao_ou_rejeicao);

		try {
			if (id_ < 1) {
				System.out.println("Identificador não pode ser menor que 0.");

			} else {
				ps.executeQuery();
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}