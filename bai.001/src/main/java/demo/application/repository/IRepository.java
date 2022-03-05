package demo.application.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.springframework.stereotype.Repository;

@Repository
public class IRepository {

	private final EntityManagerFactory emf;

	private final EntityManager em;

	public IRepository() {

		emf = Persistence.createEntityManagerFactory("ctvftech_demo");

		em = emf.createEntityManager();
	}

	public EntityManager get() {

		return em;
	}

	public void begin() throws IllegalStateException {

		if (em.isOpen())
			em.getTransaction().begin();
	}

	public void rollback() throws IllegalStateException, PersistenceException {

		if (em.getTransaction().isActive())
			em.getTransaction().rollback();
	}

	public void commit() throws IllegalStateException, RollbackException {

		if (em.getTransaction().isActive())
			em.getTransaction().commit();
	}
	
	public void close() throws IllegalStateException{
		em.close();
		emf.close();
	}
}
