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
        
        System.out.println("Username:  ");
        Username = Ler.umaString();
        
        System.out.println("\nPassword:  ");
        Password = Ler.umaString();
        
        System.out.println("\nConfirm Password: ");
        ConfirmPass = Ler.umaString();

        // Verificar se as senhas coincidem
        if (!Password.equals(ConfirmPass)) {
            System.out.println("Passwords não coincidem. Tente novamente.");
            return;
        }for (Utilizador u : Utilizadores) {
            if (u.getUsername().equals(Username)) {
                System.out.println("Este nome de utilizador já está registrado. Escolha outro.");
                return;
            }
        }

        // Registrar um novo utilizador
        Cliente novoCliente = new Cliente(Username, Password);
        Utilizadores.add(novoCliente);
        atualizarFicheiro();
        System.out.println("Utilizador registrado com sucesso!");
    }

    // Função para fazer login
    public static Utilizador login() {
    	LocalDate today = LocalDate.now();
        String Username, Password;
    
        if (Utilizadores.isEmpty()) {
            Administrador admin = new Administrador("admin", "admin", "Admin");
            Utilizadores.add(admin);
        }

        System.out.println("Username:  ");
        Username = Ler.umaString();

        System.out.println("\nPassword:  ");
        Password = Ler.umaString();

        for (Utilizador u : Utilizadores) {
            if (u.getUsername().equals(Username) && u.getPassword().equals(Password)) {
                System.out.println("Login efetuado com sucesso! Bem-vindo, " + Username + " são " + today);
                return u;
            }
        }
        System.out.println("Nome de utilizador ou senha incorretos.");
        return null;
    }
    
    public static void removerUtilizador() {
        System.out.println("Qual o o Username da conta? ");

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
                    System.out.println("Remoção cancelada.");
                    return;
                }
            }
         }
        System.out.println("Utilizador não encontrado.");
        return;
     }
    
    public static void adminregister() {
        String Username, Password, ConfirmPass;
        
        System.out.println("Username:  ");
        Username = Ler.umaString();
        
        System.out.println("\nPassword:  ");
        Password = Ler.umaString();
        
        System.out.println("\nConfirm Password: ");
        ConfirmPass = Ler.umaString();

        // Verificar se as senhas coincidem
        if (!Password.equals(ConfirmPass)) {
            System.out.println("Passwords não coincidem. Tente novamente.");
            return;
        }for (Utilizador u : Utilizadores) {
            if (u.getUsername().equals(Username)) {
                System.out.println("Este nome de utilizador já está registrado. Escolha outro.");
                return;
            }
        }
        Administrador newadmin = new Administrador(Username, Password, "Admin");
        Utilizadores.add(newadmin);
        atualizarFicheiro();
        System.out.println("Utilizador registrado com sucesso!");
    }

    // Atualizar o ficheiro Loja.dat com os Utilizadores registrados
    private static void atualizarFicheiro() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Utilizadores.ser"))) {
            os.writeInt(Utilizador.getUltimo()); // Salvar o último ID de utilizador
            os.writeObject(Utilizadores); // Salvar a lista de utilizadores
            System.out.println("Ficheiro de utilizadores atualizado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o ficheiro: " + e.getMessage());
        }
    }
}
