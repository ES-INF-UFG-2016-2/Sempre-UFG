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

public class EnsMedioEgresTest {

	private Connection connection;
	private AuxiliaInsercao auxiliar;
	private Egresso egresso;

	@Before
	public void PreparaTeste() {

		connection = ConexaoBanco.getConnection();
		auxiliar = new AuxiliaInsercao();
		egresso = new Egresso();
	}

	@After
	public void finalizaTeste() {

		try {
			connection.close();
		} catch (SQLException e) {
			throw new ErroConexaoException("Fechamento de conexão: erro");
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
			throw new DadosBDInvalidosException("Parse de data não permitido");
		}

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
}
