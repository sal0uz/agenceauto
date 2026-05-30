package agence.modele;

import agence.modele.enums.Carburant;

public class Voiture {

    private static int compteur = 1;

    private int id;
    private String marque;
    private String modele;
    private int annee;
    private double prix;
    private int kilometrage;
    private Carburant carburant;
    private boolean disponible;
    private Vendeur vendeur;

    public Voiture(String marque, String modele, int annee, double prix,
                   int kilometrage, Carburant carburant, Vendeur vendeur) {
        this.id = compteur++;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.prix = prix;
        this.kilometrage = kilometrage;
        this.carburant = carburant;
        this.disponible = true;
        this.vendeur = vendeur;
    }

    // Getters / Setters
    public int getId() { return id; }
    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }
    public String getModele() { return modele; }
    public void setModele(String modele) { this.modele = modele; }
    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public int getKilometrage() { return kilometrage; }
    public void setKilometrage(int kilometrage) { this.kilometrage = kilometrage; }
    public Carburant getCarburant() { return carburant; }
    public void setCarburant(Carburant carburant) { this.carburant = carburant; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public Vendeur getVendeur() { return vendeur; }

    @Override
    public String toString() {
        return "#" + id + " - " + marque + " " + modele + " (" + annee + ")" +
               " | Prix: " + prix + " MAD | " + kilometrage + " km | " +
               carburant + " | " + (disponible ? "Disponible" : "Non disponible") +
               " | Vendeur: " + vendeur.getPrenom() + " " + vendeur.getNom();
    }
}
