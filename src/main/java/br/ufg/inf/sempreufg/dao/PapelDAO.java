package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.HibernateSession;
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

public class PapelDAO {

    private static final SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    public int salvar(String siglaPapel, String nomePapel, ArrayList<Usuario> usuarios, ArrayList<Recurso> recursos){

        int papelID = 0;
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            Papel papel = new Papel(siglaPapel, nomePapel, usuarios, recursos);
            papelID = (int)session.save(papel);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
        }
        return papelID;
    }

    public void remover (int idPapel){

        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            Papel papel = session.get(Papel.class, idPapel);
            session.delete(papel);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

    public Papel consultarPorId(int idPapel){

        Papel papel = null;
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            papel = (Papel) session.createQuery("from Papel where idPapel = " + idPapel).uniqueResult();
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
        return papel;
    }

    public void atualizar(int idPapel, Papel novoPapel){
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            Papel papel = session.get(Papel.class, idPapel);
            papel.setSiglaPapel(novoPapel.getSiglaPapel());
            papel.setNomePapel(novoPapel.getNomePapel());
            papel.setListaRecurso(novoPapel.getListaRecurso());
            papel.setListaUsuario(novoPapel.getListaUsuario());
            session.update(papel);
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Papel> consultarTodos(){

        List<Papel> papeis = new Vector<>();
        Transaction transact = null;
        try (Session session = sessionFactory.openSession()) {
            transact = session.beginTransaction();
            for (Object papel : session.createQuery("from Papel").list()) {
                papeis.add((Papel) papel);
            }
            transact.commit();
        } catch (HibernateException e) {
            if (transact != null){
                transact.rollback();
            }
            e.printStackTrace();
        }
        return papeis;
    }
}
