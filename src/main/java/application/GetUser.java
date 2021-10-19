package application;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuario;

public class GetUser {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();
		
		System.out.print("Digite o id: ");
		int id = input.nextInt();
		
		Usuario usuario = em.find(Usuario.class, id);
		System.out.println(usuario);
		
		em.close();
	}

}
