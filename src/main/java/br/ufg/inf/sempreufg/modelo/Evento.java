package br.ufg.inf.sempreufg.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufg.inf.sempreufg.enums.Escopos;
import br.ufg.inf.sempreufg.enums.Formas;
import br.ufg.inf.sempreufg.enums.Tipos;
import org.json.JSONObject;

public class Evento {

    private int id;
    private String assunto;
    private String des_evento;
    private Date data_solicitacao;
    private int id_solicitante;
    private Date data_expiracao;
    private Tipos tipo_evento;
    private Formas forma;
    private Escopos escopo;
    private List<AreaDeConhecimento> areas_conhecimento;
    private List<PublicoAlvo> publicos_alvo;

    public Evento() {

    }

    public Evento(int id, String assunto, String des_evento, Date data_solicitacao, int id_solicitante,
                  Date data_expiracao, String tipos_eventoStr, String formaStr, String escopoStr) {

        super();
        this.id = id;
        this.assunto = assunto;
        this.des_evento = des_evento;
        this.data_solicitacao = data_solicitacao;
        this.id_solicitante = id_solicitante;
        this.data_expiracao = data_expiracao;

        for (Escopos escopo : Escopos.values()) {
            if (escopo.toString().equalsIgnoreCase(escopoStr)) {
                setEsc(escopo);
                break;
            }
        }
        for (Tipos tipo_evento : Tipos.values()) {
            if (tipo_evento.toString().equalsIgnoreCase(tipos_eventoStr)) {
                setEvento(tipo_evento);
                break;
            }
        }
        for (Formas forma : Formas.values()) {
            if (forma.toString().equalsIgnoreCase(formaStr)) {
                setForma(forma);
                break;
            }
        }

    }


    public Evento(String assunto, String des_evento, Date data_solicitacao, int id_solicitante,
                  Date data_expiracao, String tipos_eventoStr, String formaStr, String escopoStr, List<AreaDeConhecimento> areas_conhecimento, List<PublicoAlvo> publicos_alvo) {

        super();
        this.assunto = assunto;
        this.des_evento = des_evento;
        this.data_solicitacao = data_solicitacao;
        this.id_solicitante = id_solicitante;
        this.data_expiracao = data_expiracao;
        this.areas_conhecimento = areas_conhecimento;
        this.publicos_alvo = publicos_alvo;

        for (Escopos escopo : Escopos.values()) {
            if (escopo.toString().equalsIgnoreCase(escopoStr)) {
                setEsc(escopo);
                break;
            }
        }
        for (Tipos tipo_evento : Tipos.values()) {
            if (tipo_evento.toString().equalsIgnoreCase(tipos_eventoStr)) {
                setEvento(tipo_evento);
                break;
            }
        }
        for (Formas forma : Formas.values()) {
            if (forma.toString().equalsIgnoreCase(formaStr)) {
                setForma(forma);
                break;
            }
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipos getEvento() {
        return tipo_evento;
    }

    public void setEvento(Tipos evento) {
        this.tipo_evento = evento;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDes_evento() {
        return des_evento;
    }

    public void setDes_evento(String des_evento) {
        this.des_evento = des_evento;
    }

    public Date getData_solicitacao() {
        return data_solicitacao;
    }

    public void setData_solicitacao(Date data_solicitacao) {
        this.data_solicitacao = data_solicitacao;
    }

    public int getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    public Date getData_expiracao() {
        return data_expiracao;
    }

    public void setData_expiracao(Date data_expiracao) {
        this.data_expiracao = data_expiracao;
    }

    public List<AreaDeConhecimento> getAreas_conhecimento() {
        return new ArrayList<>(areas_conhecimento);
    }

    public void addArea_conhecimento(AreaDeConhecimento areaDeConhecimento) {
        areas_conhecimento.add(areaDeConhecimento);
    }

    public void removeArea_conhecimento(AreaDeConhecimento areaDeConhecimento) {
        areas_conhecimento.remove(areaDeConhecimento);
    }

    public List<PublicoAlvo> getPublicos_alvo() {
        return new ArrayList<>(publicos_alvo);
    }

    public void addPublico_alvo(PublicoAlvo publicoAlvo) {
        publicos_alvo.add(publicoAlvo);
    }

    public void removePublico_alvo(PublicoAlvo publicoAlvo) {
        publicos_alvo.remove(publicoAlvo);
    }

    public Formas getForma() {
        return forma;
    }

    public void setForma(Formas forma) {
        this.forma = forma;
    }

    public Escopos getEsc() {
        return escopo;
    }

    private void setEsc(Escopos esc) {
        this.escopo = esc;
    }

    public JSONObject toJSON() {

        JSONObject eventoAsJsonObj = new JSONObject();
        JSONObject innerJson = new JSONObject();
        DateFormat formatter = new SimpleDateFormat("dd/mm/yy");

        innerJson.put("assunto", getAssunto());
        innerJson.put("des_evento", getDes_evento());
        innerJson.put("data_solicitacao", formatter.format(getData_solicitacao()));
        innerJson.put("idSolicitante", getId_solicitante());
        innerJson.put("data_expiracao", formatter.format(getData_expiracao()));
        innerJson.put("tipo_evento", this.tipo_evento.toString());
        innerJson.put("forma", this.forma.toString());
        innerJson.put("escopo", this.escopo.toString());
        innerJson.put("listaAreasConhecimento", getListaAreaDeConhecimentoAsJson());
        innerJson.put("listaPublicosAlvo", getListaPublicoAlvoAsJson());

        eventoAsJsonObj.put(Integer.toString(getId()), innerJson);

        return eventoAsJsonObj;
    }

    private JSONObject getListaPublicoAlvoAsJson() {
        JSONObject listaPublicoAlvoAsJsonObj = new JSONObject();
        this.publicos_alvo.forEach(publicoAlvo -> listaPublicoAlvoAsJsonObj.put(Integer.toString(publicoAlvo.getCodigo_publico_alvo()), publicoAlvo.toJSON()));
        return listaPublicoAlvoAsJsonObj;
    }

    private JSONObject getListaAreaDeConhecimentoAsJson() {
        JSONObject listaAreaDeConhecimentoAsJsonObj = new JSONObject();
        this.areas_conhecimento.forEach(areaDeConhecimento -> listaAreaDeConhecimentoAsJsonObj.put(Integer.toString(areaDeConhecimento.getCodigo()), areaDeConhecimento.toJSON()));
        return listaAreaDeConhecimentoAsJsonObj;
    }

    public static Evento fromJSON(JSONObject eventoAsJson) {

        DateFormat formatter = new SimpleDateFormat("dd/mm/yy");
        List<AreaDeConhecimento> listaRecursos = new ArrayList<>();
        List<PublicoAlvo> listaUsuarios = new ArrayList<>();

        eventoAsJson.getJSONObject("listaAreasConhecimento").names().forEach(areaDeConhecimento -> {
                listaRecursos.add(AreaDeConhecimento.fromJSON((JSONObject) areaDeConhecimento));
            }
        );

        eventoAsJson.getJSONObject("listaPublicosAlvo").names().forEach(publicoAlvo -> {
                listaUsuarios.add(PublicoAlvo.fromJSON((JSONObject) publicoAlvo));
            }
        );

        try {
            return new Evento(eventoAsJson.getString("assunto"), eventoAsJson.getString("des_evento"), formatter.parse(eventoAsJson.getString("data_solicitacao")), Integer.parseInt(eventoAsJson.getString("idSolicitante")), formatter.parse(eventoAsJson.getString("data_expiracao")), eventoAsJson.getString("tipo_evento"), eventoAsJson.getString("forma"), eventoAsJson.getString("escopo"), listaRecursos, listaUsuarios);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
