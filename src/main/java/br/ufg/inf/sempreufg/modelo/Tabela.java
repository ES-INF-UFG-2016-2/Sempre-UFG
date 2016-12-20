package br.ufg.inf.sempreufg.modelo;

import java.util.List;

public class Tabela {

    private List<Linha> linhas;

    public Tabela(List<Linha> linhas) {
        this.linhas = linhas;
    }

    public List<Linha> getLinhas() {
        return linhas;
    }
}
