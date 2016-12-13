package br.ufg.inf.sempreufg.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.ufg.inf.sempreufg.enums.Nivel;
import br.ufg.inf.sempreufg.enums.TipoInstituicao;

@Entity(name="cursooutrasies")
public class CursoOutrasIES {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nomeDoCurso;
	private String unidadeAcademia;
	private String iesDoCurso;
	private String urlInstitucional;

	@Enumerated(EnumType.STRING)
	private Nivel nivel;

	@Enumerated(EnumType.STRING)
	private TipoInstituicao tipoInstituicao;

	public String getNomeDoCurso() {
		return nomeDoCurso;
	}

	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}

	public String getUnidadeAcademia() {
		return unidadeAcademia;
	}

	public void setUnidadeAcademia(String unidadeAcademia) {
		this.unidadeAcademia = unidadeAcademia;
	}

	public String getIesDoCurso() {
		return iesDoCurso;
	}

	public void setIesDoCurso(String iesDoCurso) {
		this.iesDoCurso = iesDoCurso;
	}

	public String getUrlInstitucional() {
		return urlInstitucional;
	}

	public void setUrlInstitucional(String urlInstitucional) {
		this.urlInstitucional = urlInstitucional;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public TipoInstituicao getTipoInstituicao() {
		return tipoInstituicao;
	}

	public void setTipoInstituicao(TipoInstituicao tipoInstituicao) {
		this.tipoInstituicao = tipoInstituicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
