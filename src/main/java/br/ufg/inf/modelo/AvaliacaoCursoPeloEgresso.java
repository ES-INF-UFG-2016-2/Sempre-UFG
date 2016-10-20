package br.ufg.inf.modelo;

import br.ufg.inf.enuns.Motivacao;

import java.util.Date;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class AvaliacaoCursoPeloEgresso {
    private Date timestamp_avaliacao;
    private Motivacao motivacao_escolha;
    private int satisfacao_curso;
    private int conceito_global;
    private int preparacao_mercado;
    private int melhoria_comunicacao;
    private int capacidade_etica_responsabilidade;
    private int capacidade_habilidades_area_conhecimento;
    private String comentario;
    private HistoricoUFG historico;

    public AvaliacaoCursoPeloEgresso(Date timestamp_avaliacao, Motivacao motivacao_escolha, int satisfacao_curso, int conceito_global, int preparacao_mercado, int melhoria_comunicacao, int capacidade_etica_responsabilidade, int capacidade_habilidades_area_conhecimento, String comentario, HistoricoUFG historico) {
        this.timestamp_avaliacao = timestamp_avaliacao;
        this.motivacao_escolha = motivacao_escolha;
        this.satisfacao_curso = satisfacao_curso;
        this.conceito_global = conceito_global;
        this.preparacao_mercado = preparacao_mercado;
        this.melhoria_comunicacao = melhoria_comunicacao;
        this.capacidade_etica_responsabilidade = capacidade_etica_responsabilidade;
        this.capacidade_habilidades_area_conhecimento = capacidade_habilidades_area_conhecimento;
        this.comentario = comentario;
        this.historico = historico;
    }

    public Date getTimestamp_avaliacao() {
        return timestamp_avaliacao;
    }

    public void setTimestamp_avaliacao(Date timestamp_avaliacao) {
        this.timestamp_avaliacao = timestamp_avaliacao;
    }

    public Motivacao getMotivacao_escolha() {
        return motivacao_escolha;
    }

    public void setMotivacao_escolha(Motivacao motivacao_escolha) {
        this.motivacao_escolha = motivacao_escolha;
    }

    public int getSatisfacao_curso() {
        return satisfacao_curso;
    }

    public void setSatisfacao_curso(int satisfacao_curso) {
        this.satisfacao_curso = satisfacao_curso;
    }

    public int getConceito_global() {
        return conceito_global;
    }

    public void setConceito_global(int conceito_global) {
        this.conceito_global = conceito_global;
    }

    public int getPreparacao_mercado() {
        return preparacao_mercado;
    }

    public void setPreparacao_mercado(int preparacao_mercado) {
        this.preparacao_mercado = preparacao_mercado;
    }

    public int getMelhoria_comunicacao() {
        return melhoria_comunicacao;
    }

    public void setMelhoria_comunicacao(int melhoria_comunicacao) {
        this.melhoria_comunicacao = melhoria_comunicacao;
    }

    public int getCapacidade_etica_responsabilidade() {
        return capacidade_etica_responsabilidade;
    }

    public void setCapacidade_etica_responsabilidade(int capacidade_etica_responsabilidade) {
        this.capacidade_etica_responsabilidade = capacidade_etica_responsabilidade;
    }

    public int getCapacidade_habilidades_area_conhecimento() {
        return capacidade_habilidades_area_conhecimento;
    }

    public void setCapacidade_habilidades_area_conhecimento(int capacidade_habilidades_area_conhecimento) {
        this.capacidade_habilidades_area_conhecimento = capacidade_habilidades_area_conhecimento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public HistoricoUFG getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoUFG historico) {
        this.historico = historico;
    }
}
