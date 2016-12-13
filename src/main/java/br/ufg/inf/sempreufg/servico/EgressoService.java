package br.ufg.inf.sempreufg.servico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.ufg.inf.sempreufg.dao.CursoUFGDAO;
import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.modelo.CursoOutrasIES;
import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoOutrasIES;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.InstituicaoEnsino;
import br.ufg.inf.sempreufg.modelo.Residencia;


public class EgressoService implements EgressoServiceInterface{
	
	@Override
	public List<Egresso> converterJsonParaListaEgresso(String json) {
		List<Egresso> egressos 	= new ArrayList<Egresso>();
		JSONArray jsonArray 	= new JSONArray(json);
		
		for (int i = 0; i < jsonArray.length(); i++) {
			Egresso egresso = converterJsonParaEgresso(jsonArray.getJSONObject(i).toString());
			egressos.add(egresso);
		}
		
		return egressos;
	}
	
	public Egresso converterJsonParaEgresso(String json){
		Egresso egresso = new Egresso();
		JSONObject jsonObject = new JSONObject(json);
		
		egresso.setHistoricoUfg(converterJsonParaListaHistorico(jsonObject.getJSONArray("historicoUfg").toString()));
		
		egresso.getHistoricoUfg().get(0).getCursoUFG();
		
		CursoUFG cursoUfg = new CursoUFGDAO().buscarPorCodigoCurso(egresso.getHistoricoUfg().get(0).getCursoUFG().getCodigo());
		if (cursoUfg != null) {
			egresso.getHistoricoUfg().get(0).setCursoUFG(cursoUfg);
		}
		
		egresso.setNome(jsonObject.getString("nome"));
		
		egresso.setVisibilidadeDeDados(VisibilidadeDados.valueOf(jsonObject.getString("visibilidadeDeDados")));
		egresso.setDataNascimento(converterJsonToLocalDate(jsonObject.getJSONObject("dataNascimento").toString()));
		egresso.setSexo(Sexo.valueOf(jsonObject.getString("sexo")));
		egresso.setNomeMae(jsonObject.getString("nomeMae"));
		egresso.setEmail(jsonObject.getString("email"));
		egresso.setCursosOutrasIES(convertJsonParaListaCursoOutraIES(jsonObject.getJSONArray("cursosDeOutraInstituicaoEnsino").toString()));
		egresso.setNomeMae(jsonObject.getString("numeroMatricula"));
		
		return egresso;
	} 

	private List<CursoOutrasIES> convertJsonParaListaCursoOutraIES(String json) {
		List<CursoOutrasIES> cursosOutrasIES = new CursoOutrasIESService().converterJsonParaListaCursoOutraIES(json);
		return cursosOutrasIES;
	}

	private LocalDate converterJsonToLocalDate(String json) {
		JSONObject jsonObject = new JSONObject(json);
		
		LocalDate data = LocalDate.of(jsonObject.getInt("year"),
								      jsonObject.getInt("month"),
								      jsonObject.getInt("day"));
		return data;
	}

	private List<HistoricoUFG> converterJsonParaListaHistorico(String json) {
		List<HistoricoUFG> historicos = new HistoricoUFGService().converterJsonParaListaHistorico(json);
		return historicos;
	}

	@Override
	public boolean egressoEValido(Egresso egresso) {
		return false;
	}
	
	public List<Egresso> criarListaEgressoMock(){
		List<Egresso> egressos = new ArrayList<Egresso>();

		for (int i = 0; i < 10; i++) {
			Egresso egresso = new Egresso("546546",
										  "Everton Jose",
										  "Maria",
										  LocalDate.of(1993, 12, 24),
										  Sexo.MASCULINO,
										  "email@gmail.com",
										  "emailAlternativo@gmail.com",
										  new BitSet(),
										  new BitSet(),
										  VisibilidadeDados.PUBLICO,
										  new Residencia(),
										  new InstituicaoEnsino(),
										  new HistoricoOutrasIES(),
										  new ArrayList<CursoOutrasIES>(),
										  new ArrayList<CursoUFG>(),
										  new ArrayList<HistoricoUFG>());
			egressos.add(egresso);
		}
		return egressos;
	}
}
