package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.interfaces.AtributoDAOInterface;
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
public class AtributoDAO implements AtributoDAOInterface {

    private Connection connection;
    private String lineSeparator;
    private ConfiguraAtualizacaoEgressoDAO configuraAtualizacaoEgressoDAO;

    public AtributoDAO() {
        lineSeparator = System.lineSeparator();
        this.connection = ConexaoBanco.getConnection();
        configuraAtualizacaoEgressoDAO = new ConfiguraAtualizacaoEgressoDAO();
    }

    @Override
    public Atributo salvar(Atributo atributo) {
        if (atributo == null){
            return null;
        }

        String scripSQL = "INSERT INTO atributo(" + lineSeparator +
            "nome_atributo, identificador_interno, titulo_da_questao," + lineSeparator +
            "titulo_do_campo, atributo_sucessor)" + lineSeparator +
            "VALUES (?, ?, ?, ?, ?);";
        return executeQuery(scripSQL,atributo);
    }

    @Override
    public Atributo alterar(Atributo atributo) {
        if (atributo == null){
            return null;
        }

        String scripSQL = "UPDATE atributo" + lineSeparator +
            "SET nome_atributo=?, identificador_interno=?, titulo_da_questao=?," + lineSeparator +
            "titulo_do_campo=?, atributo_sucessor=?" + lineSeparator +
            "WHERE nome_atributo = '" + atributo.getNomeDoAtributo() + "';";
        return executeQuery(scripSQL,atributo);
    }

    @Override
    public Boolean deletar(Atributo atributo) {
        if (atributo == null){
            return null;
        }

        String scripSQL = "DELETE FROM atributo" + lineSeparator +
            "	WHERE nome_atributo=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(1,atributo.getNomeDoAtributo());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Atributo getById(String id) {
        if ((id == null) || ("".equals(id))){
            return null;
        }

        try {
            String scripSQL = "SELECT nome_atributo, identificador_interno, titulo_da_questao," + lineSeparator +
                " titulo_do_campo, atributo_sucessor" + lineSeparator +
                "FROM atributo" + lineSeparator +
                "WHERE nome_atributo = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(1, id);
            return criaAtributo(preparedStatement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Atributo> getAll() {
        try {
            String scripSQL = "SELECT nome_atributo, identificador_interno, titulo_da_questao," + lineSeparator +
                " titulo_do_campo, atributo_sucessor" + lineSeparator +
                "FROM atributo;";
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            return criaAtributos(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteAll(){
        String scripSQL = "delete from atributo;";
        return configuraAtualizacaoEgressoDAO.executeSciptDelete(scripSQL);
    }

    private Atributo executeQuery(String scripSQL, Atributo atributo){
        int i=1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.setString(i++,atributo.getNomeDoAtributo());
            preparedStatement.setString(i++,atributo.getId());
            preparedStatement.setString(i++,atributo.getTituloDaQuestao());
            preparedStatement.setString(i++,atributo.getTituloDoCampo());
            preparedStatement.setString(i++,buscaIdAntecedente(atributo.getAtributoAntecedente()));
            preparedStatement.execute();
            return atributo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String buscaIdAntecedente(Atributo atributo){
        if (atributo == null) {
            return null;
        }
        return atributo.getNomeDoAtributo();
    }

    private Atributo criaAtributo(ResultSet resultSet){
        try {
            if(resultSet.next()){
                Atributo atributo = new Atributo();
                atributo.setNomeDoAtributo(resultSet.getString("nome_atributo"));
                atributo.setId(resultSet.getString("identificador_interno"));
                atributo.setTituloDaQuestao(resultSet.getString("titulo_da_questao"));
                atributo.setTituloDoCampo(resultSet.getString("titulo_do_campo"));
                atributo.setAtributoAntecedente(getById(resultSet.getString("atributo_sucessor")));
                atributo.setValorAtributoDeOrigem(
                    configuraAtualizacaoEgressoDAO.
                        getAtributoDesviaParaAtributoValorAtributoAnterior(atributo.getNomeDoAtributo()));
                atributo.setDesviaPara(
                    getById(
                        configuraAtualizacaoEgressoDAO.
                            getAtributoDesviaParaAtributoAtributo(atributo.getNomeDoAtributo())));
                return atributo;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Atributo> criaAtributos(ResultSet resultSet){
        List<Atributo> atributos = new ArrayList<>();
        try {
            while (resultSet.next()){
                Atributo atributo = new Atributo();
                atributo.setNomeDoAtributo(resultSet.getString("nome_atributo"));
                atributo.setId(resultSet.getString("identificador_interno"));
                atributo.setTituloDaQuestao(resultSet.getString("titulo_da_questao"));
                atributo.setTituloDoCampo(resultSet.getString("titulo_do_campo"));
                atributo.setAtributoAntecedente(getById(resultSet.getString("atributo_sucessor")));
                atributos.add(atributo);
                atributo.setValorAtributoDeOrigem(
                    configuraAtualizacaoEgressoDAO.
                        getAtributoDesviaParaAtributoValorAtributoAnterior(atributo.getNomeDoAtributo()));
                atributo.setDesviaPara(
                    getById(
                        configuraAtualizacaoEgressoDAO.
                            getAtributoDesviaParaAtributoAtributo(atributo.getNomeDoAtributo())));
            }
            return atributos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
