package Trabalho;

import java.io.Serializable;
import java.util.*;
import java.lang.*;

public class Produto implements Serializable{


 private int id; // Unique identifier for the product
 private static int ultimo = 0; // Static variable to track the last product ID
 private String Categoria; // Category of the product
 private String NomeProduto; // Name of the product
 private double price; // Price of the product
 private String Idadeindicada; // Recommended age for the product
 private String descricao; // Description of the product
 private int stock; // Stock quantity of the product
 
 //Constructor to initialize a new product with all attributes
 public Produto(String Categoria, String NomeProduto, double price, String Idadeindicada, String descricao, int stock) {
     ultimo++; // Increment the last product ID
     this.id = ultimo; // Assign the new ID to the product
     this.Categoria = Categoria;
     this.NomeProduto = NomeProduto;
     this.price = price;
     this.Idadeindicada = Idadeindicada;
     this.descricao = descricao;
     this.stock = stock;
 }
 
 //Getter for product description
 public String getDescricao() {
	 return descricao;
 }
//Setter for product description
 public void setDescricao(String descricao) {
	 this.descricao=descricao;
 }
 
 //Getter for product ID
 public int getId() {
	 return id;
 }
 
 //Getter for the last product ID
 public static int getUltimo() { 
		return ultimo; 
		}
 
 //Getter for product price
 public double getPrice() {
	 	return price;
 		}
 
 //Getter for recommended age
 public String getIdadeindicada() {
	 return Idadeindicada;
 }
 
 //Setter for recommended age
 public void setIdadeindicada(String Idadeindicada) {
	 this.Idadeindicada = Idadeindicada;
 }
 
 //Setter for product price
 public void setPrice(double price) {
	 	this.price = price;
 		}
 //Setter for the last product ID
 public static void setUltimo(int ultimo) { 
		Produto.ultimo = ultimo; 
		}
 //Getter for product category
 public String getCategoria() {
	 return Categoria;
 }
 
 //Setter for product category
 public void setCategoria(String Categoria) {
	 this.Categoria = Categoria;
 }
 
 //Getter for product name
 public String getProduto() {
	 return NomeProduto;
 }
 
 //Setter for product name
 public void setProduto(String NomeProduto) {
	 this.NomeProduto = NomeProduto;
 }
 
 //Getter for product stock quantity
 public int getStock() {
     return stock;
 }

 //Setter for product stock quantity
 public void setStock(int stock) {
     this.stock = stock;
 }
 
 //Method to add stock to the product
 public void adicionarStock(int quantidade) {
     this.stock += quantidade;
 }
 
 //Method to remove stock from the product
 public boolean retirarStock(int quantidade) {
     if (quantidade <= stock) { // Check if sufficient stock is available
         this.stock -= quantidade;
         return true;
     } else {
         System.out.println("Stock insuficiente!"); // Print insufficient stock message
         return false;
     }
 }
 
 //Method to check if the product has stock available
 public boolean temStock() {
	 return stock > 0;
 }
 
 //Override the equals method to compare products based on attributes
 public boolean equals(Object obj) {
	 if(obj != null && this.getClass()==obj.getClass()) {
		 Produto li = (Produto) obj;
		 return this.getCategoria().equals(li.getCategoria()) && 
				 this.getDescricao().equals(li.getDescricao())&&
				 this.getPrice()==li.getPrice()&&
				 this.getIdadeindicada().equals(li.getIdadeindicada())&&
				 this.getProduto().equals(li.getProduto())&&
				 this.getId()==li.getId();
	 }
	 return false;
 }
 
 //Override the toString method to provide a string representation of the product
 @Override
 public String toString() {
	 return "Produto{" + "ID = " + id + 
			 ", Categoria = " + Categoria + 
			 ", Produto = " + NomeProduto + 
			 ", Preço = "+ price + " €"+
			 ", Idade Recomendada: "+ Idadeindicada +
			 ", Descrição: "+ descricao + '}' + "\n";
 }
}