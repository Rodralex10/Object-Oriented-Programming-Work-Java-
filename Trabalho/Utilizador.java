package Trabalho;

import java.io.Serializable;
import java.util.ArrayList;

class Utilizador implements Serializable {
    private int id; // Unique identifier for the user
    private static int ultimo = 0; // Static variable to track the last user ID
    protected String Username; // Username of the user
    protected String Password; // Password of the user

    // Constructor to initialize a new user with username and password
    public Utilizador(String Username, String Password) {
        ultimo++; // Increment the last user ID
        id = ultimo; // Assign the new ID to the user
        this.Username = Username;
        this.Password = Password;
    }

    // Getter for user ID
    public int getId() {
        return id;
    }

    // Getter for the last user ID
    public static int getUltimo() {
        return ultimo;
    }

    // Setter for the last user ID
    public static void setUltimo(int ultimo) {
        Utilizador.ultimo = ultimo;
    }

    // Getter for the username
    public String getUsername() {
        return Username;
    }
 
    // Setter for the username
    public void setUsername(String Username) {
        this.Username = Username;
    }
 
    // Getter for the password
    public String getPassword() {
        return Password;
    }
 
    // Setter for the password
    public void setPassword(String Password) {
        this.Password = Password;
    }
 
    // Override the toString method to provide a string representation of the user
    @Override
    public String toString() {
        return "ID =" + id + ", Nome de Utilizador =" + Username + ", Password =" + Password;
    }
}