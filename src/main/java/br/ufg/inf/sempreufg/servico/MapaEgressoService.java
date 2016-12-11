package br.ufg.inf.sempreufg.servico;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapaEgressoService {

    public JSONObject obtenhaJSONEgressosAgrupados(JSONObject camposAgrupamento){
        return null;
    }

    private List<Map> obtenhaEgressoAgrupados(List<String> camposAgrupamentos){
        return null;
    }

    private List<String> trateChavesAgrupamentos(List<String> chavesNaoTratadas){
        List<String> chavesAgrupamento = new ArrayList<>();

        if(chavesNaoTratadas.contains("cidade")){
            chavesAgrupamento.add("cidade");
            chavesNaoTratadas.remove("cidade");
        }
        chavesNaoTratadas.remove("nome");

        chavesAgrupamento.addAll(chavesNaoTratadas);

        return chavesAgrupamento;
    }
}
