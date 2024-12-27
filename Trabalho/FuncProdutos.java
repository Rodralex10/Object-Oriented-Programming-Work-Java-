package Trabalho;

import java.io.*;
import java.util.ArrayList;
import myinputs.Ler;
import java.util.HashMap;
import java.util.Map;


public class FuncProdutos {

    public static void inserirProduto(ArrayList<Produto> Produtos) {
        
        // Obter dados do Produto; instanciar o objeto Produto;
        System.out.println("Qual a Categoria do Produto? ");
        String CategoriaP = Ler.umaString();
        System.out.println("Qual o Nome do Produto? ");
        String NomeP = Ler.umaString();
        System.out.println("Qual o Preco do Produto? ");
        double PrecoP = Ler.umDouble();
        System.out.println("Qual a IdadeIndicada do Produto? ");
        String IdadeIndicadaP = Ler.umaString();
        System.out.println("Qual a Descricao do Produto? ");
        String DescricaoP = Ler.umaString();
        System.out.println("Qual o Stock do Produto? ");
        int StockP = Ler.umInt();
        
        Produto l = new Produto(CategoriaP, NomeP, PrecoP, IdadeIndicadaP,DescricaoP,StockP);
        System.out.println("O Produto: " + NomeP + " , foi criado e adicionado a Categoria " + CategoriaP + ", com preço base de: " + PrecoP + "€ , com Cerca de "+StockP+" de Unidades disponiveis." );

        // Adicionar o novo Produto à lista
        Produtos.add(l);
        // Atualizar ficheiro
        atualizarFicheiro(Produtos);
    }

    public static void removerProduto(ArrayList<Produto> Produtos) {
        System.out.println("Qual o id do Produto? ");

        int num = Ler.umInt();

        // Validar número de Produto e remover o Produto
        for (int i = 0; i < Produtos.size(); i++) {
            if (Produtos.get(i).getId() == num) {
                Produtos.remove(i);
                System.out.println("Produto apagado");
                // Atualizar ficheiro após a remoção
                atualizarFicheiro(Produtos);
                return;
            }
        }

        System.out.println("Nenhum Produto encontrado com o id especificado.");
    }
    
    public static void consultarCategoria(ArrayList<Produto> Produtos) {
    	System.out.println("Qual o Categoria do Produto? ");

        String Categoria = Ler.umaString();
        
        for (int i = 0; i < Produtos.size(); i++) {
            if (Produtos.get(i).getCategoria().equals(Categoria)) {
                System.out.println(Produtos.get(i));
                return;
            }
        }
        System.out.println("Nenhum Produto encontrado com o Categoria especificado.");
    }
    
    
    public static void alterarCategoria(ArrayList<Produto> Produtos) {
    	System.out.println("Qual o id do Produto? ");

        int num = Ler.umInt();
        
        System.out.println("Qual a novo Categoria do Produto? ");

        String novoCategoria = Ler.umaString();
        
        for (int i = 0; i < Produtos.size(); i++) {
        	if (Produtos.get(i).getId() == num) {
                Produtos.get(i).setCategoria(novoCategoria);
                System.out.println("Categoria alterado");
                // Atualizar ficheiro após a alteraçao
                atualizarFicheiro(Produtos);
                return;
            }
        }
        System.out.println("Nenhum Produto encontrado com o id especificado.");
    }
    
    public static void Categoriamaiscomum(ArrayList<Produto> Produtos) {
    	Map<String, Integer> Frequencias = new HashMap<>();
    	
    	for (Produto Produto : Produtos) {
    		String Categoria = Produto.getCategoria();
    		Frequencias.put(Categoria, Frequencias.getOrDefault(Categoria, 0) + 1);
    	}
    	
    	String Categoriamaiscomum = null;
    	int maiorFrequencia = 0;
    	
    	for (Map.Entry<String, Integer> entrada : Frequencias.entrySet()) {
            if (entrada.getValue() > maiorFrequencia) {
                maiorFrequencia = entrada.getValue();
                Categoriamaiscomum = entrada.getKey();
            }
        }
    	
    	System.out.println("A Categoria com mais Produtos é a " + Categoriamaiscomum + " com um numero de Produtos de  "+ maiorFrequencia);
    }
    
    public static void adicionarStock(ArrayList<Produto> produtos) {
        System.out.println("Digite o ID do produto para adicionar stock:");
        int id = Ler.umInt();
        System.out.println("Quantidade a adicionar:");
        int quantidade = Ler.umInt();

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

    public static void removerStock(ArrayList<Produto> produtos) {
        System.out.println("Digite o ID do produto para remover stock:");
        int id = Ler.umInt();
        System.out.println("Quantidade a remover:");
        int quantidade = Ler.umInt();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                if (produto.retirarStock(quantidade)) {
                    System.out.println("Stock atualizado: " + produto.getStock());
                }
                atualizarFicheiro(produtos);
                return;
            }
        }
        System.out.println("Produto não encontrado ou stock insuficiente!");
    }

    public static void stockVerify(ArrayList<Produto> produtos) {
        System.out.println("Digite o ID do produto para verificar:");
        int id = Ler.umInt();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                if (produto.temStock()) {
                    System.out.println("O produto tem " + produto.getStock() + " unidades em stock.");
                } else {
                    System.out.println("O produto está sem stock.");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
    
    public static void listarProdutos(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
        } else {
            System.out.println("Produtos disponíveis:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
            

    public static void atualizarFicheiro(ArrayList<Produto> Produtos) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Produtos.ser"))) {
            os.writeInt(Produto.getUltimo()); // Salvar o último ID de produto
            os.writeObject(Produtos); // Salvar a lista de produtos
            System.out.println("Ficheiro de produtos atualizado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o ficheiro: " + e.getMessage());
        }
    }
    
    

}