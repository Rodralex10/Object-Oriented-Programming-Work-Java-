package Trabalho;

import java.util.ArrayList;
import myinputs.Ler;

public class FuncVendas {
	public static void finalizarCompra(Cliente cliente, ArrayList<Fatura> faturas) {
	    ArrayList<Produto> produtosCarrinho = cliente.getCarrinho();

	    if (produtosCarrinho.isEmpty()) {
	        System.out.println("O carrinho está vazio.");
	        return;
	    }

	    Fatura fatura = new Fatura(produtosCarrinho, cliente);
	    faturas.add(fatura);
	    cliente.limparCarrinho();

	    System.out.println("Compra finalizada com sucesso!");
	    System.out.println(fatura.toString());
	}

	
	public static void listarCarrinho(Cliente cliente) {
	    if (cliente.getCarrinho().isEmpty()) {
	        System.out.println("O carrinho está vazio.");
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
	                cliente.adicionarAoCarrinho(produto);
	                System.out.println("Produto adicionado ao carrinho com sucesso!");
	                return;
	            } else {
	                System.out.println("Produto sem stock.");
	                return;
	            }
	        }
	    }
	    System.out.println("Produto não encontrado.");
	}
	
	public static void addProdutoAoCarroID(ArrayList<Produto> produtos, Cliente cliente) {
        System.out.println("Digite o ID do produto que deseja adicionar ao carrinho:");
        int idProduto = Ler.umInt();

        for (Produto produto : produtos) {
            if (produto.getId() == idProduto) {
                if (produto.temStock()) {
                    cliente.adicionarAoCarrinho(produto);
                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                    return;
                } else {
                    System.out.println("Produto sem stock.");
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado.");
    }	
}
