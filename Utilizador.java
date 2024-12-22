package Trabalho;

import java.io.Serializable;

class Utilizador implements Serializable {
    private int id;
    private static int ultimo = 0;
    protected String Username;
    protected String Password;

    public Utilizador(String Username, String Password) {
        ultimo++;
        id = ultimo;
        this.Username = Username;
        this.Password = Password;
    }

    public int getId() {
        return id;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Utilizador.ultimo = ultimo;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "id=" + id + ", Username=" + Username + ", Password=" + Password;
    }
}

class Cliente extends Utilizador {

    public Cliente(String Username, String Password) {
        super(Username, Password);
    }

   
    @Override
    public String toString() {
        return "\nCliente{" + super.toString() + '}';
    }
}

class Administrador extends Utilizador {
    private String nivelAcesso;

    public Administrador(String Username, String Password, String nivelAcesso) {
        super(Username, Password);
        this.nivelAcesso = nivelAcesso;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String toString() {
        return "\nAdministrador{" + super.toString() + ", NivelAcesso=" + nivelAcesso + "}";
    }
}

        //Cliente cliente = new Cliente("joao123", "senha123", 1, "Rua A, 123");
        //Administrador admin = new Administrador("admin123", "adminpass", 2, "Gerente");
