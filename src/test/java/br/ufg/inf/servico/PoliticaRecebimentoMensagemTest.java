package br.ufg.inf.servico;

import br.ufg.inf.enums.PoliticaRecebimentoMensagens;
import br.ufg.inf.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
		usuario.DefinirPolitRecebMsg(politica);
		assertEquals("CADA_EVENTO", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaDia(){
		politica = PoliticaRecebimentoMensagens.DIARIA;
		usuario.DefinirPolitRecebMsg(politica);
		assertEquals("DIARIA", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaSemana(){
		politica = PoliticaRecebimentoMensagens.SEMANAL;
		usuario.DefinirPolitRecebMsg(politica);
		assertEquals("SEMANAL", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaMes(){
		politica = PoliticaRecebimentoMensagens.MENSAL;
		usuario.DefinirPolitRecebMsg(politica);
		assertEquals("MENSAL", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaNaoRecebimentoMensagem(){
		politica = PoliticaRecebimentoMensagens.NAO_RECEBE;
		usuario.DefinirPolitRecebMsg(politica);
		assertEquals("NAO_RECEBE", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaPadrao(){
		assertEquals("CADA_EVENTO", usuario.getTipoDivulgacao().toString());
	}

    @Test
    public void testaAlteracaoDaPoliticaDeMensagem(){
        usuario.DefinirPolitRecebMsg(PoliticaRecebimentoMensagens.CADA_EVENTO);
        usuario.DefinirPolitRecebMsg(PoliticaRecebimentoMensagens.MENSAL);

        assertNotEquals("CADA_EVENTO", usuario.getTipoDivulgacao().toString());
        assertEquals("MENSAL", usuario.getTipoDivulgacao().toString());
    }
}
