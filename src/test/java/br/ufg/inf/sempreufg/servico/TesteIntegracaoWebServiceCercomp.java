package br.ufg.inf.sempreufg.servico;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.sempreufg.dao.CursoUFGDAO;
import br.ufg.inf.sempreufg.dao.EgressoDao;
import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Egresso;

public class TesteIntegracaoWebServiceCercomp {
	private EgressoService egressoService;

	@Before
	public void init(){
		setEgressoService(new EgressoService());
	}
	
	
//Caso de teste removido devido a não implementação desse metodo no webService
//	@Test
//	public void testeConsultaWebServiceViaPeriodo(){
//		LocalDate dataInicial = LocalDate.of(2015, 01, 01);
//		LocalDate dataFinal	 = LocalDate.of(2016, 12, 30);
//		
//		String json = new EgressoWebService().buscarDadosEgressoPeloPeriodoConclusaoCurso(dataInicial, dataFinal);
//		List<Egresso> egressos = new EgressoService().converterJsonParaListaEgresso(json);
//		
//		Assert.assertEquals(true, egressos != null);
//	}

	@Test
	public void testeConsultaWebServiceViaPeloCurso(){
		CursoUFGDAO cursoDao = new CursoUFGDAO();
		StringBuilder sql = new StringBuilder();
		List<Egresso> egressos = new ArrayList<Egresso>();

		sql.append("SELECT ID, NIVEL, TIPO_RESOLUCAO, NUMERO_RESOLUCAO, E_PRESENCIAL, TURNO ")
		   .append("FROM CURSO_UFG");

		List<CursoUFG> cursos = cursoDao.select(sql.toString());
		List<String> codigosCursos = new ArrayList<String>();

		if (cursos != null) {
			cursos.stream().forEach(x-> codigosCursos.add(String.valueOf(x.getId())));
			String json = new EgressoWebService().buscarDadosEgressoPeloCurso(codigosCursos);
			egressos = new EgressoService().converterJsonParaListaEgresso(json);
			
		}

		Assert.assertTrue(egressos != null);
	}

	@Test
	public void testeConsultaWebServiceViaIdentificadorEgresso(){
		EgressoDao egressoDao = new EgressoDao();
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ID, NOME_OFICIAL, SEXO ")
		   .append("FROM EGRESSOS");

		List<Egresso> egressos = egressoDao.select(sql.toString());
		List<String> codigosEgressos = new ArrayList<String>();

		egressos.stream().forEach(x-> codigosEgressos.add(String.valueOf(x.getId())));
		String json = new EgressoWebService().buscarDadosEgressoPeloCurso(codigosEgressos);
		List<Egresso> egressosWebService = new EgressoService().converterJsonParaListaEgresso(json);
		
		Assert.assertTrue(egressosWebService != null);
	}

	
	//Esse caso de teste foi comentado pelo fato de que não será mais utilizado essa forma de consulta
	
//	@Test
//	public void testeConsultaWebServiceViaUnidadeAcademica(){
//		InstituicaoEnsinoDao instituicaoEnsinoDao = new InstituicaoEnsinoDao();
//		StringBuilder sql = new StringBuilder();
//
//		sql.append("SELECT ID, NOME_UNIDADE_ACADEMICA")
//		   .append("FROM CURSO_OUTRA_IES");
//
//		List<InstituicaoEnsino> instituicaoEnsino = instituicaoEnsinoDao.select(sql.toString());
//
//		List<Integer> codigosInstituicaoEnsino = new ArrayList<Integer>();
//		instituicaoEnsino.stream().forEach(x-> codigosInstituicaoEnsino.add(x.getId()));
//
//		List<Egresso> egresso = getEgressoService().buscarDadosEgressoPelaUnidadeAcademica(codigosInstituicaoEnsino);
//		Assert.assertTrue(!egresso.isEmpty());
//	}

	@Test
	public void testaConversaoJsonParaEgresso(){
		String json = new EgressoWebService().listarTodos();
		List<Egresso> egressos = getEgressoService().converterJsonParaListaEgresso(json);
		Assert.assertTrue(egressos != null);
	}

	public EgressoService getEgressoService() {
		return egressoService;
	}

	public void setEgressoService(EgressoService egressoService) {
		this.egressoService = egressoService;
	}
}
