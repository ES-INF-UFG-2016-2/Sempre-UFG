package br.ufg.inf.sempreufg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.sempreufg.enums.MedidasTempo;
import br.ufg.inf.sempreufg.modelo.ParametrosBackupBanco;

public class BackupBancoDao {

	private Connection con;

	public BackupBancoDao(Connection con) {
		super();
		this.con = con;
	}

	public void salvarParametrosBackupBanco(ParametrosBackupBanco parametros) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into parametros_backup_banco (diretorio_backup, diretorio_padrao_execucao_backup, tempo, unidade) ");
		sql.append("values(?, ?, ?, ?)");

		PreparedStatement preparedStatement;
		try {
			preparedStatement 	= getCon().prepareStatement(sql.toString());
			preparedStatement.setString(1, parametros.getDiretorioBackup());
			preparedStatement.setString(2, parametros.getDiretorioPadraoExecucaoBackup());
			preparedStatement.setInt(3, parametros.getTempo());
			preparedStatement.setString(4, parametros.getUnidade().toString());
			preparedStatement.execute();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerParametros(){
		StringBuilder sql = new StringBuilder();
		sql.append("delete from parametros_backup_banco");

		PreparedStatement preparedStatement;
		try {
			preparedStatement 	= getCon().prepareStatement(sql.toString());
			preparedStatement.execute();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ParametrosBackupBanco> consultarParametrosBackupBanco() {
		List<ParametrosBackupBanco> parametros = new ArrayList<ParametrosBackupBanco>();

		StringBuilder sql = new StringBuilder();
		sql.append("select diretorio_backup, 				 ")
		   .append("       diretorio_padrao_execucao_backup, ")
		   .append("       tempo, 							 ")
		   .append("       unidade 							 ")
		   .append("  from parametros_backup_banco			 ");

		PreparedStatement preparedStatement;
		try {
			preparedStatement 	= getCon().prepareStatement(sql.toString());
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ParametrosBackupBanco parametro = new ParametrosBackupBanco();
				parametro.setDiretorioBackup(resultSet.getString("diretorio_backup"));
				parametro.setDiretorioPadraoExecucaoBackup(resultSet.getString("diretorio_padrao_execucao_backup"));
				parametro.setTempo(resultSet.getInt("tempo"));
				parametro.setUnidade(MedidasTempo.valueOf(resultSet.getString("unidade")));

				parametros.add(parametro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return parametros;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
