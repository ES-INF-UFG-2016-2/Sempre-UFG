package br.ufg.inf.sempreufg.servico;

import org.springframework.web.client.RestTemplate;

public class CursoWebService {
	public static final String URL_WEB_SERVICE_LISTAR_TODOS = "http://localhost:8080/cursos";
	
	public String buscarTodosCursos(){
		String result = new RestTemplate().getForObject(URL_WEB_SERVICE_LISTAR_TODOS.toString() , String.class);
		return result;
	}
}
