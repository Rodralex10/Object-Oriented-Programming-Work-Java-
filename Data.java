package Trabalho;
import java.io.Serializable;
import java.time.LocalDate;


public class Data implements Serializable {
    private int dia, mes, ano;

    public Data() {}

    
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

 
    public int getDia() {
        return dia;
    }


    public void setDia(int dia) {
        this.dia = dia;
    }

  
    public int getMes() {
        return mes;
    }

 
    public void setMes(int mes) {
        this.mes = mes;
    }

 
    public int getAno() {
        return ano;
    }

   
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
