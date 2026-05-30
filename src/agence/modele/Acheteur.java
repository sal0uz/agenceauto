package agence.modele;

public class Acheteur extends Personne {

    public Acheteur(String nom, String prenom, String telephone, String email) {
        super(nom, prenom, telephone, email);
    }

    @Override
    public String getRole() { return "Acheteur"; }
}
