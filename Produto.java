package Trabalho;

import java.io.Serializable;

public class Produto implements Serializable {

    private int id;
    private static int ultimo = 0;
    private String Categoria;
    private String NomeProduto;
    private double preco; // Novo atributo para o preço do produto
    private int quantidade; // Novo atributo para a quantidade do produto

    // Construtor atualizado
    public Produto(String Categoria, String NomeProduto, double preco, int quantidade) {
        ultimo++;
        id = ultimo;
        this.Categoria = Categoria;
        this.NomeProduto = NomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Produto.ultimo = ultimo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getProduto() {
        return NomeProduto;
    }

    public void setProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }

    public double getPreco() { // Getter para o preço
        return preco;
    }

    public void setPreco(double preco) { // Setter para o preço
        this.preco = preco;
    }

    public int getQuantidade() { // Getter para a quantidade
        return quantidade;
    }

    public void setQuantidade(int quantidade) { // Setter para a quantidade
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", Categoria='" + Categoria + '\'' +
                ", Produto='" + NomeProduto + '\'' +
                ", Preço=" + preco +
                ", Quantidade=" + quantidade +
                '}';
    }
}
