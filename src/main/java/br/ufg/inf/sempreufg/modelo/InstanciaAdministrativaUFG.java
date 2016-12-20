package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.TipoInstancia;

import java.util.Date;

public class InstanciaAdministrativaUFG {

	private String sigla_instancia;
	private String nome;
	private TipoInstancia tipo_instancia;
	private Date data_criacao;
	private Date data_encerramento;
	private String email_institucional;
	private String url_institucional;

    public InstanciaAdministrativaUFG(){}

    public InstanciaAdministrativaUFG(String sigla_instancia, String nome, TipoInstancia tipo_instancia, Date data_criacao, Date data_encerramento, String email_institucional, String url_institucional) {
        this.sigla_instancia = sigla_instancia;
        this.nome = nome;
        this.tipo_instancia = tipo_instancia;
        this.data_criacao = data_criacao;
        this.data_encerramento = data_encerramento;
        this.email_institucional = email_institucional;
        this.url_institucional = url_institucional;
    }

    public String getSigla_instancia() {
        return sigla_instancia;
    }

    public void setSigla_instancia(String sigla_instancia) {
        this.sigla_instancia = sigla_instancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoInstancia getTipo_instancia() {
        return tipo_instancia;
    }

    public void setTipo_instancia(TipoInstancia tipo_instancia) {
        this.tipo_instancia = tipo_instancia;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Date getData_encerramento() {
        return data_encerramento;
    }

    public void setData_encerramento(Date data_encerramento) {
        this.data_encerramento = data_encerramento;
    }

    public String getEmail_institucional() {
        return email_institucional;
    }

    public void setEmail_institucional(String email_institucional) {
        this.email_institucional = email_institucional;
    }

    public String getUrl_institucional() {
        return url_institucional;
    }

    public void setUrl_institucional(String url_institucional) {
        this.url_institucional = url_institucional;
    }
}
