package br.ufg.inf.sempreufg.modelo;

public class PublicoAlvo {

    private int codigo_publico_alvo;
    private String nome_publico;

    public PublicoAlvo() {
    }

    public PublicoAlvo(int codigo_publico_alvo, String nome_publico) {
        this.codigo_publico_alvo = codigo_publico_alvo;
        this.nome_publico = nome_publico;
    }

    public int getCodigo_publico_alvo() {
        return codigo_publico_alvo;
    }

    public void setCodigo_publico_alvo(int codigo_publico_alvo) {
        this.codigo_publico_alvo = codigo_publico_alvo;
    }

    public String getNome_publico() {
        return nome_publico;
    }

    public void setNome_publico(String nome_publico) {
        this.nome_publico = nome_publico;
    }
}
