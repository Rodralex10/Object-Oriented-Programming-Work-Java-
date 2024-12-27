package Trabalho;

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