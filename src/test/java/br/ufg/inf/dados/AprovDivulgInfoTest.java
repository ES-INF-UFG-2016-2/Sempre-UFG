package br.ufg.inf.dados;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class AprovDivulgInfoTest {

	// usuario
	private String email = "email";
	private String senha = "senha";
	private String nome = "nome";
	private int cpf = 1233235353;
	private String recebe_divulgacao = "DIARIA";
	private Date data = new Date(123123123);
	private Timestamp timestamp_de_cadastramento = new Timestamp(data.getTime());
	private Timestamp timestamp_de_ultima_atualizacao = new Timestamp(data.getTime());
	private Timestamp timestamp_de_exclusao_logica = new Timestamp(data.getTime());

	// aprovacao_de_divulgacao
	private boolean aprovada = false;
	private String parecer = "parecer sobre divulgacao";
	private Timestamp data_aprovacao_ou_rejeicao = new Timestamp(data.getTime());

	// curso_da_ufg
	private String nivel = "MESTRADO";
	private String tipo_de_resolucao = "CEPEC";
	private int numero_da_resolucao = 8;
	private boolean presencial = true;
	private String turno = "INTEGRAL";

	// conexao
	static Connection conn = null;

	@BeforeClass
	public static void abreConexao() throws IOException {

		Date date = new java.util.Date();
		long milis = date.getTime();
		Timestamp ts = new Timestamp(milis);


		if (conn == null) {
			ManipulaDB db = new ManipulaDB();
			conn = db.criaConexao();

		}
	}

	@AfterClass
	public static void fechaConexao() throws IOException, SQLException {

		conn.close();

	}

	@Test
	public void testTableUsuario() throws SQLException, IOException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "usuario", null);

		assertTrue(tables.next());
	}

	@Test
	public void testTableAprov() throws SQLException, IOException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "aprovacao_de_divulgacao", null);
		assertTrue(tables.next());
	}

	@Test
	public void testTableCursos() throws SQLException, IOException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "curso_da_ufg", null);
		assertTrue(tables.next());
	}

	@Test
	public void testEnumNivel() throws SQLException, IOException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("nivel")) {
				assertTrue(rs.getString(1).equalsIgnoreCase("nivel"));
			}
		}
	}

	@Test
	public void testEnumRecebe_Divulg() throws SQLException, IOException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("recebe_divulgacao")) {
				assertTrue(rs.getString(1).equalsIgnoreCase("recebe_divulgacao"));
			}
		}
	}

	@Test
	public void testEnumTipo_de_resolucao() throws SQLException, IOException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("tipo_de_resolucao")) {
				assertTrue(rs.getString(1).equalsIgnoreCase("tipo_de_resolucao"));
			}
		}
	}

	@Test
	public void testEnumTurno() throws SQLException, IOException {

		Statement stm = conn.createStatement();

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("turno")) {
				assertTrue(rs.getString(1).equalsIgnoreCase("turno"));
			}
		}
	}

	@Test
	public void testInsertUsuario() throws SQLException, NoSuchAlgorithmException, IOException {

		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha_criptografada = hexString.toString();

		String user_data = "INSERT INTO usuario" + " ( email_principal," + "senha, nome_social,"
				+ " cpf,foto_pessoal, recebe_divulgacao,"
				+ "timestamp_de_cadastramento,timestamp_de_ultima_atualizacao," + "timestamp_de_exclusao_logica)"
				+ " values" + "(?,?,?,?,?,CAST(? AS recebe_divulgacao),?,?,?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setString(1, email);
		ps.setString(2, senha_criptografada.toLowerCase());
		ps.setString(3, nome);
		ps.setInt(4, cpf);
		ps.setBinaryStream(5, null, 0);
		ps.setString(6, recebe_divulgacao); // CAST AS recebe_divulgacao type in
											// SQL
		ps.setTimestamp(7, timestamp_de_cadastramento);
		ps.setTimestamp(8, timestamp_de_ultima_atualizacao);
		ps.setTimestamp(9, timestamp_de_exclusao_logica);

		try {
			ps.executeQuery();

		} catch (Exception e) {

			assertEquals(e.getMessage(), "Nenhum resultado foi retornado pela consulta.");

		}
	}

	@Test
	public void testInsertAprov() throws SQLException, IOException {

		String user_data = "INSERT INTO aprovacao_de_divulgacao" + " (divulgacao_aprovada,"
				+ " parecer_sobre_divulgacao, data_aprovacao_ou_rejeicao)" + " values" + "(?,?,?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setBoolean(1, aprovada);
		ps.setString(2, parecer);
		ps.setTimestamp(3, data_aprovacao_ou_rejeicao);

		try {
			ps.executeQuery();

		} catch (Exception e) {

			assertEquals(e.getMessage(), "Nenhum resultado foi retornado pela consulta.");

		}
	}

	@Test
	public void testInsertCurso() throws SQLException, IOException {

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

			assertEquals(e.getMessage(), "Nenhum resultado foi retornado pela consulta.");

		}

	}

	@Test
	public void testBuscaUsuario() throws SQLException, NoSuchAlgorithmException, IOException {

		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha_criptografada = hexString.toString();
		String busca = "SELECT * FROM public.usuario " + "WHERE cpf = '1233235353'";
		
		
		PreparedStatement ps1 = conn.prepareStatement(busca);
		ResultSet rs = ps1.executeQuery();

		while (rs.next()) {

			assertEquals(rs.getString(2), email);
			assertEquals(rs.getString(3), senha_criptografada.toLowerCase());
			assertEquals(rs.getString(4), nome);
			assertEquals(rs.getInt(5), cpf);
			assertEquals(rs.getBinaryStream(6), null);
			assertEquals(rs.getString(7), recebe_divulgacao);
			assertEquals(rs.getTimestamp(8), timestamp_de_cadastramento);
			assertEquals(rs.getTimestamp(9), timestamp_de_ultima_atualizacao);
			assertEquals(rs.getTimestamp(10), timestamp_de_exclusao_logica);
		}
	}

	@Test
	public void testBuscaAprovacao() throws SQLException, FileNotFoundException {

		String busca = "SELECT * FROM public.aprovacao_de_divulgacao " + "ORDER BY (aprov_id);";

		PreparedStatement ps1 = conn.prepareStatement(busca);
		ResultSet rs = ps1.executeQuery();

		while (rs.next()) {

			assertEquals(rs.getBoolean(2), aprovada);
			assertEquals(rs.getString(3), parecer);
			assertEquals(rs.getTimestamp(4), data_aprovacao_ou_rejeicao);
		}
	}

	@Test
	public void testBuscaCurso() throws SQLException, FileNotFoundException {

		String busca = "SELECT * FROM public.curso_da_ufg " + "ORDER BY (numero_da_resolucao);";

		PreparedStatement ps1 = conn.prepareStatement(busca);
		ResultSet rs = ps1.executeQuery();

		while (rs.next()) {

			assertEquals(rs.getString(2), nivel);
			assertEquals(rs.getString(3), tipo_de_resolucao);
			assertEquals(rs.getInt(4), numero_da_resolucao);
			assertEquals(rs.getBoolean(5), presencial);
			assertEquals(rs.getString(6), turno);
		}
	}

	@Test
	public void testCpfTamanhoInvalido() throws SQLException, FileNotFoundException {

		int cpf_invalido = 1;

		String user_data = "INSERT INTO usuario" + " (email_principal," + "senha, nome_social,"
				+ " cpf,foto_pessoal, recebe_divulgacao,"
				+ "timestamp_de_cadastramento,timestamp_de_ultima_atualizacao," + "timestamp_de_exclusao_logica)"
				+ " values" + "(?,md5(?),?,?,?,CAST(? AS recebe_divulgacao),?,?,?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setString(1, email);
		ps.setString(2, senha);
		ps.setString(3, nome);
		ps.setInt(4, cpf_invalido);
		ps.setBinaryStream(5, null, 0);
		ps.setString(6, recebe_divulgacao); // CAST AS recebe_divulgacao type in
											// SQL
		ps.setTimestamp(7, timestamp_de_cadastramento);
		ps.setTimestamp(8, timestamp_de_ultima_atualizacao);
		ps.setTimestamp(9, timestamp_de_exclusao_logica);
		
		try {
			ps.executeQuery();

		} catch (Exception e) {

			assertEquals(e.getMessage(), "Nenhum resultado foi retornado pela consulta.");

		
			
		}
	}
}
