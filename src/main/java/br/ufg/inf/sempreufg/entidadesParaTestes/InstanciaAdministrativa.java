/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.entidadesParaTestes;

import java.sql.Date;

/**
 *
 * @author Kalyn
 */
public class InstanciaAdministrativa {
    private int INSTANCIA_ADMINISTRATIVA_ID;
    private String SIGLA_INSTANCIA;
    private String NOME;
    private String TIPO;
    private Date DATA_CRIACAO;
    private Date DATA_ENCERR;
    private String EMAIL_INSTITUCIONAL;
    private String URL_INSTITUCIONAL;

    public int getINSTANCIA_ADMINISTRATIVA_ID() {
        return INSTANCIA_ADMINISTRATIVA_ID;
    }

    public void setINSTANCIA_ADMINISTRATIVA_ID(int INSTANCIA_ADMINISTRATIVA_ID) {
        this.INSTANCIA_ADMINISTRATIVA_ID = INSTANCIA_ADMINISTRATIVA_ID;
    }

    public String getSIGLA_INSTANCIA() {
        return SIGLA_INSTANCIA;
    }

    public void setSIGLA_INSTANCIA(String SIGLA_INSTANCIA) {
        this.SIGLA_INSTANCIA = SIGLA_INSTANCIA;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public Date getDATA_CRIACAO() {
        return DATA_CRIACAO;
    }

    public void setDATA_CRIACAO(String DATA_CRIACAO) {
        if(DATA_CRIACAO == null){
            this.DATA_CRIACAO= null;
        }
        else{
            this.DATA_CRIACAO = Date.valueOf(DATA_CRIACAO);
        }
    }

    public Date getDATA_ENCERR() {
        return DATA_ENCERR;
    }

    public void setDATA_ENCERR(String DATA_ENCERR) {
        if(DATA_ENCERR == null){
            this.DATA_ENCERR= null;
        }
        else{
            this.DATA_ENCERR = Date.valueOf(DATA_ENCERR);
        }
    }

    public String getEMAIL_INSTITUCIONAL() {
        return EMAIL_INSTITUCIONAL;
    }

    public void setEMAIL_INSTITUCIONAL(String EMAIL_INSTITUCIONAL) {
        this.EMAIL_INSTITUCIONAL = EMAIL_INSTITUCIONAL;
    }

    public String getURL_INSTITUCIONAL() {
        return URL_INSTITUCIONAL;
    }

    public void setURL_INSTITUCIONAL(String URL_INSTITUCIONAL) {
        this.URL_INSTITUCIONAL = URL_INSTITUCIONAL;
    }
    
    
}
