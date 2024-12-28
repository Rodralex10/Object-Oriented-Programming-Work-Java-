package Trabalho;
import Trabalho.FuncProdutos;
import java.io.*;

import java.util.ArrayList;
import myinputs.Ler;

public class MainTrabalho {	 
	
		// Main method to start the application
		public static void main(String[] args) {
		int escolha,op1,op2,op3;
        ArrayList<Produto> produtos = carregarProdutos(); // Load the list of products from the file
        ArrayList<Utilizador> users = carregarUtilizadores(); // Load the list of users from the file
        ArrayList<Fatura> faturas = carregarFaturas(); // Load the list of invoices from the file
        Utilizador.setUltimo(users.size()); // Set the last user ID based on the number of users
        FuncLogin.setUtilizadores(users); // Set the list of users in the FuncLogin class
        
		do {
			
			// Main menu options
			System.out.println("/====================================================/");
            System.out.println("/           BEM VINDO À LOJA DE BRINQUEDOS           /");
            System.out.println("/====================================================/");
            System.out.println("/        [1] - Registo                               /");
            System.out.println("/        [2] - Login                                 /");
            System.out.println("/        [3] - Sair                                  /");
            System.out.println("/====================================================/");
            System.out.println("\n    Escolha Uma Opção:\n                            ");
	         escolha = Ler.umInt(); // Read user choice
	         
			switch (escolha) {
            case 1:
                FuncLogin.register(); // Register a new user
                break;	
            case 2:
                Utilizador user = FuncLogin.login(); // Login a user
                if (user != null) {
                    if (user instanceof Administrador) { // Check if the user is an administrator
                    	do {
                        op1 = FuncAuxiliares.menuAdmin(); // Display admin menu
                        	switch (op1) {
                        	case 1:
                                do {
                                	op2 = FuncAuxiliares.menuAdminUserManager(); // User management menu for admin
                                    	switch (op2) {
                                    	case 1:
                                    		FuncLogin.removerUtilizador(); // Remove an existing user                             
                                            break;
                                    	case 2:
                                    		System.out.println(FuncLogin.getUtilizadores()); // List all users
                                            break;
                                    	case 3:
                                    		FuncLogin.adminregister(); // Register a new admin user
                                            break;
                                    	case 0:
                                    		System.out.println("Sucesso!!\n\n");
                                            break;
                                        default:
                                        	System.out.println("\nOpção inválida!");
                                     		System.out.println("Tente novamente:\n");
                                            break;
                                    	}
                                	}while (op2 != 0);
                                break;
                        		case 2:
                        		do {
                        		op2 = FuncAuxiliares.menuAdminGestao(); // Product management menu                                 
                                    	switch (op2) {
                                    	case 1:
                                    		FuncProdutos.inserirProduto(produtos); // Insert a new product
                                            break;
                                    	case 2:
                                    		System.out.println(produtos); // List all products
                                            break;
                                    	case 3:
                                    		FuncProdutos.removerProduto(produtos); // Remove a product
                                            break;
                                    	case 4:
                                    		FuncProdutos.alterarCategoria(produtos); // Change a product category
                                            break;
                                    	case 5:
                                    		do {
                                            	op3 = FuncAuxiliares.menuAdminStockManager(); // Stock management menu
                                                	switch (op3) {
                                                	case 1:
                                                		FuncProdutos.stockVerify(produtos); // Verify product stock                    
                                                        break;
                                                	case 2:
                                                		FuncProdutos.adicionarStock(produtos); // Add stock to a product
                                                        break;
                                                	case 3:
                                                		FuncProdutos.removerStock(produtos); // Remove stock from a product
                                                        break;
                                                	case 0:
                                                		System.out.println("Sucesso!!\n\n");
                                                        break;
                                                    default:
                                                    	System.out.println("\nOpção inválida!");
                                                 		System.out.println("Tente novamente:\n");
                                                        break;
                                                	}
                                            	}while (op3 != 0);
                                            break;
                                    	case 0:
                                    		System.out.println("Sucesso!!\n\n");
                                            break;
                                        default:
                                        	System.out.println("\nOpção inválida!");
                                     		System.out.println("Tente novamente:\n");
                                            break;
                                    	}
                                	}while (op2 != 0);
                                break;
                        	case 3:
                        		do {
                        			op2 = FuncAuxiliares.menuAdminShopPerformance(); // Performance menu for admin
                                    	switch (op2) {
                                    	case 1:
                                    		Estatisticas.produtosMaisEMenosVendidos(faturas); // Display best and worst-selling products
                                            break;
                                    	case 2:
                                    		Estatisticas.melhoresClientes(faturas); // Display top clients
                                            break;
                                    	case 3:
                                    	    Estatisticas.calcularFaturacaoPorPeriodo(faturas, 1); // Calculate today's revenue                            	 
                                            break;
                                    	case 4:
                                    		Estatisticas.calcularFaturacaoPorPeriodo(faturas, 2); // Calculate weekly revenue
                                            break;
                                    	case 5:
                                    		Estatisticas.calcularFaturacaoPorPeriodo(faturas, 3); // Calculate monthly revenue
                                            break;
                                    	case 6:
                                    		Estatisticas.exibirNumeroDeVendasDiarias(faturas); // Display daily sales count
                                            break;
                                    	case 0:
                                    		System.out.println("Sucesso!!\n\n");
                                            break;
                                        default:
                                        	System.out.println("\nOpção inválida!");
                                     		System.out.println("Tente novamente:\n");
                                            break;
                                    	}
                                	}while (op2 !=0);
                                break;
                        	case 0:
                        		System.out.println("Sucesso!!\n\n");
                                break;
                            default:
                            	System.out.println("\nOpção inválida!");
                         		System.out.println("Tente novamente:\n");
                                break;
                        	}
                    	}while (op1 !=0);
                    } else if (user instanceof Cliente) { // Check if the user is a client
                        Cliente cliente = (Cliente) user;
                        do {
                            op1 = FuncAuxiliares.menuCliente(); // Display client menu
                            switch (op1) {
                                case 1:
                                	do {
                                    	op2 = FuncAuxiliares.menuConsultarProdutos(); // Product consultation menu
                                        	switch (op2) {
                                        	case 1:
                                        		FuncProdutosClientes.listarCategorias(produtos); // List available categories                            
                                                break;
                                        	case 2:
                                        		FuncProdutosClientes.consultarProdutoPorNome(produtos); // Search for product by name
                                                break;
                                        	case 3:
                                        		FuncProdutosClientes.consultarProdutosPorCategoria(produtos); // Search for products by category
                                                break;
                                        	case 4:
                                        		FuncProdutosClientes.consultarProdutoPorID(produtos); // Search for product by ID
                                                break;
                                        	case 5:
                                        		FuncProdutosClientes.consultarProdutosPorIdade(produtos); // Search for products by age group
                                                break;
                                        	case 6:
                                        		FuncVendas.addProdutoAoCarroID(produtos, cliente); // Add product to cart by ID
                                                break;
                                        	case 7:
                                        		FuncVendas.addProdutoAoCarroNome(produtos, cliente); // Add product to cart by name
                                                break;
                                        	case 0:
                                        		System.out.println("Sucesso!!\n\n");
                                                break;
                                            default:
                                            	System.out.println("\nOpção inválida!");
                                         		System.out.println("Tente novamente:\n");
                                        	}
                                    	}while (op2 !=0);
                                    break;
                                case 2:
                                	do {
                                    	op2 = FuncAuxiliares.menuCarrinho(); // Cart management menu
                                        	switch (op2) {
                                        	case 1:
                                        		FuncVendas.listarCarrinho(cliente); // List items in the cart                             
                                                break;
                                        	case 2:
                                                break;
                                        	case 3:
                                        		FuncVendas.finalizarCompra(cliente, faturas, produtos); // Finalize purchase
                                                break;
                                        	case 4:
                                        		FuncVendas.limparCarrinho(cliente); // Clear the cart
                                                break;
                                        	case 0:
                                        		System.out.println("Sucesso!!\n\n");
                                                break;
                                            default:
                                            	System.out.println("\nOpção inválida!");
                                         		System.out.println("Tente novamente:\n");
                                                break;
                                        	}
                                    	}while (op2 !=0);
                                    break;
                                case 3:
                                	FuncVendas.listarFaturasDoCliente(cliente, faturas); // List invoices for the client
                                    break;                  
                                case 0:
                                    System.out.println("A sair...\n");
                                    break;
                                default:
                                	System.out.println("\nOpção inválida!");
                             		System.out.println("Tente novamente:\n");
                            }
                        } while (op1 != 0);
                    }
                }
                break;
            case 3:
                System.out.println("A sair...\n"); // Exit the application
                break;
            case 4:
                System.out.println("A sair...\n"); // Exit the application
                break;
            default:
            	System.out.println("\nOpção inválida!");
         		System.out.println("Tente novamente:\n");
                break;
			}
		} while (escolha != 4); // Exit when option 4 is selected
	}
	
	// Method to load the list of users from the file
	private static ArrayList<Utilizador> carregarUtilizadores() {
	    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Utilizadores.ser"))) {
	        Utilizador.setUltimo(is.readInt()); // Load the last user ID
	        return (ArrayList<Utilizador>) is.readObject(); // Load the list of users
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Erro ao carregar utilizadores: " + e.getMessage());
	        return new ArrayList<>(); // Return an empty list if an error occurs
	    }
	}

	// Method to load the list of products from the file
	private static ArrayList<Produto> carregarProdutos() {
	    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Produtos.ser"))) {
	        Produto.setUltimo(is.readInt()); // Load the last product ID
	        return (ArrayList<Produto>) is.readObject(); // Load the list of products
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Erro ao carregar produtos: " + e.getMessage());
	        return new ArrayList<>(); // Return an empty list if an error occurs
	    }
	}
	
	// Method to load the list of invoices from the file
	private static ArrayList<Fatura> carregarFaturas() {
	    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Faturas.ser"))) {
	    	Fatura.setUltimo(is.readInt()); // Load the last invoice ID
	    	return (ArrayList<Fatura>) is.readObject(); // Load the list of invoices
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Erro ao carregar as faturas: " + e.getMessage());
	        return new ArrayList<>(); // Return an empty list if an error occurs
	    }
	}	
}