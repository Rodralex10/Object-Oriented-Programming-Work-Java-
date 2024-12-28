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
    
    // Method to set the list of users
    public static void setUtilizadores(ArrayList<Utilizador> lista) {
        Utilizadores = lista;
    }

    // Method to get the list of users
    public static ArrayList<Utilizador> getUtilizadores() {
        return Utilizadores;
    }
 
    // Function to register a new user
    public static void register() {
        String Username, Password, ConfirmPass;
        
        System.out.println("/====================================================/");
        System.out.println("/               REGISTO NOVO UTILIZADOR              /");
        System.out.println("/====================================================/");
        
        System.out.println("Nome de Utilizador:  ");
        Username = Ler.umaString(); // Read the username
        
        System.out.println("\nPassword:  ");
        Password = Ler.umaString(); // Read the password
        
        System.out.println("\nConfirmar Password: ");
        ConfirmPass = Ler.umaString(); // Confirm the password

       // Check if passwords match
        if (!Password.equals(ConfirmPass)) {
            System.out.println("Passwords não coincidem!");
            System.out.println("Tente novamente:");
            return;
       // Check if username is already registered
        }for (Utilizador u : Utilizadores) {
            if (u.getUsername().equals(Username)) {
                System.out.println("\nEste Nome de Utilizador já está registado!");
                System.out.println("Escolha outro:\n");
                return;
            }
        }

       // Register a new user
        Cliente novoCliente = new Cliente(Username, Password);
        Utilizadores.add(novoCliente);
        atualizarFicheiro();
        System.out.println("\nNome de Utilizador registado com sucesso!\n");
    }

    	// Function to log in an existing user
    public static Utilizador login() {
    	LocalDate today = LocalDate.now();
        String Username, Password;
    
        // If no users exist, create a default admin user
        if (Utilizadores.isEmpty()) {
            Administrador admin = new Administrador("admin", "admin", "Admin");
            Utilizadores.add(admin);
        }

        System.out.println("/====================================================/");
        System.out.println("/                       LOGIN                        /");
        System.out.println("/====================================================/");
        	
        System.out.println("Nome de Utilizador:  ");
        Username = Ler.umaString(); // Read the username

        System.out.println("\nPassword:  ");
        Password = Ler.umaString(); // Read the password

        // Verify the username and password
        for (Utilizador u : Utilizadores) {
            if (u.getUsername().equals(Username) && u.getPassword().equals(Password)) {
                System.out.println("Login efetuado com sucesso!");
                System.out.println("/====================================================/");
                System.out.println("/ Bem-vindo, " + Username + ", hoje é dia " + today    );
                System.out.println("/====================================================/");
                return u;
            }
        }
        System.out.println("\nNome de Utilizador ou senha incorretos!\n");
        return null;
    }
    
    // Function to remove a user by username
    public static void removerUtilizador() {
        System.out.println("Qual o Nome de Utilizador da conta? ");

        String username = Ler.umaString(); // Read the username to be removed

        // Validate and remove the user
        for (int i = 0; i < Utilizadores.size(); i++) {
            if (Utilizadores.get(i).getUsername().equals(username)) {
            	System.out.println("Tem a certeza?? (SIM/NAO)");
                String confirm = Ler.umaString().toUpperCase(); // Confirm deletion
                if (confirm.equals("SIM")) {
                    Utilizadores.remove(i);
                    atualizarFicheiro(); // Update the file after deletion
                    System.out.println("Utilizador removido com sucesso!\n");
                    return;
                } else {
                    System.out.println("Remoção cancelada!\n");
                    return;
                }
            }
         }
        System.out.println("Utilizador não encontrado!\n");
        return;
     }
    // Function to register a new admin user
    public static void adminregister() {
        String Username, Password, ConfirmPass;
        
        System.out.println("Nome de Utilizador:  ");
        Username = Ler.umaString(); // Read the username
        
        System.out.println("\nPassword:  ");
        Password = Ler.umaString(); // Read the password
        
        System.out.println("\nConfirmar Password: ");
        ConfirmPass = Ler.umaString(); // Confirm the password

        // Check if passwords match
        if (!Password.equals(ConfirmPass)) {
        	System.out.println("Passwords não coincidem!");
            System.out.println("Tente novamente:\n");
            return;   
        }
        // Check if username is already registered
        for (Utilizador u : Utilizadores) {
            if (u.getUsername().equals(Username)) {
            	System.out.println("Este Nome de Utilizador já está registado!");
                System.out.println("Escolha outro:\n");
                return;
            }
        }
        // Register a new admin user
        Administrador newadmin = new Administrador(Username, Password, "Admin");
        Utilizadores.add(newadmin);
        atualizarFicheiro();
        System.out.println("Nome de Utilizador registado com sucesso!\n");
    }

    // Update the file "Utilizadores.ser" with the current list of users
    private static void atualizarFicheiro() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Utilizadores.ser"))) {
            os.writeInt(Utilizador.getUltimo()); // Save the last user ID
            os.writeObject(Utilizadores); // Save the list of users
            System.out.println("Ficheiro de Utilizadores atualizado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o ficheiro: " + e.getMessage());
        }
    }
}
