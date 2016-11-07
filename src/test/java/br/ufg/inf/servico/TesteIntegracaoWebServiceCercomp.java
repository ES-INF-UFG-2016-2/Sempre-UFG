package br.ufg.inf.servico;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.dao.CursoUFGDAO;
import br.ufg.inf.dao.EgressoDao;
import br.ufg.inf.dao.InstituicaoEnsinoDao;
import br.ufg.inf.modelo.CursoUFG;
import br.ufg.inf.modelo.Egresso;
import br.ufg.inf.modelo.InstituicaoEnsino;
import br.ufg.inf.stubs.WebServiceCercompMock;

public class TesteIntegracaoWebServiceCercomp {
	private EgressoService egressoService;

	
	@Before
	public void init(){
		setEgressoService(new EgressoService());
	}
	
	@Test
	public void testeConsultaWebServiceViaPeriodo(){
		Date dataInicial = new Date(01/01/2015);
		Date dataFinal	 = new Date(30/12/2016);
		List<Egresso> egressos = getEgressoService().buscarDadosEgressoPeloPeriodoConclusaoCurso(dataInicial, dataFinal);
		Assert.assertEquals(true, egressos != null);
	}
	
	@Test
	public void testeConsultaWebServiceViaPeloCurso(){
		CursoUFGDAO cursoDao = new CursoUFGDAO();
		StringBuilder sql = new StringBuilder();
		List<Egresso> egressos = new ArrayList<Egresso>();
		
		sql.append("SELECT ID, NIVEL, TIPO_RESOLUCAO, NUMERO_RESOLUCAO, E_PRESENCIAL, TURNO ")
		   .append("FROM CURSO_UFG");
		
		List<CursoUFG> cursos = cursoDao.select(sql.toString());
		List<Integer> codigosCursos = new ArrayList<Integer>();
		
		if (cursos != null) {
			cursos.stream().forEach(x-> codigosCursos.add(x.getId()));
			egressos = getEgressoService().buscarDadosEgressoPeloCurso(codigosCursos);
		}
		
		Assert.assertTrue(!egressos.isEmpty());
	}
	
	@Test
	public void testeConsultaWebServiceViaIdentificadorEgresso(){
		EgressoDao egressoDao = new EgressoDao();
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT ID, NOME_OFICIAL, SEXO ")
		   .append("FROM EGRESSOS");
		
		List<Egresso> egressos = egressoDao.select(sql.toString());
		List<Integer> codigosEgressos = new ArrayList<Integer>();
		
		egressos.stream().forEach(x-> codigosEgressos.add(x.getId()));
		
		List<Egresso> egressosWebService = getEgressoService().buscarDadosEgressoPeloIdentificadorEgresso(codigosEgressos);
		Assert.assertTrue(!egressosWebService.isEmpty());
	}
	
	@Test
	public void testeConsultaWebServiceViaUnidadeAcademica(){
		InstituicaoEnsinoDao instituicaoEnsinoDao = new InstituicaoEnsinoDao();
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT ID, NOME_UNIDADE_ACADEMICA")
		   .append("FROM CURSO_OUTRA_IES");
		
		List<InstituicaoEnsino> instituicaoEnsino = instituicaoEnsinoDao.select(sql.toString());
		
		List<Integer> codigosInstituicaoEnsino = new ArrayList<Integer>();
		instituicaoEnsino.stream().forEach(x-> codigosInstituicaoEnsino.add(x.getId()));
		
		List<Egresso> egresso = getEgressoService().buscarDadosEgressoPelaUnidadeAcademica(codigosInstituicaoEnsino);
		Assert.assertTrue(!egresso.isEmpty());
	}
	
	@Test
	public void testaConversaoXmlParaEgresso(){
		try {
			InputStream inputStream = new WebServiceCercompMock().consultarWebServiceEgresso();
			Egresso egresso = getEgressoService().converterXmlParaEgresso(inputStream);
			Assert.assertTrue(egresso != null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public EgressoService getEgressoService() {
		return egressoService;
	}

	public void setEgressoService(EgressoService egressoService) {
		this.egressoService = egressoService;
	}
}
