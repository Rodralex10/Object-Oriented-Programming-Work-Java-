package Trabalho;
import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;

public class Fatura implements Serializable {
    private int IdFatura;
    private Utilizador IdCliente;
    private ArrayList<Produto> Produtos;
    private double valortotal;
    private double valorsemiva;
    private static int ultimo;
    private LocalDate dataEmissao;

    // Constructor to initialize the invoice with a list of products and a customer
    public Fatura(ArrayList<Produto> Produtos, Utilizador IdCliente) {
        ultimo++; // Increment the static variable to generate a new invoice ID
        IdFatura = ultimo;
        this.IdCliente = IdCliente;
        this.Produtos = new ArrayList<>(Produtos); // Create a copy of the product list
        this.valorsemiva = calcularValorsemiva(); // Calculate the total value without tax (IVA)
        this.valortotal = valorsemiva + valorsemiva * 0.23; // Add 23% IVA to calculate the total value
        this.dataEmissao = LocalDate.now(); // Set the issue date to the current date
    }

    // Method to calculate the total value of products without tax (IVA)
    private double calcularValorsemiva() {
        double total = 0;
        for (Produto produto : Produtos) {
            total += produto.getPrice(); // Assuming Produto has getPrice() to return its price
        }
        return total;
    }

    // Method to calculate the total value including IVA (23%)
    private double calcularValorComIVA() {
        return this.valorsemiva * 1.23; // Apply a 23% tax to the value without IVA
    }

    // Getter for invoice ID
    public int getIdFatura() {
        return IdFatura;
    }

    // Getter for the customer associated with the invoice
    public Utilizador getIdCliente() {
        return IdCliente;
    }

    // Getter for the list of products in the invoice
    public ArrayList<Produto> getProdutos() {
        return Produtos;
    }

    // Static getter for the last used invoice ID
    public static int getUltimo() {
        return ultimo;
    }

    // Static setter for the last used invoice ID
    public static void setUltimo(int ultimo) {
        Fatura.ultimo = ultimo;
    }

    // Getter for the total value of the invoice including IVA
    public double getValorTotal() {
        return valortotal;
    }

    // Getter for the total value of the invoice without IVA
    public double getValorsemiva() {
        return valorsemiva;
    }

    // Getter for the issue date of the invoice
    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    // Override the toString method to provide a formatted representation of the invoice
    @Override
    public String toString() {
        String produtosDetalhes = "";
        for (Produto produto : Produtos) {
            produtosDetalhes += "  - " + produto.getProduto() +
                                " (Categoria: " + produto.getCategoria() +
                                ", Preço: " + produto.getPrice() + " €)\n";
        }

        return "Fatura ID: " + IdFatura + "\n" +
               "Cliente: " + IdCliente.getUsername() + " (ID: " + IdCliente.getId() + ")\n" +
               "Data de Emissão: " + dataEmissao.toString() + "\n" + // Include the issue date
               "Produtos:\n" + produtosDetalhes +
               "Valor Sem IVA: " + String.format("%.2f", valorsemiva) + " €\n" +
               "Valor Total (com IVA): " + String.format("%.2f", valortotal) + " €\n";
    }
}