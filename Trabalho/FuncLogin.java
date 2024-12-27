package Trabalho;

import java.io.FileOutputStream;

import java.time.*;
import java.time.format.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import myinputs.Ler;

public class FuncLogin {
    private static ArrayList<Utilizador> Utilizadores = new ArrayList<>();
    
    public static void setUtilizadores(ArrayList<Utilizador> lista) {
        Utilizadores = lista;
    }

    // Método para obter a lista de utilizadores
    public static ArrayList<Utilizador> getUtilizadores() {
        return Utilizadores;
    }
 
    // Função para registrar um novo utilizador
    public static void register() {
        String Username, Password, ConfirmPass;
        
        System.out.println("Nome de Utilizador:  ");
        Username = Ler.umaString();
        
        System.out.println("\nPassword:  ");
        Password = Ler.umaString();
        
        System.out.println("\nConfirmar Password: ");
        ConfirmPass = Ler.umaString();

        // Verificar se as senhas coincidem
        if (!Password.equals(ConfirmPass)) {
            System.out.println("Passwords não coincidem!");
            System.out.println("Tente novamente:");
            return;
        }for (Utilizador u : Utilizadores) {
            if (u.getUsername().equals(Username)) {
                System.out.println("Este Nome de Utilizador já está registado!");
                System.out.println("Escolha outro:");
                return;
            }
        }

        // Registrar um novo utilizador
        Cliente novoCliente = new Cliente(Username, Password);
        Utilizadores.add(novoCliente);
        atualizarFicheiro();
        System.out.println("Nome de Utilizador registado com sucesso!");
    }

    // Função para fazer login
    public static Utilizador login() {
    	LocalDate today = LocalDate.now();
        String Username, Password;
    
        if (Utilizadores.isEmpty()) {
            Administrador admin = new Administrador("admin", "admin", "Admin");
            Utilizadores.add(admin);
        }

        System.out.println("Nome de Utilizador:  ");
        Username = Ler.umaString();

        System.out.println("\nPassword:  ");
        Password = Ler.umaString();

        for (Utilizador u : Utilizadores) {
            if (u.getUsername().equals(Username) && u.getPassword().equals(Password)) {
                System.out.println("Login efetuado com sucesso!");
                System.out.println("Bem-vindo, " + Username + ", hoje é dia " + today);
                return u;
            }
        }
        System.out.println("Nome de Utilizador ou senha incorretos!");
        return null;
    }
    
    public static void removerUtilizador() {
        System.out.println("Qual o Nome de Utilizador da conta? ");

        String username = Ler.umaString();

        // Validar número de Produto e remover o Produto
        for (int i = 0; i < Utilizadores.size(); i++) {
            if (Utilizadores.get(i).getUsername().equals(username)) {
            	System.out.println("Tem a certeza?? (SIM/NAO)");
                String confirm = Ler.umaString().toUpperCase();
                if (confirm.equals("SIM")) {
                    Utilizadores.remove(i);
                    atualizarFicheiro();
                    System.out.println("Utilizador removido com sucesso!");
                    return;
                } else {
                    System.out.println("Remoção cancelada!");
                    return;
                }
            }
         }
        System.out.println("Utilizador não encontrado!");
        return;
     }
    
    public static void adminregister() {
        String Username, Password, ConfirmPass;
        
        System.out.println("Nome de Utilizador:  ");
        Username = Ler.umaString();
        
        System.out.println("\nPassword:  ");
        Password = Ler.umaString();
        
        System.out.println("\nConfirmar Password: ");
        ConfirmPass = Ler.umaString();

        // Verificar se as senhas coincidem
        if (!Password.equals(ConfirmPass)) {
        	System.out.println("Passwords não coincidem!");
            System.out.println("Tente novamente:");
            return;
        }for (Utilizador u : Utilizadores) {
            if (u.getUsername().equals(Username)) {
            	System.out.println("Este Nome de Utilizador já está registado!");
                System.out.println("Escolha outro:");
                return;
            }
        }
        Administrador newadmin = new Administrador(Username, Password, "Admin");
        Utilizadores.add(newadmin);
        atualizarFicheiro();
        System.out.println("Nome de Utilizador registado com sucesso!");
    }

    // Atualizar o ficheiro Loja.dat com os Utilizadores registrados
    private static void atualizarFicheiro() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Utilizadores.ser"))) {
            os.writeInt(Utilizador.getUltimo()); // Salvar o último ID de utilizador
            os.writeObject(Utilizadores); // Salvar a lista de utilizadores
            System.out.println("Ficheiro de Utilizadores atualizado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o ficheiro: " + e.getMessage());
        }
    }
}
