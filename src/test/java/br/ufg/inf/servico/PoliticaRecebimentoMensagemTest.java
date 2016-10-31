package br.ufg.inf.servico;

import br.ufg.inf.enums.PoliticaRecebimentoMensagens;
import br.ufg.inf.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
		usuario.setTipoDivulgacao(politica);
		assertEquals("CADA_EVENTO", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaDia(){
		politica = PoliticaRecebimentoMensagens.DIARIA;
		usuario.setTipoDivulgacao(politica);
		assertEquals("DIARIA", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaSemana(){
		politica = PoliticaRecebimentoMensagens.SEMANAL;
		usuario.setTipoDivulgacao(politica);
		assertEquals("SEMANAL", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaMes(){
		politica = PoliticaRecebimentoMensagens.MENSAL;
		usuario.setTipoDivulgacao(politica);
		assertEquals("MENSAL", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaNaoRecebimentoMensagem(){
		politica = PoliticaRecebimentoMensagens.NAO_RECEBE;
		usuario.setTipoDivulgacao(politica);
		assertEquals("NAO_RECEBE", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaPadrao(){
		politica = PoliticaRecebimentoMensagens.CADA_EVENTO;
		usuario.setTipoDivulgacao(politica);
		assertEquals("CADA_EVENTO", usuario.getTipoDivulgacao().toString());
	}


}
