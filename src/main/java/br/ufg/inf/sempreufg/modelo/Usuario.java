package br.ufg.inf.sempreufg.modelo;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.List;

import br.ufg.inf.sempreufg.enums.PoliticaRecebimentoMensagens;

public class Usuario {

    private final int ID_USER = 0;
    private String mail;
    private String senha;
    private String nome;
    private long cpf;
    private BitSet foto = new BitSet();
    private PoliticaRecebimentoMensagens tipoDivulgacao = PoliticaRecebimentoMensagens.CADA_EVENTO;
    private Date ts_cadastramento;
    private Date ts_ult_update;
    private Date ts_exclusao;

	private List<Papel> listaPapel;

    public PoliticaRecebimentoMensagens getTipoDivulgacao() {
        return tipoDivulgacao;
    }

    public void DefinirPolitRecebMsg(PoliticaRecebimentoMensagens tipoDivulgacao) {
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
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

    public boolean validarUsuario(String email, String senha) {
        return senha.equals("senha");
    }

    public List<Papel> getListaPapel() {
        if (this.listaPapel == null) {
            this.listaPapel = new ArrayList<Papel>();
        }
        return this.listaPapel;
    }

    public void setListaPapel(List<Papel> listaPapel) {
        this.listaPapel = listaPapel;
    }

    public static boolean validarCpf(long cpf) {

		String str_cpf = String.valueOf(cpf);

		while (str_cpf.length() < 11) {

			str_cpf = "0" + str_cpf;

		}

		String cpf_completo = str_cpf;

		str_cpf = str_cpf.substring(0, 9);
		char dig10, dig11;
		int sm, i, r, num, peso;

		sm = 0;
		peso = 10;
		for (i = 0; i <= 8; i++) {
			num = (int) (str_cpf.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11))
			dig10 = '0';
		else
			dig10 = (char) (r + 48);

		sm = 0;
		peso = 11;
		str_cpf = str_cpf + dig10;
		for (i = 0; i <= 9; i++) {
			num = (int) (str_cpf.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11))
			dig11 = '0';
		else
			dig11 = (char) (r + 48);

		str_cpf = str_cpf + dig11;

		if (dig10 == cpf_completo.charAt(9) && dig11 == cpf_completo.charAt(10) && cpf_completo.equals(str_cpf)) {

			return true;

		}

		return false;
	}
}
