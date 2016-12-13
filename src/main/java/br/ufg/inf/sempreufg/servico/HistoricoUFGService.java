package br.ufg.inf.sempreufg.servico;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;

public class HistoricoUFGService {

	public List<HistoricoUFG> converterJsonParaListaHistorico(String json) {
		JSONArray jsonArray = new JSONArray(json);
		List<HistoricoUFG> historicosUfg = new ArrayList<HistoricoUFG>();
		for (int i = 0; i < jsonArray.length(); i++) {
			HistoricoUFG historicoUFG = converterJsonParaHistorico(jsonArray.getJSONObject(i).toString());
			historicosUfg.add(historicoUFG);
			
		}
		return historicosUfg;
	}
	
	public HistoricoUFG converterJsonParaHistorico(String json){
		JSONObject jsonObject = new JSONObject(json);
		
		HistoricoUFG historicoUFG = new HistoricoUFG();
		historicoUFG.setNum_matricula(jsonObject.getInt("numeroMatriculaCurso"));
		historicoUFG.setMes_inicio(jsonObject.getInt("mesInicio"));
		historicoUFG.setAno_inicio(jsonObject.getInt("anoInicio"));
		historicoUFG.setMes_fim(jsonObject.getInt("mesFinal"));
		historicoUFG.setAno_fim(jsonObject.getInt("anoFinal"));
		historicoUFG.setCursoUFG(criarCursoUfg(jsonObject.getJSONObject("cursoUfg").toString()));
		
		return historicoUFG;
	}

	private CursoUFG criarCursoUfg(String json) {
		CursoUFGService cursoUFGService = new CursoUFGService();
		CursoUFG cursoUFG = cursoUFGService.converterJsonParaCursoUfg(json);
		return cursoUFG;
	}
}
