package agence.modele;

import agence.modele.enums.EtatAnnonce;
import java.time.LocalDate;

public class Annonce {

    private static int compteur = 1;

    private final int id;
    private String description;
    private LocalDate datePublication;
    private EtatAnnonce etat;
    private Voiture voiture;

    public Annonce(String description, Voiture voiture) {
        this.id = compteur++;
        this.description = description;
        this.datePublication = LocalDate.now();
        this.etat = EtatAnnonce.ACTIVE;
        this.voiture = voiture;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDatePublication() { return datePublication; }
    public EtatAnnonce getEtat() { return etat; }
    public void setEtat(EtatAnnonce etat) { this.etat = etat; }
    public Voiture getVoiture() { return voiture; }

    public String getCoordonneesVendeur() {
        return voiture.getVendeur().getPrenom() + " " + voiture.getVendeur().getNom() +
               " | Tel: " + voiture.getVendeur().getTelephone() +
               " | Email: " + voiture.getVendeur().getEmail();
    }

    @Override
    public String toString() {
        return "#" + id + " - " + voiture.getMarque() + " " + voiture.getModele() +
               " | Etat: " + etat + " | Date: " + datePublication +
               "\n   Description: " + description +
               "\n   Contact: " + getCoordonneesVendeur();
    }
}
