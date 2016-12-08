package br.ufg.inf.sempreufg.modelo;

import javax.persistence.*;
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

	public List<Usuario> getListaUsuario() {
		return new ArrayList<>(this.listaUsuario);
	}
}
