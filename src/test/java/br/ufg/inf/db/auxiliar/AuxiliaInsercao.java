package br.ufg.inf.db.auxiliar;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufg.inf.enums.TipoInstituicao;
import br.ufg.inf.modelo.Egresso;

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

	public boolean insereEnsinoMedio(Connection connection, String sql, String nome, TipoInstituicao instituicao) {

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setString(2, instituicao.toString());

			stmt.execute();
			stmt.close();

			return true;

		} catch (SQLException e) {
			return false;
		}
	}
}