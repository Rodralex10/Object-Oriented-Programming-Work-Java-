package Trabalho; // Package declaration for the project

// The Administrador class extends the Utilizador class, representing a specific type of user with an access level
class Administrador extends Utilizador {
    // Private field to store the access level of the administrator
    private String nivelAcesso;

    // Constructor for the Administrador class
    // Takes Username, Password, and nivelAcesso as parameters
    public Administrador(String Username, String Password, String nivelAcesso) {
        // Calls the constructor of the superclass Utilizador
        super(Username, Password);
        // Initializes the nivelAcesso field with the given value
        this.nivelAcesso = nivelAcesso;
    }

    // Getter method for the nivelAcesso field
    // Returns the access level of the administrator
    public String getNivelAcesso() {
        return nivelAcesso;
    }

    // Setter method for the nivelAcesso field
    // Allows updating the access level of the administrator
    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    // Overrides the toString method from the Object class
    // Provides a string representation of the Administrador object
    @Override
    public String toString() {
        return "\nAdministrador{" + super.toString() + ", NivelAcesso=" + nivelAcesso + "}";
    }
}