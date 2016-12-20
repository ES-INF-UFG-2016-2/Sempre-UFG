package br.ufg.inf.sempreufg.modelo;

import org.json.JSONObject;

public class AreaDeConhecimento {
    private String nome;
    private int codigo;

    public AreaDeConhecimento(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public JSONObject toJson() {
        JSONObject areaDeConhecimentoAsJsonObj = new JSONObject();
        areaDeConhecimentoAsJsonObj.put("codigo", getCodigo());
        areaDeConhecimentoAsJsonObj.put("nome", getNome());
        return areaDeConhecimentoAsJsonObj;
    }

    public static AreaDeConhecimento fromJson(JSONObject areaDeconhecimentoAsJson) {
        return new AreaDeConhecimento(areaDeconhecimentoAsJson.getString("nome"), Integer.parseInt(areaDeconhecimentoAsJson.getString("codigo")));
    }

}
