package Trabalho;

import java.util.ArrayList;
import myinputs.Ler;

public class FuncProdutosClientes {

    // Método para listar categorias disponíveis
    public static void listarCategorias(ArrayList<Produto> produtos) {
        System.out.println("Categorias disponíveis:");
        produtos.stream()
                .map(Produto::getCategoria)
                .distinct()
                .forEach(System.out::println);
    }

    // Método para consultar um produto pelo nome
    public static void consultarProdutoPorNome(ArrayList<Produto> produtos) {
        System.out.println("Digite o nome do produto:");
        String nome = Ler.umaString();
        boolean encontrado = false;

        for (Produto produto : produtos) {
            if (produto.getProduto().equalsIgnoreCase(nome)) {
                System.out.println(produto);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com o nome: " + nome);
        }
    }

    // Método para consultar produtos de uma categoria
    public static void consultarProdutosPorCategoria(ArrayList<Produto> produtos) {
        System.out.println("Digite a categoria:");
        String categoria = Ler.umaString();
        boolean encontrado = false;

        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(produto);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum produto encontrado na categoria: " + categoria);
        }
    }

    // Método para consultar um produto pelo ID
    public static void consultarProdutoPorID(ArrayList<Produto> produtos) {
        System.out.println("Digite o ID do produto:");
        int id = Ler.umInt();
        boolean encontrado = false;

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                System.out.println(produto);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com o ID: " + id);
        }
    }
}