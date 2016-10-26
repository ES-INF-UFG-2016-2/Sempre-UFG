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
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        assertEquals(email, usuario.getEmail());
    }

    @Test
    public void testeEmailIncorreto() throws Exception {
        String email = "teste_email#gmail.com";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        assertEquals(nome, usuario.getEmail());
    }

    @Test
    public void testeSenhaIncorreto() throws Exception {
        String senha = "";
        Usuario usuario = new Usuario();
        usuario.setSenha(senha);
        assertEquals(senha, usuario.getSenha());
    }

    @Test
    public void testeNomeCorreto() throws Exception {
        String nome = "Alberto Alves";
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        assertEquals(nome, usuario.getNome());
    }

    @Test
    public void testeNomeIncorreto() throws Exception {
        String nome = "";
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        assertEquals(nome, usuario.getNome());
    }

    @Test
    public void testeCpfCorreto() throws Exception {
        String cpf = "00265453923";
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeCpfIncorretoMenor() throws Exception {
        String cpf = "0026";
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeCpfIncorretoMaior() throws Exception {
        String cpf = "00262342535235532";
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeCpfIncorretoInvalido() throws Exception {
        String cpf = "0026g453923";
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeValidarUsuarioTrue() throws Exception {
        String email = "usuario123@gmail.com";
        String senha = "testesenha1343";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        assertEquals(true, usuario.validarUsuario());
    }

    @Test
    public void testeValidarUsuarioSemSenha() throws Exception {
        String email = "usuario123@gmail.com";
        String senha = "";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        assertEquals(false, usuario.validarUsuario());
    }

    @Test
    public void testeValidarUsuarioSemEmail() throws Exception {
        String email = "";
        String senha = "testesenha1343";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        assertEquals(false, usuario.validarUsuario());
    }
}
