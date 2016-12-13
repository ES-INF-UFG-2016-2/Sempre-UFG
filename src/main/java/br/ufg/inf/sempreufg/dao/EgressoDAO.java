package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.HibernateSession;
import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.interfaces.EgressoDAOInterface;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.*;

public class EgressoDAO implements EgressoDAOInterface<Egresso> {

    private static final SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    @Override
    public void inserir(Egresso entity) {
    }

    @Override
    public List<Egresso> select(String sql, Map<String, Object> parametros) {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> select(String sql) {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> selectAll() {
        return criarListaEgressoMock();
    }

    @Override
    public Egresso buscarById(int id) {
        return null;
    }

    public List<Egresso> criarListaEgressoMock() {
        List<Egresso> egressos = new ArrayList<Egresso>();

        for (int i = 0; i < 10; i++) {
            Egresso egresso = new Egresso(
                "Everton Jose",
                "Maria",
                new Date(),
                Sexo.MASCULINO,
                new BitSet(),
                new BitSet(),
                VisibilidadeDados.PUBLICO,
                new ArrayList<HistoricoUFG>(),
                new LocalizacaoGeografica()
            );

            egressos.add(egresso);
        }

        return egressos;
    }

    @Override
    public int salvar(Egresso egresso) throws Exception {
        Transaction transact = null;
        int egressoID = 0;

        try (Session session = sessionFactory.openSession()) {

            transact = session.beginTransaction();
            egressoID = (int) session.save(egresso);
            transact.commit();

        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
        }
        return egressoID;
    }

    @Override
    public void atualizar(Egresso egressoAtualizado) {

        Transaction transact = null;

        try (Session session = sessionFactory.openSession()) {

            transact = session.beginTransaction();
            Egresso egressoDesatualizado = session.get(Egresso.class, egressoAtualizado.getId());
            egressoDesatualizado = egressoAtualizado;
            session.update(egressoDesatualizado);
            transact.commit();

        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void deletar(int id) throws SQLException {
        Transaction transact = null;

        try (Session session = sessionFactory.openSession()) {

            transact = session.beginTransaction();
            Egresso egresso = session.get(Egresso.class, id);
            session.delete(egresso);

            transact.commit();

        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }

            e.printStackTrace();
        }
    }

    @Override
    public Egresso getById(int id) throws Exception {

        Egresso egresso = null;
        Transaction transact = null;

        try (Session session = sessionFactory.openSession()) {

            transact = session.beginTransaction();
            egresso = session.get(Egresso.class, id);
            transact.commit();

        } catch (HibernateException e) {
            if (transact != null) {
                transact.rollback();
            }

            e.printStackTrace();
        }

        return egresso;
    }

    @Override
    public List<Egresso> getAll() throws SQLException {
        return null;
    }
}
