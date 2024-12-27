package Trabalho;

import java.io.Serializable;
import java.util.*;
import java.lang.*;

public class Produto implements Serializable{


 private int id;
 private static int ultimo = 0;
 private String Categoria;
 private String NomeProduto;
 private double price;
 private String Idadeindicada;
 private String descricao;
 private int stock;
 
 public Produto(String Categoria, String NomeProduto, double price, String Idadeindicada, String descricao, int stock) {
     ultimo++;
     this.id = ultimo;
     this.Categoria = Categoria;
     this.NomeProduto = NomeProduto;
     this.price = price;
     this.Idadeindicada = Idadeindicada;
     this.descricao = descricao;
     this.stock = stock;
 }
 
 public String getDescricao() {
	 return descricao;
 }
 
 public void setDescricao(String descricao) {
	 this.descricao=descricao;
 }
 
 public int getId() {
	 return id;
 }
 
 public static int getUltimo() { 
		return ultimo; 
		}
 
 public double getPrice() {
	 	return price;
 		}
 
 public String getIdadeindicada() {
	 return Idadeindicada;
 }
 
 public void setIdadeindicada(String Idadeindicada) {
	 this.Idadeindicada = Idadeindicada;
 }
 
 public void setPrice(double price) {
	 	this.price = price;
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
 
 public int getStock() {
     return stock;
 }

 public void setStock(int stock) {
     this.stock = stock;
 }
 
 public void adicionarStock(int quantidade) {
     this.stock += quantidade;
 }

 public boolean retirarStock(int quantidade) {
     if (quantidade <= stock) {
         this.stock -= quantidade;
         return true;
     } else {
         System.out.println("Stock insuficiente!");
         return false;
     }
 }
 
 public boolean temStock() {
	 return stock > 0;
 }
 
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
 
 @Override
 public String toString() {
	 return "Produto{" + "id=" + id + 
			 ", Categoria=" + Categoria + 
			 ", Produto=" + NomeProduto + 
			 ", Preço= "+ price + " €"+
			 ", Idade Recomendada: "+ Idadeindicada +
			 ", Descriçao: "+ descricao + '}';
 }
}