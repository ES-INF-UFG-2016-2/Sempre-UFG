package br.ufg.inf.view;

import br.ufg.inf.modelo.AutenticacaoUsuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Esta classe é responsável por gerenciar operações relacionadas a autenticação
 * providas pela interface de usuário.
 *
 * @author cleber
 */
@ManagedBean(name = "autenticaoView")
@SessionScoped
public class AutenticacaoView {
    private AutenticacaoUsuario autenticacaoUsuario;

    public AutenticacaoView() {
        autenticacaoUsuario = new AutenticacaoUsuario();
    }

    public AutenticacaoUsuario getAutenticacaoUsuario() {
        return autenticacaoUsuario;
    }

    public void setAutenticacaoUsuario(AutenticacaoUsuario autenticacaoUsuario) {
        this.autenticacaoUsuario = autenticacaoUsuario;
    }
    
    public void autenticar() {
        System.out.println("Autenticando " + autenticacaoUsuario.getLogin() + " com senha " + autenticacaoUsuario.getSenha());
    }
}
