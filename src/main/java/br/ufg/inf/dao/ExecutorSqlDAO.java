/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import br.ufg.inf.db.ConexaoBanco;

/**
 *
 * @author Kalyn
 */
public class ExecutorSqlDAO {
    public static boolean executarSQL(String sql) {
        try {
            Connection con = ConexaoBanco.getConnection();

            Statement stm = con.createStatement();

            Boolean retorno = stm.execute(sql);

            con.close();
            return retorno;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Executa um comando SQL esperando um ResultSset. 
    //Retorna o casting para Sting do valor contido na coluna colunaRetorno, caso exista
    public static String executarSqlComRetorno(String sql, String colunaRetorno) {
        String retorno = "";
        try {
            Connection con = ConexaoBanco.getConnection();

            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(sql);

            if (resultado.next()) {
                retorno = (String) resultado.getString(colunaRetorno);
            } else {
                retorno = "Nenhum Resultado";
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            retorno = "erro";
        }
        return retorno;

    }
}
