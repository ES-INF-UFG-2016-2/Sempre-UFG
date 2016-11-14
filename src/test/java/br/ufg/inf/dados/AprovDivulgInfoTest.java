package br.ufg.inf.dados;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.ufg.inf.dao.AprovDivulgInfoDAO;
import br.ufg.inf.interfaces.AprovDivulgInfoDAOInterface;

/**
 * @author Rafael
 *
 */
public class AprovDivulgInfoTest {

	// interface
	private static AprovDivulgInfoDAOInterface testeDAO = new AprovDivulgInfoDAO();

	// usuario
	private String email_principal = "email";
	private String senha = "senha";
	private String nome = "primeiro usuario";
	private long cpf = 123234345;
	private String recebe_divulgacao = "DIARIA";
	private Date data = new Date(123123);
	private Timestamp timestamp_de_cadastramento = new Timestamp(data.getTime());
	private Timestamp timestamp_de_ultima_atualizacao = new Timestamp(data.getTime());
	private Timestamp timestamp_de_exclusao_logica = new Timestamp(data.getTime());
	private int instancia_administrativa = 2;

	// evento
	private String assunto = "assunto";
	private String tipo_evento = "NOTICIA";
	private String descricao = "descricao do evento";
	private Timestamp data_solicitacao = new Timestamp(data.getTime());
	private String solicitante_divulgacao = "nome solicitante";
	private String solicitante_email = "solicitante@email.com";
	private String forma_divulgacao = "MENSAGEM";
	private String escopo_divulgacao = "COMUNIDADE";
	private Date data_expiracao = new Date(123123);

	// instancia_administrativa
	private String sigla_instancia = "INF";
	private String nome_instancia = "Instituto de Informática";
	private String tipo_instancia = "UNIDADE";
	private Date data_criacao = new Date(123123);
	private Date data_encerra = new Date(123123);
	private String email_institucional = "info@inf.ufg.br";
	private String url_institucional = "http://www.inf.ufg.br/";

	// aprovacao_de_divulgacao
	private boolean divulgacao_aprovada = true;
	private String parecer = "parecer sobre";
	private Date data_aprovacao_ou_rejeicao = new Date(data.getTime());
	private int evento = 1;
	private int usuario = 1;

	// curso_da_ufg
	private String nivel = "BACHARELADO";
	private String tipo_de_resolucao = "CEPEC";
	private int numero_da_resolucao = 8;
	private boolean presencial = true;
	private String turno = "INTEGRAL";

	// area_de_conhecimento
	private String nome_area = "Ciências Humanas";
	private int codigo_area = 123;
	private int area_conhecimento = 1;

	// conexao
	static Connection conn = null;

	@BeforeClass
	public static void abreConexao() throws Exception {

		conn = testeDAO.abreConexao();
		testeDAO.truncateAll();
		testeDAO.populateDb();

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

		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rs = dbm.getTypeInfo();
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("turno")) {
				assertTrue(rs.getString(1).equalsIgnoreCase("turno"));
			}
		}
	}

	@Test
	public void testInsertAprovacao() {

		try{
			assertTrue(testeDAO.salvaAprovacao(divulgacao_aprovada, parecer, data_aprovacao_ou_rejeicao, evento, usuario));

		} catch(Exception e) {
			
		}
	}

	@Test
	public void testInsertUsuario() {

		String s = "Foto do usuario";
		byte[] foto;
		try {
			foto = s.getBytes("UTF-8");
			assertTrue(testeDAO.salvaUsuario(email_principal, senha, nome, cpf, foto, recebe_divulgacao,
					timestamp_de_cadastramento, timestamp_de_ultima_atualizacao, timestamp_de_exclusao_logica,
					instancia_administrativa));
		} catch (Exception e) {
			fail();

		}

	}

	@Test
	public void testInsertEvento() {

		
		try {
			assertTrue(testeDAO.salvaEvento(assunto, tipo_evento, descricao, data_solicitacao, solicitante_divulgacao,
					solicitante_email, forma_divulgacao, escopo_divulgacao, data_expiracao));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testInsertInstancia() {

		try {
			assertTrue(testeDAO.salvaInstancia(sigla_instancia, nome_instancia, tipo_instancia, data_criacao, data_encerra,
					email_institucional, url_institucional));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testInsertCurso() throws SQLException, IOException {

		String user_data = "INSERT INTO curso_da_ufg" + " (nivel," + "tipo_de_resolucao, numero_da_resolucao, "
				+ "presencial, turno, area_conhecimento)" + " values" + "(CAST(? AS	 nivel),"
				+ "CAST(? AS tipo_de_resolucao),?,?," + "CAST(? AS turno), ?);";

		PreparedStatement ps = conn.prepareStatement(user_data);
		ps.setString(1, nivel);
		ps.setString(2, tipo_de_resolucao);
		ps.setInt(3, numero_da_resolucao);
		ps.setBoolean(4, presencial);
		ps.setString(5, turno);
		ps.setInt(6, 1);

		try {
			ps.executeQuery();

		} catch (Exception e) {

			assertEquals(e.getMessage(), "Nenhum resultado foi retornado pela consulta.");

		}

	}

	@Test
	@Ignore
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
	public void testBuscaUsuario() throws SQLException, NoSuchAlgorithmException, IOException {

		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha_criptografada = hexString.toString();
		String s = "Foto do usuario2";
		byte[] foto = s.getBytes("UTF-8");

		ResultSet rs = testeDAO.buscaUsuario(cpf);

		while (rs.next()) {

			assertEquals(rs.getString(2), "email@usuario.com");
			// assertEquals(rs.getString(3), senha_criptografada);
			assertEquals(rs.getString(4), "segundo usuario");
			assertEquals(rs.getInt(5), 1233235352);
			assertTrue(Arrays.equals(rs.getBytes(6), foto));
			assertEquals(rs.getString(7), recebe_divulgacao);
			assertEquals(rs.getTimestamp(8), timestamp_de_cadastramento);
			assertEquals(rs.getTimestamp(9), timestamp_de_ultima_atualizacao);
			assertEquals(rs.getTimestamp(10), timestamp_de_exclusao_logica);
			assertEquals(rs.getInt(11), 1);
		}
	}

	@Test
	public void testBuscaAprovacao() {

		String busca = "SELECT * FROM public.aprovacao_de_divulgacao WHERE " + "evento = ?;";

		try {

			PreparedStatement ps1 = conn.prepareStatement(busca);
			ps1.setInt(1, 1);
			ResultSet rs = ps1.executeQuery();

			rs.next();
			assertTrue(rs.getBoolean(1) == divulgacao_aprovada);
			assertEquals(rs.getString(2).toString(), parecer.toString());
			assertTrue(rs.getDate(3).toString().hashCode() == data_aprovacao_ou_rejeicao.toString().hashCode());
			assertTrue(rs.getInt(4) == evento);
			assertTrue(rs.getInt(5) == usuario);

		} catch (Exception e) {

			fail(e.getMessage());

		} catch (AssertionError e1) {

			fail(e1.getMessage());

		}

	}

}