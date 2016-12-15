package br.ufg.inf.sempreufg.modelo;

import org.json.JSONObject;

public class HistoricoUFG {

    private int id;

    private int num_matricula;
    private int mes_inicio;
    private int mes_fim;
    private int ano_inicio;
    private int ano_fim;
    private CursoUFG cursoUFG;
    private String titulo_trabalho_final;


    public HistoricoUFG(int num_matricula, int mes_inicio, int mes_fim, int ano_inicio, int ano_fim, CursoUFG cursoUFG, String titulo_trabalho_final) {
        this.num_matricula = num_matricula;
        this.mes_inicio = mes_inicio;
        this.mes_fim = mes_fim;
        this.ano_inicio = ano_inicio;
        this.ano_fim = ano_fim;
        this.cursoUFG = cursoUFG;
        this.titulo_trabalho_final = titulo_trabalho_final;
    }

    public HistoricoUFG() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }

    public int getMes_inicio() {
        return mes_inicio;
    }

    public void setMes_inicio(int mes_inicio) {
        this.mes_inicio = mes_inicio;
    }

    public int getMes_fim() {
        return mes_fim;
    }

    public void setMes_fim(int mes_fim) {
        this.mes_fim = mes_fim;
    }

    public int getAno_inicio() {
        return ano_inicio;
    }

    public void setAno_inicio(int ano_inicio) {
        this.ano_inicio = ano_inicio;
    }

    public int getAno_fim() {
        return ano_fim;
    }

    public void setAno_fim(int ano_fim) {
        this.ano_fim = ano_fim;
    }

    public CursoUFG getCursoUFG() {
        return cursoUFG;
    }

    public void setCursoUFG(CursoUFG cursoUFG) {
        this.cursoUFG = cursoUFG;
    }

    public String getTitulo_trabalho_final() {
        return titulo_trabalho_final;
    }

    public void setTitulo_trabalho_final(String titulo_trabalho_final) {
        this.titulo_trabalho_final = titulo_trabalho_final;
    }

    public JSONObject toJson(){
        JSONObject historicoUFGAsJson = new JSONObject();
        JSONObject innerJSON = new JSONObject();

        innerJSON.put("num_matricula", getNum_matricula());
        innerJSON.put("mes_inicio", getMes_inicio());
        innerJSON.put("mes_fim", getMes_fim());
        innerJSON.put("ano_inicio", getAno_inicio());
        innerJSON.put("ano_fim", getAno_fim());
        innerJSON.put("cursoUFG", getCursoUFGAsJson());
        innerJSON.put("titulo_trabalho_final", getTitulo_trabalho_final());

        historicoUFGAsJson.put( Integer.toString(getId()) , innerJSON);

        return historicoUFGAsJson;
    }

    public static HistoricoUFG fromJson(JSONObject historicoUFGAsJson){

        JSONObject cursoUFGAsJson = historicoUFGAsJson.getJSONObject("cursoUFG");
        CursoUFG cursoUFGFromJson = CursoUFG.fromJson(cursoUFGAsJson);

        return new HistoricoUFG(
            historicoUFGAsJson.getInt("num_matricula"),
            historicoUFGAsJson.getInt("mes_inicio"),
            historicoUFGAsJson.getInt("mes_fim"),
            historicoUFGAsJson.getInt("ano_inicio"),
            historicoUFGAsJson.getInt("ano_fim"),
            cursoUFGFromJson,
            historicoUFGAsJson.getString("titulo_trabalho_final")
        );

    }

    public JSONObject getCursoUFGAsJson() {
        return cursoUFG.toJson();
    }
}
