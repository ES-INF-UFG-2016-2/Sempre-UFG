package br.ufg.inf.sempreufg.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import br.ufg.inf.sempreufg.enums.PoliticaRecebimentoMensagens;
import org.json.JSONObject;

public class Usuario {

    private int idUsuario;
    private String mail;
    private String senha;
    private String nome;
    private long cpf;
    private BitSet foto;
    private PoliticaRecebimentoMensagens tipoDivulgacao;
    private Date ts_cadastramento;
    private Date ts_ult_update;
    private Date ts_exclusao;

	private List<Papel> listaPapel;

    public Usuario(){}

    public Usuario(String mail, String senha, String nome, long cpf, BitSet foto, PoliticaRecebimentoMensagens tipoDivulgacao, Date ts_cadastramento, Date ts_ult_update, Date ts_exclusao, List<Papel> listaPapel) {
        this.mail = mail;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.foto = foto;
        this.tipoDivulgacao = tipoDivulgacao;
        this.ts_cadastramento = ts_cadastramento;
        this.ts_ult_update = ts_ult_update;
        this.ts_exclusao = ts_exclusao;
        this.listaPapel = listaPapel;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setTipoDivulgacao(PoliticaRecebimentoMensagens tipoDivulgacao) {
        this.tipoDivulgacao = tipoDivulgacao;
    }

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
        return new ArrayList<>(this.listaPapel);
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

        return dig10 == cpf_completo.charAt(9) && dig11 == cpf_completo.charAt(10) && cpf_completo.equals(str_cpf);

    }

    private JSONObject getListaPapelAsJson() {
        JSONObject listaPapelAsJsonObj = new JSONObject();
        this.listaPapel.forEach(papel -> listaPapelAsJsonObj.put(Integer.toString(papel.getIdPapel()), papel.toJSON()));
        return listaPapelAsJsonObj;
    }

    public JSONObject toJSON(){

        JSONObject usuarioAsJsonObj = new JSONObject();
        JSONObject innerJson = new JSONObject();
        DateFormat formatter = new SimpleDateFormat("dd/mm/yy");

        innerJson.put("email", getMail());
        innerJson.put("senha", getSenha());
        innerJson.put("nome", getNome());
        innerJson.put("cpf", getSenha());
        innerJson.put("tipoDivulgacao", getTipoDivulgacao());
        innerJson.put("ts_cadastramento", formatter.format(getTs_cadastramento()));
        innerJson.put("ts_ult_update", formatter.format(getTs_ult_update()));
        innerJson.put("ts_exclusao", formatter.format(getTs_exclusao()));
        innerJson.put("listaPapeis", getListaPapelAsJson());

        usuarioAsJsonObj.put(Integer.toString(getIdUsuario()), innerJson);

        return usuarioAsJsonObj;
    }

    public static Usuario fromJSON(JSONObject usuarioAsJson) throws ParseException {

        DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
        List<Papel> listaPapeis = new ArrayList<>();

        usuarioAsJson.getJSONObject("listaPapeis").names().forEach(papelAsJsonObj -> {
                listaPapeis.add(Papel.fromJSON((JSONObject) papelAsJsonObj));
            }
        );

        return new Usuario(
            usuarioAsJson.getString("email"),
            usuarioAsJson.getString("senha"),
            usuarioAsJson.getString("nome"),
            Long.parseLong(usuarioAsJson.getString("cpf")),
            new BitSet(), // Necessário uma forma de recuperar esse dado em JSON
            PoliticaRecebimentoMensagens.valueOf(usuarioAsJson.getString("tipoDivulgacao")),
            format.parse(usuarioAsJson.getString("ts_cadastramento")),
            format.parse(usuarioAsJson.getString("ts_ult_update")),
            format.parse(usuarioAsJson.getString("ts_exclusao")),
            listaPapeis
        );
    }

}
