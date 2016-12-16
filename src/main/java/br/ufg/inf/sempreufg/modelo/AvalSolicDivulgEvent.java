package br.ufg.inf.sempreufg.modelo;

import java.util.Date;

public class AvalSolicDivulgEvent {
    
    private int id_evento;
    private int id_usuario;
    private boolean pertinencia;
    private String parecer;
    private Date data;
    
    public AvalSolicDivulgEvent(){}
    
    public AvalSolicDivulgEvent(int id_evento, int id_usuario, boolean pertinencia, String parecer, Date data) {
        this.id_evento = id_evento;
        this.id_usuario = id_usuario;
        this.pertinencia = false;
        this.parecer = parecer;
        this.data = data;
    }

    public int getEvento() {
        return id_evento;
    }

    public void setEvento(int id_evento) {
        this.id_evento = id_evento;
    }
    
    public int getUsuario() {
        return id_usuario;
    }
    
    public void setUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isPertinencia() {
        return pertinencia;
    }
    
    public void isPertinencia(boolean pertinencia) {
        this.pertinencia = pertinencia;
    }

    public String getParecer() {
        return parecer;
    }
    
    public void setParecer(String parecer) {
        this.parecer = parecer;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
