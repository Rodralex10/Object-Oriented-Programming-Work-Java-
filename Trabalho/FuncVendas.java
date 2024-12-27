package Trabalho;

import java.util.ArrayList;
import java.io.*;
import myinputs.Ler;

public class FuncVendas {
	
	
	public static void listarFaturasDoCliente(Cliente cliente, ArrayList<Fatura> faturas) {
	    boolean encontrouFaturas = false;

	    System.out.println("Faturas do cliente " + cliente.getUsername() + ":");
	    for (Fatura fatura : faturas) {
	        if (fatura.getIdCliente().getId() == cliente.getId()) {
	            System.out.println(fatura);
	            encontrouFaturas = true;
	        }
	    }

	    if (!encontrouFaturas) {
	        System.out.println("Nenhuma fatura encontrada para este cliente.");
	    }
	}
	
	
	
	public static void finalizarCompra(Cliente cliente, ArrayList<Fatura> faturas, ArrayList<Produto> produtos) {
	    ArrayList<Produto> carrinhoProdutos = cliente.getCarrinho();

	    if (carrinhoProdutos.isEmpty()) {
	        System.out.println("O carrinho está vazio!");
	        return;
	    }

	    Fatura fatura = new Fatura(carrinhoProdutos, cliente);
	    faturas.add(fatura);
	    cliente.limparCarrinho();
	    salvarFaturas(faturas);
	    
	    FuncProdutos.atualizarFicheiro(produtos);

	    System.out.println("Compra finalizada com sucesso!");
	    System.out.println(fatura.toString());
	}

	
	public static void listarCarrinho(Cliente cliente) {
	    if (cliente.getCarrinho().isEmpty()) {
	        System.out.println("O carrinho está vazio!");
	    } else {
	        System.out.println("Produtos no carrinho:");
	        for (Produto produto : cliente.getCarrinho()) {
	            System.out.println(produto);
	        }
	    }
	}
	
	public static void limparCarrinho(Cliente cliente) {
		String Confirmacao = Ler.umaString();
		if (Confirmacao.equals("SIM")) {
			cliente.limparCarrinho();
			System.out.println("Carrinho Eliminado com sucesso!");
		}else {
			System.out.println("Ação Cancelada!");			
		}
	}

	public static void addProdutoAoCarroNome(ArrayList<Produto> produtos, Cliente cliente) {
	    System.out.println("Digite o nome do produto que deseja adicionar:");
	    String nomeProduto = Ler.umaString();

	    for (Produto produto : produtos) {
	        if (produto.getProduto().equalsIgnoreCase(nomeProduto)) {
	            if (produto.temStock()) {
	            	produto.retirarStock(1);
	                cliente.adicionarAoCarrinho(produto);
	                System.out.println("Produto adicionado ao carrinho com sucesso!");
	                return;
	            } else {
	                System.out.println("Produto sem stock!");
	                return;
	            }
	        }
	    }
	    System.out.println("Produto não encontrado!");
	}
	
	public static void addProdutoAoCarroID(ArrayList<Produto> produtos, Cliente cliente) {
        System.out.println("Digite o ID do produto que deseja adicionar ao carrinho:");
        int idProduto = Ler.umInt();

        for (Produto produto : produtos) {
            if (produto.getId() == idProduto) {
                if (produto.temStock()) {
                	produto.retirarStock(1);
                    cliente.adicionarAoCarrinho(produto);
                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                    return;
                } else {
                    System.out.println("Produto sem stock!");
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado!");
    }
	
	public static void salvarFaturas(ArrayList<Fatura> faturas) {
	    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Faturas.ser"))) {
	        os.writeInt(Fatura.getUltimo()); // Salvar o último ID usado
	        os.writeObject(faturas); // Salvar a lista de faturas
	        System.out.println("Faturas salvas com sucesso!");
	    } catch (IOException e) {
	        System.out.println("Erro ao salvar faturas: " + e.getMessage());
	    }
	}
}