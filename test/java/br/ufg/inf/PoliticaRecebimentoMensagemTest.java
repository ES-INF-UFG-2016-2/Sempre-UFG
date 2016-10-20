package br.ufg.inf;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.enuns.PoliticaRecebimentoMensagens;
import br.ufg.inf.modelo.Usuario;

public class PoliticaRecebimentoMensagemTest {
	
	Usuario usuario;
	PoliticaRecebimentoMensagens politica;
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario();
	}

	@Test
	public void testaUsuarioAutenticavel() {
		assertEquals(true, usuario.validarUsuario("mail", "senha"));
	}

	@Test
	public void testaUsuarioNaoAutenticavel() {
		assertEquals(false, usuario.validarUsuario("mail", "senhaerrada"));
	}
	
	@Test
	public void testaPoliticaRecebimentoMensagemIndividual(){
		politica = PoliticaRecebimentoMensagens.CADA_EVENTO;
		usuario.setPolitRecebMsg(politica);
		assertEquals("CADA_EVENTO", usuario.getPolitRecebMsg().toString());
	}
	
	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaDia(){
		politica = PoliticaRecebimentoMensagens.DIARIA;
		usuario.setPolitRecebMsg(politica);
		assertEquals("DIARIA", usuario.getPolitRecebMsg().toString());
	}
	
	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaSemana(){
		politica = PoliticaRecebimentoMensagens.SEMANAL;
		usuario.setPolitRecebMsg(politica);
		assertEquals("SEMANAL", usuario.getPolitRecebMsg().toString());
	}
	
	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaMes(){
		politica = PoliticaRecebimentoMensagens.MENSAL;
		usuario.setPolitRecebMsg(politica);
		assertEquals("MENSAL", usuario.getPolitRecebMsg().toString());
	}
	
	@Test
	public void testaPoliticaNaoRecebimentoMensagem(){
		politica = PoliticaRecebimentoMensagens.NAO_RECEBE;
		usuario.setPolitRecebMsg(politica);
		assertEquals("NAO_RECEBE", usuario.getPolitRecebMsg().toString());
	}
	
	@Test
	public void testaPoliticaPadrao(){
		politica = PoliticaRecebimentoMensagens.CADA_EVENTO;
		usuario.setPolitRecebMsg(politica);
		assertEquals("CADA_EVENTO", usuario.getPolitRecebMsg().toString());
	}
	
	
}
