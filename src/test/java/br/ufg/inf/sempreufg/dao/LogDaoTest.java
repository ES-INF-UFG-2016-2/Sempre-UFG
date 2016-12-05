/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.factory.ConnectionFactoryPostegres;
import br.ufg.inf.sempreufg.modelo.Log;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kleudson
 * @version 1.0
 */
public class LogDaoTest {

    private Connection con;
    private LogDao logDao;

    public LogDaoTest() {
    }

    @Before
    public void setUp() {
        try {
            //Inicializa variáveis antes do teste
            con = new ConnectionFactoryPostegres().getConnection();
            logDao = new LogDao(con);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        try {
            con.close();
        } catch (Exception e) {
        }

    }

    @Test
    public void crudLog() {
        Log log = mockLog();
        
        //Descomentar somente após criar a tabela no banco de dados
        //logDao.salvarLog(log);

        //Log logSalvo = logDao.consultaLog(log.getIdLog());

        //Verifica se o método de inserção e seleção estão funcionando
        //assertEquals(log, logSalvo);
        
        //logDao.removerLog(logSalvo);

        //logSalvo = logDao.consultaLog(logSalvo.getIdLog());

        //Verifica remoção
        //assertNull(logSalvo);

    }
    


    private Log mockLog() {
        Log log = new Log();
        log.setIdLog(1);
        log.setMensagem("Mensagem");
        log.setTipoLog(1);
        log.setUsuario("admin");

        return log;
    }
}
