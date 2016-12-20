package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.interfaces.EntidadeDAOInterface;
import br.ufg.inf.sempreufg.modelo.Atributo;
import br.ufg.inf.sempreufg.modelo.Entidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 15/12/2016.
 */
public class EntidadeDAO implements EntidadeDAOInterface {

    private Connection connection;
    private String lineSeparator;
    ConfiguraAtualizacaoEgressoDAO configuraAtualizacaoEgressoDAO;

    public EntidadeDAO() {
        lineSeparator = System.lineSeparator();
        this.connection = ConexaoBanco.getConnection();
        configuraAtualizacaoEgressoDAO = new ConfiguraAtualizacaoEgressoDAO();
    }

    @Override
    public Entidade salvar(Entidade entidade) {
        if (entidade == null){
            return null;
        }

        String scripSQL = "INSERT INTO entidade(" + lineSeparator +
            "nome_entidade, id_interno, titulo_grupo_questoes," + lineSeparator +
            "titulo_grupo_campos, entidade_sucessora, atributo)" + lineSeparator +
            "VALUES (?,?,?,?,?,?);";
        return executeQuery(scripSQL,entidade);
    }

    @Override
    public Entidade alterar(Entidade entidade) {
        if (entidade == null){
            return null;
        }

        String scripSQL = "UPDATE entidade" + lineSeparator +
            "SET nome_entidade=?, id_interno=?, titulo_grupo_questoes=?," + lineSeparator +
            "titulo_grupo_campos=?, entidade_sucessora=?, atributo=?" + lineSeparator +
            "WHERE nome_entidade = '" + entidade.getNome() + "';";
        return executeQuery(scripSQL,entidade);
    }

    @Override
    public Boolean deletar(Entidade entidade) {
        if (entidade == null){
            return null;
        }

        String scripSQL = "DELETE FROM entidade" + lineSeparator +
            "	WHERE nome_entidade=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(1,entidade.getNome());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Entidade getById(String id) {
        if ((id == null) || ("".equals(id))){
            return null;
        }

        try {
            String scripSQL = "SELECT nome_entidade, id_interno, titulo_grupo_questoes," + lineSeparator +
                "titulo_grupo_campos, entidade_sucessora, atributo" + lineSeparator +
                "FROM entidade" + lineSeparator +
                "WHERE nome_entidade = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(1, id);
            return criaEntidade(preparedStatement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Entidade> getAll() {
        try {
            String scripSQL = "SELECT nome_entidade, id_interno, titulo_grupo_questoes," + lineSeparator +
                "titulo_grupo_campos, entidade_sucessora, atributo" + lineSeparator +
                "FROM entidade;";
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            return criaEntidades(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteAll(){
        ConfiguraAtualizacaoEgressoDAO configuraAtualizacaoEgressoDAO = new ConfiguraAtualizacaoEgressoDAO();
        String scripSQL = "delete from entidade;";
        return configuraAtualizacaoEgressoDAO.executeSciptDelete(scripSQL);
    }

    public Entidade buscaSucessor(Entidade entidade){
        try {
            String scripSQL = "SELECT nome_entidade, id_interno, titulo_grupo_questoes," + lineSeparator +
                "titulo_grupo_campos, entidade_sucessora, atributo" + lineSeparator +
                "FROM entidade" + lineSeparator +
                "WHERE entidade_sucessora = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(1, entidade.getNome());
            return criaEntidade(preparedStatement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Entidade executeQuery(String scripSQL, Entidade entidade){
        int i=1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(i++,entidade.getNome());
            preparedStatement.setString(i++,entidade.getId());
            preparedStatement.setString(i++,entidade.getTituloDoGrupoDeQuestoes());
            preparedStatement.setString(i++,entidade.getTituloDoGrupoDeCampos());
            preparedStatement.setString(i++,buscaIdAntecedente(entidade.getEntidadeAntecedente()));
            preparedStatement.setString(i++,null);
            preparedStatement.execute();
            return entidade;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String buscaIdAntecedente(Entidade entidade){
        if (entidade == null) {
            return null;
        }
        return entidade.getNome();
    }

     private Entidade criaEntidade(ResultSet resultSet){
         try {
             if(resultSet.next()){
                 Entidade entidadeResult = new Entidade();
                 entidadeResult.setNome(resultSet.getString("nome_entidade"));
                 entidadeResult.setId(resultSet.getString("id_interno"));
                 entidadeResult.setTituloDoGrupoDeQuestoes(resultSet.getString("titulo_grupo_questoes"));
                 entidadeResult.setTituloDoGrupoDeCampos(resultSet.getString("titulo_grupo_campos"));
                 entidadeResult.setEntidadeAntecedente(getById(resultSet.getString("entidade_sucessora")));
                 entidadeResult.setAtributos(buscaAtributos(resultSet.getString("nome_entidade")));
                 return entidadeResult;
             }
             return null;
         } catch (SQLException e) {
             e.printStackTrace();
             return null;
         }
    }

    private List<Entidade> criaEntidades(ResultSet resultSet){
        List<Entidade> entidades = new ArrayList<>();
        try {
            while (resultSet.next()){
                Entidade entidadeResult = new Entidade();
                entidadeResult.setNome(resultSet.getString("nome_entidade"));
                entidadeResult.setId(resultSet.getString("id_interno"));
                entidadeResult.setTituloDoGrupoDeQuestoes(resultSet.getString("titulo_grupo_questoes"));
                entidadeResult.setTituloDoGrupoDeCampos(resultSet.getString("titulo_grupo_campos"));
                entidadeResult.setEntidadeAntecedente(getById(resultSet.getString("entidade_sucessora")));
                entidadeResult.setAtributos(buscaAtributos(resultSet.getString("nome_entidade")));
                entidades.add(entidadeResult);
            }
            return entidades;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Atributo> buscaAtributos(String idEntidade){
        ConfiguraAtualizacaoEgressoDAO configuraAtualizacaoEgressoDao = new ConfiguraAtualizacaoEgressoDAO();
        AtributoDAO atributoDAO = new AtributoDAO();
        List<String> referencias = configuraAtualizacaoEgressoDao.getReferenciasAtributosEntidades(idEntidade);

        if (referencias == null){
            return null;
        }

        List<Atributo> atributos = new ArrayList<>();
        for (String s : referencias) {
            atributos.add(atributoDAO.getById(s));
        }

        return atributos;
    }
}
