package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("aula-jpa");
		}catch(Exception e) {
			
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> openT() {
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> closeT() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> insert(E entidade) {
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> insertAtomic(E entidade) {
		return this.openT().insert(entidade).closeT();
	}
	
	public List<E> obterTodos(int limit, int displacement){
		if(classe == null) {
			throw new UnsupportedOperationException("Null class");
		}
		
		String jpql = "SELECT e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(limit);
		query.setFirstResult(displacement);
		return query.getResultList();
		
	}
	
}
