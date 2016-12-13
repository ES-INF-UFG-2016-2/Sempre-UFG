package br.ufg.inf.sempreufg.modelo;

public class UnidadeAcademica {
    
    int id;
    String nome;
    LocalizacaoGeografica localizacao;
    RegionalUFG regional;

    public UnidadeAcademica(int id, String nome, LocalizacaoGeografica localizacao, RegionalUFG regional) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.regional = regional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalizacaoGeografica getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoGeografica localizacao) {
        this.localizacao = localizacao;
    }

    public RegionalUFG getRegional() {
        return regional;
    }

    public void setRegional(RegionalUFG regional) {
        this.regional = regional;
    }
}
