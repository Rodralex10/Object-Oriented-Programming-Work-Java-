package Trabalho;
import java.io.*;

import java.util.ArrayList;
import myinputs.Ler;

public class MainTrabalho {	 
	
	public static void main(String[] args) {
		int escolha,op1,op2,op3;
        ArrayList<Produto> produtos = carregarProdutos();
        ArrayList<Utilizador> users = carregarUtilizadores();
        Utilizador.setUltimo(users.size());
        FuncLogin.setUtilizadores(users);
		try {
			 ObjectInputStream is = new ObjectInputStream( new FileInputStream("Loja.dat"));
			 produtos = (ArrayList<Produto>) is.readObject();
			 users = (ArrayList<Utilizador>) is.readObject();
		 }
		 catch (IOException e){
			 System.out.println(e.getMessage());
		 }
		 catch ( ClassNotFoundException e) {
			 System.out.println(e.getMessage());
		 }
		do {
		 System.out.println("1 - Registar");
	         System.out.println("2 - Login");
	         System.out.println("3 - Sair");
	         System.out.println("Escolha Uma Opção:");
	         escolha = Ler.umInt();
			switch (escolha) {
            case 1:
                FuncLogin.register();
                break;
            case 2:
                Utilizador user = FuncLogin.login();
                if (user != null) {
                    if (user instanceof Administrador) {
                    	do {
                        op1 = FuncAuxiliares.menuAdmin();
                        	switch (op1) {
                        	case 1:
                                do {
                                	op2 = FuncAuxiliares.menuAdminUserManager();
                                    	switch (op2) {
                                    	case 1:
                                    		FuncLogin.removerUtilizador();//Remove um Utilizador que ja esteja registado                              
                                            break;
                                    	case 2:
                                    		System.out.println(FuncLogin.getUtilizadores());//Lista os Utilizadores Existentes
                                            break;
                                    	case 3:
                                    		FuncLogin.adminregister();//Criar Um novo utilizador com Permissões de Admin
                                            break;
                                    	case 4:
                                    		System.out.println("Sucesso!!\n\n");
                                            break;
                                        default:
                                            System.out.println("Opção inválida, tente novamente.\n");
                                            break;
                                    	}
                                	}while (op2 !=4);
                                break;
                        	case 2:
                        		do {
                        		op2 = FuncAuxiliares.menuAdminGestao();                                  
                                    	switch (op2) {
                                    	case 1:
                                    		System.out.println(produtos);//Lista os Produtos Existentes bem como as suas Categorias e ID's
                                            break;
                                    	case 2:
                                    		FuncProdutos.inserirProduto(produtos); //insere e cria um produto novo 
                                            break;
                                    	case 3:
                                    		FuncProdutos.removerProduto(produtos);//Remove um Produto que ja esteja registado 
                                            break;
                                    	case 4:
                                    		FuncProdutos.alterarCategoria(produtos);//Alterar a categoria de Um produto existente
                                            break;
                                    	case 5://atualizar detalhes do produto 
                                    		FuncProdutos.gerirDetalhes(produtos);//por fazer 
                                            break;
                                    	case 6: //gerir descontos
                                    		FuncProdutos.gerirDescontos(produtos); //por fazer
                                            break;
                                    	case 7:
                                    		System.out.println("Sucesso!!\n\n");
                                            break;
                                        default:
                                            System.out.println("Opção inválida, tente novamente.\n");
                                            break;
                                    	}
                                	}while (op2 !=7);
                                break;
                        	case 3:
                        		do {
                        			op2 = FuncAuxiliares.menuAdminShopPerformance();
                                    	switch (op2) {
                                    	case 1: //relatorio de vendas   		
                                            break;
                                    	case 2: //análise de estoque
                                            break;
                                    	case 3: //receita total e lucros
                                            break;
                                    	case 4: //desempenho de produtos
                                            break;
                                    	case 5: // satisfação do cliente 
                                            break;
                                    	case 6:
                                    		FuncAuxiliares.Categoriamaiscomum(produtos); //categoria mais comum 
                                            break;
                                    	case 7:
                                    		System.out.println("Sucesso!!\n\n");
                                            break;
                                        default:
                                            System.out.println("Opção inválida, tente novamente.\n");
                                            break;
                                    	}
                                	}while (op2 !=7);
                                break;
                        	case 4:
                        		System.out.println("Sucesso!!\n\n");
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente.\n");
                                break;
                        	}
                    	}while (op1 !=4);
                    } else if (user instanceof Cliente) {
                    	do {
                    	op1 = FuncAuxiliares.menuUser();
                    		switch (op1) {
                    		case 1://listar categorias
                    			FuncAuxiliares.listarcategorias(produtos); //por fazer 
                    			break;
                    		case 2://consultar produto dado nome 
                    			break;
                    			FuncAuxiliares.consultarpornome(produtos); //por fazer 
                    		case 3: //consultar produtos de categorias
                    			
                    			
                    			break;
                    		case 4: //consultar produto dado ID 
                    		
                    			break;
                    		case 5: //comprar produto por nome
                    	
                    			break;
                    		case 6: //comprar produto por ID 
                    			FuncLogin.register();
                    			break;
                    		case 7:	
                    			System.out.println ("Sucesso!!\n\n");
                                break;
                    		default:
                    			System.out.println("Opção inválida, tente novamente.");
                    			break;
                    		}
                    	}while (op1 !=7);
                    }
                }
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
			}
		} while (escolha != 3);
	}
	private static ArrayList<Utilizador> carregarUtilizadores() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Utilizadores.ser"))) {
            return (ArrayList<Utilizador>) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar utilizadores: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static ArrayList<Produto> carregarProdutos() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Produtos.ser"))) {
            return (ArrayList<Produto>) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
            return new ArrayList<>();
        }
    }	
}
