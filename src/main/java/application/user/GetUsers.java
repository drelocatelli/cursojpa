package application.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuario;

public class GetUsers {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();
		
		// jpql
		List<Usuario> usuarios = em
				.createQuery("SELECT u from Usuario u", Usuario.class)
				.setMaxResults(10)
				.getResultList();
		
		for(Usuario usuario: usuarios) {
			System.out.println(usuario);
		}
		
		em.close();
	}
	
}
