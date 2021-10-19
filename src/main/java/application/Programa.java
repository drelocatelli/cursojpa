package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa("Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa("Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		em.getTransaction().commit();
					
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
	}

}
