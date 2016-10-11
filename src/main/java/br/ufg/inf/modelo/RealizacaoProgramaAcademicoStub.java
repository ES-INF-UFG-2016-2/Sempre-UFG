package br.ufg.inf.modelo;

import br.ufg.inf.enuns.TiposProgramaAcademico;

import java.util.Date;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class RealizacaoProgramaAcademicoStub {
    private HistoricoUFGStub historicoUFGStub;
    private TiposProgramaAcademico tipoProgramaAcademico;
    private Date data_inicio;
    private Date data_fim;
    private String descricao;

    public RealizacaoProgramaAcademicoStub(HistoricoUFGStub historicoUFGStub, TiposProgramaAcademico tipoProgramaAcademico, Date data_inicio, Date data_fim, String descricao) {
        this.historicoUFGStub = historicoUFGStub;
        this.tipoProgramaAcademico = tipoProgramaAcademico;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.descricao = descricao;
    }

    public HistoricoUFGStub getHistoricoUFGStub() {
        return historicoUFGStub;
    }

    public void setHistoricoUFGStub(HistoricoUFGStub historicoUFGStub) {
        this.historicoUFGStub = historicoUFGStub;
    }

    public TiposProgramaAcademico getTipoProgramaAcademico() {
        return tipoProgramaAcademico;
    }

    public void setTipoProgramaAcademico(TiposProgramaAcademico tipoProgramaAcademico) {
        this.tipoProgramaAcademico = tipoProgramaAcademico;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
