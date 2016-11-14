package br.ufg.inf.interfaces;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;

public interface AprovDivulgInfoDAOInterface  {

	public boolean salvaAprovacao(boolean divulgacao_aprovada, String parecer_sobre_divulgacao,
			Date data_aprovacao_ou_rejeicao, int evento_id, int usuario_id)throws Exception;

	boolean salvaUsuario(String email_principal, String senha_criptografada, String nome, long cpf, byte[] foto,
			String recebe_divulgacao, Timestamp timestamp_de_cadastramento, Timestamp timestamp_de_ultima_atualizacao,
			Timestamp timestamp_de_exclusao_logica, int instancia_administrativa)throws Exception;

	boolean salvaEvento(String assunto, String tipo, String descricao, Timestamp data_solicita_divulgacao,
			String solicitante_divulgacao, String solicitante_email, String forma_divulgacao, String escopo_divulgacao,
			Date data_expiracao)throws Exception;

	boolean salvaInstancia(String sigla_instancia, String nome_instancia, String tipo_instancia, Date data_criacao,
			Date data_encerra, String email_institucional, String url_institucional)throws Exception;

	boolean salvaArea_Conhecimento(String nome, int codigo, int area_conhecimento)throws Exception;

	public ResultSet buscaAprovacao(int evento_id);
	public ResultSet buscaUsuario(long cpf);
	public ResultSet buscaEvento(String assunto);
	public ResultSet buscaArea_Conhecimento(String nome_area);
	public ResultSet buscaInstancia(String sigla);

	public Connection abreConexao();
	public void truncateAll();
	public void populateDb() throws Exception;


}
