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
public class EventoRelacionadoAreaTest {
    private RD_DivulgInfoDAO divulgInfo;
    @Before
    public void preparacao(){
        this.divulgInfo = new RD_DivulgInfoDAO();
        
        divulgInfo.LimparEventoRelacionadoArea();
        divulgInfo.LimparAreaDeConhecimento();
        divulgInfo.LimparEvento();
        
        // Para campos validos
        AreaDeConhecimento area = new AreaDeConhecimento();
        area.setAREA_DE_CONHECIMENTO_ID(1);
        area.setNOME("Ciencias da Terra");
        area.setCODIGO("1");
        area.setAREA_CONHECIMENTO(null);
        divulgInfo.InserirAreaDeConhecimento(area);
        
        Evento evento = new Evento();
        evento.setEVENTO_ID(1);
        evento.setASSUNTO("Teste");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Area relacionada a Evento");
        evento.setDATA_SOLICITA_DIVULGACAO("2016-12-20 10:20:00");
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        divulgInfo.InserirEvento(evento);
        
        //Para Area Duplicada
        AreaDeConhecimento areaDuplicada = new AreaDeConhecimento();
        areaDuplicada.setAREA_DE_CONHECIMENTO_ID(2);
        areaDuplicada.setNOME("Ciencias Exatas");
        areaDuplicada.setCODIGO("2");
        areaDuplicada.setAREA_CONHECIMENTO(null);
        divulgInfo.InserirAreaDeConhecimento(areaDuplicada);
        
        EventoRelacionadoArea eventoArea = new EventoRelacionadoArea();
        eventoArea.setEVENTO("1");
        eventoArea.setAREA_CONHECIMENTO("2");
        divulgInfo.InserirEventoRelacionadoArea(eventoArea);
        
    }
    
    @After
    public void conclusao(){
        divulgInfo.LimparEventoRelacionadoArea();
        divulgInfo.LimparAreaDeConhecimento();
        divulgInfo.LimparEvento();
    }
    
    @Test
    public void testCamposValidos() {
        EventoRelacionadoArea eventoArea = new EventoRelacionadoArea();
        eventoArea.setEVENTO("1");
        eventoArea.setAREA_CONHECIMENTO("1");
        
        String retorno = divulgInfo.InserirEventoRelacionadoArea(eventoArea);
        
        assertEquals("sucesso", retorno);
    }
    
    @Test
    public void testEventoIdNulo() {
        EventoRelacionadoArea eventoArea = new EventoRelacionadoArea();
        eventoArea.setEVENTO(null);
        eventoArea.setAREA_CONHECIMENTO("1");
        
        String retorno = divulgInfo.InserirEventoRelacionadoArea(eventoArea);
        
        String erro = "ERROR: null value in column \"evento\" violates not-null constrain";
        assertTrue(retorno.contains(erro));
    }
    
    @Test
    public void testCodigoAreaNulo() {
        EventoRelacionadoArea eventoArea = new EventoRelacionadoArea();
        eventoArea.setEVENTO("1");
        eventoArea.setAREA_CONHECIMENTO(null);
        
        String retorno = divulgInfo.InserirEventoRelacionadoArea(eventoArea);
        
        String erro = "ERROR: null value in column \"area_conhecimento\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }
    
    @Test //RO DO Descobrir o Erro de campo duplicado e colocar na variavel Erro
    public void testCodigoAreaDuplicada() {
        EventoRelacionadoArea eventoArea = new EventoRelacionadoArea();
        eventoArea.setEVENTO("1");
        eventoArea.setAREA_CONHECIMENTO("2");
        String retorno = divulgInfo.InserirEventoRelacionadoArea(eventoArea);
        
        String erro = "ERROR";
        
        assertTrue(retorno.contains(erro));
    }
}
