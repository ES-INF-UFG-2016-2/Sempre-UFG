package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.FormaIngressoInstituicao;
import java.util.Date;

public class Atuacao {
    
    private Date data_inicio;
    private Date data_fim;
    private float renda_mensal_media;
    private int satisfacao_renda;
    private int perspectiva_sobre_futuro_area;
    private String comentario;
    private String razao_social_organizacao;
    private FormaIngressoInstituicao forma_ingresso;

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

    public float getRenda_mensal_media() {
        return renda_mensal_media;
    }

    public void setRenda_mensal_media(float renda_mensal_media) {
        this.renda_mensal_media = renda_mensal_media;
    }

    public int getSatisfacao_renda() {
        return satisfacao_renda;
    }

    public void setSatisfacao_renda(int satisfacao_renda) {
        this.satisfacao_renda = satisfacao_renda;
    }

    public int getPerspectiva_sobre_futuro_area() {
        return perspectiva_sobre_futuro_area;
    }

    public void setPerspectiva_sobre_futuro_area(int perspectiva_sobre_futuro_area) {
        this.perspectiva_sobre_futuro_area = perspectiva_sobre_futuro_area;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getRazao_social_organizacao() {
        return razao_social_organizacao;
    }

    public void setRazao_social_organizacao(String razao_social_organizacao) {
        this.razao_social_organizacao = razao_social_organizacao;
    }

    public FormaIngressoInstituicao getForma_ingresso() {
        return forma_ingresso;
    }

    public void setForma_ingresso(FormaIngressoInstituicao forma_ingresso) {
        this.forma_ingresso = forma_ingresso;
    }
    
}
