/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Kleudson
 * @version 1.0
 */
@Entity
@Table(name = "Log")
public class Log implements Serializable{
    
    @Id
    @Column(name = "id_log")
    private int idLog;
    
    @Column(name = "mensagem")
    private String mensagem;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "tipo")
    private int tipoLog;

    /**
     * @return the idLog
     */
    public int getIdLog() {
        return idLog;
    }

    /**
     * @param idLog the idLog to set
     */
    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the tipoLog
     */
    public int getTipoLog() {
        return tipoLog;
    }

    /**
     * @param tipoLog the tipoLog to set
     */
    public void setTipoLog(int tipoLog) {
        this.tipoLog = tipoLog;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idLog;
        hash = 71 * hash + Objects.hashCode(this.mensagem);
        hash = 71 * hash + Objects.hashCode(this.usuario);
        hash = 71 * hash + this.tipoLog;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Log other = (Log) obj;
        if (this.idLog != other.idLog) {
            return false;
        }
        if (this.tipoLog != other.tipoLog) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    
    
}
