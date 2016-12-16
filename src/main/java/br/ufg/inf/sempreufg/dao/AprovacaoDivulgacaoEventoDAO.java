package br.ufg.inf.sempreufg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufg.inf.sempreufg.interfaces.AprovacaoDivulgacaoEventoDAOInterface;
import br.ufg.inf.sempreufg.modelo.AprovacaoDivulgacaoEvento;

public class AprovacaoDivulgacaoEventoDAO implements AprovacaoDivulgacaoEventoDAOInterface{

    private AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento;

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sempreufg");
    
    @Override
    public void salvar(AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento) {
    	EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(aprovacaoDivulgacaoEvento);
		em.getTransaction().commit();
    }

    @Override
    public void alterar(AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento) {

    }

    @Override
    public void deletar(int id_AprovacaoDivulgacaoEvento) {

    }

    @Override
    public AprovacaoDivulgacaoEvento getById(int id_Areid_AprovacaoDivulgacaoEvento) {
        return null;
    }

    @Override
    public boolean obtemStatusAprovacaoEvento() {
        return aprovacaoDivulgacaoEvento.isDivulgacaoAprovada();
    }
}
