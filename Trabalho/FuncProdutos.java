package Trabalho;

import java.io.*;
import java.util.ArrayList;
import myinputs.Ler;
import java.util.HashMap;
import java.util.Map;


public class FuncProdutos {
	
	// Method to insert a new product into the list
    public static void inserirProduto(ArrayList<Produto> Produtos) {
        
    	// Gather product data and create a new Product object
        System.out.println("Qual a Categoria do Produto?\n");
        String CategoriaP = Ler.umaString();
        System.out.println("Qual o Nome do Produto?\n");
        String NomeP = Ler.umaString();
        System.out.println("Qual o Preço do Produto?\n");
        double PrecoP = Ler.umDouble();
        System.out.println("Qual a Idade Indicada para utilização do Produto?\n");
        String IdadeIndicadaP = Ler.umaString();
        System.out.println("Qual a Descrição do Produto?\n");
        String DescricaoP = Ler.umaString();
        System.out.println("Qual o Stock do Produto?\n");
        int StockP = Ler.umInt();
        
        Produto l = new Produto(CategoriaP, NomeP, PrecoP, IdadeIndicadaP,DescricaoP,StockP);
        System.out.println("O Produto: " + NomeP + " , foi criado e adicionado à Categoria " + CategoriaP + ", com preço base de: " + PrecoP + "€ , com Cerca de "+StockP+" de Unidades Disponíveis." );

        // Add the new product to the list
        Produtos.add(l);
    	// Update the file with the new product
        atualizarFicheiro(Produtos);
    }
    // Method to remove a product from the list
    public static void removerProduto(ArrayList<Produto> Produtos) {
        System.out.println("Qual o ID do Produto?\n");

        int num = Ler.umInt(); // Read the product ID to remove

        // Validate the product ID and remove the product
        for (int i = 0; i < Produtos.size(); i++) {
            if (Produtos.get(i).getId() == num) {
                Produtos.remove(i);
                System.out.println("Produto Apagado!\n");
                // Update the file after removal
                atualizarFicheiro(Produtos);
                return;
            }
        }

        System.out.println("Nenhum Produto foi encontrado com o ID Especificado!\n");
    }
    
    // Method to consult products by category
    public static void consultarCategoria(ArrayList<Produto> Produtos) {
    	System.out.println("Qual a Categoria do Produto?\n");

        String Categoria = Ler.umaString(); // Read the category name
        
        for (int i = 0; i < Produtos.size(); i++) {
            if (Produtos.get(i).getCategoria().equals(Categoria)) {
                System.out.println(Produtos.get(i));
                return;
            }
        }
        System.out.println("Nenhum Produto foi encontrado com a Categoria Especificada!\n");
    }
    
    // Method to change the category of a product
    public static void alterarCategoria(ArrayList<Produto> Produtos) {
    	System.out.println("Qual o ID do Produto?\n");

        int num = Ler.umInt(); // Read the product ID
        
        System.out.println("Qual a Nova Categoria do Produto?\n");

        String novoCategoria = Ler.umaString(); // Read the new category
        
        for (int i = 0; i < Produtos.size(); i++) {
        	if (Produtos.get(i).getId() == num) {
                Produtos.get(i).setCategoria(novoCategoria);
                System.out.println("Categoria Alterada!\n");
                // Update the file after the change
                atualizarFicheiro(Produtos);
                return;
            }
        }
        System.out.println("Nenhum Produto foi encontrado com o ID Especificado!\n");
    }
    // Method to find the most common category among products
    public static void Categoriamaiscomum(ArrayList<Produto> Produtos) {
    	Map<String, Integer> Frequencias = new HashMap<>();
    	
    	// Count occurrences of each category
    	for (Produto Produto : Produtos) {
    		String Categoria = Produto.getCategoria();
    		Frequencias.put(Categoria, Frequencias.getOrDefault(Categoria, 0) + 1);
    	}
    	
    	String Categoriamaiscomum = null;
    	int maiorFrequencia = 0;
    	
    	// Find the category with the highest frequency
    	for (Map.Entry<String, Integer> entrada : Frequencias.entrySet()) {
            if (entrada.getValue() > maiorFrequencia) {
                maiorFrequencia = entrada.getValue();
                Categoriamaiscomum = entrada.getKey();
            }
        }
    	
    	System.out.println("A Categoria com mais Produtos é a " + Categoriamaiscomum + " com um número de Produtos de  "+ maiorFrequencia);
    }
    
    // Method to add stock to a product
    public static void adicionarStock(ArrayList<Produto> produtos) {
        System.out.println("Digite o ID do produto para adicionar stock:\n");
        int id = Ler.umInt(); // Read the product ID
        System.out.println("Quantidade a adicionar:\n");
        int quantidade = Ler.umInt(); // Read the quantity to add

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.adicionarStock(quantidade);
                System.out.println("Stock atualizado: " + produto.getStock());
                atualizarFicheiro(produtos);
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
    
    // Method to remove stock from a product
    public static void removerStock(ArrayList<Produto> produtos) {
        System.out.println("Digite o ID do Produto para remover stock:\n");
        int id = Ler.umInt(); // Read the product ID
        System.out.println("Quantidade a remover:\n");
        int quantidade = Ler.umInt(); // Read the quantity to remove

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                if (produto.retirarStock(quantidade)) {
                    System.out.println("Stock atualizado: " + produto.getStock());
                }
                atualizarFicheiro(produtos);
                return;
            }
        }
        System.out.println("Produto não foi encontrado ou stock insuficiente!\n");
    }

    // Method to verify the stock of a product
    public static void stockVerify(ArrayList<Produto> produtos) {
        System.out.println("Digite o ID do Produto para verificar:\n");
        int id = Ler.umInt(); // Read the product ID

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                if (produto.temStock()) {
                    System.out.println("O Produto tem " + produto.getStock() + " unidades em stock!");
                } else {
                    System.out.println("O Produto está sem stock!\n");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado!\n");
    }
    
    // Method to list all available products
    public static void listarProdutos(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum Produto está disponível.\n");
        } else {
            System.out.println("Produtos disponíveis:\n");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
            
    // Method to update the file "Produtos.ser" with the current list of products
    public static void atualizarFicheiro(ArrayList<Produto> Produtos) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Produtos.ser"))) {
            os.writeInt(Produto.getUltimo()); // Save the last product ID
            os.writeObject(Produtos); // Save the product list
            System.out.println("Ficheiro de Produtos atualizado com sucesso!\n");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o ficheiro de Produtos: " + e.getMessage());
        }
    }
}