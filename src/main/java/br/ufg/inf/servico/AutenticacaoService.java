package br.ufg.inf.servico;

import br.ufg.inf.modelo.Egresso;
import br.ufg.inf.modelo.Usuario;
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

    public AutenticacaoService() {
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
    
    public boolean loginPrimeiroAcesso(Egresso egresso) {
        //TODO
        return isAutenticado();
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    protected void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    protected void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public String getErro() {
        return erro;
    }

    protected void setErro(String erro) {
        this.erro = erro;
    }
    
}
