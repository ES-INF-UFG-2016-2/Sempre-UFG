package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.HibernateSession;
import br.ufg.inf.sempreufg.modelo.Log;
import br.ufg.inf.sempreufg.modelo.Papel;
import br.ufg.inf.sempreufg.modelo.Recurso;
import br.ufg.inf.sempreufg.modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LogDao {

    private static final SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    public void salvar(Log log) {

        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            session.save(log);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

    public void remover(Log log) {

        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            session.delete(log);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

    public Log consultarPorId(int id) {
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {

            return (Log) session.createQuery("from Log where idLog = " + id).uniqueResult();

        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public void atualizar(Log log) {
        Transaction transact = null;

        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            session.update(log);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<Log> consultarTodos() {

        try (Session session = sessionFactory.openSession()) {

            return session.createQuery("from Log", Log.class).list();

        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }

    }
}
