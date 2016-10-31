package br.ufg.inf.interfaces;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;

public interface AprovDivulgInfoDAOInterface {

	public boolean salvaAprovacao(boolean divulgacao_aprovada, String parecer_sobre_divulgacao,
			Date data_aprovacao_ou_rejeicao, int evento_id, int usuario_id);

	boolean salvaUsuario(String email_principal, String senha_criptografada, String nome, int cpf, InputStream foto,
			String recebe_divulgacao, Timestamp timestamp_de_cadastramento, Timestamp timestamp_de_ultima_atualizacao,
			Timestamp timestamp_de_exclusao_logica, int instancia_administrativa);

	boolean salvaEvento(String assunto, String tipo, String descricao, Timestamp data_solicita_divulgacao,
			String solicitante_divulgacao, String solicitante_email, String forma_divulgacao, String escopo_divulgacao,
			Date data_expiracao);

	boolean salvaInstancia(String sigla_instancia, String nome_instancia, String tipo_instancia, Date data_criacao,
			Date data_encerra, String email_institucional, String url_institucional);

	boolean salvaArea_Conhecimento(String nome, int codigo, int area_conhecimento);

	public ResultSet buscaAprovacao();
	public ResultSet buscaUsuario(int cpf);
	public ResultSet buscaEvento();
	public ResultSet buscaArea_Conhecimento();
	public ResultSet buscaInstancia();

	public Connection abreConexao();
	public void truncateAll();
	public void populateDb();


}
