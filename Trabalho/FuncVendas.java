package Trabalho;

import java.util.ArrayList;
import java.io.*;
import myinputs.Ler;

public class FuncVendas {
	
		// Method to list all invoices of a specific client
		public static void listarFaturasDoCliente(Cliente cliente, ArrayList<Fatura> faturas) {
	    boolean encontrouFaturas = false;

	    System.out.println("Faturas do cliente " + cliente.getUsername() + ":");
	    // Iterate through the list of invoices
	    for (Fatura fatura : faturas) {
	        if (fatura.getIdCliente().getId() == cliente.getId()) { // Check if the invoice belongs to the client
	            System.out.println(fatura); // Print the invoice details
	            encontrouFaturas = true; // Mark as found
	        }
	    }

	    // If no invoices were found, print a message
	    if (!encontrouFaturas) {
	        System.out.println("Nenhuma fatura encontrada para este cliente.");
	    }
	}
	
		// Method to finalize a purchase for a client
		public static void finalizarCompra(Cliente cliente, ArrayList<Fatura> faturas, ArrayList<Produto> produtos) {
	    ArrayList<Produto> carrinhoProdutos = cliente.getCarrinho(); // Get the client's cart

	    if (carrinhoProdutos.isEmpty()) { // Check if the cart is empty
	        System.out.println("O carrinho está vazio!");
	        return;
	    }

	    // Create a new invoice and add it to the list
	    Fatura fatura = new Fatura(carrinhoProdutos, cliente);
	    faturas.add(fatura);
	    cliente.limparCarrinho(); // Clear the client's cart
	    salvarFaturas(faturas); // Save the updated list of invoices
	    
	    FuncProdutos.atualizarFicheiro(produtos); // Update the product file

	    System.out.println("Compra finalizada com sucesso!");
	    System.out.println(fatura.toString()); // Print the invoice details
	}

		// Method to list the items in the client's cart
		public static void listarCarrinho(Cliente cliente) {
	    if (cliente.getCarrinho().isEmpty()) { // Check if the cart is empty
	        System.out.println("O carrinho está vazio!");
	    } else {
	        System.out.println("Produtos no carrinho:");
	        // Print all products in the cart
	        for (Produto produto : cliente.getCarrinho()) {
	            System.out.println(produto);
	        }
	    }
	}
	
		// Method to clear the client's cart
		public static void limparCarrinho(Cliente cliente) {
		String Confirmacao = Ler.umaString(); // Read the confirmation input
		if (Confirmacao.equals("SIM")) { // Check if the confirmation is "SIM"
			cliente.limparCarrinho(); // Clear the cart
			System.out.println("Carrinho Eliminado com sucesso!");
		}else {
			System.out.println("Ação Cancelada!"); // Action canceled	
		}
	}

		// Method to add a product to the cart by its name
		public static void addProdutoAoCarroNome(ArrayList<Produto> produtos, Cliente cliente) {
	    System.out.println("Digite o nome do produto que deseja adicionar:");
	    String nomeProduto = Ler.umaString(); // Read the product name

	    // Iterate through the product list
	    for (Produto produto : produtos) {
	        if (produto.getProduto().equalsIgnoreCase(nomeProduto)) { // Check if the product name matches
	            if (produto.temStock()) { // Check if the product is in stock
	            	produto.retirarStock(1); // Reduce the stock by 1
	                cliente.adicionarAoCarrinho(produto); // Add the product to the cart
	                System.out.println("Produto adicionado ao carrinho com sucesso!");
	                return;
	            } else {
	                System.out.println("Produto sem stock!"); // No stock available
	                return;
	            }
	        }
	    }
	    System.out.println("Produto não encontrado!"); // Product not found
	}
	
		// Method to add a product to the cart by its ID
		public static void addProdutoAoCarroID(ArrayList<Produto> produtos, Cliente cliente) {
        System.out.println("Digite o ID do produto que deseja adicionar ao carrinho:");
        int idProduto = Ler.umInt(); // Read the product ID

        // Iterate through the product list
        for (Produto produto : produtos) {
            if (produto.getId() == idProduto) { // Check if the product ID matches
                if (produto.temStock()) { // Check if the product is in stock
                	produto.retirarStock(1); // Reduce the stock by 1
                    cliente.adicionarAoCarrinho(produto); // Add the product to the cart
                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                    return;
                } else {
                    System.out.println("Produto sem stock!"); // No stock available
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado!"); // Product not found
    }
	
		// Method to save the list of invoices to a file
		public static void salvarFaturas(ArrayList<Fatura> faturas) {
	    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Faturas.ser"))) {
	        os.writeInt(Fatura.getUltimo()); // Save the last ID used
	        os.writeObject(faturas); // Save the list of invoices
	        System.out.println("Faturas salvas com sucesso!");
	    } catch (IOException e) {
	        System.out.println("Erro ao salvar faturas: " + e.getMessage()); // Handle errors
	    }
	}
}