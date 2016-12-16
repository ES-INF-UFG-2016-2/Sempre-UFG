package br.ufg.inf.sempreufg.modelo;

public class Atributo {
    private String id;

    private String nomeDoAtributo;

    private String tituloDaQuestao;

    private String tituloDoCampo;

    private Atributo desviaPara;

    private Atributo atributoAntecedente;

    private String valorAtributoDeOrigem;

    public Atributo() {
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeDoAtributo() {
        return nomeDoAtributo;
    }

    public void setNomeDoAtributo(String nomeDoAtributo) {
        this.nomeDoAtributo = nomeDoAtributo;
    }

    public String getTituloDaQuestao() {
        return tituloDaQuestao;
    }

    public void setTituloDaQuestao(String tituloDaQuestao) {
        this.tituloDaQuestao = tituloDaQuestao;
    }

    public String getTituloDoCampo() {
        return tituloDoCampo;
    }

    public void setTituloDoCampo(String tituloDoCampo) {
        this.tituloDoCampo = tituloDoCampo;
    }

    public Atributo getDesviaPara() {
        return desviaPara;
    }

    public void setDesviaPara(Atributo desviaPara) {
        this.desviaPara = desviaPara;
    }

    public Atributo getAtributoAntecedente() {
        return atributoAntecedente;
    }

    public void setAtributoAntecedente(Atributo atributoAntecedente) {
        this.atributoAntecedente = atributoAntecedente;
    }

    public String getValorAtributoDeOrigem() {
        return valorAtributoDeOrigem;
    }

    public void setValorAtributoDeOrigem(String valorAtributoDeOrigem) {
        this.valorAtributoDeOrigem = valorAtributoDeOrigem;
    }
}
