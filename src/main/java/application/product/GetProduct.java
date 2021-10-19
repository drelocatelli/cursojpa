package application.product;

import java.util.List;

import infra.DAO;
import models.Produto;

public class GetProduct {

	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		List<Produto> produtos = dao.obterTodos(10, 0);
		
		for(Produto produto: produtos) {
			System.out.println(produto);
		}
				
	}
	
}
