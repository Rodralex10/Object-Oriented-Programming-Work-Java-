package Trabalho;

import java.util.ArrayList;
import myinputs.Ler;

public class FuncProdutosClientes {

	// Method to list available categories
    public static void listarCategorias(ArrayList<Produto> produtos) {
        System.out.println("Categorias Disponíveis:\n");
        // Stream through the products, extract unique categories, and print them
        produtos.stream()
                .map(Produto::getCategoria) // Get the category of each product
                .distinct() // Ensure uniqueness of categories
                .forEach(System.out::println); // Print each category
    }

    // Method to search for a product by its name
    public static void consultarProdutoPorNome(ArrayList<Produto> produtos) {
        System.out.println("Digite o Nome do Produto:\n");
        String nome = Ler.umaString(); // Read the product name from user input
        boolean encontrado = false;

        // Iterate through the list of products
        for (Produto produto : produtos) {
            if (produto.getProduto().equalsIgnoreCase(nome)) { // Check if names match, ignoring case
                System.out.println(produto); // Print the product details
                encontrado = true; // Set the flag to true if a match is found
            }
        }

        // If no product is found, display an appropriate message
        if (!encontrado) {
            System.out.println("Nenhum Produto foi encontrado com o Nome: " + nome);
        }
    }

    // Method to search for products within a specific category
    public static void consultarProdutosPorCategoria(ArrayList<Produto> produtos) {
        System.out.println("Digite a Categoria do Produto:\n");
        String categoria = Ler.umaString(); // Read the category from user input
        boolean encontrado = false;

        // Iterate through the list of products
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) { // Check if categories match, ignoring case
                System.out.println(produto); // Print the product details
                encontrado = true; // Set the flag to true if a match is found
            }
        }

        // If no product is found, display an appropriate message
        if (!encontrado) {
            System.out.println("Nenhum Produto foi encontrado na Categoria: " + categoria);
        }
    }
    
    	// Method to search for products suitable for a specific age group
    	public static void consultarProdutosPorIdade(ArrayList<Produto> produtos) {
        System.out.println("Digite a Idade Idicada para os Produtos que procura:");
        String idadeIndicada = Ler.umaString();
        boolean encontrado = false;

        System.out.println("Produtos recomendados para Idade Indicada: " + idadeIndicada);
        
        // Iterate through the list of products
        for (Produto produto : produtos) {
            if (produto.getIdadeindicada().equalsIgnoreCase(idadeIndicada)) { // Check if age group matches, ignoring case
                System.out.println(produto); // Print the product details
                encontrado = true; // Set the flag to true if a match is found
            }
        }
        
    	// If no product is found, display an appropriate message
        if (!encontrado) {
            System.out.println("Nenhum Produto encontrado para a Idade Indicada.\n");
        }
    }

    	// Method to search for a product by its ID
    	public static void consultarProdutoPorID(ArrayList<Produto> produtos) {
        System.out.println("Digite o ID do produto:\n");
        int id = Ler.umInt(); // Read the product ID from user input
        boolean encontrado = false;

        // Iterate through the list of products
        for (Produto produto : produtos) {
            if (produto.getId() == id) { // Check if IDs match
                System.out.println(produto); // Print the product details
                encontrado = true; // Set the flag to true if a match is found
                break; // Exit the loop once a match is found
            }
        }

        // If no product is found, display an appropriate message
        if (!encontrado) {
            System.out.println("Nenhum Produto foi encontrado com o ID: " + id);
        }
    }
}