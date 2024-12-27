package Trabalho;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import myinputs.Ler;

public class FuncAuxiliares {
	
	public static void ClearConsole() {
	        for (int i = 0; i < 50; ++i) {
	            System.out.println();
	        }
	    }
	
	public static int menuAdmin(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Gestão de Utilizadores");
		 System.out.println("2 - Gestão de Loja/Stocks");
		 System.out.println("3 - Estatisticas da Loja");
		 System.out.println("4 - Logout");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
		 }
	
	public static int menuAdminGestao(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Novo Produto");
		 System.out.println("2 - Listar Produtos");
		 System.out.println("3 - Apagar Produto");
		 System.out.println("4 - Alterar Categoria de um produto");
		 System.out.println("5 - Gerenciador de Stocks");
		 System.out.println("6 – Por Implementar?");
		 System.out.println("7 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
		 }
	
	public static int menuAdminUserManager(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Apagar Utilizador");
		 System.out.println("2 - Listar Utilizadores");
		 System.out.println("3 – Criar Novo Admin User");
		 System.out.println("4 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
		 }
	
	public static int menuAdminShopPerformance(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Produtos Mais e Menos Vendidos");
		 System.out.println("2 - Dois Melhores Clientes");
		 System.out.println("3 - Valor Faturado Diário (POR IMPLEMENTAR)");
		 System.out.println("4 - Número de Vendas Diário (POR IMPLEMENTAR)");
		 System.out.println("5 - Por Implementar");
		 System.out.println("6 – Por Implementar");
		 System.out.println("7 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
		 }
	
	public static int menuCarrinho(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Consultar Carrinho");
		 System.out.println("2 - Tirar Produto do Carrinho");
		 System.out.println("3 - Finalizar Compra");
		 System.out.println("4 - Cancelar/Apagar Carrinho");
		 System.out.println("5 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
	
	public static int menuConsultarProdutos(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Listar Categorias");
		 System.out.println("2 - Consultar Produto dado Nome");
		 System.out.println("3 - Consultar Produtos de Categorias");
		 System.out.println("4 - Consultar Produto dado ID");
		 System.out.println("5 - Adicionar Produto ao Carrinho por ID");
		 System.out.println("6 – Adicionar Produto ao Carrinho por Nome");
		 System.out.println("7 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
	
	public static int menuCliente(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Pesquisar No Catálogo");
		 System.out.println("2 - Carrinho de Compras");
		 System.out.println("3 - Consultar Estatisticas Pessoais e Faturas");
		 System.out.println("4 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
	public static int menuAdminStockManager(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Consultar Stock de Produtos");
		 System.out.println("2 - Adicionar Stocks");
		 System.out.println("3 - Remover Stocks");
		 System.out.println("4 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
}
