package agence.modele;

import agence.modele.enums.EtatDemande;
import java.time.LocalDate;

public class Demande {

    private static int compteur = 1;

    private int id;
    private Acheteur acheteur;
    private String criteres; 
    private EtatDemande etat;
    private LocalDate dateDemande;

    public Demande(Acheteur acheteur, String criteres) {
        this.id = compteur++;
        this.acheteur = acheteur;
        this.criteres = criteres;
        this.etat = EtatDemande.EN_ATTENTE;
        this.dateDemande = LocalDate.now();
    }

    public int getId() { return id; }
    public Acheteur getAcheteur() { return acheteur; }
    public String getCriteres() { return criteres; }
    public void setCriteres(String criteres) { this.criteres = criteres; }
    public EtatDemande getEtat() { return etat; }
    public void setEtat(EtatDemande etat) { this.etat = etat; }
    public LocalDate getDateDemande() { return dateDemande; }

    @Override
    public String toString() {
        return "#" + id + " - Acheteur: " + acheteur.getPrenom() + " " + acheteur.getNom() +
               " | Critères: " + criteres + " | Etat: " + etat + " | Date: " + dateDemande;
    }
}
