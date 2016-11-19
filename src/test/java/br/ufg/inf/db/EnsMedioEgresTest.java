package br.ufg.inf.db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.db.auxiliar.AuxiliaInsercao;
import br.ufg.inf.enums.Sexo;
import br.ufg.inf.enums.TipoInstituicao;
import br.ufg.inf.enums.VisibilidadeDados;
import br.ufg.inf.excecoes.DadosBDInvalidosException;
import br.ufg.inf.excecoes.ErroConexaoException;
import br.ufg.inf.modelo.Egresso;
import br.ufg.inf.modelo.LocalizacaoGeografica;

public class EnsMedioEgresTest {

	private Connection connection;
	private AuxiliaInsercao auxiliar;

	@Before
	public void PreparaTeste() {

		connection = ConexaoBanco.getConnection();
		auxiliar = new AuxiliaInsercao();
	}

	@After
	public void finalizaTeste() {

		try {
			connection.close();
		} catch (SQLException e) {
			throw new ErroConexaoException("Fechamento de conex�o: erro");
		}
	}

	@Test
	public void testeInserirDadosIdeiaisEgresso() {

		Date dateformat;
		String sql = "insert into egresso"
				+ " (nome, nome_mae, data_nascimento, foto_principal, foto_adicionais, visibilidade, sexo, id_localizacao)"
				+ " values (?,?,?,?,?,?,?,?)";

		try {
			String data_nascimento = "12/05/1972";
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			dateformat = format.parse(data_nascimento);
		} catch (ParseException e) {
			throw new DadosBDInvalidosException("Parse de data n�o permitido");
		}

		Egresso egresso = new Egresso();

		egresso.setNome("Jose da Silva");
		egresso.setNome_mae("Maria Aparecida da Silva");
		egresso.setData_nascimento(dateformat);
		egresso.setFoto_principal(null);
		egresso.setFotos_adicionais(null);
		egresso.setFotos_adicionais(null);
		egresso.setVisibilidade(VisibilidadeDados.PUBLICO);
		egresso.setSexo(Sexo.MASCULINO);

		boolean inseriu = auxiliar.insereEgresso(connection, sql, egresso);

		assertTrue("Egresso inserido com sucesso", inseriu);
	}

	@Test
	public void testeInserirDadosIdeaisEnsinoMedio() {

		String sql = "insert into ensmedioegres" + " (nome_iem, tipo_iem)" + " values (?,?)";

		boolean inseriu = auxiliar.insereEnsinoMedio(connection, sql, "Colegio Omega", TipoInstituicao.Particular);

		assertTrue("Dados Ensino Medio Inserido com sucesso", inseriu);
	}

	@Test
	public void testeInserirDadosIdeaisLocalizacaoGeografica() {

		String sql = "insert into localizgeograf"
				+ "(cidade, unid_federativa, pais, sigla_unid_federativa, latitude, longitude)"
				+ "values (?,?,?,?,?,?)";

		LocalizacaoGeografica localizacao = new LocalizacaoGeografica();

		localizacao.setNomeDaCidade("Goiania");
		localizacao.setNomeDaUnidadeFederativa("Goias");
		localizacao.setNomeDoPais("Brasil");
		localizacao.setSiglaDaUnidadeFederativa("GO");
		localizacao.setLatitude((float) -16.6868910);
		localizacao.setLongitude((float) -49.2647940);

		boolean inseriu = auxiliar.insereLocalizacaoGeografica(connection, sql, localizacao);

		assertTrue("Dados de Localiza��o Geografica Inserido com sucesso", inseriu);
	}
	
	@Test
	public void testeInserirDadosHistoricoEnsinoMedio(){
		
		String sql = "insert into histensmedio"
				+ "(mes_inicio, ano_inicio, mes_fim, ano_fim)"
				+ "values (?,?,?,?)";
		
		boolean inseriu = auxiliar.insereHistoricoEnsinoMedio(connection, sql, 03, 10, 04, 13);
		
		assertTrue("Dados de historico do ensino medio inserido com sucesso", inseriu);
	}
}
