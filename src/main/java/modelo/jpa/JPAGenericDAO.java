package modelo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.dao.GenericDAO;

public abstract class JPAGenericDAO<T, K> implements GenericDAO<T, K> {

	protected final EntityManager em;
	protected final Class<T> type;
	
	public JPAGenericDAO(Class<T> type) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPersona");
		em = emf.createEntityManager();
		this.type = type;
	}
	
	@Override
	public void create(T obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	@Override
	public void update(T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		
	}

	@Override
	public void delete(K id) {
		T obj = getById(id);
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
		
	}

	@Override
	public T getById(K id) {
		return em.find(type, id);
	}

}
