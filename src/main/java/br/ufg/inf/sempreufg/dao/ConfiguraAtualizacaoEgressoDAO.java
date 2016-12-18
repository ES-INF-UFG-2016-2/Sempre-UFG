package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.modelo.Atributo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 15/12/2016.
 */
public class ConfiguraAtualizacaoEgressoDAO {

    private Connection connection;
    private String lineSeparator;

    public ConfiguraAtualizacaoEgressoDAO() {
        lineSeparator = System.lineSeparator();
        connection = ConexaoBanco.getConnection();
    }

    public boolean gravarReferenciasAtributosEntidades(String idEntidade, String idAtributo){
        String scripSQL = "INSERT INTO atributos_contidos_por_entidades(" + lineSeparator +
            "nome_entidade, nome_atributo)" + lineSeparator +
            "VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(1,idEntidade);
            preparedStatement.setString(2,idAtributo);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getReferenciasAtributosEntidades(String idEntidade){
        List<String> referencias = new ArrayList<>();
        String scripSQL = "select nome_atributo" + lineSeparator +
            "from atributos_contidos_por_entidades" + lineSeparator +
            "where nome_entidade = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(1,idEntidade);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                referencias.add(resultSet.getString("nome_atributo"));
            }
            return referencias;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deletaReferenciasAtributosEntidades(){
        String scripSQL = "delete from atributos_contidos_por_entidades;";
        return executeSciptDelete(scripSQL);
    }

    public boolean gravarAtributoDesviaParaAtributo(Atributo atributo){
        String scripSQL = "INSERT INTO atributo_desvia_para_atributo(" + lineSeparator +
            "atributo_origem, atributo_destino, valor_atributo_origem)" + lineSeparator +
            "VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(1,atributo.getNomeDoAtributo());
            preparedStatement.setString(2,atributo.getDesviaPara().getNomeDoAtributo());
            preparedStatement.setString(3,atributo.getValorAtributoDeOrigem());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getAtributoDesviaParaAtributoAtributo(String idAtributo){
        return getAtributoDesviaParaAtributo("atributo_destino",idAtributo);
    }

    public String getAtributoDesviaParaAtributoValorAtributoAnterior(String idAtributo){
        return getAtributoDesviaParaAtributo("valor_atributo_origem",idAtributo);
    }

    public boolean deletaAtributoDesviaParaAtributo(){
        String scripSQL = "delete from atributo_desvia_para_atributo;";
        return executeSciptDelete(scripSQL);
    }

    public boolean executeSciptDelete(String scripSQL){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getAtributoDesviaParaAtributo(String fieldName, String idAtributo){
        String scripSQL = "select " + fieldName + lineSeparator +
            "from atributo_desvia_para_atributo" + lineSeparator +
            "where atributo_origem = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(1,idAtributo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return  resultSet.getString(fieldName);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
