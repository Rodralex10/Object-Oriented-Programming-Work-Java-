package Trabalho; // Specifies the package name

import java.io.Serializable; // Imports the Serializable interface for object serialization
import java.time.LocalDate; // Imports the LocalDate class for date manipulation

public class Data implements Serializable { // Declares the Data class implementing Serializable
    private int dia, mes, ano; // Private fields for day, month, and year

    public Data() {} // Default constructor

    public Data(int dia, int mes, int ano) { // Parameterized constructor
        this.dia = dia; // Initializes the day
        this.mes = mes; // Initializes the month
        this.ano = ano; // Initializes the year
    }

    public int getDia() { // Getter for day
        return dia; // Returns the day
    }

    public void setDia(int dia) { // Setter for day
        this.dia = dia; // Sets the day
    }

    public int getMes() { // Getter for month
        return mes; // Returns the month
    }

    public void setMes(int mes) { // Setter for month
        this.mes = mes; // Sets the month
    }

    public int getAno() { // Getter for year
        return ano; // Returns the year
    }

    public void setAno(int ano) { // Setter for year
        this.ano = ano; // Sets the year
    }

    @Override
    public String toString() { // Overrides the toString method
        return String.format("%02d/%02d/%04d", dia, mes, ano); // Returns the date in dd/mm/yyyy format
    }
}