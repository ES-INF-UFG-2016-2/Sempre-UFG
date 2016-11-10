package br.ufg.inf.modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.ufg.inf.modelo.Usuario;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author hiago
 */
public class UsuarioTeste {

    @Test
    public void testeEmailCorreto() throws Exception {
        String email = "teste_email@gmail.com";
        Usuario usuario = new Usuario();
        usuario.setMail(email);
        assertEquals(email, usuario.getMail());
    }

    @Test
    public void testeEmailIncorreto() throws Exception {
        String email = "teste_email#gmail.com";
        Usuario usuario = new Usuario();
        usuario.setMail(email);
        assertEquals(email, usuario.getMail());
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
        long cpf = 265453923l;
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeCpfIncorretoMenor() throws Exception {
        long cpf = 0026l;
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeCpfIncorretoMaior() throws Exception {
        long cpf = 262342535235532l;
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeCpfIncorretoInvalido() throws Exception {
        long cpf = 26453923l;
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    public void testeValidarUsuarioTrue() throws Exception {
        String email = "usuario123@gmail.com";
        String senha = "senha";
        Usuario usuario = new Usuario();
        usuario.setMail(email);
        usuario.setSenha(senha);
        assertEquals(true, usuario.validarUsuario(email, senha));
    }

    @Test
    public void testeValidarUsuarioSemSenha() throws Exception {
        String email = "usuario123@gmail.com";
        String senha = "";
        Usuario usuario = new Usuario();
        usuario.setMail(email);
        usuario.setSenha(senha);
        assertEquals(false, usuario.validarUsuario(email, senha));
    }

    @Test
    public void testeValidarUsuarioSemEmail() throws Exception {
        String email = "";
        String senha = "testesenha1343";
        Usuario usuario = new Usuario();
        usuario.setMail(email);
        usuario.setSenha(senha);
        assertEquals(false, usuario.validarUsuario(email, senha));
    }
}
