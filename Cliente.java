package Trabalho;
import java.util.ArrayList;

class Cliente extends Utilizador {
    private ArrayList<Produto> carrinho;

    public Cliente(String Username, String Password) {
        super(Username, Password);
        this.carrinho = new ArrayList<>();
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public void adicionarAoCarrinho(Produto produto) {
        this.carrinho.add(produto);
    }
    
    public void limparCarrinho() {
        this.carrinho.clear();
    }

    @Override
    public String toString() {
        return "\nCliente{" + super.toString() + ", Carrinho=" + carrinho + '}';
    }
}
