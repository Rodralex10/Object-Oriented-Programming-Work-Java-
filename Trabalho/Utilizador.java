package Trabalho;

import java.io.Serializable;
import java.util.ArrayList;

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




