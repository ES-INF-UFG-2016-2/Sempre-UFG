package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.HibernateSession;
import br.ufg.inf.sempreufg.modelo.Noticia;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class NoticiaDAO {

    private static final SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    public Noticia salvar(int idEvento,Date dataExpiracao){
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            Noticia noticia = new Noticia(idEvento, dataExpiracao);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public void remover (int IdEvento){

    }

    public Noticia consultarPorId(int idEvento){
        return null;
    }

    public Noticia atualizar(int idEvento,Date dataExpiracao){
        return null;
    }

    public List<Noticia> consultarTodos(){
        return null;
    }

}
