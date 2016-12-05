package br.ufg.inf.sempreufg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.ufg.inf.sempreufg.modelo.Log;
/**
 * 
 * @author Kleudson
 * @version 1.0
 */
public class LogDao {

    private Connection con;

    public LogDao(Connection con) throws NullPointerException {
        if (con == null) {
            throw new NullPointerException("Não é permitido informar parâmetro de conexão nulo.");
        }
        this.con = con;
    }

    /**
     * Adiciona um log ao banco de dados
     * @param log 
     */
    
    public void salvarLog(Log log) {
        StringBuilder sql = new StringBuilder();

        sql.append("insert into log (id_log, mensagem, usuario, tipo) ");
        sql.append("values(?, ?, ?, ?)");

        PreparedStatement preparedStatement;
        try {
            preparedStatement = this.con.prepareStatement(sql.toString());
            preparedStatement.setInt(1, log.getIdLog());
            preparedStatement.setString(2, log.getMensagem());
            preparedStatement.setString(3, log.getUsuario());
            preparedStatement.setInt(4, log.getTipoLog());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Remove um log do banco de dados
     * @param log 
     */
    public void removerLog(Log log) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from log where id_log = ?");

        PreparedStatement preparedStatement;
        try {

            preparedStatement = this.con.prepareStatement(sql.toString());
            preparedStatement.setInt(1, log.getIdLog());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna um log através do ID
     * 
     * @param idLog
     * @return 
     */
    public Log consultaLog(int idLog) {
        try {
            Log log = null;
            StringBuilder sql = new StringBuilder();
            sql.append("select * from log where id_log = ? ");                    
            PreparedStatement preparedStatement;

            preparedStatement = this.con.prepareStatement(sql.toString());
            preparedStatement.setInt(1, idLog);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                log = new Log();
                log.setIdLog(resultSet.getInt("id_log"));
                log.setMensagem(resultSet.getString("mensagem"));
                log.setTipoLog(resultSet.getInt("tipo"));
                log.setUsuario(resultSet.getString("usuario"));                
            }

            return log;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Log> consultaLogs() {
        List<Log> logs = new ArrayList<Log>();

        StringBuilder sql = new StringBuilder();
        sql.append("select * from log");              

        PreparedStatement preparedStatement;
        try {
            preparedStatement = this.con.prepareStatement(sql.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Log log = new Log();
                log.setIdLog(resultSet.getInt("id_log"));
                log.setMensagem(resultSet.getString("mensagem"));
                log.setTipoLog(resultSet.getInt("tipo"));
                log.setUsuario(resultSet.getString("usuario"));

                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return logs;
    }

}
