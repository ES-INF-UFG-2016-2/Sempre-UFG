package br.ufg.inf.modelo;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class AreaDeConhecimentoStub {
    private String nome;
    private int codigo;

    public AreaDeConhecimentoStub(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
