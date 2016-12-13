package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.TiposProgramaAcademico;

import java.util.Date;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class RealizacaoProgramaAcademico {
    private HistoricoUFG historicoUFG;
    private TiposProgramaAcademico tipoProgramaAcademico;
    private Date data_inicio;
    private Date data_fim;
    private String descricao;

    public RealizacaoProgramaAcademico(HistoricoUFG historicoUFG, TiposProgramaAcademico tipoProgramaAcademico, Date data_inicio, Date data_fim, String descricao) {
        this.historicoUFG = historicoUFG;
        this.tipoProgramaAcademico = tipoProgramaAcademico;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.descricao = descricao;
    }

    public HistoricoUFG getHistoricoUFG() {
        return historicoUFG;
    }

    public void setHistoricoUFG(HistoricoUFG historicoUFG) {
        this.historicoUFG = historicoUFG;
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
