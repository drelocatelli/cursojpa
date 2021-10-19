package application.user;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuario;

public class DeleteUser {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();

		// input
		System.out.print("Digite o ID do usuario que deseja excluir: ");
		int id = input.nextInt();

		Usuario usuario = em.find(Usuario.class, id);
		
		if(usuario != null) {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
			
			System.out.println(String.format("Usuario %d excluido!", id));
		}

	}

}
