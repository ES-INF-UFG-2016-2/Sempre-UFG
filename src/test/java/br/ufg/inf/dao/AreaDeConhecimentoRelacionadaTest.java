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
public class AreaDeConhecimentoRelacionadaTest {
    @Before
    public void preparacao(){
        String sql = "DELETE FROM EVENTO;";
        ExecutorSqlDAO.executarSQL(sql);
        sql = "DELETE FROM AREA_DE_CONHECIMENTO;";
        ExecutorSqlDAO.executarSQL(sql);
        sql = "DELETE FROM EVENTO_RELACIONADO_A_AREA;";
        ExecutorSqlDAO.executarSQL(sql);
        
        sql = "INSERT INTO AREA_DE_CONHECIMENTO  VALUES (1, \'Ciencias da Terra\', 3, \'null\')";
        ExecutorSqlDAO.executarSQL(sql);
        
        sql = "INSERT INTO EVENTO VALUES (1, \'Teste 3\', \'NOTICIA\', \'Area "
                + "relacionada a Evento\', \'20-10-2016 10:20:00\', \'Edmundo "
                + "Sergio Spoto\', \'edmundo@inf.ufg.br\', \'NOTICIA\',"
                + " \'COMUNIDADE\', \'20-10-2017\')";
        ExecutorSqlDAO.executarSQL(sql);
        
        //Para Area Duplicada
        sql = "INSERT INTO AREA_DE_CONHECIMENTO  VALUES (2, \'Ciencias da Terra\', \'null\')";
        ExecutorSqlDAO.executarSQL(sql);
        sql = "INSERT INTO EVENTO_RELACIONADO_A_AREA VALUES(1, 2);";
        ExecutorSqlDAO.executarSQL(sql);
        
    }
    
    @After
    public void conclusao(){
        String sql = "DELETE FROM EVENTO;";
        ExecutorSqlDAO.executarSQL(sql);
    }
    
    @Test
    public void testCamposValidos() {
        String sqlTesteObjetivo = "INSERT INTO EVENTO_RELACIONADO_A_AREA VALUES(1, 1);";
        
        String sqlTesteRetorno = "select * from EVENTO_RELACIONADO_A_AREA where evento_id = 1 AND codigo_area = 1";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "evento_id");
        
        assertEquals("1", retorno);
        
    }
    
    @Test
    public void testEventoIdNulo() {
        String sqlTesteObjetivo = "INSERT INTO EVENTO_RELACIONADO_A_AREA VALUES(\'null\', 1);";
        
        String sqlTesteRetorno = "select * from EVENTO_RELACIONADO_A_AREA where evento_id = \'null\' AND codigo_area = 1";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "evento_id");
        
        assertEquals("Nenhum Retorno", retorno);
        
    }
    
    @Test
    public void testCodigoAreaNulo() {
        String sqlTesteObjetivo = "INSERT INTO EVENTO_RELACIONADO_A_AREA VALUES(1, \'null\');";
        
        String sqlTesteRetorno = "select * from EVENTO_RELACIONADO_A_AREA where evento_id = 1 AND codigo_area = \'null\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "evento_id");
        
        assertEquals("Nenhum Retorno", retorno);
    }
}
