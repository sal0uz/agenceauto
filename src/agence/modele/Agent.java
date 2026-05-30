package agence.modele;

public class Agent extends Personne {

    private String matricule;

    public Agent(String nom, String prenom, String telephone, String email, String matricule) {
        super(nom, prenom, telephone, email);
        this.matricule = matricule;
    }

    @Override
    public String getRole() { return "Agent"; }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    @Override
    public String toString() {
        return super.toString() + " | Matricule: " + matricule;
    }
}
