package br.ufg.inf.sempreufg.modelo;

import java.util.List;

public class Entidade {
    private String id;

    private String nomeDaEntidade;

    private List<Atributo> atributos;

    private String tituloDoGrupoDeQuestoes;

    private String tituloDoGrupoDeCampos;

    private Entidade entidadeAntecedente;

    public Entidade() {
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNomeDaEntidade() {
        return nomeDaEntidade;
    }

    public void setNomeDaEntidade(String nomeDaEntidade) {
        this.nomeDaEntidade = nomeDaEntidade;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public String getTituloDoGrupoDeQuestoes() {
        return tituloDoGrupoDeQuestoes;
    }

    public void setTituloDoGrupoDeQuestoes(String tituloDoGrupoDeQuestoes) {
        this.tituloDoGrupoDeQuestoes = tituloDoGrupoDeQuestoes;
    }

    public String getTituloDoGrupoDeCampos() {
        return tituloDoGrupoDeCampos;
    }

    public void setTituloDoGrupoDeCampos(String tituloDoGrupoDeCampos) {
        this.tituloDoGrupoDeCampos = tituloDoGrupoDeCampos;
    }

    public Entidade getEntidadeAntecedente() {
        return entidadeAntecedente;
    }

    public void setEntidadeAntecedente(Entidade entidadeAntecedente) {
        this.entidadeAntecedente = entidadeAntecedente;
    }
}
