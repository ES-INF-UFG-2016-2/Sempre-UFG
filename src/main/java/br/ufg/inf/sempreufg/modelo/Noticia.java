package br.ufg.inf.sempreufg.modelo;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Matheus Cardoso Duarte Santos
 */

@Entity
@Table(name = "EVENTO")
public class Noticia {

    @Id
    private int idEvento;
    private boolean expirada;
    private Date dataExpiracao;

    public Noticia(int idEvento, Date dataExpiracao) {
        this.idEvento = idEvento;
        this.expirada = false;
        this.dataExpiracao = dataExpiracao;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public boolean isExpirada() {
        return expirada;
    }

    public void setExpirada(boolean expirada) {
        this.expirada = expirada;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
