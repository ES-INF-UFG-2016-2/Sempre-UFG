package br.ufg.inf.db.auxiliar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufg.inf.excecoes.DadosBDInvalidosException;

public class AuxiliaInsercao {
	
	public boolean insereEgresso(Connection connection, String sql, String nome, String nome_mae,
			 String data_nascimento, byte[] foto_principal, byte[] foto_adicional, String visibilidade,
			 String sexo){
		
		try {
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date dateformat = format.parse(data_nascimento);

			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setString(2, nome_mae);
			stmt.setDate(3, (java.sql.Date) dateformat);
			stmt.setBytes(4, foto_principal);
			stmt.setBytes(5, foto_adicional);
			stmt.setString(6, visibilidade);
			stmt.setString(7, sexo);
			
			stmt.execute();
			stmt.close();
			
			return true;
			
		} catch (SQLException e) {
			throw new DadosBDInvalidosException("Estrutura SQL errada");
		} catch (ParseException e) {
			throw new DadosBDInvalidosException("Erro transformacao: String para Date");
		}
		
	}
}
