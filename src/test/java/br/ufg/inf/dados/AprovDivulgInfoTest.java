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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.postgresql.util.PSQLException;

public class AprovDivulgInfoTest {

	// usuario
	private String email = "email";
	private String senha = "senha";
	private String nome = "nome";
	private String cpf = "00000000001";
	private String recebe_divulgacao = "DIARIA";
	private Date timestamp_de_cadastramento = new Date(0000, 00, 00);
	private Date timestamp_de_ultima_atualizacao = new Date(0000, 00, 00);
	private Date timestamp_de_exclusao_logica = new Date(0000, 00, 00);

	// aprovacao_de_divulgacao
	private int id_aprovacao = 1;
	private boolean aprovada = false;
	private String parecer = "parecer sobre divulgacao";
	private Date data_aprovacao_ou_rejeicao = new Date(0000, 00, 00);

	// curso_da_ufg
	private String nivel = "MESTRADO";
	private String tipo_de_resolucao = "CEPEC";
	private int numero_da_resolucao = 2;
	private boolean presencial = false;
	private String turno = "INTEGRAL";

	// conexao
	static Connection conn = null;

	@BeforeClass
	public static void abreConexao() throws IOException {

		ManipulaDB db = new ManipulaDB();
		conn = db.criaConexao();
	}

	@Test
	@Before
	public void testTableUsuario() throws SQLException, IOException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "usuario", null);

		assertTrue(tables.next());
	}

	@Test
	@Before
	public void testTableAprov() throws SQLException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "aprovacao_de_divulgacao", null);
		assertTrue(tables.next());
	}

	@Test
	@Before
	public void testTableCursos() throws SQLException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "curso_da_ufg", null);
		assertTrue(tables.next());
	}

	@Test
	@Before
	public void testEnumNivel() throws SQLException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("nivel")) {
				assertTrue(rs.getString(1).equalsIgnoreCase("nivel"));
			}
		}
	}

	@Test
	@Before
	public void testEnumRecebe_Divulg() throws SQLException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("recebe_divulgacao")) {
				assertTrue(rs.getString(1).equalsIgnoreCase("recebe_divulgacao"));
			}
		}
	}

	@Test
	@Before
	public void testEnumTipo_de_resolucao() throws SQLException {

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("tipo_de_resolucao")) {
				assertTrue(rs.getString(1).equalsIgnoreCase("tipo_de_resolucao"));
			}
		}
	}

	@Test
	@Before
	public void testEnumTurno() throws SQLException {

		Statement stm = conn.createStatement();

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("turno")) {
				assertTrue(rs.getString(1).equalsIgnoreCase("turno"));
			}
		}
	}

	@Test(expected = PSQLException.class)
	public void testInsertUsuario()
			throws SQLException, FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {

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
		ps.setString(2, senha_criptografada);
		ps.setString(3, nome);
		ps.setString(4, cpf);
		ps.setBinaryStream(5, null, 0);
		ps.setString(6, recebe_divulgacao); // CAST AS recebe_divulgacao type in
											// SQL
		ps.setDate(7, timestamp_de_cadastramento);
		ps.setDate(8, timestamp_de_ultima_atualizacao);
		ps.setDate(9, timestamp_de_exclusao_logica);

		assertEquals(ps.executeQuery(), PSQLException.class);
	}

	@Test(expected = PSQLException.class)
	public void testInsertAprov() throws SQLException, FileNotFoundException {

		String user_data = "INSERT INTO aprovacao_de_divulgacao" + " (id, divulgacao_aprovada,"
				+ " parecer_sobre_divulgacao, data_aprovacao_ou_rejeicao)" + " values" + "(?,?,?,?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setInt(1, id_aprovacao);
		ps.setBoolean(2, aprovada);
		ps.setString(3, parecer);
		ps.setDate(4, data_aprovacao_ou_rejeicao);

		assertEquals(ps.executeQuery(), PSQLException.class);
	}

	@Test(expected = PSQLException.class)
	public void testInsertCurso() throws SQLException, FileNotFoundException {

		String user_data = "INSERT INTO curso_da_ufg" + " (nivel," + " tipo_de_resolucao, numero_da_resolucao, "
				+ "presencial, turno)" + " values" + "(CAST(? AS nivel)," + "CAST(? AS tipo_de_resolucao),?,?,"
				+ "CAST(? AS turno));";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setString(1, nivel);
		ps.setString(2, tipo_de_resolucao);
		ps.setInt(3, numero_da_resolucao);
		ps.setBoolean(4, presencial);
		ps.setString(5, turno);

		assertEquals(ps.executeQuery(), PSQLException.class);
	}

	@Test
	public void testBuscaUsuario()
			throws SQLException, FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {

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

			assertEquals(rs.getString(1), email);
			assertEquals(rs.getString(2), senha_criptografada);
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

	@Test(expected = PSQLException.class)
	public void testCpfTamanhoInvalido() throws SQLException, FileNotFoundException {

		String cpf_invalido = "000000000001";

		String user_data = "INSERT INTO usuario" + " (email_principal," + "senha, nome_social,"
				+ " cpf,foto_pessoal, recebe_divulgacao,"
				+ "timestamp_de_cadastramento,timestamp_de_ultima_atualizacao," + "timestamp_de_exclusao_logica)"
				+ " values" + "(?,md5(?),?,?,?,CAST(? AS recebe_divulgacao),?,?,?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setString(1, email + "3");
		ps.setString(2, senha);
		ps.setString(3, nome);
		ps.setString(4, cpf_invalido);
		ps.setBinaryStream(5, null, 0);
		ps.setString(6, recebe_divulgacao); // CAST AS recebe_divulgacao type in
											// SQL
		ps.setDate(7, timestamp_de_cadastramento);
		ps.setDate(8, timestamp_de_ultima_atualizacao);
		ps.setDate(9, timestamp_de_exclusao_logica);

		assertEquals(ps.executeQuery(), PSQLException.class);
	}
}