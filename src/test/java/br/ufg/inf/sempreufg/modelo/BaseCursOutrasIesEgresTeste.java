package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.enums.Nivel;
import br.ufg.inf.sempreufg.enums.TipoInstituicao;
import junit.framework.TestCase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseCursOutrasIesEgresTeste extends TestCase {

	public boolean testaNomesValidos(String nome) throws Exception {
		if (nome.isEmpty()) {
			throw new Exception("O nome não pode ser vazio.");
		} else {
			Pattern pattern = Pattern.compile("[0-9]");
			Matcher matcher = pattern.matcher(nome);
			if (matcher.find()) {
				throw new Exception("O nome não pode conter números.");
			}
		}
		return true;
	}

	public boolean inserirCursosOutrasIES(CursoOutrasIES cursoOutrasIES) throws SQLException {
		Statement stmt = null;

		stmt = ConexaoBanco.getConnection().createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into curso_outras_ies_egres(nome_curso,nivel_curso,");
		sql.append("nome_unidade_academica,ies_curso,tipo_ies, url_institucional) values (?,?::nivel,?,?,?::tipo_instituicao,?) ");

		PreparedStatement preparedStatement = ConexaoBanco.getConnection().prepareStatement(sql.toString());
		preparedStatement.setString(1, cursoOutrasIES.getNomeDoCurso()); //nome curso
		preparedStatement.setString(2, cursoOutrasIES.getNivel() != null? cursoOutrasIES.getNivel().name() : null); // nivel
		preparedStatement.setString(3, cursoOutrasIES.getUnidadeAcademia()); // nome unidade academica
		preparedStatement.setString(4, cursoOutrasIES.getIesDoCurso()); // ies curso
		preparedStatement.setString(5, cursoOutrasIES.getTipoInstituicao() != null? cursoOutrasIES.getTipoInstituicao().name() : null); // tipo ies
		preparedStatement.setString(6, cursoOutrasIES.getUrlInstitucional()); // url institucional

		preparedStatement.executeUpdate();

		return true;
	}

	public boolean inserirLocalizacaoGeografia(LocalizacaoGeografica localizacaoGeografica) throws SQLException {
		Statement stmt = null;

		stmt = ConexaoBanco.getConnection().createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into localizacao_geografica(nome_cidade,nome_unidade_federativa,");
		sql.append("nome_pais,sigla_unidade_federativa,latitude, longitude) values (?,?,?,?,?,?) ");

		PreparedStatement preparedStatement = ConexaoBanco.getConnection().prepareStatement(sql.toString());
		preparedStatement.setString(1, localizacaoGeografica.getNomeDaCidade()); //nome cidade
		preparedStatement.setString(2, localizacaoGeografica.getNomeDaUnidadeFederativa()); // nome unidade federativa
		preparedStatement.setString(3, localizacaoGeografica.getNomeDoPais()); // nome pais
		preparedStatement.setString(4, localizacaoGeografica.getSiglaDaUnidadeFederativa()); // sigla unidade

		if( localizacaoGeografica.getLatitude() == null){
			preparedStatement.setNull(5, Types.FLOAT); //latitude
		}else{
			preparedStatement.setFloat(5, localizacaoGeografica.getLatitude()); //latitude
		}

		if( localizacaoGeografica.getLongitude() == null){
			preparedStatement.setNull(6, Types.FLOAT); //latitude
		}else{
			preparedStatement.setFloat(6, localizacaoGeografica.getLongitude()); // longitude
		}

		preparedStatement.executeUpdate();

		return true;
	}



	public boolean inserirHistoricoOutrasIES(HistoricoOutrasIES historicoOutrasIES) throws SQLException {
		Statement stmt = null;

		stmt = ConexaoBanco.getConnection().createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into historico_outras_ies(ano_inicio,ano_fim,mes_inicio,mes_fim)");
		sql.append(" values (?,?,?,?) ");

		PreparedStatement preparedStatement = ConexaoBanco.getConnection().prepareStatement(sql.toString());

		//ano inicio
		if( historicoOutrasIES.getAnoInicio() == null){
			preparedStatement.setNull(1, Types.FLOAT);
		}else{
			preparedStatement.setInt(1, historicoOutrasIES.getAnoInicio());
		}

		//ano fim
		if( historicoOutrasIES.getAnoFim() == null){
			preparedStatement.setNull(2, Types.FLOAT);
		}else{
			preparedStatement.setInt(2, historicoOutrasIES.getAnoFim());
		}

		//mes inicio
		if( historicoOutrasIES.getMesInicio() == null){
			preparedStatement.setNull(3, Types.FLOAT);
		}else{
			preparedStatement.setInt(3, historicoOutrasIES.getMesInicio());
		}

		//mes fim
		if( historicoOutrasIES.getMesFim() == null){
			preparedStatement.setNull(4, Types.FLOAT);
		}else{
			preparedStatement.setInt(4, historicoOutrasIES.getMesFim());
		}

		preparedStatement.executeUpdate();

		return true;
	}

	public CursoOutrasIES getCursoOutrasIESCompleto(){
		CursoOutrasIES cursoOutrasIES = new CursoOutrasIES();
		cursoOutrasIES.setNomeDoCurso("Engenharia de Software");
		cursoOutrasIES.setUnidadeAcademia("Samambaia");
		cursoOutrasIES.setIesDoCurso("UFG");
		cursoOutrasIES.setUrlInstitucional("www.ufg.org");
		cursoOutrasIES.setNivel(Nivel.Bacharelado);
		cursoOutrasIES.setTipoInstituicao(TipoInstituicao.Federal);

		return cursoOutrasIES;
	}

	public LocalizacaoGeografica getLocalizacaoGeografiaCompleto(){
		LocalizacaoGeografica localizacaoGeografica = new LocalizacaoGeografica();
		localizacaoGeografica.setNomeDaCidade("Goiânia");
		localizacaoGeografica.setNomeDaUnidadeFederativa("Universidade Federal De Goias");
		localizacaoGeografica.setNomeDoPais("Brasil");
		localizacaoGeografica.setSiglaDaUnidadeFederativa("UFG");
		localizacaoGeografica.setLatitude(1283f);
		localizacaoGeografica.setLongitude(8923f);

		return localizacaoGeografica;
	}

	public HistoricoOutrasIES getHistoricoOutrasIESCompleto(){
		HistoricoOutrasIES historicoOutrasIES = new HistoricoOutrasIES();

		historicoOutrasIES.setAnoInicio(2000);
		historicoOutrasIES.setAnoFim(2010);
		historicoOutrasIES.setMesInicio(3);
		historicoOutrasIES.setMesFim(10);

		return historicoOutrasIES;

	}

}
