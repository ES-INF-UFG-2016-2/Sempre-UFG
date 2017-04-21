/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.db;

import br.ufg.inf.sempreufg.daoParaTestes.RD_DivulgInfoDAO;
import br.ufg.inf.sempreufg.entidadesParaTestes.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;

/**
 *
 * @author Kalyn
 */
public class EventoTeste {

    private int contador = 0;
    private RD_DivulgInfoDAO divulgInfo;

    private int contagem() {
        return contador++;
    }
    
    private String timestampFuturo(){
        Timestamp data = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH, 40);
        data.setTime(cal.getTime().getTime());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(data);
    }
    
    private String dataFutura(int dias){
        Date data = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, dias);
        data = cal.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        return df.format(data);
    }
    
    private String dataPassada(int dias){
        Date data = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, dias);
        data = cal.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        return df.format(data);
    }

    @Before
    public void preparacao() {
        this.divulgInfo = new RD_DivulgInfoDAO();

        divulgInfo.LimparEvento();

        Evento eventoDuplicado = new Evento();
        eventoDuplicado.setEVENTO_ID(contagem());
        eventoDuplicado.setASSUNTO("Teste Assunto Duplicado");
        eventoDuplicado.setTIPO("NOTICIA");
        eventoDuplicado.setDESCRICAO("Area relacionada a Evento");
        eventoDuplicado.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        eventoDuplicado.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        eventoDuplicado.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        eventoDuplicado.setFORMA_DIVULGACAO("NOTICIA");
        eventoDuplicado.setESCOPO_DIVULGACAO("COMUNIDADE");
        eventoDuplicado.setDATA_EXPIRACAO(null);
        divulgInfo.InserirEvento(eventoDuplicado);
    }

    @After
    public void conclusao() {
        divulgInfo.LimparEvento();
    }

    @Test
    public void testeTodosCamposValidos() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("TesteTodosCamposValidos");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }
    
    @Test
    public void testeAssuntoDuplicado(){
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Assunto Duplicado");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Area relacionada a Evento");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);
        
        String erro = "ERROR: duplicate key value violates unique constraint \"evento_assunto_key\"";
        assertTrue(retorno.contains(erro));
        
    }

    @Test
    public void testeAssuntoNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO(null);
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR: null value in column \"assunto\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }

    @Test
    public void testeDescricaoEventoNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Descrição Evento Nulo");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO(null);
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR: null value in column \"descricao\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }

    @Test
    public void testeDataHoraDivulgacaoNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Data Hora Divulgacao Nulo");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(null);
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR: null value in column \"data_solicita_divulgacao\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }

    @Test
    public void testeIdentificacaoQuemSolicitaNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Identificacao Quem Solicita Nulo");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO(null);
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR: null value in column \"solicitante_divulgacao\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }

    @Test
    public void testeEmailSolicitanteNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Email Solicitante Nulo");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL(null);
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR: null value in column \"solicitante_email\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }

    @Test
    public void testeDataExpiracaoNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Data Expiracao Nulo");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeDataExpiracaoNaoNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Data Expiracao Nao Nulo");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(dataFutura(60));
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test // TODO Descobrir Erro 
    public void testeDataExpiracaoMenorQueAtual() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Data Expiracao Menor Que Atual");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(dataPassada(30));
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR";
        assertTrue(retorno.contains(erro));
    }

    @Test // TODO Descobrir Erro
    public void testeDataExpiracaoMenorQueDataDivulgacao() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Data Expiracao Menor Que Data Divulgacao");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(dataFutura(10));
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR";
        assertTrue(retorno.contains(erro));
    }

    @Test
    public void testeTipoEventoNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Tipo Evento Nulo");
        evento.setTIPO(null);
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR: null value in column \"tipo\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }
    
    @Test
    public void testeTipoEventoNoticia() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Tipo Evento Nulo");
        evento.setTIPO(null);
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeTipoEventoPalestra() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Tipo Evento Palestra");
        evento.setTIPO("PALESTRA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeTipoEventoCurso() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Tipo Evento Curso");
        evento.setTIPO("CURSO");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeTipoEventoOportunidadeEmprego() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Tipo Evento Oportunidade Emprego");
        evento.setTIPO("OPORTUNIDADE DE EMPREGO");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeTipoEventoDiversos() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Tipo Evento Diversos");
        evento.setTIPO("DIVERSOS");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeEscopoApenasEgressos() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Escopo Apenas Egressos");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("APENAS EGRESSOS");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeEscopoComunidade() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Escopo Comunidade");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeEscopoForaDeEscopo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Escopo Fora de Escopo");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("FORA DE ESCOPO");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeEscopoNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Escopo Nulo");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO(null);
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR: null value in column \"escopo_divulgacao\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }

    @Test
    public void testeFormaDivulgacaoMensagem() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Forma Divulgacao Mensagem");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("MENSAGEM");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeFormaDivulgacaoNoticia() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Forma Divulgacao Noticia");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NOTICIA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeFormaDivulgacaoAmbos() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Forma Divulgacao Ambos");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("AMBOS");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeFormaDivulgacaoNenhuma() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Forma Divulgacao Nenhuma");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO("NENHUMA");
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        assertEquals("sucesso", retorno);
    }

    @Test
    public void testeFormaDivulgacaoNulo() {
        Evento evento = new Evento();
        evento.setEVENTO_ID(contagem());
        evento.setASSUNTO("Teste Forma Divulgacao Nulo");
        evento.setTIPO("NOTICIA");
        evento.setDESCRICAO("Teste");
        evento.setDATA_SOLICITA_DIVULGACAO(timestampFuturo());
        evento.setSOLICITANTE_DIVULGACAO("Edmundo Sergio Spoto");
        evento.setSOLICITANTE_EMAIL("edmundo@inf.ufg.br");
        evento.setFORMA_DIVULGACAO(null);
        evento.setESCOPO_DIVULGACAO("COMUNIDADE");
        evento.setDATA_EXPIRACAO(null);
        String retorno = divulgInfo.InserirEvento(evento);

        String erro = "ERROR: null value in column \"forma_divulgacao\" violates not-null constraint";
        assertTrue(retorno.contains(erro));
    }
}
