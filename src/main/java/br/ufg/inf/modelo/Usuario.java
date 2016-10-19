package br.ufg.inf.modelo;

import br.ufg.inf.enuns.TiposDivulgacao;

import java.util.BitSet;
import java.util.Date;

public class Usuario {

	private final int ID_USER = 0;
	private String mail;
	private String senha;
	private String nome;
	private String cpf;
	private BitSet foto = new BitSet();
	private TiposDivulgacao tipoDivulgacao;
	private Date ts_cadastramento;
	private Date ts_ult_update;
	private Date ts_exclusao;

    public TiposDivulgacao getTipoDivulgacao() {
        return tipoDivulgacao;
    }

    public void setTipoDivulgacao(TiposDivulgacao tipoDivulgacao) {
        this.tipoDivulgacao = tipoDivulgacao;
    }

    public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BitSet getFoto() {
		return foto;
	}

	public void setFoto(BitSet foto) {
		this.foto = foto;
	}

	public Date getTs_cadastramento() {
		return ts_cadastramento;
	}

	public void setTs_cadastramento(Date ts_cadastramento) {
		this.ts_cadastramento = ts_cadastramento;
	}

	public Date getTs_ult_update() {
		return ts_ult_update;
	}

	public void setTs_ult_update(Date ts_ult_update) {
		this.ts_ult_update = ts_ult_update;
	}

	public Date getTs_exclusao() {
		return ts_exclusao;
	}

	public void setTs_exclusao(Date ts_exclusao) {
		this.ts_exclusao = ts_exclusao;
	}
}
