package br.ufg.inf.sempreufg.db.auxiliar;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import br.ufg.inf.sempreufg.enums.*;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;

public class AuxiliaInsercao {

	public boolean insereEgresso(Connection connection, String sql, Egresso egresso) {

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, egresso.getNome());
			stmt.setString(2, egresso.getNome_mae());
			stmt.setDate(3, (java.sql.Date) egresso.getData_nascimento());
			stmt.setBlob(4, (Blob) egresso.getFoto_principal());
			stmt.setBlob(5, (Blob) egresso.getFotos_adicionais());
			stmt.setString(6, egresso.getVisibilidade().toString());
			stmt.setString(7, egresso.getSexo().toString());

			stmt.execute();
			stmt.close();

			return true;

		} catch (SQLException e) {
			return false;
		}

	}

	public boolean insereEnsinoMedio(Connection connection, String sql, int id, String nome, TipoInstituicao instituicao) {

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			stmt.setString(2, nome);
			stmt.setString(3, instituicao.toString());

			stmt.execute();
			stmt.close();

			return true;

		} catch (SQLException e) {
			return false;
		}
	}

	public boolean insereLocalizacaoGeografica(Connection connection, String sql, LocalizacaoGeografica localizacao) {

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, localizacao.getNomeDaCidade());
			stmt.setString(2, localizacao.getNomeDaUnidadeFederativa());
			stmt.setString(3, localizacao.getNomeDoPais());
			stmt.setString(4, localizacao.getSiglaDaUnidadeFederativa());
			stmt.setFloat(5, localizacao.getLatitude());
			stmt.setFloat(6, localizacao.getLongitude());

			stmt.execute();
			stmt.close();

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean insereHistoricoEnsinoMedio(Connection connection, String sql, int idegresso, int idensinomedio, int mesInicio, int mesFim,
			int anoInicio, int anoFim) {

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, idegresso);
			stmt.setInt(2, idensinomedio);
			stmt.setInt(3, mesInicio);
			stmt.setInt(4, anoInicio);
			stmt.setInt(5, mesFim);
			stmt.setInt(6, anoFim);

			stmt.execute();
			stmt.close();

			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
