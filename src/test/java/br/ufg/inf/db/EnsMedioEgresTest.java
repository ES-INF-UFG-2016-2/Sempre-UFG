package br.ufg.inf.db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.db.auxiliar.AuxiliaInsercao;
import br.ufg.inf.enums.Sexo;
import br.ufg.inf.enums.VisibilidadeDados;
import br.ufg.inf.excecoes.ErroConexaoException;

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
			throw new ErroConexaoException("Fechamento de conexão: erro");
		}
	}

	@Test
	public void InserirDadosIdeiais() {

		String sql = "insert into egresso"
				+ " (nome, nome_mae, data_nascimento, foto_principal, foto_adicionais, visibilidade, sexo, id_localizacao)"
				+ " values (?,?,?,?,?,?,?,?)";

		boolean inseriu = auxiliar.insereEgresso(connection, sql, "Fulano", "Ciclana", "12/05/1972", null, null,
				VisibilidadeDados.PUBLICO.toString(), Sexo.MASCULINO.toString());

		assertTrue("Inserido com sucesso", inseriu);
	}

}
