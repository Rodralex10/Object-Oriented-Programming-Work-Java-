package Trabalho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import myinputs.Ler;

import java.time.LocalDate;

public class Estatisticas {
	public static void produtosMaisEMenosVendidos(ArrayList<Fatura> faturas) {
	    // HashMap para armazenar o nome do produto (chave) e a quantidade vendida (valor).
	    HashMap<String, Integer> vendas = new HashMap<>();

	    // Iterar sobre cada fatura para contar as vendas de cada produto.
	    for (Fatura fatura : faturas) {
	        // Iterar sobre os produtos de cada fatura.
	        for (Produto produto : fatura.getProdutos()) {
	            // Atualizar a contagem no HashMap. Se o produto já existe, incrementar; caso contrário, iniciar com 1.
	            vendas.put(produto.getProduto(), vendas.getOrDefault(produto.getProduto(), 0) + 1);
	        }
	    }

	    // Verificar se há vendas registradas. Se o HashMap estiver vazio, não há vendas.
	    if (vendas.isEmpty()) {
	        System.out.println("Não há vendas registradas.");
	        return;
	    }

	    // Variáveis para armazenar o produto mais vendido, menos vendido e suas respectivas contagens.
	    String produtoMaisVendido = null;
	    String produtoMenosVendido = null;
	    int maxVendas = Integer.MIN_VALUE; // Inicializado com o menor valor possível.
	    int minVendas = Integer.MAX_VALUE; // Inicializado com o maior valor possível.

	    // Iterar sobre o HashMap para encontrar o produto mais vendido e o menos vendido.
	    for (Map.Entry<String, Integer> entry : vendas.entrySet()) {
	        String nomeProduto = entry.getKey();
	        int quantidadeVendida = entry.getValue();

	        // Atualizar o produto mais vendido.
	        if (quantidadeVendida > maxVendas) {
	            maxVendas = quantidadeVendida;
	            produtoMaisVendido = nomeProduto;
	        }

	        // Atualizar o produto menos vendido.
	        if (quantidadeVendida < minVendas) {
	            minVendas = quantidadeVendida;
	            produtoMenosVendido = nomeProduto;
	        }
	    }

	    // Exibir o resultado no console.
	    System.out.println("Produto mais vendido: " + produtoMaisVendido + " com " + maxVendas + " vendas.");
	    System.out.println("Produto menos vendido: " + produtoMenosVendido + " com " + minVendas + " vendas.");
	}
	
	public static void melhoresClientes(ArrayList<Fatura> faturas) {
	    // HashMap para armazenar o cliente (chave) e o total gasto (valor).
	    HashMap<Utilizador, Double> gastos = new HashMap<>();

	    // Iterar sobre todas as faturas para calcular o total gasto por cliente.
	    for (Fatura fatura : faturas) {
	        Utilizador cliente = fatura.getIdCliente();
	        double valorFatura = fatura.getValorTotal();

	        // Atualizar o total gasto no HashMap. Se o cliente já existe, somar o valor; caso contrário, iniciar com o valor da fatura.
	        gastos.put(cliente, gastos.getOrDefault(cliente, 0.0) + valorFatura);
	    }

	    // Verificar se há clientes registrados.
	    if (gastos.isEmpty()) {
	        System.out.println("Não há dados de clientes.");
	        return;
	    }

	    // Identificar os dois melhores clientes.
	    Utilizador melhorCliente = null;
	    Utilizador segundoMelhorCliente = null;
	    double maiorGasto = 0;
	    double segundoMaiorGasto = 0;

	    // Iterar sobre o HashMap para encontrar os dois melhores clientes.
	    for (Map.Entry<Utilizador, Double> entry : gastos.entrySet()) {
	        Utilizador cliente = entry.getKey();
	        double gasto = entry.getValue();

	        if (gasto > maiorGasto) {
	            // Atualizar o segundo melhor antes de substituir o melhor.
	            segundoMaiorGasto = maiorGasto;
	            segundoMelhorCliente = melhorCliente;

	            // Atualizar o melhor cliente.
	            maiorGasto = gasto;
	            melhorCliente = cliente;
	        } else if (gasto > segundoMaiorGasto) {
	            // Atualizar o segundo melhor cliente.
	            segundoMaiorGasto = gasto;
	            segundoMelhorCliente = cliente;
	        }
	    }

	    // Exibir o resultado.
	    System.out.println("Melhor cliente: " + (melhorCliente != null ? melhorCliente.getUsername() : "N/A") +
	                       " com gasto total de " + maiorGasto + "€.");
	    System.out.println("Segundo melhor cliente: " + (segundoMelhorCliente != null ? segundoMelhorCliente.getUsername() : "N/A") +
	                       " com gasto total de " + segundoMaiorGasto + "€.");
	}
	
	public static double calcularFaturacaoPorPeriodo(ArrayList<Fatura> faturas) {
	    double totalFaturado = 0;
	    int dia = Ler.umInt();
	    int mes = Ler.umInt();
	    int ano = Ler.umInt();
	    
	    for (Fatura fatura : faturas) {
	        LocalDate dataEmissao = fatura.getDataEmissao();

	        boolean corresponde = (dia == 0 || dataEmissao.getDayOfMonth() == dia) &&
	                              (mes == 0 || dataEmissao.getMonthValue() == mes) &&
	                              (ano == 0 || dataEmissao.getYear() == ano);

	        if (corresponde) {
	            totalFaturado += fatura.getValorTotal();
	        }
	    }

	    return totalFaturado;
	}
}
