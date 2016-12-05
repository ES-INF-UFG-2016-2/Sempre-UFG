package br.ufg.inf.sempreufg.repository;

import br.ufg.inf.sempreufg.dao.NoticiaDAO;
import br.ufg.inf.sempreufg.modelo.Noticia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoticiaRepository {

    private NoticiaDAO noticiaDAO = new NoticiaDAO();

    public Noticia persisteNoticia(Noticia noticia){
        return noticiaDAO.salvar(noticia.getIdEvento(), noticia.getDataExpiracao());
    }
    public Noticia obterNoticia(int IdEvento){
        return noticiaDAO.consultarPorId(IdEvento);
    }

    public List<Noticia> obterListaNoticias(){
        return noticiaDAO.consultarTodos();
    }

    public List<Noticia> obterListaNoticiasExpiradas(){
        return noticiaDAO.consultarTodos().stream().filter(Noticia::isExpirada).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Noticia> obterListaNoticiasNaoExpiradas(){
        return noticiaDAO.consultarTodos().stream().filter(noticia -> !noticia.isExpirada()).collect(Collectors.toCollection(ArrayList::new));
    }

    public void removerNoticia (int idEvento){
        noticiaDAO.remover(idEvento);
    }

    public Noticia atualizaNoticia (Noticia noticia){
        return noticiaDAO.atualizar(noticia.getIdEvento(), noticia.getDataExpiracao());
    }

}
