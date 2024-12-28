package Trabalho;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import myinputs.Ler;

public class FuncAuxiliares {
	// Method to clear the console by printing multiple empty lines
	public static void ClearConsole() {
	        for (int i = 0; i < 50; ++i) {
	            System.out.println();
	        }
	    }
	
	public static int menuAdmin(){ // Menu for the admin to choose main options
		 int opcao;
		 System.out.println("/====================================================/");
	     System.out.println("/                 MENU ADMINISTRADOR                 /");
	     System.out.println("/====================================================/");
	     System.out.println("/====================================================/");
		 System.out.println("/      [1] - Gestão de Utilizadores                  /");
		 System.out.println("/      [2] - Gestão de Loja/Stocks                   /");
		 System.out.println("/      [3] - Estatísticas da Loja                    /");
		 System.out.println("/      [0] - Logout                                  /");
		 System.out.println("/====================================================/");
		 System.out.println("\n    Escolha Uma Opção:\n                            ");
		 opcao = Ler.umInt();
		 return opcao;
		 }
	
	public static int menuAdminGestao(){ // Menu for admin's product management options
		 int opcao;
		 System.out.println("/====================================================/");
	     System.out.println("/                GESTÃO DE LOJA/STOCKS               /");
	     System.out.println("/====================================================/");
	     System.out.println("/====================================================/");
		 System.out.println("/      [1] - Novo Produto                            /");
		 System.out.println("/      [2] - Listar Produtos                         /");
		 System.out.println("/      [3] - Apagar Produto                          /");
		 System.out.println("/      [4] - Alterar Categoria de um Produto         /");
		 System.out.println("/      [5] - Gerenciador de Stocks                   /");
		 System.out.println("/      [0] - Sair                                    /");
		 System.out.println("/====================================================/");
		 System.out.println("\n    Escolha Uma Opção:\n                            ");
		 opcao = Ler.umInt();
		 return opcao;
		 }
	
	public static int menuAdminUserManager(){ // Menu for admin's user management options
		 int opcao;
		 System.out.println("/====================================================/");
	     System.out.println("/                GESTÃO DE UTILIZADORES              /");
	     System.out.println("/====================================================/");
	     System.out.println("/====================================================/");
		 System.out.println("/      [1] - Apagar Utilizador                       /");
		 System.out.println("/      [2] - Listar Utilizadores                     /");
		 System.out.println("/      [3] – Criar Novo Admin User                   /");
		 System.out.println("/      [0] - Sair                                    /");
		 System.out.println("/====================================================/");
		 System.out.println("\n    Escolha Uma Opção:\n                            ");
		 opcao = Ler.umInt();
		 return opcao;
		 }
	
	public static int menuAdminShopPerformance(){ //  Menu for admin's shop performance analytics
		 int opcao;
		 System.out.println("/====================================================/");
	     System.out.println("/                ESTATÍSTICA DA LOJA                 /");
	     System.out.println("/====================================================/");
	     System.out.println("/====================================================/");
		 System.out.println("/      [1] - Produtos Mais e Menos Vendidos          /");
		 System.out.println("/      [2] - Dois Melhores Clientes                  /");
		 System.out.println("/      [3] - Valor Faturado no dia de hoje           /");
		 System.out.println("/      [4] - Valor Faturado na última semana         /");
		 System.out.println("/      [5] - Valor Faturado no último mês            /");
		 System.out.println("/      [6] – Número de vendas diárias                /");
		 System.out.println("/      [0] - Sair                                    /");
		 System.out.println("/====================================================/");
		 System.out.println("\n    Escolha Uma Opção:\n                            ");
		 opcao = Ler.umInt();
		 return opcao;
		 }
	
	
	public static int menuCarrinho(){ // Menu for cart management options
		 int opcao;
		 System.out.println("/====================================================/");
	     System.out.println("/                CARRINHO DE COMPRAS                 /");
	     System.out.println("/====================================================/");
	     System.out.println("/====================================================/");
		 System.out.println("/      [1] - Consultar Carrinho                      /");
		 System.out.println("/      [2] - Tirar Produto do Carrinho               /");
		 System.out.println("/      [3] - Finalizar Compra                        /");
		 System.out.println("/      [4] - Cancelar/Apagar Carrinho                /");
		 System.out.println("/      [0] - Sair                                    /");
		 System.out.println("/====================================================/");
		 System.out.println("\n    Escolha Uma Opção:\n                            ");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
	
	public static int menuConsultarProdutos(){ // Menu for product consultation options
		 int opcao;
		 System.out.println("/====================================================/");
	     System.out.println("/                PESQUISAR NO CATÁLOGO               /");
	     System.out.println("/====================================================/");
	     System.out.println("/====================================================/");
		 System.out.println("/      [1] - Listar Categorias                       /");
		 System.out.println("/      [2] - Consultar Produto dado Nome             /");
		 System.out.println("/      [3] - Consultar Produtos de Categorias        /");
		 System.out.println("/      [4] - Consultar Produto dado ID               /");
		 System.out.println("/      [5] - Procurar Produtos pela Idade Indicada   /");
		 System.out.println("/      [6] - Adicionar Produto ao Carrinho por ID    /");
		 System.out.println("/      [7] – Adicionar Produto ao Carrinho por Nome  /");
		 System.out.println("/      [0] - Sair                                    /");
		 System.out.println("/====================================================/");
		 System.out.println("\n    Escolha Uma Opção:\n                            ");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
	
	public static int menuCliente(){ // Menu for customer options
		 int opcao;
		 System.out.println("/====================================================/");
	     System.out.println("/                   MENU UTILIZADOR                  /");
	     System.out.println("/====================================================/");
	     System.out.println("/====================================================/");
		 System.out.println("/      [1] - Pesquisar No Catálogo                   /");
		 System.out.println("/      [2] - Carrinho de Compras                     /");
		 System.out.println("/      [3] - Consultar Faturas                       /");
		 System.out.println("/      [0] - Sair                                    /");
		 System.out.println("/====================================================/");
		 System.out.println("\n    Escolha Uma Opção:\n                            ");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
	public static int menuAdminStockManager(){ // Menu for admin's stock management options
		 int opcao;
		 System.out.println("/====================================================/");
	     System.out.println("/                GERENCIADOR DE STOCKS               /");
	     System.out.println("/====================================================/");
	     System.out.println("/====================================================/");
		 System.out.println("/      [1] - Consultar Stock de Produtos             /");
		 System.out.println("/      [2] - Adicionar Stocks                        /");
		 System.out.println("/      [3] - Remover Stocks                          /");
		 System.out.println("/      [0] - Sair                                    /");
		 System.out.println("/====================================================/");
		 System.out.println("\n    Escolha Uma Opção:\n                            ");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
}