package br.ufg.inf.sempreufg.modelo;

import org.json.JSONObject;

import javax.persistence.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Entity
// Não há DDL para esta entidade! @Table(name = "")
public class DivulgacaoEventoComunidade {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="<id_row>")
    @SequenceGenerator(name="<id_row>", initialValue=1, sequenceName="DIVULGACAO_EVENTO_COMUNIDADE_ID_SEQUENCE", allocationSize=1)
    private int id;
    private Evento evento;
    private List<Usuario> usuarios;

    public DivulgacaoEventoComunidade(){}

    public DivulgacaoEventoComunidade(Evento evento, List<Usuario> usuarios) {
        this.evento = evento;
        this.usuarios = usuarios;
    }

    public int getId() {
        return id;
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(this.usuarios);
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    private JSONObject getListaUsuarioAsJson() {
        JSONObject listaUsuarioAsJsonObj = new JSONObject();
        this.usuarios.forEach(usuario -> listaUsuarioAsJsonObj.put(Integer.toString(usuario.getIdUsuario()), usuario.toJSON()));
        return listaUsuarioAsJsonObj;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public JSONObject toJSON() {

        JSONObject divulgacaoEventoComunidadeAsJsonObj = new JSONObject();
        JSONObject innerJson = new JSONObject();

        innerJson.put("evento", this.evento.toJSON());
        innerJson.put("listaUsuarios", getListaUsuarioAsJson());

        divulgacaoEventoComunidadeAsJsonObj.put(Integer.toString(getId()), innerJson);

        return divulgacaoEventoComunidadeAsJsonObj;
    }

    public static DivulgacaoEventoComunidade fromJSON(JSONObject divulgacaoEventoComunidadeAsJson) {

        List<Usuario> listaUsuarios = new ArrayList<>();

        divulgacaoEventoComunidadeAsJson.getJSONObject("listaUsuarios").names().forEach(usuarioAsJsonObj -> {
                try {
                    listaUsuarios.add(Usuario.fromJSON((JSONObject) usuarioAsJsonObj));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        );

        return new DivulgacaoEventoComunidade(Evento.fromJSON(divulgacaoEventoComunidadeAsJson.getJSONObject("evento")), listaUsuarios);

    }
}
