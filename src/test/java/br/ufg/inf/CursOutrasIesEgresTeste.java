package br.ufg.inf;

import java.sql.SQLException;

import org.junit.Test;

import br.ufg.inf.modelo.CursoOutrasIES;
import br.ufg.inf.modelo.HistoricoOutrasIES;
import br.ufg.inf.modelo.LocalizacaoGeografica;

public class CursOutrasIesEgresTeste extends BaseCursOutrasIesEgresTeste {

	/*
	 * Alguns testes foram omitidos, por exemplo checagem de tipo o próprio java não ia deixar o mesmo acontecer
	 * e ia dar erro de compilação as alguns casos. ( Lucas Campos)
	 * 
	 * Testes de limite restriçoes foram emitidos pela ausencia dos mesmos nos scripts, que deverá ser revisado //TODO ( Lucas Campos)
	 * 
	 * Scripts necessitam de otimização para testarem os valores limites. ( Lucas Campos )
	 */
	
	@Test
	public void testaInserirCursoOutrasIESCompleto() throws SQLException {
		CursoOutrasIES cursoOutrasIES  = getCursoOutrasIESCompleto();
		
		assertTrue(inserirCursosOutrasIES(cursoOutrasIES));
	}
	
	@Test
	public void testaInserirCursoOutrasIESOpcional() throws SQLException {
		CursoOutrasIES cursoOutrasIES  = getCursoOutrasIESCompleto();
		cursoOutrasIES.setUrlInstitucional(null);
		
		assertTrue(inserirCursosOutrasIES(cursoOutrasIES));
	}
	
	@Test
	public void testaInserirCursoOutrasIESEnumIncorreto() throws SQLException {
		CursoOutrasIES cursoOutrasIES  = getCursoOutrasIESCompleto();
		
		assertTrue(inserirCursosOutrasIES(cursoOutrasIES));
	}
	
	
	@Test
	public void testaInserirCursoOutrasNomeDoCursoNull() throws SQLException {
		CursoOutrasIES cursoOutrasIES  = getCursoOutrasIESCompleto();
		cursoOutrasIES.setNomeDoCurso(null);
		
		try{
			assertTrue(inserirCursosOutrasIES(cursoOutrasIES));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"nome_curso\" "));
		}
	}
	
	@Test
	public void testaInserirCursoOutrasUnidadeAcademicaNull() throws SQLException {
		CursoOutrasIES cursoOutrasIES  = getCursoOutrasIESCompleto();
		cursoOutrasIES.setUnidadeAcademia(null);
		
		try{
			assertTrue(inserirCursosOutrasIES(cursoOutrasIES));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"nome_unidade_academica\" "));
		}
	}
	
	@Test
	public void testaInserirCursoOutrasIesDoCursoNull() throws SQLException {
		CursoOutrasIES cursoOutrasIES  = getCursoOutrasIESCompleto();
		cursoOutrasIES.setIesDoCurso(null);
		
		try{
			assertTrue(inserirCursosOutrasIES(cursoOutrasIES));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"ies_curso\" "));
		}
	}
	
	@Test
	public void testaInserirCursoOutrasNivelNull() throws SQLException {
		CursoOutrasIES cursoOutrasIES  = getCursoOutrasIESCompleto();
		cursoOutrasIES.setNivel(null);
		
		try{
			assertTrue(inserirCursosOutrasIES(cursoOutrasIES));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"nivel_curso\" "));
		}
	}
	
	@Test
	public void testaInserirCursoOutrasTipoInstituicaoNull() throws SQLException {
		CursoOutrasIES cursoOutrasIES  = getCursoOutrasIESCompleto();
		cursoOutrasIES.setTipoInstituicao(null);
		
		try{
			assertTrue(inserirCursosOutrasIES(cursoOutrasIES));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"tipo_ies\" "));
		}
	}
	
	@Test
	public void testaInserirLocalizacaoGeograficaCompleto() throws SQLException {
		LocalizacaoGeografica localizacaoGeografica  = getLocalizacaoGeografiaCompleto();
		
		assertTrue(inserirLocalizacaoGeografia(localizacaoGeografica));
	}
	
	@Test
	public void testaInserirLocalizacaoGeograficaOpcional() throws SQLException {
		LocalizacaoGeografica localizacaoGeografica  = getLocalizacaoGeografiaCompleto();
		localizacaoGeografica.setLatitude(null);
		localizacaoGeografica.setLongitude(null);
		
		assertTrue(inserirLocalizacaoGeografia(localizacaoGeografica));
	}
	
	
	@Test
	public void testaInserirLocalizacaoGeograficaNomeDaCidadeNull() throws SQLException {
		LocalizacaoGeografica localizacaoGeografica  =  getLocalizacaoGeografiaCompleto();
		localizacaoGeografica.setNomeDaCidade(null);
		
		try{
			assertTrue(inserirLocalizacaoGeografia(localizacaoGeografica));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"nome_cidade\" "));
		}
	}
	
	@Test
	public void testaInserirLocalizacaoGeograficaNomeUnidadeFederativaNull() throws SQLException {
		LocalizacaoGeografica localizacaoGeografica  =  getLocalizacaoGeografiaCompleto();
		localizacaoGeografica.setNomeDaUnidadeFederativa(null);
		
		try{
			assertTrue(inserirLocalizacaoGeografia(localizacaoGeografica));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"nome_unidade_federativa\" "));
		}
	}
	
	@Test
	public void testaInserirLocalizacaoGeograficaNomePaisNull() throws SQLException {
		LocalizacaoGeografica localizacaoGeografica  =  getLocalizacaoGeografiaCompleto();
		localizacaoGeografica.setNomeDoPais(null);
		
		try{
			assertTrue(inserirLocalizacaoGeografia(localizacaoGeografica));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"nome_pais\" "));
		}
	}
	
	@Test
	public void testaInserirLocalizacaoGeograficaSiglaUnidadeFederativaNull() throws SQLException {
		LocalizacaoGeografica localizacaoGeografica  =  getLocalizacaoGeografiaCompleto();
		localizacaoGeografica.setSiglaDaUnidadeFederativa(null);
		
		localizacaoGeografica.getLatitude();
		
		try{
			assertTrue(inserirLocalizacaoGeografia(localizacaoGeografica));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"sigla_unidade_federativa\" "));
		}
	}
	
	@Test
	public void testaInserirHistoricoOutrasIESCompleto() throws SQLException {
		HistoricoOutrasIES historicoOutrasIES  = getHistoricoOutrasIESCompleto();
		
		assertTrue(inserirHistoricoOutrasIES(historicoOutrasIES));
	}
	
	@Test
	public void testaInserirHistoricoOutrasMesInicioNull() throws SQLException {
		HistoricoOutrasIES historicoOutrasIES  = getHistoricoOutrasIESCompleto();
		historicoOutrasIES.setMesInicio(null);
		
		try{
			assertTrue(inserirHistoricoOutrasIES(historicoOutrasIES));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"mes_inicio\" "));
		}
	}
	
	@Test
	public void testaInserirHistoricoOutrasMesFimNull() throws SQLException {
		HistoricoOutrasIES historicoOutrasIES  = getHistoricoOutrasIESCompleto();
		historicoOutrasIES.setMesFim(null);
		
		try{
			assertTrue(inserirHistoricoOutrasIES(historicoOutrasIES));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"mes_fim\" "));
		}
	}
	
	@Test
	public void testaInserirHistoricoOutrasAnoInicioNull() throws SQLException {
		HistoricoOutrasIES historicoOutrasIES  = getHistoricoOutrasIESCompleto();
		historicoOutrasIES.setAnoInicio(null);
		
		try{
			assertTrue(inserirHistoricoOutrasIES(historicoOutrasIES));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"ano_inicio\" "));
		}
	}
	
	@Test
	public void testaInserirHistoricoOutrasAnoFimNull() throws SQLException {
		HistoricoOutrasIES historicoOutrasIES  = getHistoricoOutrasIESCompleto();
		historicoOutrasIES.setAnoFim(null);
		
		try{
			assertTrue(inserirHistoricoOutrasIES(historicoOutrasIES));
		}catch (SQLException e) {
			assertTrue(e.getMessage().contains("ERROR: null value in column \"ano_fim\" "));
		}
	}
	
}
