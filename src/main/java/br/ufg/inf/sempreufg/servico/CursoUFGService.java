package br.ufg.inf.sempreufg.servico;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.ufg.inf.sempreufg.enums.NiveisCurso;
import br.ufg.inf.sempreufg.enums.TiposResolucao;
import br.ufg.inf.sempreufg.enums.Turnos;
import br.ufg.inf.sempreufg.modelo.CursoUFG;

public class CursoUFGService {
	public CursoUFG converterJsonParaCursoUfg(String json) {
		JSONObject jsonObject = new JSONObject(json);
		
		CursoUFG curso = new CursoUFG();
		curso.setCodigo(jsonObject.getString("codigo"));
		curso.setNome(jsonObject.getString("nome"));
		curso.setNivel(NiveisCurso.valueOf(jsonObject.getString("nivel")));
		curso.setTiposResolucao(TiposResolucao.valueOf(jsonObject.getString("tipoResolucao")));
		curso.setNum_resolucao(jsonObject.getInt("numeroResolucao"));
		
		curso.setPresencial((jsonObject.getBoolean("ePresencial")));
		curso.setTurno(Turnos.valueOf(jsonObject.getString("turno")));	
		
		return curso;
	}

	public List<CursoUFG> converterJsonParaListaCursoUfg(String json) {
		List<CursoUFG> cursos = new ArrayList<CursoUFG>();
		JSONArray jsonArray = new JSONArray(json);
		for (int i = 0; i < jsonArray.length(); i++) {
			CursoUFG curso = converterJsonParaCursoUfg(jsonArray.getJSONObject(0).toString());
			cursos.add(curso);
		}
		return cursos;
	}
}
