package br.ufg.inf.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstanciaAdm {

    private String sigla;
    private String nome;

    private enum Tipos {
        REGIONAL, UNIDADE, CURSO
    };

    private Tipos tipo;
    private Date data_criacao = new Date();
    private Date data_enc = new Date();
    private String email;
    private String url_inst;
    private List instancias = new ArrayList();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
