package br.ufg.inf.servico;

import java.util.Date;

/**
 *
 * @author Matheus Cardoso Duarte Santos
 */
public interface DivulgadorNoticiasServiceInterface {

    boolean divulgarNoticia(int idEvento, Date dataExpiracao);

    boolean removerNoticiasExpiradas();

    boolean removerNoticia(int idEvento);
}
