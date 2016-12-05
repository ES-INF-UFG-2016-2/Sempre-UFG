package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.Noticia;

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
        noticias.add(new Noticia(idEvento, new Date(System.currentTimeMillis());
        return true;
    }

    @Override
    public boolean removerNoticiasExpiradas() {
        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).isExpirada()) {
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
