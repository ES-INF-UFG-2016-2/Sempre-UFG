package br.ufg.inf.sempreufg.modelo;

import org.json.JSONObject;

import java.util.List;

/**
 * @author Bruno Martins de Carvalho
 *
 */
public class Recurso {

	private String idRecurso;
	private String siglaRecurso;
	private String descricao;

	private List<Papel> listaPapel;

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
		return listaPapel;
	}

	public void setListaPapel(List<Papel> listaPapel) {
		this.listaPapel = listaPapel;
	}

	public JSONObject toJSON(){

	    JSONObject recursoAsJsonObj = new JSONObject();

        recursoAsJsonObj.put("idRecurso", getIdRecurso());
        recursoAsJsonObj.put("siglaRecurso", getSiglaRecurso());
        recursoAsJsonObj.put("descricao", getDescricao());

	    return recursoAsJsonObj;
    }

}
