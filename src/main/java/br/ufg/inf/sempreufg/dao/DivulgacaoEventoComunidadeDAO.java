package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.HibernateSession;
import br.ufg.inf.sempreufg.modelo.DivulgacaoEventoComunidade;
import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Vector;

public class DivulgacaoEventoComunidadeDAO {

    private static final SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    public int salvar(Evento evento, List<Usuario> usuarios){

        Transaction transact = null;
        int divulgEventComunID = 0;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            DivulgacaoEventoComunidade divulgacaoEventoComunidade = new DivulgacaoEventoComunidade(evento, usuarios);
            divulgEventComunID = (int)session.save(divulgacaoEventoComunidade);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
        }
        return divulgEventComunID;
    }

    public void remover (int idDivulgEventComun){

        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            DivulgacaoEventoComunidade divulgacaoEventoComunidade = session.get(DivulgacaoEventoComunidade.class, idDivulgEventComun);
            session.delete(divulgacaoEventoComunidade);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

    public DivulgacaoEventoComunidade consultarPorId(int idDivulgEventComun){

        DivulgacaoEventoComunidade divulgacaoEventoComunidade = null;
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            divulgacaoEventoComunidade = (DivulgacaoEventoComunidade) session.createQuery("from <table_name> where <id_row> = " + idDivulgEventComun).uniqueResult();
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
        return divulgacaoEventoComunidade;
    }

    public void atualizar(int idDivulgEventComun, DivulgacaoEventoComunidade novaDivulgacaoEventoComunidade){
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            DivulgacaoEventoComunidade divulgacaoEventoComunidade = session.get(DivulgacaoEventoComunidade.class, idDivulgEventComun);
            divulgacaoEventoComunidade.setEvento(novaDivulgacaoEventoComunidade.getEvento());
            divulgacaoEventoComunidade.setUsuarios(novaDivulgacaoEventoComunidade.getUsuarios());
            session.update(divulgacaoEventoComunidade);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<DivulgacaoEventoComunidade> consultarTodos(){

        List<DivulgacaoEventoComunidade> divulgacoesEventoComunidade = new Vector<>();
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            for (Object divulgacaoEventoComunidade : session.createQuery("from <table_name>").list()) {
                divulgacoesEventoComunidade.add((DivulgacaoEventoComunidade) divulgacaoEventoComunidade);
            }
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
        return divulgacoesEventoComunidade;
    }



}
