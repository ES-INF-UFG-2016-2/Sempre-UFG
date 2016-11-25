//package br.ufg.inf;
//
//import Usuario;
//import org.junit.Before;
//import org.junit.Test;
//
//@SuppressWarnings("unused")
//public class PolitRecebMsgTest {
//
//	Usuario usuario;
//	PolitRecebMsg politica;
//
//	@Before
//	public void setUp() throws Exception {
//		usuario = new Usuario();
//		politica = new PolitRecebMsg();
//	}
//
//	@Test
//	public void testUsuarioValido() {
//		assertEquals(true, usuario.UsuarioValido("teste@teste.com", "123"));
//	}
//
//	@Test
//	public void testPolitMsgIndividual(){
//		assertEquals("RecebMsgIndividual",politica.selecionaPolitica(1));
//	}
//
//	@Test
//	public void testPolitMsgAgregDia(){
//		assertEquals("RecebMsgAgregDia",politica.selecionaPolitica(2));
//	}
//
//	@Test
//	public void testPolitMsgAgregSemana(){
//		assertEquals("RecebMsgAgregSemana",politica.selecionaPolitica(3));
//	}
//
//	@Test
//	public void testPolitMsgAgregMes(){
//		assertEquals("RecebMsgAgregMes",politica.selecionaPolitica(4));
//	}
//
//
//	@Test
//	public void testPolitNaoRecebMsg(){
//		assertEquals("NaoRecebMsg",politica.selecionaPolitica(5));
//	}
//
//
//}
