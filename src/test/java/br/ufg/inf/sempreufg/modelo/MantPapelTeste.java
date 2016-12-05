package br.ufg.inf.sempreufg.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.ufg.inf.sempreufg.stubs.MantPapelStub;;

public class MantPapelTeste {
	
	 @Test
	    public void testCriarPermissaoUsuarioCorreta() {
		 String papel = "Administrador";
		 String recurso = "recursoControleAcesso";
		 
		 MantPapelStub criarPermissao = new MantPapelStub();
		 assertEquals("Permissão Inserida", criarPermissao.criarPermissaoUsuario(papel, recurso));
	    }
	 
	@Test 
	 	public void testExcluirPermissaoUsuario(){

		 String papel = "Administrador";
         String recurso = "recursoControleAcesso";
		 String usuario = "Jean";
		 MantPapelStub excluirPermissao = new MantPapelStub();
		 assertEquals("Permissão Excluida", excluirPermissao.excluirPermissaoUsuario(usuario));
	 }
	 
	@Test 
	    public void testConsultaPermissaoUsuario(){
		
		String usuario = "Carlos";
		MantPapelStub consultaPermissao = new MantPapelStub();
		assertTrue(consultaPermissao.consultaPermissao(usuario));
	}
}
