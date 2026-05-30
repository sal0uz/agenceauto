package agence.service;

import agence.modele.Voiture;
import agence.modele.enums.Carburant;

import java.util.ArrayList;
import java.util.List;

public class GestionVoitures implements Gerable<Voiture> {

    private List<Voiture> voitures = new ArrayList<>();

    @Override
    public void ajouter(Voiture v) {
        voitures.add(v);
        System.out.println("✔ Voiture ajoutée : " + v.getMarque() + " " + v.getModele());
    }

    @Override
    public List<Voiture> listerTous() {
        return voitures;
    }

    @Override
    public Voiture trouverParId(int id) {
        for (Voiture v : voitures) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    @Override
    public void supprimer(int id) {
        Voiture v = trouverParId(id);
        if (v == null) {
            System.out.println("✘ Voiture introuvable."); return;
        }
        if (v.isDisponible()) {
            System.out.println("✘ Impossible de supprimer une voiture disponible.");
        } else {
            voitures.remove(v);
            System.out.println("✔ Voiture #" + id + " supprimée.");
        }
    }

    public List<Voiture> rechercherParMarque(String marque) {
        List<Voiture> res = new ArrayList<>();
        for (Voiture v : voitures) {
            if (v.getMarque().equalsIgnoreCase(marque)) res.add(v);
        }
        return res;
    }

    public List<Voiture> rechercherParPrixMax(double prixMax) {
        List<Voiture> res = new ArrayList<>();
        for (Voiture v : voitures) {
            if (prixMax <= 0 || v.getPrix() <= prixMax) res.add(v);
        }
        return res;
    }

    public List<Voiture> rechercherParCarburant(Carburant carburant) {
        List<Voiture> res = new ArrayList<>();
        for (Voiture v : voitures) {
            if (v.getCarburant() == carburant) res.add(v);
        }
        return res;
    }

    public List<Voiture> rechercher(String marque, double prixMax, Carburant carburant) {
        List<Voiture> res = new ArrayList<>();
        for (Voiture v : voitures) {
            if (marque != null && !marque.isBlank() && !v.getMarque().equalsIgnoreCase(marque)) continue;
            if (prixMax > 0 && v.getPrix() > prixMax) continue;
            if (carburant != null && v.getCarburant() != carburant) continue;
            res.add(v);
        }
        return res;
    }

    public void modifierVoiture(int id, double nouveauPrix, int nouveauKm) {
        Voiture v = trouverParId(id);
        if (v != null) {
            v.setPrix(nouveauPrix);
            v.setKilometrage(nouveauKm);
            System.out.println("✔ Voiture #" + id + " modifiée.");
        } else {
            System.out.println("✘ Voiture introuvable.");
        }
    }
}
