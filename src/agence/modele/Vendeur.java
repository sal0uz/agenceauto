package agence.modele;

public class Vendeur extends Personne {

    public Vendeur(String nom, String prenom, String telephone, String email) {
        super(nom, prenom, telephone, email);
    }

    @Override
    public String getRole() { return "Vendeur"; }
}
