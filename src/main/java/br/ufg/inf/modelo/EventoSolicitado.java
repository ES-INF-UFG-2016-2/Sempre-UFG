package br.ufg.inf.modelo;

public class EventoSolicitado {

    private String email;
    private String descricao;
    private String publicoAlvo;
    private String areasRelacionadas;
    private String instanciasInteressadas;

    public EventoSolicitado(String email, String descricao, String publicoAlvo, String areasRelacionadas, String instanciasInteressadas) {
        this.email = email;
        this.descricao = descricao;
        this.publicoAlvo = publicoAlvo;
        this.areasRelacionadas = areasRelacionadas;
        this.instanciasInteressadas = instanciasInteressadas;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the publicoAlvo
     */
    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    /**
     * @param publicoAlvo the publicoAlvo to set
     */
    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    /**
     * @return the areasRelacionadas
     */
    public String getAreasRelacionadas() {
        return areasRelacionadas;
    }

    /**
     * @param areasRelacionadas the areasRelacionadas to set
     */
    public void setAreasRelacionadas(String areasRelacionadas) {
        this.areasRelacionadas = areasRelacionadas;
    }

    /**
     * @return the instanciasInteressadas
     */
    public String getInstanciasInteressadas() {
        return instanciasInteressadas;
    }

    /**
     * @param instanciasInteressadas the instanciasInteressadas to set
     */
    public void setInstanciasInteressadas(String instanciasInteressadas) {
        this.instanciasInteressadas = instanciasInteressadas;
    }

}
