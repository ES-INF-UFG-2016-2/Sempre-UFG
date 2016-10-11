package br.ufg.inf.modelo;

import br.ufg.inf.enuns.NiveisCurso;
import br.ufg.inf.enuns.TiposResolucao;
import br.ufg.inf.enuns.Turnos;

public class CursoUFGStub {

    private NiveisCurso nivel;
    private TiposResolucao tiposResolucao;
    private int num_resolucao;
    private boolean presencial;
    private Turnos turno;
    private AreaDeConhecimentoStub area_de_conhecimento;

    public CursoUFGStub(NiveisCurso nivel, TiposResolucao tiposResolucao, int num_resolucao, boolean presencial, Turnos turno, AreaDeConhecimentoStub area_de_conhecimento) {
        this.nivel = nivel;
        this.tiposResolucao = tiposResolucao;
        this.num_resolucao = num_resolucao;
        this.presencial = presencial;
        this.turno = turno;
        this.area_de_conhecimento = area_de_conhecimento;
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

    public AreaDeConhecimentoStub getArea_de_conhecimento() {
        return area_de_conhecimento;
    }

    public void setArea_de_conhecimento(AreaDeConhecimentoStub area_de_conhecimento) {
        this.area_de_conhecimento = area_de_conhecimento;
    }
}
