package agence.service;

import agence.modele.Demande;
import agence.modele.enums.EtatDemande;

import java.util.ArrayList;
import java.util.List;

public class GestionDemandes implements Gerable<Demande> {

    private List<Demande> demandes = new ArrayList<>();

    @Override
    public void ajouter(Demande d) {
        demandes.add(d);
        System.out.println("✔ Demande enregistrée pour : " + d.getAcheteur().getPrenom());
    }

    @Override
    public List<Demande> listerTous() {
        return demandes;
    }

    @Override
    public Demande trouverParId(int id) {
        for (Demande d : demandes) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    @Override
    public void supprimer(int id) {
        Demande d = trouverParId(id);
        if (d != null) {
            demandes.remove(d);
            System.out.println("✔ Demande #" + id + " supprimée.");
        }
    }

    public void changerEtat(int id, EtatDemande etat) {
        Demande d = trouverParId(id);
        if (d != null) {
            d.setEtat(etat);
            System.out.println("✔ Demande #" + id + " → " + etat);
        } else {
            System.out.println("✘ Demande introuvable.");
        }
    }
}
