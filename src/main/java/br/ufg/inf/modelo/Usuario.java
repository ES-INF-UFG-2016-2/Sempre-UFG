package br.ufg.inf.modelo;

/**
 * Esta classe é responsável por definir e executar operações relacionadas a um
 * usuário.
 *
 * @author cleber
 */
public class Usuario {
    private String login;
    private String senha;

    public Usuario() {
        login = "";
        senha = "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
