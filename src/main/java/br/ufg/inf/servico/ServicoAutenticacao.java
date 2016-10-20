package br.ufg.inf.servico;

import br.ufg.inf.dao.UsuarioDAO;
import br.ufg.inf.excecao.AutenticacaoException;
import br.ufg.inf.modelo.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cleber
 */
@ManagedBean
@SessionScoped
public class ServicoAutenticacao {
    
//    private HttpSession sessao;
    private boolean autenticado;
    private Usuario usuarioAutenticado;
    private String erro;

    @PostConstruct
    public void init() {
//        sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);        
        autenticado = false;
        usuarioAutenticado = null;
    }
    
    public boolean login(String login, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        setUsuarioAutenticado(usuarioDAO.getUsuarioAutenticacao(login, senha));
        if(getUsuarioAutenticado() == null){
            
            setAutenticado(false);
            erro = "Usuário e senha incorretos!";
//            sessao.setAttribute("autenticado", true);
        } else {
            setAutenticado(true);
            erro = "";
        }
        return isAutenticado();
    }
    
    public void logout(){
        
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
