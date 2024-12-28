package Trabalho; // Defines the package name for the class
import java.util.ArrayList; // Imports the ArrayList class from the Java utility library

class Cliente extends Utilizador { // Class Cliente inherits from the Utilizador class
    private ArrayList<Produto> carrinho; // Field to store the list of products in the client's cart

    public Cliente(String Username, String Password) { // Constructor to initialize the Cliente object
        super(Username, Password); // Calls the constructor of the parent class Utilizador
        this.carrinho = new ArrayList<>(); // Initializes the cart as an empty ArrayList
    }

    public ArrayList<Produto> getCarrinho() { // Getter method for the cart
        return carrinho; // Returns the list of products in the cart
    }

    public void adicionarAoCarrinho(Produto produto) { // Method to add a product to the cart
        this.carrinho.add(produto); // Adds the specified product to the cart
    }
    
    public void limparCarrinho() { // Method to clear all items from the cart
        this.carrinho.clear(); // Removes all products from the cart
    }

    @Override
    public String toString() { // Overrides the toString method to provide a string representation of the Cliente object
        return "\nCliente{" + super.toString() + ", Carrinho=" + carrinho + '}'; // Combines parent class string and cart contents
    }
}