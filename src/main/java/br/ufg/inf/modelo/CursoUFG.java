package br.ufg.inf.modelo;

import br.ufg.inf.abstratas.AreaDeConhecimento;
import br.ufg.inf.enums.NiveisCurso;
import br.ufg.inf.enums.Nivel;
import br.ufg.inf.enums.TipoResolucao;
import br.ufg.inf.enums.Turno;

public class CursoUFG {

    private String nome;
    private NiveisCurso nivel;
    private TipoResolucao tiposResolucao;
    private int num_resolucao;
    private boolean presencial;
    private Turno turno;
    private AreaDeConhecimento area_de_conhecimento;

    public CursoUFG(NiveisCurso nivel, TipoResolucao tiposResolucao, int num_resolucao, boolean presencial, Turno turno, AreaDeConhecimento area_de_conhecimento) {
        this.nivel = nivel;
        this.tiposResolucao = tiposResolucao;
        this.num_resolucao = num_resolucao;
        this.presencial = presencial;
        this.turno = turno;
        this.area_de_conhecimento = area_de_conhecimento;
    }

    public CursoUFG(Nivel nivel, TipoResolucao tipoResolucao, int numResolucao, boolean ePresencial, Turno turno, br.ufg.inf.modelo.AreaDeConhecimento areaConhecimentoEsperada, UnidadeAcademica unidadeAcademicaEsperada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public TipoResolucao getTiposResolucao() {
        return tiposResolucao;
    }

    public void setTiposResolucao(TipoResolucao tiposResolucao) {
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

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public AreaDeConhecimento getArea_de_conhecimento() {
        return area_de_conhecimento;
    }

    public void setArea_de_conhecimento(AreaDeConhecimento area_de_conhecimento) {
        this.area_de_conhecimento = area_de_conhecimento;
    }
}
