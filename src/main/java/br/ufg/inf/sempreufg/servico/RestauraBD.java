package br.ufg.inf.sempreufg.servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.excecoes.ErroExecutarSQLException;
import br.ufg.inf.sempreufg.excecoes.TempoExpiradoException;
import br.ufg.inf.sempreufg.excecoes.TipoDBInvalidoException;

public class RestauraBD {

	Connection connection;

	public void restaurar(String database, String caminho, String username, int tipo) {

		switch (tipo) {
		case 1:
			BancoMariaDB(database, caminho, username);
			break;

		case 2:
			BancoPostegreSQL(database, caminho, username);

		default:
			throw new TipoDBInvalidoException("Banco de dados escolhido: Inexistente");
		}
	}

	public void restaurar(String database, String caminho, int tipo) {

		switch (tipo) {
		case 1:
			BancoMariaDB(database, caminho, "root");
			break;

		case 2:
			BancoPostegreSQL(database, caminho, "root");

		default:
			throw new TipoDBInvalidoException("Banco de dados escolhido: Inexistente");
		}
	}

	private void BancoMariaDB(String database, String caminho, String username) {

		connection = ConexaoBanco.getConnection(username);

		String sql = "mysql -u " + username + " -p " + database + " < " + caminho;
		executeRestoreDB(sql);

	}

	private void BancoPostegreSQL(String database, String caminho, String username) {

		connection = ConexaoBanco.getConnection(username);

		String sql = "psql -U " + username + " -d " + database + " -f " + caminho;
		executeRestoreDB(sql);
	}

	private void executeRestoreDB(String sql) {

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.executeQuery();
			stmt.close();

		} catch (SQLTimeoutException e) {
			throw new TempoExpiradoException("Tempo de execução SQL expirada");
		} catch (SQLException e) {
			throw new ErroExecutarSQLException("Erro na execução do comando SQL");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new ErroExecutarSQLException("Fechamento de conexão: Falha");
			}
		}
	}
}
