/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.db;

import br.ufg.inf.sempreufg.daoParaTestes.RD_DivulgInfoDAO;
import br.ufg.inf.sempreufg.entidadesParaTestes.*;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Kalyn
 */
public class EventoRelacionadoInstanciaTest {
    RD_DivulgInfoDAO divulgInfo;
    @Before
    public void preparacao(){
        this.divulgInfo = new RD_DivulgInfoDAO();
        
        divulgInfo.LimparEventoRelacionadoInstancia();
        divulgInfo.LimparEventoRelacionadoInstancia();
        divulgInfo.LimparEvento();
        
        // Para campos validos
        InstanciaAdministrativa instancia = new InstanciaAdministrativa();
        instancia.setINSTANCIA_ADMINISTRATIVA_ID(1);
        instancia.setSIGLA_INSTANCIA("INF");
        instancia.setNOME("Instituto de Informática");
        instancia.setTIPO("REGIONAL");
        instancia.setDATA_CRIACAO("2015-10-20");
        instancia.setDATA_ENCERR("2017-10-20");
        instancia.setEMAIL_INSTITUCIONAL("inf@inf.ufg.br");
        instancia.setURL_INSTITUCIONAL("www.inf.ufg.br");
        divulgInfo.InserirInstanciaAdministrativa(instancia);
        
        Evento evento = new Evento();
        evento.setEVENTO_ID(1);
        evento.setASSUNTO("Teste");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Instancia Administrativa relacionada a Evento");
        evento.setDATA_SOLICITA_DIVULGACAO("2016-12-20 10:20:00");
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        divulgInfo.InserirEvento(evento);
        
        //Para Instancia Duplicada
        InstanciaAdministrativa instanciaDuplicada = new InstanciaAdministrativa();
        instanciaDuplicada.setINSTANCIA_ADMINISTRATIVA_ID(2);
        instanciaDuplicada.setSIGLA_INSTANCIA("FL");
        instanciaDuplicada.setNOME("Facultade de Letras");
        instanciaDuplicada.setTIPO("REGIONAL");
        instanciaDuplicada.setDATA_CRIACAO("2015-10-20");
        instanciaDuplicada.setDATA_ENCERR("2017-10-20");
        instanciaDuplicada.setEMAIL_INSTITUCIONAL("fl@fl.ufg.br");
        instanciaDuplicada.setURL_INSTITUCIONAL("www.fl.ufg.br");
        divulgInfo.InserirInstanciaAdministrativa(instanciaDuplicada);
        
        EventoRelacionadoInstancia eventoInstancia = new EventoRelacionadoInstancia();
        eventoInstancia.setEVENTO("1");
        eventoInstancia.setINSTANCIA_ADMINISTRATIVA("2");
        divulgInfo.InserirEventoRelacionadoInstancia(eventoInstancia);
    }
    
    @After
    public void conclusao(){
        divulgInfo.LimparEventoRelacionadoInstancia();
        divulgInfo.LimparInstanciaAdministrativa();
        divulgInfo.LimparEvento();
    }
    
    @Test
    public void testCamposValidos() {
        EventoRelacionadoInstancia eventoInstancia = new EventoRelacionadoInstancia();
        eventoInstancia.setEVENTO("1");
        eventoInstancia.setINSTANCIA_ADMINISTRATIVA("1");
        
        String retorno = divulgInfo.InserirEventoRelacionadoInstancia(eventoInstancia);
        
        assertEquals("sucesso", retorno);
    }
    
    @Test
    public void testEventoIdNulo() {
        EventoRelacionadoInstancia eventoInstancia = new EventoRelacionadoInstancia();
        eventoInstancia.setEVENTO(null);
        eventoInstancia.setINSTANCIA_ADMINISTRATIVA("1");
        
        String retorno = divulgInfo.InserirEventoRelacionadoInstancia(eventoInstancia);
        
        String erro = "ERROR: null value in column \"evento\" violates not-null constrain";
        assertTrue(retorno.contains(erro));
    }
    
    @Test
    public void testCodigoInstanciaNulo() {
        EventoRelacionadoInstancia eventoInstancia = new EventoRelacionadoInstancia();
        eventoInstancia.setEVENTO("1");
        eventoInstancia.setINSTANCIA_ADMINISTRATIVA(null);
        
        String retorno = divulgInfo.InserirEventoRelacionadoInstancia(eventoInstancia);
        
        String erro = "null value in column \"instancia_administrativa\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }
    
    @Test //RO DO Descobrir o Erro de campo duplicado e colocar na variavel Erro
    public void testCodigoInstanciaDuplicada() {
        EventoRelacionadoInstancia eventoInstancia = new EventoRelacionadoInstancia();
        eventoInstancia.setEVENTO("1");
        eventoInstancia.setINSTANCIA_ADMINISTRATIVA("2");
        
        String retorno = divulgInfo.InserirEventoRelacionadoInstancia(eventoInstancia);
        
        String erro = "ERROR";
        
        assertTrue(retorno.contains(erro));
    }
}
