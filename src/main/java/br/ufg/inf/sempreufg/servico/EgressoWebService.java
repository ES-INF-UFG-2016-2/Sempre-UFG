package br.ufg.inf.sempreufg.servico;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class EgressoWebService {
	
	public static final String URL_WEB_SERVICE_LISTAR_TODOS = "http://localhost:8080/egressos";
	public static final String URL_WEB_SERVICE_LISTAR_POR_MATRICULA = "http://localhost:8080/egressos/listarPorMatricula/";
	public static final String URL_WEB_SERVICE_LISTAR_POR_IDENTIFICADOR_CURSO = "http://localhost:8080/egressos/listarPorIdentificadorCurso/";
	
	public String buscarDadosEgressoPeloPeriodoConclusaoCurso(LocalDate dataInicial, LocalDate dataFinal){
		return null;
	}

	public String buscarDadosEgressoPeloIdentificadorEgresso(List<String> identificadores){
		StringBuilder url = new StringBuilder();
		
		for (int i = 0; i < identificadores.size(); i++) {
			url.append(identificadores.get(0));
			if (i < (identificadores.size()-1)) {
				url.append(",");
			}
		}
		
		String result = new RestTemplate().getForObject(URL_WEB_SERVICE_LISTAR_POR_MATRICULA.toString()+url.toString() , String.class);
		return result;
	}

	public String buscarDadosEgressoPeloCurso(List<String> identificadores){
		StringBuilder url = new StringBuilder();
		
		for (int i = 0; i < identificadores.size(); i++) {
			url.append(identificadores.get(0));
			if (i < (identificadores.size()-1)) {
				url.append(",");
			}
		}
		
		String result = new RestTemplate().getForObject(URL_WEB_SERVICE_LISTAR_POR_IDENTIFICADOR_CURSO.toString()+url.toString() , String.class);
		return result;
	}

	public String buscarDadosEgressoPelaUnidadeAcademica(List<String> identificadores){
		return null;
	}
	
	public String listarTodos(){
		String result = new RestTemplate().getForObject(URL_WEB_SERVICE_LISTAR_TODOS.toString() , String.class);
		return result;
	}
}
