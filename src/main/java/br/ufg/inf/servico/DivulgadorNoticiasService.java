package br.ufg.inf.servico;

import br.ufg.inf.modelo.Noticia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Matheus Cardoso Duarte Santos
 */
public class DivulgadorNoticiasService implements DivulgadorNoticiasServiceInterface {

    private List<Noticia> noticias = new ArrayList();

    @Override
    public boolean divulgarNoticia(int idEvento, Date dataExpiracao) {
        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getIdEvento() == idEvento) {
                return false;
            }
        }
        removerNoticiasExpiradas();
        Noticia noticia = new Noticia(idEvento);
        noticia.setExpiracao(dataExpiracao);
        noticias.add(noticia);
        return true;
    }

    @Override
    public boolean removerNoticiasExpiradas() {
        Date dataAtual = new Date(System.currentTimeMillis());
        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getExpiracao().getTime() < dataAtual.getTime()) {
                noticias.remove(i);
            }
        }
        return true;
    }

    @Override
    public boolean removerNoticia(int idEvento) {
        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getIdEvento() == idEvento) {
                noticias.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }
}
