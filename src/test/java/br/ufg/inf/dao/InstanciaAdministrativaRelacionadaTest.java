/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.dao;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Kalyn
 */
public class InstanciaAdministrativaRelacionadaTest {
    @Before
    public void preparacao(){
        String sql = "DELETE FROM EVENTO;";
        ExecutorSqlDAO.executarSQL(sql);
        sql = "DELETE FROM INSTANCIA_ADMINISTRATIVA_UFG VALUES;";
        ExecutorSqlDAO.executarSQL(sql);
        sql = "DELETE FROM EVENTO_INTERESSA_A_INSTANCIA";
        ExecutorSqlDAO.executarSQL(sql);
        
        sql = "INSERT INTO INSTANCIA_ADMINISTRATIVA_UFG VALUES (\'Sigla\',"
                + " \'Nome\', \'REGIONAL\', \'20-10-2015\', \'20-10-2017\',"
                + " \'Email\', \'URL Institucional\')";
        ExecutorSqlDAO.executarSQL(sql);
        
        sql = "INSERT INTO EVENTO VALUES (1, \'Teste 4\', \'NOTICIA\',"
                + " \'Instancia Administrativa Interessada\', \'20-10-2016 10:20:00\',"
                + " \'Edmundo Sergio Spoto\', \'edmundo@inf.ufg.br\', \'NOTICIA\',"
                + " \'COMUNIDADE\', \'20-10-2017\')";
        ExecutorSqlDAO.executarSQL(sql);
        
        //Para Area Duplicada
        sql = "INSERT INTO INSTANCIA_ADMINISTRATIVA_UFG VALUES (\'Sigla2\', \'Nome\', \'REGIONAL\', \'20-10-2015\', \'20-10-2017\', \'Email\', \'URL Institucional\')";
        ExecutorSqlDAO.executarSQL(sql);
        sql = "INSERT INTO EVENTO_INTERESSA_A_INSTANCIA VALUES (1, \'Sigla2\')";
        ExecutorSqlDAO.executarSQL(sql);
        
    }
    
    @After
    public void conclusao(){
        String sql = "DELETE FROM EVENTO;";
        ExecutorSqlDAO.executarSQL(sql);
        sql = "DELETE FROM INSTANCIA_ADMINISTRATIVA_UFG VALUES;";
        ExecutorSqlDAO.executarSQL(sql);
        sql = "DELETE FROM EVENTO_INTERESSA_A_INSTANCIA";
        ExecutorSqlDAO.executarSQL(sql);
    }
    
    @Test
    public void testCamposValidos() {
        String sqlTesteObjetivo = "INSERT INTO EVENTO_INTERESSA_A_INSTANCIA VALUES (1, \'Sigla\')";
        
        String sqlTesteRetorno = "select * from EEVENTO_INTERESSA_A_INSTANCIA where evento_id = 1 AND sigla_instancia = \'Sigla'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "evento_id");
        
        assertEquals("1", retorno);
        
    }
    
    @Test
    public void testEventoIdNulo() {
        String sqlTesteObjetivo = "INSERT INTO EVENTO_INTERESSA_A_INSTANCIA VALUES (\'null\', \'Sigla\')";
        
        String sqlTesteRetorno = "select * from EEVENTO_INTERESSA_A_INSTANCIA where evento_id = 1 AND sigla_instancia = \'Sigla'";

        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "evento_id");
        
        assertEquals("Nenhum Retorno", retorno);
        
    }
    
    @Test
    public void testSiglaInstanciaNulo() {
        String sqlTesteObjetivo = "INSERT INTO EVENTO_INTERESSA_A_INSTANCIA VALUES (1, \'null\')";
        
        String sqlTesteRetorno = "select * from EEVENTO_INTERESSA_A_INSTANCIA where evento_id = 1 AND sigla_instancia = \'Sigla'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "evento_id");
        
        assertEquals("Nenhum Retorno", retorno);
    }
}
