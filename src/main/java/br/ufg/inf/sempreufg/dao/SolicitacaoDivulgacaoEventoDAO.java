package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.HibernateSession;
import br.ufg.inf.sempreufg.modelo.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Vector;

public class SolicitacaoDivulgacaoEventoDAO {

        private static final SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        public int salvar(Evento evento, Usuario usuario){
            Transaction transact = null;
            int solicitacaoDivulgacaoEventoID = 0;
            try (Session session = sessionFactory.openSession()) {
                transact = session.beginTransaction();
                SolicitacaoDivulgacaoEvento solicitacaoDivulgacaoEvento = new SolicitacaoDivulgacaoEvento(evento, usuario);
                solicitacaoDivulgacaoEventoID = (int)session.save(solicitacaoDivulgacaoEvento);
                transact.commit();
            } catch (HibernateException e) {
                if (transact != null) {
                    transact.rollback();
                }
                e.printStackTrace();
            }
            return solicitacaoDivulgacaoEventoID;
        }

    public SolicitacaoDivulgacaoEvento consultarPorId(int id) {

        SolicitacaoDivulgacaoEvento solicitacaoDivulgacaoEvento = null;
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            solicitacaoDivulgacaoEvento = (SolicitacaoDivulgacaoEvento) session.createQuery("from <table_name> where <id_row> = " + id).uniqueResult();
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
        return solicitacaoDivulgacaoEvento;

    }

    public List<SolicitacaoDivulgacaoEvento> consultarTodas(){

        List<SolicitacaoDivulgacaoEvento> solicitacoesDivulgacaoEventos = new Vector<>();
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            for (Object aUser : session.createQuery("from <table_name>").list()) {
                solicitacoesDivulgacaoEventos.add((SolicitacaoDivulgacaoEvento) aUser);
            }
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
        return solicitacoesDivulgacaoEventos;

    }

    public void updateUser(int id, SolicitacaoDivulgacaoEvento novaSolicitacaoDivulgacaoEvento){

        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            SolicitacaoDivulgacaoEvento solicitacaoDivulgacaoEvento = session.get(SolicitacaoDivulgacaoEvento.class, id);
            solicitacaoDivulgacaoEvento.setEvento(novaSolicitacaoDivulgacaoEvento.getEvento());
            solicitacaoDivulgacaoEvento.setUsuario(novaSolicitacaoDivulgacaoEvento.getUsuario());
            solicitacaoDivulgacaoEvento.setAprovado(novaSolicitacaoDivulgacaoEvento.isAprovado());
            session.update(solicitacaoDivulgacaoEvento);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

    public void remover(int id){

        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            SolicitacaoDivulgacaoEvento solicitacaoDivulgacaoEvento = session.get(SolicitacaoDivulgacaoEvento.class, id);
            session.delete(solicitacaoDivulgacaoEvento);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

}
