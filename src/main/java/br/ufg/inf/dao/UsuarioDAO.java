package br.ufg.inf.dao;

import br.ufg.inf.modelo.Usuario;

/**
 *
 * @author cleber
 */
public class UsuarioDAO {

    public Usuario getUsuarioAutenticacao(String identificador, String senha) {
        Usuario usuario = null;
        if ("cleber@ufg.br".equals(identificador) && "123456".equals(senha)) {
            usuario = new Usuario();
            usuario.setLogin("cleber@ufg.br");
            usuario.setSenha("123");
        }
        return usuario;
    }
}
