package br.ufg.inf.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import br.ufg.inf.dados.ManipulaDB;
import br.ufg.inf.interfaces.AprovDivulgInfoDAOInterface;

public class AprovDivulgInfoDAO implements AprovDivulgInfoDAOInterface {

	// conexao
	static Connection conn = null;

	public Connection abreConexao() {

		if (conn == null) {
			ManipulaDB db;
			try {
				db = new ManipulaDB();
				return db.criaConexao();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void testaConexao() throws IOException {

		if (conn == null) {
			ManipulaDB db = new ManipulaDB();
			conn = db.criaConexao();

		}
	}

	public void populateDb() {

		// instancia_administrativa
		String sigla_instancia = "IF";
		String nome_instancia = "Instituto de Física";
		String tipo_instancia = "UNIDADE";
		Date data_criacao = new Date(123123);
		Date data_encerra = new Date(123123);
		String email_institucional = "info@if.ufg.br";
		String url_institucional = "http://www.inf.ufg.br/";

		// usuario
		String email_principal = "email@usuario.com";
		String senha = "senha";
		String nome = "segundo usuario";
		int cpf = 1233235352;
		String recebe_divulgacao = "DIARIA";
		Date data = new Date(123123);
		Timestamp timestamp_de_cadastramento = new Timestamp(data.getTime());
		Timestamp timestamp_de_ultima_atualizacao = new Timestamp(data.getTime());
		Timestamp timestamp_de_exclusao_logica = new Timestamp(data.getTime());
		int instancia_administrativa = 1;
		String s = "Foto do usuario2";
		byte[] foto = null;
		try {
			foto = s.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getLocalizedMessage());

		}

		// evento
		String assunto = "outro assunto";
		String tipo_evento = "PALESTRA";
		String descricao = "descricao do evento";
		Timestamp data_solicitacao = new Timestamp(11111);
		String solicitante_divulgacao = "nome solicitante";
		String solicitante_email = "solicitante@email.com";
		String forma_divulgacao = "MENSAGEM";
		String escopo_divulgacao = "COMUNIDADE";
		Date data_expiracao = new Date(123123);

		// aprovacao_de_divulgacao
		boolean divulgacao_aprovada = true;
		String parecer = "parecer sobre";
		Date data_aprovacao_ou_rejeicao = new Date(data.getTime());
		int evento = 1;
		int usuario = 1;

		try {
			testaConexao();

			salvaInstancia(sigla_instancia, nome_instancia, tipo_instancia, data_criacao, data_encerra,
					email_institucional, url_institucional);
			salvaEvento(assunto, tipo_evento, descricao, data_solicitacao, solicitante_divulgacao, solicitante_email,
					forma_divulgacao, escopo_divulgacao, data_expiracao);
			salvaUsuario(email_principal, senha, nome, cpf, foto, recebe_divulgacao, timestamp_de_cadastramento,
					timestamp_de_ultima_atualizacao, timestamp_de_exclusao_logica, instancia_administrativa);
			salvaAprovacao(divulgacao_aprovada, parecer, data_aprovacao_ou_rejeicao, evento, usuario);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean salvaAprovacao(boolean divulgacao_aprovada, String parecer_sobre_divulgacao,
			Date data_aprovacao_ou_rejeicao, int evento_id, int usuario_id) {

		try {
			testaConexao();

			String user_data = "INSERT INTO aprovacao_de_divulgacao" + " (divulgacao_aprovada,"
					+ " parecer_sobre_divulgacao, data_aprovacao_ou_rejeicao, evento, usuario)" + " values"
					+ "(?,?,?,?,?);";

			PreparedStatement ps = conn.prepareStatement(user_data);
			ps.setBoolean(1, divulgacao_aprovada);
			ps.setString(2, parecer_sobre_divulgacao);
			ps.setDate(3, data_aprovacao_ou_rejeicao);
			ps.setInt(4, evento_id);
			ps.setInt(5, usuario_id);
			ps.executeQuery();

			return false;

		} catch (Exception e) {

			if (e.getMessage().toString().equals("No results were returned by the query.")) {
				return true;
			}
			
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean salvaEvento(String assunto, String tipo, String descricao, Timestamp data_solicita_divulgacao,
			String solicitante_divulgacao, String solicitante_email, String forma_divulgacao, String escopo_divulgacao,
			Date data_expiracao) {

		try {
			testaConexao();

			String query = "INSERT INTO evento" + " (assunto,"
					+ " tipo, descricao, data_solicita_divulgacao, solicitante_divulgacao, "
					+ "solicitante_email, forma_divulgacao, escopo_divulgacao, " + "data_expiracao)" + " values"
					+ "(?,CAST(? AS tipo_evento),?,?,?,?,CAST(? AS forma_divulgacao),CAST(? AS escopo_divulgacao),?);";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, assunto);
			ps.setString(2, tipo);
			ps.setString(3, descricao);
			ps.setTimestamp(4, data_solicita_divulgacao);
			ps.setString(5, solicitante_divulgacao);
			ps.setString(6, solicitante_email);
			ps.setString(7, forma_divulgacao);
			ps.setString(8, escopo_divulgacao);
			ps.setDate(9, data_expiracao);

			ps.executeQuery();

			return false;

		} catch (Exception e) {

			if (e.getMessage().toString().equals("No results were returned by the query.")) {
				return true;
			}
			e.printStackTrace();

		}

		return false;

	}

	@Override
	public boolean salvaUsuario(String email_principal, String senha, String nome, long cpf, byte[] foto,
			String recebe_divulgacao, Timestamp timestamp_de_cadastramento, Timestamp timestamp_de_ultima_atualizacao,
			Timestamp timestamp_de_exclusao_logica, int instancia_administrativa) {

		try {
			MessageDigest algorithm;
			algorithm = MessageDigest.getInstance("MD5");
			byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			String senha_criptografada = hexString.toString();

			String user_data = "INSERT INTO usuario" + " (email_principal," + "senha, nome_social,"
					+ " cpf,foto_pessoal, recebe_divulgacao,"
					+ "timestamp_de_cadastramento,timestamp_de_ultima_atualizacao,"
					+ "timestamp_de_exclusao_logica, instancia_administrativa)" + " values"
					+ "(?,?,?,?,?,CAST(? AS recebe_divulgacao),?,?,?,?) " + "";

			PreparedStatement ps = conn.prepareStatement(user_data);
			ps.setString(1, email_principal);
			ps.setString(2, senha_criptografada.toLowerCase().substring(0, 9));
			ps.setString(3, nome);
			ps.setLong(4, cpf);
			ps.setBytes(5, foto);
			ps.setString(6, recebe_divulgacao); // CAST AS recebe_divulgacao
												// type in
												// SQL
			ps.setTimestamp(7, timestamp_de_cadastramento);
			ps.setTimestamp(8, timestamp_de_ultima_atualizacao);
			ps.setTimestamp(9, timestamp_de_exclusao_logica);
			ps.setInt(10, instancia_administrativa);

			ps.executeQuery();

		} catch (Exception e) {

			try {
				if (buscaUsuario(cpf).next()) {
					return true;
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}

		return false;

	}

	@Override
	public boolean salvaInstancia(String sigla_instancia, String nome_instancia, String tipo_instancia,
			Date data_criacao, Date data_encerra, String email_institucional, String url_institucional) {

		try {

			testaConexao();

			String user_data = "INSERT INTO instancia_administrativa_ufg "
					+ "(sigla_instancia, nome, tipo, data_criacao," + "data_encerra, email_institucional,"
					+ "url_institucional)" + "values" + "(?,?,CAST(? AS tipo_instancia),?,?,?,?);";

			PreparedStatement ps = conn.prepareStatement(user_data);
			ps.setString(1, sigla_instancia);
			ps.setString(2, nome_instancia);
			ps.setString(3, tipo_instancia);
			ps.setDate(4, data_criacao);
			ps.setDate(5, data_encerra);
			ps.setString(6, email_institucional);
			ps.setString(7, url_institucional);
			ps.executeQuery();

		} catch (Exception e) {

			if (e.getMessage().toString().equals("No results were returned by the query.")) {

				return true;
			}

			e.printStackTrace();

		}

		return false;
	}

	@Override
	public boolean salvaArea_Conhecimento(String nome_area, int codigo_area, int area_conhecimento) {

		try {

			testaConexao();

			String user_data = "INSERT INTO area_de_conhecimento" + " (nome, codigo, area_conhecimento) " + " values"
					+ "(?,?,?);";

			PreparedStatement ps = conn.prepareStatement(user_data);
			ps.setString(1, nome_area);
			ps.setInt(2, codigo_area);
			ps.setInt(3, area_conhecimento);
			ps.executeQuery();

		} catch (Exception e) {

			if (e.getMessage().toString().equals("No results were returned by the query.")) {

				return true;
			}

			e.printStackTrace();
		}
		return false;

	}

	public static void truncateAprovacao() {

		try {

			testaConexao();

			String truncate = "TRUNCATE table aprovacao_de_divulgacao";
			conn.prepareStatement(truncate).executeQuery();
		} catch (Exception e) {

		}

	}

	public void truncateCurso() {

		try {

			testaConexao();

			String truncate = "TRUNCATE table curso_da_ufg RESTART IDENTITY CASCADE";
			conn.prepareStatement(truncate).executeQuery();
		} catch (Exception e) {

		}

	}

	public static void truncateUsuario() {

		try {

			testaConexao();

			String truncate = "TRUNCATE table usuario RESTART IDENTITY CASCADE";
			conn.prepareStatement(truncate).executeQuery();
		} catch (Exception e) {

		}

	}

	public static void truncateEvento() {
		try {

			testaConexao();

			String truncate = "TRUNCATE table evento RESTART IDENTITY CASCADE;";
			conn.prepareStatement(truncate).executeQuery();
		} catch (Exception e) {

		}

	}

	public void truncateInstancia() {
		try {
			testaConexao();
			String truncate = "TRUNCATE table instancia_administrativa_ufg RESTART IDENTITY CASCADE;";

			conn.prepareStatement(truncate).executeQuery();
		} catch (Exception e) {

		}
	}

	@Override
	public void truncateAll() {

		try {

			testaConexao();

			truncateEvento();
			truncateUsuario();
			truncateCurso();
			truncateAprovacao();
			truncateInstancia();

		} catch (Exception e) {

		}

	}

	@Override
	public ResultSet buscaAprovacao() {

		return null;
	}

	@Override
	public ResultSet buscaUsuario(long cpf) {

		try {
			String busca = "SELECT * FROM usuario WHERE " + "email_principal=?";
			PreparedStatement ps1;
			ps1 = conn.prepareStatement(busca);
			ps1.setString(1, "email@usuario.com");

			return ps1.executeQuery();
		} catch (Exception e) {

		}

		return null;
	}

	@Override
	public ResultSet buscaEvento(String assunto) {

		try {
			String busca = "SELECT * FROM usuario WHERE " + "email_principal=?";
			PreparedStatement ps1;
			ps1 = conn.prepareStatement(busca);
			ps1.setString(1, "email@usuario.com");

			return ps1.executeQuery();
		} catch (Exception e) {

		}

		return null;
	}

	@Override
	public ResultSet buscaArea_Conhecimento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet buscaInstancia() {
		// TODO Auto-generated method stub
		return null;
	}

}
