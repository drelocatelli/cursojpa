package application.relational;

import java.util.Scanner;

import infra.DAO;
import models.relationship.Assento;
import models.relationship.Cliente;

public class AddClienteAssento {
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Digite o nome do cliente: ");
		String nome = input.nextLine();
		
		System.out.print("Digite o nome do assento: ");
		String assNome = input.nextLine();
		
		Assento assento = new Assento(assNome);
		Cliente cliente = new Cliente(nome, assento);
		
		DAO<Object> dao = new DAO<>();
		
		dao
		.openT()
			.insert(assento)
			.insert(cliente)
		.closeT();
		
		System.out.println(cliente);
		
	}
	
}
