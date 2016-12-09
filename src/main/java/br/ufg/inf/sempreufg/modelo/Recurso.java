package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.PoliticaRecebimentoMensagens;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Locale;

/**
 * @author Bruno Martins de Carvalho
 *
 */
public class Recurso {

	private String idRecurso;
	private String siglaRecurso;
	private String descricao;

	private List<Papel> listaPapel;

    public Recurso(){}

    public Recurso(String siglaRecurso, String descricao, List<Papel> listaPapel) {
        this.siglaRecurso = siglaRecurso;
        this.descricao = descricao;
        this.listaPapel = listaPapel;
    }

    public String getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(String idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getSiglaRecurso() {
		return siglaRecurso;
	}

	public void setSiglaRecurso(String siglaRecurso) {
		this.siglaRecurso = siglaRecurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Papel> getListaPapel() {
		return new ArrayList<>(this.listaPapel);
	}

	public void setListaPapel(List<Papel> listaPapel) {
		this.listaPapel = listaPapel;
	}

    public void addPapel(Papel papel) {
        this.listaPapel.add(papel);
    }

    private JSONObject getListaPapelAsJson() {
        JSONObject listaPapelAsJsonObj = new JSONObject();
        this.listaPapel.forEach(papel -> listaPapelAsJsonObj.put(Integer.toString(papel.getIdPapel()), papel.toJSON()));
        return listaPapelAsJsonObj;
    }

	public JSONObject toJSON(){

	    JSONObject recursoAsJsonObj = new JSONObject();
        JSONObject innerJson = new JSONObject();

        innerJson.put("siglaRecurso", getSiglaRecurso());
        innerJson.put("descricao", getDescricao());
        innerJson.put("listaPapeis", getListaPapelAsJson());

        recursoAsJsonObj.put(getIdRecurso(), innerJson);

	    return recursoAsJsonObj;
    }

    public static Recurso fromJSON(JSONObject recursoAsJson) {

        List<Papel> listaPapeis = new ArrayList<>();

        recursoAsJson.getJSONObject("listaPapeis").names().forEach(papelAsJsonObj -> {
                listaPapeis.add(Papel.fromJSON((JSONObject) papelAsJsonObj));
            }
        );

        return new Recurso(recursoAsJson.getString("siglaRecurso"), recursoAsJson.getString("descricao"), listaPapeis);
    }

}
