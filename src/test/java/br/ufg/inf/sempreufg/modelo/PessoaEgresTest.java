package br.ufg.inf.sempreufg.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;

public class PessoaEgresTest {

	Connection con;
	String sql;

	@Before
	public void setUp() {

		try {

			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SempreUFG", "postgres", "admin");

		} catch (SQLException e) {

			System.out.println("Conexão com o banco PostgreSQL não criada!");
		}
	}

	@Test
	public void testInserirLocalizacaoGeograficaComCamposOpcionais() {

		String cidade = "Catalão";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";
		float latitude = 321343004;
		float longitude = 03520220043;

		boolean inseriu = inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, latitude, longitude);
		assertTrue(inseriu);
	}

	@Test
	public void testInserirLocalizacaoGeograficaSemCamposOpcionais() {

		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		boolean inseriu = inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);
		assertTrue(inseriu);
	}

	@Test
	public void testInserirLocalizacaoGeograficaSemCidade() {

		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		boolean inseriu = inserirLocalizacaoGeografica(null, unidade_federativa, pais, sigla, 0, 0);
		assertFalse(inseriu);
	}

	@Test
	public void testInserirLocalizacaoGeograficaSemUnidadeFederativa() {

		String cidade = "Jataí";
		String pais = "Brasil";
		String sigla = "GO";

		boolean inseriu = inserirLocalizacaoGeografica(cidade, null, pais, sigla, 0, 0);
		assertFalse(inseriu);
	}

	@Test
	public void testInserirLocalizacaoGeograficaSemPais() {

		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String sigla = "GO";

		boolean inseriu = inserirLocalizacaoGeografica(cidade, unidade_federativa, null, sigla, 0, 0);
		assertFalse(inseriu);
	}

	@Test
	public void testInserirLocalizacaoGeograficaSemSigla() {

		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";

		boolean inseriu = inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, null, 0, 0);
		assertFalse(inseriu);
	}

	@Test
	public void testInserirLocalizacaoGeograficaComTodosOsCamposNulos() {

		boolean inseriu = inserirLocalizacaoGeografica(null, null, null, null, 0, 0);
		assertFalse(inseriu);
	}

	@Test
	// testar string cidade com mais de 150 caracteres
	public void testInserirLocalizacaoGeograficaComCidadeOverflow() {

		String cidade = "ASDFGHJKLÇASDFGHJKLÇDGFSDFASDFASFHADFHASFHAFSGSDFASDFASHDFHGDJDGJDGSJSFGDHAFGADSFFGASDFGDFHGDJGSJSDGFAGADSGASDFGFADHGDJDGSAGASDGAFSGHJHGASDGASGASGSGSAGSAGASDGSDAGSGSDGASSDGGSGSGSAG";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		boolean inseriu = inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);
		assertFalse(inseriu);
	}

	@Test
	// testar string unidade_federativa com mais de 150 caracteres
	public void testInserirLocalizacaoGeograficaComUnidadeFederativaOverflow() {

		String cidade = "Goiania";
		String unidade_federativa = "ASDFGHJKLÇASDFGHJKLÇDGFSDFASDFASFHADFHASFHAFSGSDFASDFASHDFHGDJDGJDGSJSFGDHAFGADSFFGASDFGDFHGDJGSJSDGFAGADSGASDFGFADHGDJDGSAGASDGAFSGHJHGASDGASGASGSGSAGSAGASDGSDAGSGSDGASSDGGSGSGSAG";
		String pais = "Brasil";
		String sigla = "GO";

		boolean inseriu = inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);
		assertFalse(inseriu);
	}

	@Test
	// testar string país com mais de 150 caracteres
	public void testInserirLocalizacaoGeograficaComPaisOverflow() {

		String cidade = "Goiania";
		String unidade_federativa = "Goias";
		String pais = "ASDFGHJKLÇASDFGHJKLÇDGFSDFASDFASFHADFHASFHAFSGSDFASDFASHDFHGDJDGJDGSJSFGDHAFGADSFFGASDFGDFHGDJGSJSDGFAGADSGASDFGFADHGDJDGSAGASDGAFSGHJHGASDGASGASGSGSAGSAGASDGSDAGSGSDGASSDGGSGSGSAG";
		String sigla = "GO";

		boolean inseriu = inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);
		assertFalse(inseriu);
	}

	@Test
	// testar string sigla com mais de 2 caracteres
	public void testInserirLocalizacaoGeograficaComSiglaOverflow() {

		String cidade = "Goiania";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GOIANIA";

		boolean inseriu = inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);
		assertFalse(inseriu);
	}

	@Test
	public void testInserirLocalizacaoGeograficaComIdentificadorLocalizacaoDuplicado() {

		int id = 1;
		String cidade = "Inhumas";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";
		float longitude = 03571043;

		boolean inseriu = inserirLocalizacaoGeografica(id, cidade, unidade_federativa, pais, sigla, 0, longitude);
		assertFalse(inseriu);
	}

	@Test
	public void testInserirEgresso() {

		int id_localizacao = 1;
		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		this.inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);

		String nome = "Nome teste";
		String nome_mae = "Nome Mae Teste";
		Date data_nascimento = new Date(new java.util.Date().getTime());
		byte[] foto_principal = "1".getBytes();
		byte[] foto_adicionais = "1".getBytes();
		VisibilidadeDados visibilidade = VisibilidadeDados.PUBLICO;
		Sexo sexo = Sexo.MASCULINO;

		boolean inseriu = inserirEgresso(id_localizacao, nome, nome_mae, data_nascimento, foto_principal,
				foto_adicionais, visibilidade, sexo);

		assertTrue(inseriu);
	}

	@Test
	public void testInserirEgressoSemFotoPrincipal() {

		int id_localizacao = 1;
		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		this.inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);

		String nome = "Nome teste";
		String nome_mae = "Nome Mae Teste";
		Date data_nascimento = new Date(new java.util.Date().getTime());
		byte[] foto_adicionais = "1".getBytes();
		VisibilidadeDados visibilidade = VisibilidadeDados.PRIVADO;
		Sexo sexo = Sexo.MASCULINO;

		boolean inseriu = inserirEgresso(id_localizacao, nome, nome_mae, data_nascimento, null, foto_adicionais,
				visibilidade, sexo);

		assertTrue(inseriu);
	}

	@Test
	public void testInserirEgressoSemFotoAdicional() {

		int id_localizacao = 1;
		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		this.inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);

		String nome = "Nome teste";
		String nome_mae = "Nome Mae Teste";
		Date data_nascimento = new Date(new java.util.Date().getTime());
		byte[] foto_principal = "1".getBytes();
		VisibilidadeDados visibilidade = VisibilidadeDados.PRIVADO;
		Sexo sexo = Sexo.MASCULINO;

		boolean inseriu = inserirEgresso(id_localizacao, nome, nome_mae, data_nascimento, foto_principal, null,
				visibilidade, sexo);

		assertTrue(inseriu);
	}

	@Test
	public void testInserirEgressoSemSexo() {

		int id_localizacao = 1;
		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		this.inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);

		String nome = "Nome teste";
		String nome_mae = "Nome Mae Teste";
		Date data_nascimento = new Date(new java.util.Date().getTime());
		byte[] foto_principal = "1".getBytes();
		byte[] foto_adicionais = "1".getBytes();
		VisibilidadeDados visibilidade = VisibilidadeDados.PRIVADO;

		boolean inseriu = inserirEgresso(id_localizacao, nome, nome_mae, data_nascimento, foto_principal,
				foto_adicionais, visibilidade, null);

		assertTrue(inseriu);
	}

	@Test
	public void testInserirEgressoSemNome() {

		int id_localizacao = 1;
		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		this.inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);

		String nome_mae = "Nome Mae Teste";
		Date data_nascimento = new Date(new java.util.Date().getTime());
		byte[] foto_principal = "1".getBytes();
		byte[] foto_adicionais = "1".getBytes();
		VisibilidadeDados visibilidade = VisibilidadeDados.PRIVADO;
		Sexo sexo = Sexo.MASCULINO;

		boolean inseriu = inserirEgresso(id_localizacao, null, nome_mae, data_nascimento, foto_principal,
				foto_adicionais, visibilidade, sexo);

		assertFalse(inseriu);
	}

	@Test
	public void testInserirEgressoSemNomeMae() {

		int id_localizacao = 1;
		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		this.inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);

		String nome = "Murilo";
		Date data_nascimento = new Date(new java.util.Date().getTime());
		byte[] foto_principal = "1".getBytes();
		byte[] foto_adicionais = "1".getBytes();
		VisibilidadeDados visibilidade = VisibilidadeDados.PRIVADO;
		Sexo sexo = Sexo.MASCULINO;

		boolean inseriu = inserirEgresso(id_localizacao, nome, null, data_nascimento, foto_principal, foto_adicionais,
				visibilidade, sexo);

		assertFalse(inseriu);
	}

	@Test
	public void testInserirEgressoSemDataNascimento() {

		int id_localizacao = 1;
		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		this.inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);

		String nome = "Nome Teste";
		String nome_mae = "Nome Mae Teste";
		byte[] foto_principal = "1".getBytes();
		byte[] foto_adicionais = "1".getBytes();
		VisibilidadeDados visibilidade = VisibilidadeDados.PRIVADO;
		Sexo sexo = Sexo.MASCULINO;

		boolean inseriu = inserirEgresso(id_localizacao, nome, nome_mae, null, foto_principal, foto_adicionais,
				visibilidade, sexo);

		assertFalse(inseriu);
	}

	@Test
	public void testInserirEgressoSemVisibilidade() {

		int id_localizacao = 1;
		String cidade = "Jataí";
		String unidade_federativa = "Goias";
		String pais = "Brasil";
		String sigla = "GO";

		this.inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);

		String nome = "Nome Teste";
		String nome_mae = "Nome Mae Teste";
		Date data_nascimento = new Date(new java.util.Date().getTime());
		byte[] foto_principal = "1".getBytes();
		byte[] foto_adicionais = "1".getBytes();
		Sexo sexo = Sexo.MASCULINO;

		boolean inseriu = inserirEgresso(id_localizacao, nome, nome_mae, data_nascimento, foto_principal,
				foto_adicionais, null, sexo);

		assertFalse(inseriu);
	}

	@Test
	public void testInserirResidencia() {

		int id_localizacao = 1;
		String cidade = "Jataí";
		String unidade_federativa = "GO";
		String pais = "Brasil";
		String sigla = "GO";

		this.inserirLocalizacaoGeografica(cidade, unidade_federativa, pais, sigla, 0, 0);

		String nome = "Nome teste";
		String nome_mae = "Nome Mae Teste";
		Date data_nascimento = new Date(new java.util.Date().getTime());
		byte[] foto_principal = "teste".getBytes();
		byte[] foto_adicionais = "teste".getBytes();
		VisibilidadeDados visibilidade = VisibilidadeDados.PRIVADO;
		Sexo sexo = Sexo.MASCULINO;

		this.inserirEgresso(id_localizacao, nome, nome_mae, data_nascimento, foto_principal, foto_adicionais,
				visibilidade, sexo);

		final String endereco = "Rua 10";
		final Date data_inicio = new Date(new java.util.Date().getTime());
		final Date data_fim = new Date(new java.util.Date().getTime());

		boolean inseriu = this.inserirResidencia(this.obterIdUltimoEgressoInserido(), endereco, data_inicio, data_fim,
				id_localizacao);
		assertTrue(inseriu);
	}

	private boolean inserirLocalizacaoGeografica(String cidade, String unidade_federativa, String pais, String sigla,
			float latitude, float longitude) {

		boolean resultado = true;

		sql = "INSERT INTO localizacao_geografica(nome_cidade, nome_unidade_federativa, nome_pais, sigla, latitude, longitude)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);

			stmt.setString(1, cidade);
			stmt.setString(2, unidade_federativa);
			stmt.setString(3, pais);
			stmt.setString(4, sigla);
			stmt.setFloat(5, latitude);
			stmt.setFloat(6, longitude);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			Logger.getLogger(PessoaEgresTest.class.getName()).log(Level.SEVERE, null, e);

			resultado = false;
		}

		return resultado;
	}

	private boolean inserirLocalizacaoGeografica(int id, String cidade, String unidade_federativa, String pais,
			String sigla, float latitude, float longitude) {

		boolean resultado = true;

		sql = "INSERT INTO localizacao_geografica(nome_cidade, nome_unidade_federativa, nome_pais, sigla, latitude,longitude, id)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);

			stmt.setString(1, cidade);
			stmt.setString(2, unidade_federativa);
			stmt.setString(3, pais);
			stmt.setString(4, sigla);
			stmt.setFloat(5, latitude);
			stmt.setFloat(6, longitude);
			stmt.setInt(7, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			Logger.getLogger(PessoaEgresTest.class.getName()).log(Level.SEVERE, null, e);

			resultado = false;
		}

		return resultado;
	}

	private boolean inserirEgresso(int id, String nome, String nome_mae, Date data_nascimento, byte[] foto_principal,
			byte[] foto_adicionais, VisibilidadeDados visibilidade, Sexo sexo) {

		boolean resultado = true;

		sql = "INSERT INTO egresso(nome, nome_mae, data_nascimento, foto_principal,  visibilidade, sexo)"
				+ "VALUES (?, ?, ?, ?, CAST(? AS visibilidade), CAST(? AS sexo))";

		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setString(2, nome_mae);
			stmt.setDate(3, data_nascimento);
			stmt.setBytes(4, foto_principal);
			if (visibilidade != null) {
				stmt.setString(5, visibilidade.getNome());
			} else {
				stmt.setString(5, null);
			}
			if (sexo != null) {
				stmt.setString(6, sexo.toString().toLowerCase());
			} else {
				stmt.setString(6, null);
			}
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			Logger.getLogger(PessoaEgresTest.class.getName()).log(Level.SEVERE, null, e);

			resultado = false;
		}

		return resultado;
	}

	private int obterIdUltimoEgressoInserido() {

		int resultado = 0;

		sql = "SELECT id FROM egresso ORDER BY id DESC LIMIT 1";

		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);

			final ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				resultado = rs.getInt(1);
			}

			stmt.close();

		} catch (SQLException e) {
			Logger.getLogger(PessoaEgresTest.class.getName()).log(Level.SEVERE, null, e);
		}

		return resultado;
	}

	private boolean inserirResidencia(int id_egresso, String endereco, Date data_inicio, Date data_fim,
			int localizacao_geografica_id) {

		boolean resultado = true;

		sql = "INSERT INTO residencia(data_inicio, data_fim, endereco, egresso_id, localizacao_geografica_id) VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);

			stmt.setDate(1, data_inicio);
			stmt.setDate(2, data_fim);
			stmt.setString(3, endereco);
			stmt.setInt(4, id_egresso);
			stmt.setInt(5, localizacao_geografica_id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			Logger.getLogger(PessoaEgresTest.class.getName()).log(Level.SEVERE, null, e);

			resultado = false;
		}

		return resultado;
	}
}