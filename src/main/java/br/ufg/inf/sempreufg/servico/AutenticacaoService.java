package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.Usuario;

/**
 * Gerencia as informações e operações de autenticação do sistema SempreUFG.
 *
 * @author cleber
 */
public class AutenticacaoService {

    private boolean autenticado;
    private Usuario usuarioAutenticado;
    private String erro;

    public AutenticacaoService() {
        logout();
    }

    /**
     * Executa o login de usuário.
     *
     * @param login Identificador do usuário (email ou CPF)
     * @param senha Senha do usuário
     * @return TRUE se o usuário é autenticado com sucesso ou FALSE caso contrário.
     */
    public boolean login(String login, String senha) {
        //TODO
        return isAutenticado();
    }

    /**
     * Efetua o logout do usuário.
     */
    public void logout() {
        setAutenticado(false);
        setUsuarioAutenticado(null);
        setErro("");
    }

    /**
     * Efetua o login de usuário para o primeiro acesso do mesmo.
     *
     * @param egresso Objeto com os dados do egresso para verificação de autenticidade do usuário. As seguintes
     * informações egresso são esperadas para esse tipo de autenticação:
     * <ul>
     * <li> Nome da mãe </li>
     * <li> Data de nascimento </li>
     * <li> Nacionalidade (nome do país) </li>
     * <li> Nome de um curso e a respectiva matrícula no mesmo na UFG </li>
     * </ul>
     * @return TRUE se o usuário é autenticado com sucesso ou FALSE caso contrário.
     */
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
