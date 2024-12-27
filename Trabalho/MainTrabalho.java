package Trabalho;
import Trabalho.FuncProdutos;
import java.io.*;

import java.util.ArrayList;
import myinputs.Ler;

public class MainTrabalho {	 
	
	public static void main(String[] args) {
		int escolha,op1,op2,op3;
        ArrayList<Produto> produtos = carregarProdutos();
        ArrayList<Utilizador> users = carregarUtilizadores();
        ArrayList<Fatura> faturas = carregarFaturas();
        Utilizador.setUltimo(users.size());
        FuncLogin.setUtilizadores(users);
		do {
			 System.out.println("1 - Registo");
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
                                    		FuncProdutos.inserirProduto(produtos);//Insere/Cria um produto Novo 
                                            break;
                                    	case 2:
                                    		System.out.println(produtos);//Lista os Produtos Existentes bem como as suas Categorias e ID's
                                            break;
                                    	case 3:
                                    		FuncProdutos.removerProduto(produtos);//Remove um Utilizador que ja esteja registado 
                                            break;
                                    	case 4:
                                    		FuncProdutos.alterarCategoria(produtos);//Alterar a categoria de Um produto existente
                                            break;
                                    	case 5:
                                    		do {
                                            	op3 = FuncAuxiliares.menuAdminStockManager();
                                                	switch (op3) {
                                                	case 1:
                                                		FuncProdutos.stockVerify(produtos);                       
                                                        break;
                                                	case 2:
                                                		FuncProdutos.adicionarStock(produtos);
                                                        break;
                                                	case 3:
                                                		FuncProdutos.removerStock(produtos);
                                                        break;
                                                	case 4:
                                                		System.out.println("Sucesso!!\n\n");
                                                        break;
                                                    default:
                                                        System.out.println("Opção inválida, tente novamente.\n");
                                                        break;
                                                	}
                                            	}while (op3 != 4);
                                            break;
                                    	case 6:
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
                                    	case 1:
                                    		Estatisticas.produtosMaisEMenosVendidos(faturas);
                                            break;
                                    	case 2:
                                    		Estatisticas.melhoresClientes(faturas);
                                            break;
                                    	case 3:
                                    		Estatisticas.calcularFaturacaoPorPeriodo(faturas);
                                            break;
                                    	case 4:
                                    		System.out.println(faturas);
                                            break;
                                    	case 5:
                                            break;
                                    	case 6:
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
                        Cliente cliente = (Cliente) user;
                        do {
                            op1 = FuncAuxiliares.menuCliente();
                            switch (op1) {
                                case 1:
                                	do {
                                    	op2 = FuncAuxiliares.menuConsultarProdutos();
                                        	switch (op2) {
                                        	case 1:
                                        		FuncProdutosClientes.listarCategorias(produtos);                             
                                                break;
                                        	case 2:
                                        		FuncProdutosClientes.consultarProdutoPorNome(produtos);
                                                break;
                                        	case 3:
                                        		FuncProdutosClientes.consultarProdutosPorCategoria(produtos);
                                                break;
                                        	case 4:
                                        		FuncProdutosClientes.consultarProdutoPorID(produtos);
                                                break;
                                        	case 5:
                                        		FuncVendas.addProdutoAoCarroID(produtos, cliente);
                                                break;
                                        	case 6:
                                        		FuncVendas.addProdutoAoCarroNome(produtos, cliente);
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
                                case 2:
                                	do {
                                    	op2 = FuncAuxiliares.menuCarrinho();
                                        	switch (op2) {
                                        	case 1:
                                        		FuncVendas.listarCarrinho(cliente);                             
                                                break;
                                        	case 2:
                                        		
                                                break;
                                        	case 3:
                                        		FuncVendas.finalizarCompra(cliente, faturas, produtos);
                                                break;
                                        	case 4:
                                        		FuncVendas.limparCarrinho(cliente);
                                                break;
                                        	case 5:
                                        		System.out.println("Sucesso!!\n\n");
                                                break;
                                            default:
                                                System.out.println("Opção inválida, tente novamente.\n");
                                                break;
                                        	}
                                    	}while (op2 !=5);
                                    break;
                                case 3:
                                	FuncVendas.listarCarrinho(cliente);
                                    break;                  
                                case 4:
                                    System.out.println("A sair...");
                                    break;
                                default:
                                    System.out.println("Opção inválida, tente novamente.");
                            }
                        } while (op1 != 4);
                    }
                }
                break;
            case 3:
                System.out.println("A sair...");
                break;
            case 4:
                System.out.println("A sair...");
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
			}
		} while (escolha != 4);
	}
	
	private static ArrayList<Utilizador> carregarUtilizadores() {
	    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Utilizadores.ser"))) {
	        Utilizador.setUltimo(is.readInt());
	        return (ArrayList<Utilizador>) is.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Erro ao carregar utilizadores: " + e.getMessage());
	        return new ArrayList<>();
	    }
	}


	private static ArrayList<Produto> carregarProdutos() {
	    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Produtos.ser"))) {
	        Produto.setUltimo(is.readInt()); // Carregar o último ID de produto
	        return (ArrayList<Produto>) is.readObject(); // Carregar a lista de produtos
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Erro ao carregar produtos: " + e.getMessage());
	        return new ArrayList<>();
	    }
	}
	
	private static ArrayList<Fatura> carregarFaturas() {
	    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Faturas.ser"))) {
	    	Fatura.setUltimo(is.readInt());
	    	return (ArrayList<Fatura>) is.readObject(); // Carregar a lista de faturas
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Erro ao carregar as faturas: " + e.getMessage());
	        return new ArrayList<>();
	    }
	}	
}