package br.ufg.inf.sempreufg.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import br.ufg.inf.sempreufg.enums.NiveisCurso;
import br.ufg.inf.sempreufg.enums.TiposResolucao;
import br.ufg.inf.sempreufg.enums.Turnos;

@Entity(name = "cursoufg")
public class CursoUFG implements Serializable{

	private static final long serialVersionUID = 5470137330235095143L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String codigo;
	private String nome;
	
	@Enumerated(EnumType.STRING)
    private NiveisCurso nivel;
	
	@Enumerated(EnumType.STRING)
    private TiposResolucao tiposResolucao;
	
    private int num_resolucao;
    
    @Type(type="true_false")
    private boolean presencial;
    
    @Enumerated(EnumType.STRING)
    private Turnos turno;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "area_de_conhecimento")
    private AreaDeConhecimento area_de_conhecimento;

    public CursoUFG(NiveisCurso nivel, TiposResolucao tiposResolucao, int num_resolucao, boolean presencial, Turnos turno, AreaDeConhecimento area_de_conhecimento) {
        this.nivel = nivel;
        this.tiposResolucao = tiposResolucao;
        this.num_resolucao = num_resolucao;
        this.presencial = presencial;
        this.turno = turno;
        this.area_de_conhecimento = area_de_conhecimento;
    }
    
    public CursoUFG() {
    	super();
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
