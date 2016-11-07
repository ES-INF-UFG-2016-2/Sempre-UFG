package br.ufg.inf.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Martins de Carvalho
 *
 */
public class Papel {

	private Integer idPapel;
	private String siglaPapel;
	private String nomePapel;

	private List<Usuario> listaUsuario;
	private List<Recurso> listaRecurso;

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
		if (this.listaRecurso == null) {
			this.listaRecurso = new ArrayList<Recurso>();
		}
		return this.listaRecurso;
	}

	public void setListaRecurso(final List<Recurso> listaRecurso) {
		this.listaRecurso = listaRecurso;
	}

	public List<Usuario> getListaUsuario() {
		if (this.listaUsuario == null) {
			this.listaUsuario = new ArrayList<Usuario>();
		}
		return this.listaUsuario;
	}

	public void setListaUsuario(final List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

}
