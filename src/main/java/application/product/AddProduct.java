package application.product;

import infra.DAO;
import models.Produto;

public class AddProduct {
	
	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		Produto produto = new Produto("Notebook", 2987.78);
		dao.openT().insert(produto).closeT();
		
	}

}
