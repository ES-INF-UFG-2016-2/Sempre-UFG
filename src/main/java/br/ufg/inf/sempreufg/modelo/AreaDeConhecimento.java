package br.ufg.inf.sempreufg.modelo;

import org.json.JSONObject;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
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

    public JSONObject toJSON() {
        JSONObject areaDeConhecimentoAsJsonObj = new JSONObject();
        areaDeConhecimentoAsJsonObj.put("codigo", getCodigo());
        areaDeConhecimentoAsJsonObj.put("nome", getNome());
        return areaDeConhecimentoAsJsonObj;
    }

    public static AreaDeConhecimento fromJSON(JSONObject areaDeconhecimentoAsJson) {
        return new AreaDeConhecimento(areaDeconhecimentoAsJson.getString("nome"), Integer.parseInt(areaDeconhecimentoAsJson.getString("codigo")));
    }



}
