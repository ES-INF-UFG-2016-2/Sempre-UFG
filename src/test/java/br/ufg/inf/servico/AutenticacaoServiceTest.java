package br.ufg.inf.servico;

import br.ufg.inf.modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cleber
 */
public class AutenticacaoServiceTest {

    private class AutenticacaoServiceStub extends AutenticacaoService {

        private final Usuario usuarioTeste = new Usuario();

        public AutenticacaoServiceStub() {
            usuarioTeste.setCpf("123456789");
            usuarioTeste.setMail("usuarioTeste@teste.com");
            usuarioTeste.setSenha("senhaTeste");
        }

        @Override
        public boolean login(String login, String senha) {
            if (login == null || senha == null) {
                setErro("Login e senha são obrigatório(s)");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            } else if ((login.equals(usuarioTeste.getCpf()) || login.equals(usuarioTeste.getMail()))
                    && senha.equals(usuarioTeste.getSenha())) {
                setErro("");
                setUsuarioAutenticado(usuarioTeste);
                setAutenticado(true);
            } else {
                setErro("Login e/ou senha inválido(s)");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            }
            return isAutenticado();
        }

        @Override
        public boolean loginPrimeiroAcesso(Usuario usuario) {
            return super.loginPrimeiroAcesso(usuario); //To change body of generated methods, choose Tools | Templates.
        }

    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando login e senha são ambos nulos.
     */
    @Test
    public void testLoginLoginSenhaNulos() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login(null, null));
    }
    
    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login é nulo.
     */
    @Test
    public void testLoginLoginNulo() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login(null, "senhaTeste"));
    }
    
    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando a senha é nula.
     */
    @Test
    public void testLoginSenhaNula() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("123456789", null));
    }
    
    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando login e senha são diferentes do esperado.
     */
    @Test
    public void testLoginLoginSenhaDiferentes() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("987654321", "minhaSenha"));
    }
    
    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login é diferente do esperado.
     */
    @Test
    public void testLoginLoginDiferente() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("987654321", "senhaTeste"));
    }
    
    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando a senha é diferente do esperado.
     */
    @Test
    public void testLoginSenhaDiferente() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("123456789", "minhaSenha"));
    }
    
    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login corresponde ao CPF.
     */
    @Test
    public void testLoginLoginCPF() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(true, autenticacaoService.login("123456789", "senhaTeste"));
    }
    
    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login corresponde ao email.
     */
    @Test
    public void testLoginLoginEmail() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(true, autenticacaoService.login("usuarioTeste@teste.com", "senhaTeste"));
    }

    /**
     * Test of loginPrimeiroAcesso method, of class AutenticacaoService.
     */
    @Test
    public void testLoginPrimeiroAcesso() {
        System.out.println("loginPrimeiroAcesso");
        Usuario usuario = null;
        AutenticacaoService instance = new AutenticacaoService();
        boolean expResult = false;
        boolean result = instance.loginPrimeiroAcesso(usuario);
        assertEquals(expResult, result);
    }

}
