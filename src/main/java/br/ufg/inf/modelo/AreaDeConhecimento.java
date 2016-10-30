package br.ufg.inf.modelo;


public class AreaDeConhecimento {
    
    private String id;
    private String nomeArea;
    private int codigoArea;

    public AreaDeConhecimento(String id, String nomeArea, int codigoArea) {
        this.id = id;
        this.nomeArea = nomeArea;
        this.codigoArea = codigoArea;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public int getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
    }
    
    
}
