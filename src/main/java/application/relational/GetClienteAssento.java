package application.relational;

import java.util.List;

import infra.DAO;
import models.relationship.Assento;
import models.relationship.Cliente;

public class GetClienteAssento {

public static void main(String[] args) {
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		List<Cliente> clientes = dao.obterTodos(10, 0);
		
		for(Cliente cliente: clientes) {
			System.out.println(cliente);
		}
		
	}
	
}
