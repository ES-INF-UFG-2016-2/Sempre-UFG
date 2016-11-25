/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.RD_DivulgInfoEntidades;

import java.sql.*;

/**
 *
 * @author Kalyn
 */
public class Evento {
    
    private int EVENTO_ID;
    private String ASSUNTO;
    private String TIPO;
    private String DESCRICAO;
    private Timestamp DATA_SOLICITA_DIVULGACAO;
    private String SOLICITANTE_DIVULGACAO;
    private String SOLICITANTE_EMAIL;
    private String FORMA_DIVULGACAO;
    private String ESCOPO_DIVULGACAO;
    private Date DATA_EXPIRACAO;
    
    public int getEVENTO_ID() {
        return EVENTO_ID;
    }

    public void setEVENTO_ID(int EVENTO_ID) {
        this.EVENTO_ID = EVENTO_ID;
    }

    public String getASSUNTO() {
        return ASSUNTO;
    }

    public void setASSUNTO(String ASSUNTO) {
        this.ASSUNTO = ASSUNTO;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public Timestamp getDATA_SOLICITA_DIVULGACAO() {
        return DATA_SOLICITA_DIVULGACAO;
    }

    public void setDATA_SOLICITA_DIVULGACAO(String DATA_SOLICITA_DIVULGACAO) {
        if(DATA_SOLICITA_DIVULGACAO == null){
            this.DATA_SOLICITA_DIVULGACAO = null;
        }
        else{
            this.DATA_SOLICITA_DIVULGACAO = Timestamp.valueOf(DATA_SOLICITA_DIVULGACAO);
        }
    }

    public String getSOLICITANTE_DIVULGACAO() {
        return SOLICITANTE_DIVULGACAO;
    }

    public void setSOLICITANTE_DIVULGACAO(String SOLICITANTE_DIVULGACAO) {
        this.SOLICITANTE_DIVULGACAO = SOLICITANTE_DIVULGACAO;
    }

    public String getSOLICITANTE_EMAIL() {
        return SOLICITANTE_EMAIL;
    }

    public void setSOLICITANTE_EMAIL(String SOLICITANTE_EMAIL) {
        this.SOLICITANTE_EMAIL = SOLICITANTE_EMAIL;
    }

    public String getFORMA_DIVULGACAO() {
        return FORMA_DIVULGACAO;
    }

    public void setFORMA_DIVULGACAO(String FORMA_DIVULGACAO) {
        this.FORMA_DIVULGACAO = FORMA_DIVULGACAO;
    }

    public String getESCOPO_DIVULGACAO() {
        return ESCOPO_DIVULGACAO;
    }

    public void setESCOPO_DIVULGACAO(String ESCOPO_DIVULGACAO) {
        this.ESCOPO_DIVULGACAO = ESCOPO_DIVULGACAO;
    }

    public Date getDATA_EXPIRACAO() {
        return DATA_EXPIRACAO;
    }

    public void setDATA_EXPIRACAO(String DATA_EXPIRACAO) {
        if(DATA_EXPIRACAO == null){
            this.DATA_EXPIRACAO = null;
        }
        else{
            this.DATA_EXPIRACAO = Date.valueOf(DATA_EXPIRACAO);
        }
    }
    
}
