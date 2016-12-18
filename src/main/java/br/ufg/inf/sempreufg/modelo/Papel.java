package br.ufg.inf.sempreufg.modelo;

import org.json.JSONObject;

import javax.persistence.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Martins de Carvalho
 *
 */

@Entity
@Table(name = "Papel")
public class Papel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="idPapel")
    @SequenceGenerator(name="idPapel", initialValue=10, sequenceName="PAPEL_ID_SEQUENCE", allocationSize=1)
	private Integer idPapel;
	private String siglaPapel;
	private String nomePapel;

	private List<Usuario> listaUsuario;
	private List<Recurso> listaRecurso;

    public Papel(){};

    public Papel(String siglaPapel, String nomePapel, List<Usuario> listaUsuario, List<Recurso> listaRecurso) {
        this.siglaPapel = siglaPapel;
        this.nomePapel = nomePapel;
        this.listaUsuario = listaUsuario;
        this.listaRecurso = listaRecurso;
    }

    public Integer getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(Integer idPapel) {
		this.idPapel = idPapel;
	}

	public String getSiglaPapel() {
		return siglaPapel;
	}

	public void setSiglaPapel(String siglaPapel) {
		this.siglaPapel = siglaPapel;
	}

	public String getNomePapel() {
		return nomePapel;
	}

	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}

	public List<Recurso> getListaRecurso() {
		return new ArrayList<>(this.listaRecurso);
	}

    private JSONObject getListaRecursoAsJson() {
        JSONObject listaRecursoAsJsonObj = new JSONObject();
        this.listaRecurso.forEach(recurso -> listaRecursoAsJsonObj.put(recurso.getIdRecurso(), recurso.toJSON()));
        return listaRecursoAsJsonObj;
    }

	public void addRecurso(Recurso recurso) {
	    this.listaRecurso.add(recurso);
    }

    public void removeRecurso(Recurso recurso) {
        this.listaRecurso.remove(recurso);
    }

    public void setListaRecurso(List<Recurso> listaRecurso){
        this.listaRecurso = listaRecurso;
    }

	public List<Usuario> getListaUsuario() {
		return new ArrayList<>(this.listaUsuario);
	}

    private JSONObject getListaUsuarioAsJson() {
        JSONObject listaUsuarioAsJsonObj = new JSONObject();
        this.listaUsuario.forEach(usuario -> listaUsuarioAsJsonObj.put(Integer.toString(usuario.getIdUsuario()), usuario.toJSON()));
        return listaUsuarioAsJsonObj;
    }

    public void addUsuario(Usuario usuario) {
        this.listaUsuario.add(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        this.listaUsuario.remove(usuario);
    }

    public void setListaUsuario(List<Usuario> listaUsuario){
        this.listaUsuario = listaUsuario;
    }

    public JSONObject toJSON(){

        JSONObject papelAsJsonObj = new JSONObject();
        JSONObject innerJson = new JSONObject();

        innerJson.put("siglaPapel", getSiglaPapel());
        innerJson.put("nomePapel", getNomePapel());
        innerJson.put("listaRecursos", getListaRecursoAsJson());
        innerJson.put("listaUsuarios", getListaUsuarioAsJson());

        papelAsJsonObj.put(Integer.toString(getIdPapel()), innerJson);

        return papelAsJsonObj;
    }

    public static Papel fromJSON(JSONObject papelAsJsonObj){

        List<Recurso> listaRecursos = new ArrayList<>();
        List<Usuario> listaUsuarios = new ArrayList<>();

        papelAsJsonObj.getJSONObject("listaRecursos").names().forEach(recursoAsJsonObj -> {
                listaRecursos.add(Recurso.fromJSON((JSONObject) recursoAsJsonObj));
            }
        );

        papelAsJsonObj.getJSONObject("listaUsuarios").names().forEach(usuarioAsJsonObj -> {
                try {
                    listaUsuarios.add(Usuario.fromJSON((JSONObject) usuarioAsJsonObj));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        );

        return new Papel(papelAsJsonObj.getString("siglaPapel"), papelAsJsonObj.getString("nomePapel"), listaUsuarios, listaRecursos);
    }

}
