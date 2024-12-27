package Trabalho;

import java.util.*;
import java.time.LocalDate;

public class Fatura {
    private int idFatura;
    private Utilizador cliente;
    private ArrayList<Produto> produtos;
    private double valorTotal;
    private double valorSemIVA;
    private static int ultimoId = 0; // Inicializando o último ID como 0
    private LocalDate dataEmissao;

    public Fatura(ArrayList<Produto> produtos, Utilizador cliente) {
        if (produtos == null || produtos.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos não pode ser nula ou vazia.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
        }
        ultimoId++;
        this.idFatura = ultimoId;
        this.cliente = cliente;
        this.produtos = new ArrayList<>(produtos);
        this.valorSemIVA = calcularValorSemIVA();
        this.valorTotal = calcularValorComIVA();
        this.dataEmissao = LocalDate.now();
    }

    private double calcularValorSemIVA() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPrice(); // Assumindo que Produto tem método getPrice()
        }
        return total;
    }

    private double calcularValorComIVA() {
        return this.valorSemIVA * 1.23; // Considerando IVA de 23%
    }

    public int getIdFatura() {
        return idFatura;
    }

    public Utilizador getIdCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos); // Retornando uma cópia da lista para proteger o encapsulamento
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorSemIVA() {
        return valorSemIVA;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    @Override
    public String toString() {
        StringBuilder detalhesProdutos = new StringBuilder();
        for (Produto produto : produtos) {
            detalhesProdutos.append("  - ")
                    .append(produto.getProduto())
                    .append(" (Categoria: ").append(produto.getCategoria())
                    .append(", Preço: ").append(String.format("%.2f", produto.getPrice())).append(" €)\n");
        }

        return "Fatura ID: " + idFatura + "\n" +
               "Cliente: " + cliente.getUsername() + " (ID: " + cliente.getId() + ")\n" +
               "Data de Emissão: " + dataEmissao + "\n" +
               "Produtos:\n" + detalhesProdutos.toString() +
               "Valor Sem IVA: " + String.format("%.2f", valorSemIVA) + " €\n" +
               "Valor Total (com IVA): " + String.format("%.2f", valorTotal) + " €\n";
    }
}
