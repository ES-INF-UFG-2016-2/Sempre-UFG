<<<<<<< HEAD:src/main/java/br/ufg/inf/modelo/CursoOutrasIES.java
package br.ufg.inf.modelo;

import br.ufg.inf.enums.NiveisCurso;
import br.ufg.inf.enums.TipoInstituicao;

public class CursoOutrasIES {

    private String id;

    private String nomeDoCurso;

    private String unidadeAcademia;

    private String iesDoCurso;

    private String urlInstitucional;

    private NiveisCurso nivel;

    private TipoInstituicao tipoInstituicao;

    private String url;
    
    private AreaDeConhecimento areaConhecimento;
    
    public CursoOutrasIES(){
        
    }

    public CursoOutrasIES(String id, String nomeDoCurso, String unidadeAcademia, String iesDoCurso, String urlInstitucional, NiveisCurso nivel, TipoInstituicao tipoInstituicao, AreaDeConhecimento areaDeConhecimento) {
        this.id = id;
        this.nomeDoCurso = nomeDoCurso;
        this.unidadeAcademia = unidadeAcademia;
        this.iesDoCurso = iesDoCurso;
        this.urlInstitucional = urlInstitucional;
        this.nivel = nivel;
        this.tipoInstituicao = tipoInstituicao;
        this.areaConhecimento = areaDeConhecimento;
    }

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

    public NiveisCurso getNivel() {
        return nivel;
    }

    public void setNivel(NiveisCurso nivel) {
        this.nivel = nivel;
    }

    public TipoInstituicao getTipoInstituicao() {
        return tipoInstituicao;
    }

    public void setTipoInstituicao(TipoInstituicao tipoInstituicao) {
        this.tipoInstituicao = tipoInstituicao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUnidadeAcademica(UnidadeAcademica segundaUnidadeAcademica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
=======
package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.Nivel;
import br.ufg.inf.sempreufg.enums.TipoInstituicao;

public class CursoOutrasIES {

	private String nomeDoCurso;

	private String unidadeAcademia;

	private String iesDoCurso;

	private String urlInstitucional;

	private Nivel nivel;

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


}
>>>>>>> origin/develop:src/main/java/br/ufg/inf/sempreufg/modelo/CursoOutrasIES.java
