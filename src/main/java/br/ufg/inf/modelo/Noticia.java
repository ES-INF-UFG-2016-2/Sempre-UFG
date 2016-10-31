package br.ufg.inf.modelo;

import java.util.Date;

/**
 *
 * @author Matheus Cardoso Duarte Santos
 */
public class Noticia {

    private int idEvento;
    private Date expiracao;

    public Noticia(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Date getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(Date expiracao) {
        this.expiracao = expiracao;
    }

}
