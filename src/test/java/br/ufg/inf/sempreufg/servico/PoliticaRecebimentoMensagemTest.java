package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.enums.PoliticaRecebimentoMensagens;
import br.ufg.inf.sempreufg.modelo.Usuario;
import org.junit.Assert;
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
		usuario.setTipoDivulgacao(politica);
		Assert.assertEquals("CADA_EVENTO", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaDia(){
		politica = PoliticaRecebimentoMensagens.DIARIA;
		usuario.setTipoDivulgacao(politica);
		Assert.assertEquals("DIARIA", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaSemana(){
		politica = PoliticaRecebimentoMensagens.SEMANAL;
		usuario.setTipoDivulgacao(politica);
		Assert.assertEquals("SEMANAL", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaRecebimentoMensagemAgrupadaMes(){
		politica = PoliticaRecebimentoMensagens.MENSAL;
		usuario.setTipoDivulgacao(politica);
		Assert.assertEquals("MENSAL", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaNaoRecebimentoMensagem(){
		politica = PoliticaRecebimentoMensagens.NAO_RECEBE;
		usuario.setTipoDivulgacao(politica);
		Assert.assertEquals("NAO_RECEBE", usuario.getTipoDivulgacao().toString());
	}

	@Test
	public void testaPoliticaPadrao(){
		Assert.assertEquals("CADA_EVENTO", usuario.getTipoDivulgacao().toString());
	}

    @Test
    public void testaAlteracaoDaPoliticaDeMensagem(){
        usuario.setTipoDivulgacao(PoliticaRecebimentoMensagens.CADA_EVENTO);
        usuario.setTipoDivulgacao(PoliticaRecebimentoMensagens.MENSAL);

        Assert.assertNotEquals("CADA_EVENTO", usuario.getTipoDivulgacao().toString());
        Assert.assertEquals("MENSAL", usuario.getTipoDivulgacao().toString());
    }
}
