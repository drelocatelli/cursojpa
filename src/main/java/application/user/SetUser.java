package application.user;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuario;

public class SetUser {
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// input
		System.out.print("Digite o ID do usuario que deseja alterar: ");
		int id = input.nextInt();
		
		System.out.println("Encontrado:");
		Usuario usuario = em.find(Usuario.class, id);
		System.out.println(usuario);
		
		// input
		System.out.print("Digite o novo nome: ");
		String nome = input.nextLine();
		nome = input.nextLine();
		
		usuario.setNome(nome);
		
		em.merge(usuario);
		em.getTransaction().commit();
		
		System.out.println("Usuario alterado:");
		System.out.println(usuario);
		
	}
	
}
