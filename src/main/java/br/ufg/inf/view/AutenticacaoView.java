package br.ufg.inf.view;

import br.ufg.inf.modelo.Usuario;
import br.ufg.inf.servico.ServicoAutenticacao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Esta classe é responsável por gerenciar operações relacionadas a autenticação
 * providas pela interface de usuário.
 *
 * @author cleber
 */
@ManagedBean(name = "autenticaoView")
@SessionScoped
public class AutenticacaoView implements Serializable {
    private String login;
    private String senha;
    private String mensagemErro;
    
    @ManagedProperty(value = "#{servicoAutenticacao}")
    private ServicoAutenticacao servicoAutenticacao;

    public AutenticacaoView() {
        login = "";
        senha = "";
        mensagemErro = "essa mensagem não está aparecendo";
    }
    
    public void autenticar() {
        System.out.println("Autenticando " + login + " com senha " + senha + "...");
        servicoAutenticacao.login(login, senha);
        mensagemErro = servicoAutenticacao.getErro();
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

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public ServicoAutenticacao getServicoAutenticacao() {
        return servicoAutenticacao;
    }

    public void setServicoAutenticacao(ServicoAutenticacao servicoAutenticacao) {
        this.servicoAutenticacao = servicoAutenticacao;
    }
    
    
    
    
}
