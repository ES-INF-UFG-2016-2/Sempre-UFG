package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.HibernateSession;
import br.ufg.inf.sempreufg.modelo.Noticia;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Vector;

public class NoticiaDAO {

    private static final SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    public int salvar(int idEvento, Date dataExpiracao){

        Transaction transact = null;
        int noticiaID = 0;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            Noticia noticia = new Noticia(idEvento, dataExpiracao);
            noticiaID = (int)session.save(noticia);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
        }
        return noticiaID;
    }

    public void remover (int idNoticia){

        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            Noticia noticia = session.get(Noticia.class, idNoticia);
            session.delete(noticia);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

    public Noticia consultarPorId(int idNoticia){

        Noticia noticia = null;
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            noticia = (Noticia) session.createQuery("from <table_name> where <id_row> = " + idNoticia).uniqueResult();
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
        return noticia;
    }

    public void atualizar(int idNoticia, Noticia novaNoticia){
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            Noticia noticia = session.get(Noticia.class, idNoticia);
            noticia.setDataExpiracao(novaNoticia.getDataExpiracao());
            noticia.setExpirada(novaNoticia.isExpirada());
            session.update(noticia);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Noticia> consultarTodos(){

        List<Noticia> noticias = new Vector<>();
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            for (Object noticia : session.createQuery("from <table_name>").list()) {
                noticias.add((Noticia) noticia);
            }
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
        return noticias;
    }

}
