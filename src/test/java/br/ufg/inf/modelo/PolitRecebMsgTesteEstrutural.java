package br.ufg.inf.modelo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ufg.inf.enums.PoliticaRecebimentoMensagens;

public class PolitRecebMsgTesteEstrutural {

	@BeforeClass
	public static void defineUsuario() {

		Usuario usuario = new Usuario();

	}

	@Test
	public void testDefinePolitRecebMsg() {

	}

	@Test
	public void testAlteraPolitRecebMsg() {
	}

	@Test
	public void testPolitRecebMsgNull() {

		Usuario usuarioDefault = new Usuario();

		try {
			usuarioDefault.setTipoDivulgacao(null);
			// fail("Politica null foi aprovada.");
		} catch (Exception e) {

			e.getMessage();

		}

	}

	@Test
	public void testRetornaPolitRecebMsg() {
		
		
	}

	@Test
	public void testPolitRecebMsgDefault() throws Exception {
		
		assertTrue(new Usuario().getTipoDivulgacao().equals(PoliticaRecebimentoMensagens.CADA_EVENTO));
		
	}

	@Test
	public void testPolitRecebMsgInvalida() {

		Usuario usuarioDefault = new Usuario();
		String politica = "politica";

		try {
			usuarioDefault.setTipoDivulgacao(PoliticaRecebimentoMensagens.valueOf("jkahdsf"));
			fail("Politica invalida foi aprovada.");
		} catch (Exception e) {

			assertEquals(java.lang.IllegalArgumentException.class, e.getClass());
		}

	}
}
