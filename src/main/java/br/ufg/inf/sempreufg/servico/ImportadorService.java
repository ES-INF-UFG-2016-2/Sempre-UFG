package br.ufg.inf.sempreufg.servico;

import java.util.List;

import br.ufg.inf.sempreufg.dao.CursoUFGDAO;
import br.ufg.inf.sempreufg.dao.EgressoDao;
import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Egresso;

public class ImportadorService {
	public void importarEgresos(List<String> parametros){
		EgressoWebService egressoWebService = new EgressoWebService();
		String jsonEgressos = egressoWebService.buscarDadosEgressoPeloIdentificadorEgresso(parametros);
		List<Egresso> egressos = new EgressoService().converterJsonParaListaEgresso(jsonEgressos);
		for (int i = 0; i < egressos.size(); i++) {
			new EgressoDao().inserir(egressos.get(i));
		}
	}
	
	public void importarCursos(){
		CursoWebService webService = new CursoWebService();
		String json = webService.buscarTodosCursos();
		CursoUFGService service = new CursoUFGService();
		List<CursoUFG> cursos = service.converterJsonParaListaCursoUfg(json);
		for (int i = 0; i < cursos.size(); i++) {
			new CursoUFGDAO().inserir(cursos.get(i));
		}
	}
}
