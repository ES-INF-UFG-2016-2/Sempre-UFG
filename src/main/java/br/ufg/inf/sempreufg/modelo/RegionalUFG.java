package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.Regional;

public class RegionalUFG {

    private int id;
    private Regional regional;
    private LocalizacaoGeografica localizacao;

    public RegionalUFG(int id, Regional regional, LocalizacaoGeografica localizacao) {
        this.id = id;
        this.regional = regional;
        this.localizacao = localizacao;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    public LocalizacaoGeografica getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoGeografica localizacao) {
        this.localizacao = localizacao;
    }

}
