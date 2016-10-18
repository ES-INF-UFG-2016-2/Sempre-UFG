package br.ufg.inf.view;

import br.ufg.inf.modelo.AutenticacaoPrimeiroAcesso;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author cleber
 */
@ManagedBean(name = "primeiroAcessoView")
public class PrimeiroAcessoView {
    private AutenticacaoPrimeiroAcesso autenticacaoPrimeiroAcesso;

    public PrimeiroAcessoView() {
        autenticacaoPrimeiroAcesso = new AutenticacaoPrimeiroAcesso();
    }

    public void realizarPrimeiroAcesso(){
        System.out.println("Verificando acesso...");
    }
    
    public AutenticacaoPrimeiroAcesso getAutenticacaoPrimeiroAcesso() {
        return autenticacaoPrimeiroAcesso;
    }

    public void setAutenticacaoPrimeiroAcesso(AutenticacaoPrimeiroAcesso autenticacaoPrimeiroAcesso) {
        this.autenticacaoPrimeiroAcesso = autenticacaoPrimeiroAcesso;
    }
    
    
}
