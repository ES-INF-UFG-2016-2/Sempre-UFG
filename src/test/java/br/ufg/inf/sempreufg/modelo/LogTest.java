/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kleudson
 * @version 1.0
 */
public class LogTest {
    
    private Log log;
    
    public LogTest() {
    }
    
    @Before
    public void setUp() {
        log = new Log();
    }
    
    @Test
    public void setIdLog(){
        int id = 100;
        log.setIdLog(100);
        
        //Verifica se o get e set do atributo Id esta funcionando
        assertEquals(id, log.getIdLog());
    }
    
    @Test
    public void setMensagemLog(){
        String mensagem = "Teste";
        log.setMensagem(mensagem);
        
        //Verifica se o get e set do atributo Mensagem esta funcionando
        assertEquals(mensagem, log.getMensagem());
    }
    
    @Test
    public void setUsuarioLog(){
        String usuario = "Teste";
        log.setUsuario(usuario);
        
        //Verifica se o get e set do atributo Usuario esta funcionando
        assertEquals(usuario, log.getUsuario());
    }
    
    @Test
    public void setTipoLog(){
        int tipo = 1;
        log.setTipoLog(tipo);
        
        //Verifica se o get e set do atributo TipoLog esta funcionando
        assertEquals(tipo, log.getTipoLog());
    }

}
