package br.ufg.inf.servico;

import br.ufg.inf.modelo.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cleber
 */
@ManagedBean
@SessionScoped
public class AutenticacaoService {
    
    private boolean autenticado;
    private Usuario usuarioAutenticado;
    private String erro;

    @PostConstruct
    public void init() {
        logout();
    }
    
    public boolean login(String login, String senha) {
        //TODO
        return isAutenticado();
    }
    
    public void logout(){
        setAutenticado(false);
        setUsuarioAutenticado(null);
        setErro("");
    }
    
    public boolean loginPrimeiroAcesso(Usuario usuario) {
        //TODO
        return isAutenticado();
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
    
}
