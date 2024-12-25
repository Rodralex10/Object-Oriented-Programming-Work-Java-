package Trabalho;
import java.util.*;

public class Fatura {
	private int IdFatura;
	private Utilizador IdCliente;
	private ArrayList<Produto> Produtos;
	private double valortotal;
	private double valorsemiva;
	private static int ultimo;
	
	public Fatura(ArrayList<Produto> produto, Utilizador IdCliente) {
		ultimo++;
		IdFatura = ultimo;
		this.IdCliente=IdCliente;
		this.Produtos = new ArrayList<>(Produtos);
		this.valorsemiva = calcularValorsemiva();
		this.valortotal = valorsemiva + valorsemiva*0.23;
	}
		
	private double calcularValorsemiva() {
        double total = 0;
        for (Produto produto : Produtos) {
            total += produto.getPrice();  // Supondo que Produto tem getPreco() e getQuantidade().
        }
        return total;
    }
	
	private double calcularValorComIVA() {
        return this.valorsemiva * 1.23; // Considerando IVA de 23%
    }

	
	public int getIdFatura() {
        return IdFatura;
    }

    public Utilizador getIdCliente() {
        return IdCliente;
    }

    public ArrayList<Produto> getProdutos() {
        return Produtos;
    }

    public double getValorTotal() {
        return valortotal;
    }
    
    public double getValorsemiva() {
        return valorsemiva;
    }
    
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
               "Produtos:\n" + produtosDetalhes +
               "Valor Sem IVA: " + String.format("%.2f", valorsemiva) + " €\n" +
               "Valor Total (com IVA): " + String.format("%.2f", valortotal) + " €\n";
    }

}
