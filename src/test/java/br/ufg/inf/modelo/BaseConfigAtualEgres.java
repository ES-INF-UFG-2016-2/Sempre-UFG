package br.ufg.inf.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;

import br.ufg.inf.db.ConexaoBanco;
import br.ufg.inf.modelo.Atributo;
import br.ufg.inf.modelo.Entidade;

public class BaseConfigAtualEgres {
	
	public static final String TITULO_GRUPO_QUESTOES = "Titulo Grupo Default";
	
	public static final String TITULO_GRUPO_CAMPOS = "Titulo Campos Default";
	
	 @BeforeClass
    public static void runOnceBeforeClass() throws SQLException {
		 limpaBancoParaTestes();
    }	
	 
	public Entidade JSONToEntidade(JSONObject entidadeJSON) throws JSONException{
		Entidade entidade = new Entidade();
		entidade.setNome(entidadeJSON.getString("nome"));
		entidade.setTituloGrupoDeQuestoes(entidadeJSON.getString("tituloGrupoQuestoes"));
		entidade.setTituloGrupoDeCampos(entidadeJSON.getString("tituloGrupoCampos"));
		entidade.setAntecessor(entidadeJSON.getInt("antecessor"));
		
		return entidade;
	}
	
	public Atributo JSONToAtributo(JSONObject atributoJSON) throws JSONException{
		Atributo atributo = new Atributo();
		atributo.setNome(atributoJSON.getString("nome"));
		atributo.setTituloDaQuestao(atributoJSON.getString("tituloGrupoQuestoes"));
		atributo.setTituloDoCampo(atributoJSON.getString("tituloGrupoCampos"));
		atributo.setAntecessor(atributoJSON.getInt("antecessor"));
		
		return atributo;
	}

	public JSONObject criaEntidadeJSON(String nomeEntidade,	Integer antecessor) throws JSONException{
		JSONObject entidade = new JSONObject();
		entidade.put("nome", nomeEntidade);
		entidade.put("tituloGrupoQuestoes", TITULO_GRUPO_QUESTOES);
		entidade.put("tituloGrupoCampos", TITULO_GRUPO_CAMPOS);
		
		if(antecessor != null){
			entidade.put("antecessor", antecessor);
		}else{
			entidade.put("antecessor", "0");
		}
		
		return entidade;
	}
	
	public JSONObject criaAtributoJSON(String nomeAtributo,	Integer antecessor) throws JSONException{
		JSONObject atributo = new JSONObject();
		atributo.put("nome", nomeAtributo);
		atributo.put("tituloGrupoQuestoes", TITULO_GRUPO_QUESTOES);
		atributo.put("tituloGrupoCampos", TITULO_GRUPO_CAMPOS);
		
		if(antecessor != null){
			atributo.put("antecessor", antecessor);
		}else{
			atributo.put("antecessor", "0");
		}
		
		return atributo;
	}
	
	public JSONArray retornaEntradaEntidadeAtributoJSONValido() throws JSONException{
		JSONArray entidades = new JSONArray();
		
		//Entidade / Atributos referentes a Entidade 1
		JSONObject entidade1 = criaEntidadeJSON("Entidade 1", null);
		
		JSONArray atributos1 = new JSONArray();
		JSONObject atributo1 = criaAtributoJSON("Atributo 1", null);
		JSONObject atributo2 = criaAtributoJSON("Atributo 2", 1);
		JSONObject atributo3 = criaAtributoJSON("Atributo 3", 2);
		
		atributos1.put(atributo1);
		atributos1.put(atributo2);
		atributos1.put(atributo3);
		
		entidade1.put("atributos", atributos1);
		
		
		//Entidade - Atributos referentes a Entidade 2
		JSONObject entidade2 = criaEntidadeJSON("Entidade 2", 1);
		
		JSONArray atributos2 = new JSONArray();
		
		atributos2.put(atributo1);
		atributos2.put(atributo2);
		atributos2.put(atributo3);
		
		entidade2.put("atributos", atributos2);
		
		//Entidade - Atributos referentes a Entidade 3
		JSONObject entidade3 = criaEntidadeJSON("Entidade 3", 2);
		
		JSONArray atributos3 = new JSONArray();
		
		atributos3.put(atributo1);
		atributos3.put(atributo2);
		atributos3.put(atributo3);
		
		entidade3.put("atributos", atributos3);
		
		entidades.put(entidade1);
		entidades.put(entidade2);
		entidades.put(entidade3);
		
		return entidades;
	}
	
	public JSONArray retornaEntradaEntidadeAtributoJSONInValido() throws JSONException{
		JSONArray entidades = new JSONArray();
		
		//Entidade / Atributos referentes a Entidade 1
		JSONObject entidade1 = criaEntidadeJSON("Entidade 1", null);
		
		JSONArray atributos1 = new JSONArray();
		JSONObject atributo1 = criaAtributoJSON("Atributo 1", null);
		JSONObject atributo2 = criaAtributoJSON("Atributo 2", 1);
		JSONObject atributo3 = criaAtributoJSON("Atributo 3", 2);
		
		atributos1.put(atributo1);
		atributos1.put(atributo2);
		atributos1.put(atributo3);
		
		entidade1.put("atributos", atributos1);
		
		
		//Entidade - Atributos referentes a Entidade 2
		JSONObject entidade2 = criaEntidadeJSON("Entidade 2", 1);
		
		JSONArray atributos2 = new JSONArray();
		
		atributo2 = criaAtributoJSON("Atributo 2", 1);
		atributo3 = criaAtributoJSON("Atributo 3", 1);
		
		atributos2.put(atributo1);
		atributos2.put(atributo2);
		atributos2.put(atributo3);
		
		entidade2.put("atributos", atributos2);
		
		//Entidade - Atributos referentes a Entidade 3
		JSONObject entidade3 = criaEntidadeJSON("Entidade 3", 1);
		
		JSONArray atributos3 = new JSONArray();
		
		atributos3.put(atributo1);
		atributos3.put(atributo2);
		atributos3.put(atributo3);
		
		entidade3.put("atributos", atributos3);
		
		entidades.put(entidade1);
		entidades.put(entidade2);
		entidades.put(entidade3);
		
		return entidades;
	}
	
	public List<Entidade> entidadesJSONTOEntidade(JSONArray entidadesJSON) throws JSONException{
		List<Entidade> entidades = new ArrayList();
		
		for(int i = 0; i < entidadesJSON.length(); i++){
			
			JSONObject entidadeJSON = entidadesJSON.getJSONObject(i);
			Entidade entidade = JSONToEntidade(entidadeJSON);
			List<Atributo> atributos = new ArrayList();
			for(int j = 0 ; j < entidadeJSON.getJSONArray("atributos").length() ; j++){
				
				Atributo atributo = JSONToAtributo(entidadeJSON.getJSONArray("atributos").getJSONObject(j));
				atributos.add(atributo);
			}
			
			entidade.setAtributos(atributos);
			
			entidades.add(entidade);
		}
		
		return entidades;
	}
	
	public Integer inserirEntidade(Entidade entidade) throws SQLException {
		Statement stmt = null;

		stmt = ConexaoBanco.getConnection().createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into entidade(id_entidade,nome,");
		sql.append("titulo_grupo_questoes,titulo_grupo_campos,antecessor_id) values (nextval('id_entidade_seq'),?,?,?,?) ");

		PreparedStatement preparedStatement = ConexaoBanco.getConnection().prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, entidade.getNome()); 
		preparedStatement.setString(2, entidade.getTituloGrupoDeQuestoes());
		preparedStatement.setString(3, entidade.getTituloGrupoDeCampos()); 
		
		if(entidade.getAntecessor() != null){
			preparedStatement.setInt(4, entidade.getAntecessor());
		}else{
			preparedStatement.setNull(4, Types.FLOAT);
		}
		
		preparedStatement.executeUpdate();
		
		 ResultSet rs = preparedStatement.getGeneratedKeys();
		 Integer id_entidade = null;
         if(rs.next())
         {
        	 id_entidade = rs.getInt(1);
         }

		return id_entidade;
	}
	
	public Integer inserirAtributo(Atributo atributo) throws SQLException {
		Statement stmt = null;

		stmt = ConexaoBanco.getConnection().createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into atributo(id_atributo,nome,");
		sql.append("titulo_questao,titulo_campo,antecessor_id,entidade_id) values (nextval('id_atributo_seq'),?,?,?,?,?) ");

		PreparedStatement preparedStatement = ConexaoBanco.getConnection().prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, atributo.getNome()); 
		preparedStatement.setString(2, atributo.getTituloDaQuestao());
		preparedStatement.setString(3, atributo.getTituloDoCampo()); 
		
		if(atributo.getAntecessor() != null){
			preparedStatement.setInt(4, atributo.getAntecessor());
		}else{
			preparedStatement.setNull(4, Types.FLOAT);
		}
		
		if(atributo.getEntidade() != null){
			preparedStatement.setInt(5, atributo.getEntidade());
		}else{
			preparedStatement.setNull(5, Types.FLOAT);
		}
		
		preparedStatement.executeUpdate();
		
		 ResultSet rs = preparedStatement.getGeneratedKeys();
		 Integer id_atributo = null;
         if(rs.next())
         {
        	 id_atributo = rs.getInt(1);
         }

		return id_atributo;
	}
	
	public List<Entidade> listarTodasEntidades() throws Exception {
		String sql = "SELECT id_entidade,nome,titulo_grupo_questoes,titulo_grupo_campos,antecessor_id from entidade";
		List<Entidade> listAll = new ArrayList();
		Entidade entidade;
		Statement stm =null;
		ResultSet rs = null;
		try {
			Connection con = ConexaoBanco.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				entidade = new Entidade();
				entidade.setId(rs.getInt("id_entidade"));
				entidade.setNome(rs.getString("nome"));
				entidade.setTituloGrupoDeQuestoes(rs.getString("titulo_grupo_questoes"));
				entidade.setTituloGrupoDeCampos(rs.getString("titulo_grupo_campos"));
				entidade.setAntecessor(rs.getInt("antecessor_id"));;
				listAll.add(entidade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();
			stm.close();
		}
		return listAll;
	}
	
	public List<Atributo> listarTodosAtributos(Integer idEntidade) {
		StringBuilder sql = new StringBuilder("SELECT id_atributo,nome,titulo_questao,titulo_campo,antecessor_id,entidade_id ");
		sql.append("  from atributo where entidade_id = " + idEntidade);
		List<Atributo> listAll = new ArrayList();
		Atributo atributo;
		try {
			Connection con = ConexaoBanco.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			while (rs.next()) {
				atributo = new Atributo();
				atributo.setId(rs.getInt("id_atributo"));
				atributo.setNome(rs.getString("nome"));
				atributo.setTituloDaQuestao("titulo_questao");
				atributo.setTituloDoCampo("titulo_campo");
				atributo.setAntecessor(rs.getInt("antecessor_id"));
				atributo.setEntidade(rs.getInt("entidade_id"));
				listAll.add(atributo);
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listAll;
	}

	private static void limpaBancoParaTestes() throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		
		stm.execute("delete from atributo");
		stm.execute("delete from entidade");
	}
}
