package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.NiveisCurso;
import br.ufg.inf.sempreufg.enums.TiposResolucao;
import br.ufg.inf.sempreufg.enums.Turnos;
import org.json.JSONObject;

import java.io.Serializable;


public class CursoUFG extends InstanciaAdministrativaUFG implements Serializable {

    private int id;
    private NiveisCurso nivel;
    private TiposResolucao tiposResolucao;
    private int num_resolucao;
    private boolean presencial;
    private Turnos turno;
    private AreaDeConhecimento area_de_conhecimento;

    private static final long serialVersionUID = 5470137330235095143L;

    public CursoUFG() {
        super();
    }

    public CursoUFG(NiveisCurso nivel, TiposResolucao tiposResolucao, int num_resolucao, boolean presencial, Turnos turno, AreaDeConhecimento area_de_conhecimento) {
        super();
        this.nivel = nivel;
        this.tiposResolucao = tiposResolucao;
        this.num_resolucao = num_resolucao;
        this.presencial = presencial;
        this.turno = turno;
        this.area_de_conhecimento = area_de_conhecimento;
    }

    public NiveisCurso getNivel() {
        return nivel;
    }

    public void setNivel(NiveisCurso nivel) {
        this.nivel = nivel;
    }

    public TiposResolucao getTiposResolucao() {
        return tiposResolucao;
    }

    public void setTiposResolucao(TiposResolucao tiposResolucao) {
        this.tiposResolucao = tiposResolucao;
    }

    public int getNum_resolucao() {
        return num_resolucao;
    }

    public void setNum_resolucao(int num_resolucao) {
        this.num_resolucao = num_resolucao;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public Turnos getTurno() {
        return turno;
    }

    public void setTurno(Turnos turno) {
        this.turno = turno;
    }

    public AreaDeConhecimento getArea_de_conhecimento() {
        return area_de_conhecimento;
    }

    public void setArea_de_conhecimento(AreaDeConhecimento area_de_conhecimento) {
        this.area_de_conhecimento = area_de_conhecimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JSONObject toJson() {
        JSONObject cursoUFGAsJson = new JSONObject();
        JSONObject innerJSON = new JSONObject();

        innerJSON.put("nivel", getNivel().toString());
        innerJSON.put("tiposResolucao", getTiposResolucao().toString());
        innerJSON.put("num_resolucao", getNum_resolucao());
        innerJSON.put("presencial", isPresencial());
        innerJSON.put("turno", getTurno().toString());
        innerJSON.put("area_de_conhecimento", getArea_de_conhecimentoToJson());

        cursoUFGAsJson.put( Integer.toString(getId()) , innerJSON);

        return cursoUFGAsJson;
    }

    public static CursoUFG fromJson(JSONObject cursoUFG){

        JSONObject areaDeConhecimentoAsJson = cursoUFG.getJSONObject("area_de_conhecimento");
        AreaDeConhecimento areaDeConhecimentoFromJson  = AreaDeConhecimento.fromJson(areaDeConhecimentoAsJson);

        return new CursoUFG(
            NiveisCurso.valueOf(cursoUFG.getString("nivel")),
            TiposResolucao.valueOf(cursoUFG.getString("tiposResolucao")),
            cursoUFG.getInt("num_resolucao"),
            cursoUFG.getBoolean("presencial"),
            Turnos.valueOf(cursoUFG.getString("turno")),
            areaDeConhecimentoFromJson
        );
    }

    public JSONObject getArea_de_conhecimentoToJson() {
        return area_de_conhecimento.toJson();
    }
}
