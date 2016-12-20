package br.ufg.inf.sempreufg.db;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class GerenciadorPersistencia {

    private static EntityManager entityManager = Persistence.createEntityManagerFactory("sempreufg").
        createEntityManager();;

    public static <T> List<T> executaQuery(String hibernateQuery, Class<T> classe) {
        return entityManager.createQuery(hibernateQuery, classe).getResultList();
    }

    public static EntityManager obtenhaEntityManager() {
        return entityManager;
    }

}
