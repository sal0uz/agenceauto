package agence.modele;

import agence.modele.enums.EtatTransaction;
import java.time.LocalDate;

public class Transaction {

    private static int compteur = 1;

    private int id;
    private Annonce annonce;
    private Acheteur acheteur;
    private Agent agent;
    private double montantVente;
    private double fraisMediation;
    private EtatTransaction etat;
    private LocalDate dateTransaction;
    private RendezVous rendezVous;

    public Transaction(Annonce annonce, Acheteur acheteur, Agent agent) {
        this.id = compteur++;
        this.annonce = annonce;
        this.acheteur = acheteur;
        this.agent = agent;
        this.montantVente = annonce.getVoiture().getPrix();
        this.fraisMediation = Mediation.calculerFrais(montantVente);
        this.etat = EtatTransaction.EN_COURS;
        this.dateTransaction = LocalDate.now();
    }

    public void finaliser() {
        this.etat = EtatTransaction.FINALISEE;
        annonce.getVoiture().setDisponible(false);
        annonce.setEtat(agence.modele.enums.EtatAnnonce.VENDUE);
    }

    public void annuler() {
        this.etat = EtatTransaction.ANNULEE;
    }

    public int getId() { return id; }
    public Annonce getAnnonce() { return annonce; }
    public Acheteur getAcheteur() { return acheteur; }
    public Agent getAgent() { return agent; }
    public double getMontantVente() { return montantVente; }
    public double getFraisMediation() { return fraisMediation; }
    public EtatTransaction getEtat() { return etat; }
    public LocalDate getDateTransaction() { return dateTransaction; }
    public RendezVous getRendezVous() { return rendezVous; }
    public void setRendezVous(RendezVous rendezVous) { this.rendezVous = rendezVous; }

    @Override
    public String toString() {
        return "#" + id +
               " | Voiture: " + annonce.getVoiture().getMarque() + " " + annonce.getVoiture().getModele() +
               " | Acheteur: " + acheteur.getPrenom() + " " + acheteur.getNom() +
               " | Agent: " + agent.getPrenom() + " " + agent.getNom() +
               "\n   Montant: " + montantVente + " MAD | Frais: " + String.format("%.2f", fraisMediation) + " MAD" +
               " | Etat: " + etat +
               " | RDV: " + (rendezVous != null ? rendezVous : "Non planifié");
    }
}
