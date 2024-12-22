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
	
	public static void createFile() {
        try {
            File file = new File("Loja.ser");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
	
	public static int menuAdmin(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Gestão de Utilizadores");
		 System.out.println("2 - Gestão de Loja/Stocks");
		 System.out.println("3 - Performance/Estatisticas da Loja");
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
		 System.out.println("5 - Por Implementar");
		 System.out.println("6 – Por Implementar");
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
		 System.out.println("1 - Por Implementar");
		 System.out.println("2 - Por Implementar");
		 System.out.println("3 - Por Implementar");
		 System.out.println("4 - Por Implementar");
		 System.out.println("5 - Por Implementar");
		 System.out.println("6 – Por Implementar");
		 System.out.println("7 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
		 }
	
	public static int menuCategorias(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Categoria 1");
		 System.out.println("2 - Categoria 2");
		 System.out.println("3 - Categoria 3");
		 System.out.println("4 - Categoria 4");
		 System.out.println("5 - Categoria 5");
		 System.out.println("6 – Categoria 6");
		 System.out.println("7 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
	
	public static int menuUser(){ // função na classe do main
		 int opcao;
		 System.out.println("1 - Listar Categorias");
		 System.out.println("2 - Consultar Produto dado Nome");
		 System.out.println("3 - Consultar Produtos de Categorias");
		 System.out.println("4 - Consultar Produto dado ID");
		 System.out.println("5 - Comprar Produto por ID");
		 System.out.println("6 – ");
		 System.out.println("7 - Sair");
		 System.out.println("Qual a sua opção:");
		 opcao = Ler.umInt();
		 return opcao;
	 	}
}
