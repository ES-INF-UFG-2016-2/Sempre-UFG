/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf;

import br.ufg.inf.modelo.Usuario;
import br.ufg.inf.enuns.PoliticaRecebimentoMensagens;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.jvnet.mock_javamail.Mailbox;

/**
 *
 * @author hiago
 */
public class UsuarioTest {

    @Before
    public void setUp() {
        Mailbox.clearAll();
    }

    @Test
    public void testeEmailCorreto() throws Exception {
        String email = "teste_email@gmail.com";

        boolean check = true;

        Usuario usuario = new Usuario();
        assertEquals(check, usuario.setMail(email));
    }

    @Test
    public void testeEmailIncorreto() throws Exception {
        String email = "teste_email#gmail.com";

        boolean check = false;

        Usuario usuario = new Usuario();
        assertEquals(check, usuario.setMail(email));
    }

    @Test
    public void testeSenhaIncorreto() throws Exception {
        String senha = "";

        boolean check = false;

        Usuario usuario = new Usuario();
        assertEquals(check, usuario.setSenha(senha));
    }

    @Test
    public void testeNomeCorreto() throws Exception {
        String nome = "Alberto Alves";

        boolean check = true;

        Usuario usuario = new Usuario();
        assertEquals(check, usuario.setNome(nome));
    }

    @Test
    public void testeNomeIncorreto() throws Exception {
        String nome = "";

        boolean check = false;

        Usuario usuario = new Usuario();
        assertEquals(check, usuario.setNome(nome));
    }

    @Test
    public void testeCpfCorreto() throws Exception {
        String cpf = "00265453923";

        boolean check = true;

        Usuario usuario = new Usuario();
        assertEquals(check, usuario.setCpf(cpf));
    }

    @Test
    public void testeCpfIncorretoMenor() throws Exception {
        String cpf = "0026";

        boolean check = false;

        Usuario usuario = new Usuario();
        assertEquals(check, usuario.setCpf(cpf));
    }

    @Test
    public void testeCpfIncorretoMaior() throws Exception {
        String cpf = "00262342535235532";

        boolean check = false;

        Usuario usuario = new Usuario();
        assertEquals(check, usuario.setCpf(cpf));
    }

    @Test
    public void testeCpfIncorretoInvalido() throws Exception {
        String cpf = "0026g453923";

        boolean check = false;

        Usuario usuario = new Usuario();
        assertEquals(check, usuario.setCpf(cpf));
    }

    @Test
    public void testeRecebeDivulgValido() throws Exception {
        PoliticaRecebimentoMensagens tipoDivulgacao = new PoliticaRecebimentoMensagens();

        int valor = 1;
        
        boolean check = true;

        assertEquals(check, tipoDivulgacao.mudarPolitica(valor));
    }
    
    @Test
    public void testeRecebeDivulgInvalido() throws Exception {
        PoliticaRecebimentoMensagens tipoDivulgacao = new PoliticaRecebimentoMensagens();

        int valor = 0;
        
        boolean check = true;

        assertEquals(check, tipoDivulgacao.mudarPolitica(valor));
    }
    
    @Test
    public void testeRecebeDivulgInvalidoMaior() throws Exception {
        PoliticaRecebimentoMensagens tipoDivulgacao = new PoliticaRecebimentoMensagens();

        int valor = 6;
        
        boolean check = true;

        assertEquals(check, tipoDivulgacao.mudarPolitica(valor));
    }
}
