package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.NaturezaOrganizacao;

public class Organizacao {
    
    private String razao_social;
    private String endereco_comercial;
    private NaturezaOrganizacao natureza_organizacao;
    private String pagina_web;

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getEndereco_comercial() {
        return endereco_comercial;
    }

    public void setEndereco_comercial(String endereco_comercial) {
        this.endereco_comercial = endereco_comercial;
    }

    public NaturezaOrganizacao getNatureza_organizacao() {
        return natureza_organizacao;
    }

    public void setNatureza_organizacao(NaturezaOrganizacao natureza_organizacao) {
        this.natureza_organizacao = natureza_organizacao;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }
}
