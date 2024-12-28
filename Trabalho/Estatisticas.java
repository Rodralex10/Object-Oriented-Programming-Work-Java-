package Trabalho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

import myinputs.Ler;

import java.time.LocalDate;

public class Estatisticas {
    public static void produtosMaisEMenosVendidos(ArrayList<Fatura> faturas) {
        // HashMap to store the product name (key) and the quantity sold (value).
        HashMap<String, Integer> vendas = new HashMap<>();

        // Iterate over each invoice to count the sales of each product.
        for (Fatura fatura : faturas) {
            // Iterate over the products in each invoice.
            for (Produto produto : fatura.getProdutos()) {
                // Update the count in the HashMap. If the product exists, increment it; otherwise, start with 1.
                vendas.put(produto.getProduto(), vendas.getOrDefault(produto.getProduto(), 0) + 1);
            }
        }

        // Check if there are any sales registered. If the HashMap is empty, there are no sales.
        if (vendas.isEmpty()) {
            System.out.println("Não há vendas registradas.");
            return;
        }

        // Variables to store the most sold and least sold products and their respective counts.
        String produtoMaisVendido = null;
        String produtoMenosVendido = null;
        int maxVendas = Integer.MIN_VALUE; // Initialized with the smallest possible value.
        int minVendas = Integer.MAX_VALUE; // Initialized with the largest possible value.

        // Iterate over the HashMap to find the most sold and least sold products.
        for (Map.Entry<String, Integer> entry : vendas.entrySet()) {
            String nomeProduto = entry.getKey();
            int quantidadeVendida = entry.getValue();

            // Update the most sold product.
            if (quantidadeVendida > maxVendas) {
                maxVendas = quantidadeVendida;
                produtoMaisVendido = nomeProduto;
            }

            // Update the least sold product.
            if (quantidadeVendida < minVendas) {
                minVendas = quantidadeVendida;
                produtoMenosVendido = nomeProduto;
            }
        }

        // Display the result on the console.
        System.out.println("Produto mais vendido: " + produtoMaisVendido + " com " + maxVendas + " vendas.");
        System.out.println("Produto menos vendido: " + produtoMenosVendido + " com " + minVendas + " vendas.");
    }

    public static void melhoresClientes(ArrayList<Fatura> faturas) {
        // HashMap to store the customer (key) and the total spent (value).
        HashMap<Utilizador, Double> gastos = new HashMap<>();

        // Iterate over all invoices to calculate the total spent by each customer.
        for (Fatura fatura : faturas) {
            Utilizador cliente = fatura.getIdCliente();
            double valorFatura = fatura.getValorTotal();

            // Update the total spent in the HashMap. If the customer exists, add the value; otherwise, start with the invoice value.
            gastos.put(cliente, gastos.getOrDefault(cliente, 0.0) + valorFatura);
        }

        // Check if there are any customers registered.
        if (gastos.isEmpty()) {
            System.out.println("Não há dados de clientes.");
            return;
        }

        // Identify the top two customers.
        Utilizador melhorCliente = null;
        Utilizador segundoMelhorCliente = null;
        double maiorGasto = 0;
        double segundoMaiorGasto = 0;

        // Iterate over the HashMap to find the top two customers.
        for (Map.Entry<Utilizador, Double> entry : gastos.entrySet()) {
            Utilizador cliente = entry.getKey();
            double gasto = entry.getValue();

            if (gasto > maiorGasto) {
                // Update the second best before replacing the best.
                segundoMaiorGasto = maiorGasto;
                segundoMelhorCliente = melhorCliente;

                // Update the best customer.
                maiorGasto = gasto;
                melhorCliente = cliente;
            } else if (gasto > segundoMaiorGasto) {
                // Update the second best customer.
                segundoMaiorGasto = gasto;
                segundoMelhorCliente = cliente;
            }
        }

        // Display the result.
        System.out.println("Melhor cliente: " + (melhorCliente != null ? melhorCliente.getUsername() : "N/A")
                + " com gasto total de " + maiorGasto + "€.");
        System.out.println("Segundo melhor cliente: " + (segundoMelhorCliente != null ? segundoMelhorCliente.getUsername() : "N/A")
                + " com gasto total de " + segundoMaiorGasto + "€.");
    }

    public static void calcularFaturacaoPorPeriodo(ArrayList<Fatura> faturas, int opcao) {
        double totalFaturado = 0;
        LocalDate hoje = LocalDate.now();
        LocalDate inicioPeriodo = hoje;

        // Determine the start date based on the chosen option.
        if (opcao == 1) {
            inicioPeriodo = hoje; // Today
        } else if (opcao == 2) {
            inicioPeriodo = hoje.minusWeeks(1); // Last week
        } else if (opcao == 3) {
            inicioPeriodo = hoje.minusMonths(1); // Last month
        }

        // Calculate revenue within the period.
        for (Fatura fatura : faturas) {
            LocalDate dataEmissao = fatura.getDataEmissao();
            if (!dataEmissao.isBefore(inicioPeriodo) && !dataEmissao.isAfter(hoje)) {
                totalFaturado += fatura.getValorTotal();
            }
        }
        System.out.println("Faturação no período escolhido: " + totalFaturado + "€");
    }

    public static void exibirNumeroDeVendasDiarias(ArrayList<Fatura> faturas) {
        // Get the current date.
        LocalDate hoje = LocalDate.now();

        // Calculate the number of daily sales.
        int totalVendas = 0;
        for (Fatura fatura : faturas) {
            if (fatura.getDataEmissao().isEqual(hoje)) {
                totalVendas++;
            }
        }

        // Display the result.
        System.out.println("Número de vendas feitas no dia (" + hoje + "): " + totalVendas);
    }
}