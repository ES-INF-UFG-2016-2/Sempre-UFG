package br.ufg.inf.sempreufg.modelo;

public class AtributoDaTabela {

    private String atributo;
    private String tabela;

    public AtributoDaTabela(String tabela, String atributo) {
        this.tabela = tabela;
        this.atributo = atributo;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    @Override
    public String toString() {
        return getTabela() + "." + getAtributo();
    }
}
