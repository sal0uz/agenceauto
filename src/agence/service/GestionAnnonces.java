package agence.service;

import agence.modele.Annonce;
import agence.modele.Voiture;
import agence.modele.enums.EtatAnnonce;

import java.util.ArrayList;
import java.util.List;

public class GestionAnnonces implements Gerable<Annonce> {

    private List<Annonce> annonces = new ArrayList<>();

    @Override
    public void ajouter(Annonce a) {
        annonces.add(a);
        System.out.println("✔ Annonce créée pour : " + a.getVoiture().getMarque() + " " + a.getVoiture().getModele());
    }

    @Override
    public List<Annonce> listerTous() {
        return annonces;
    }

    @Override
    public Annonce trouverParId(int id) {
        for (Annonce a : annonces) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    @Override
    public void supprimer(int id) {
        Annonce a = trouverParId(id);
        if (a != null) {
            annonces.remove(a);
            System.out.println("✔ Annonce #" + id + " supprimée.");
        } else {
            System.out.println("✘ Annonce #" + id + " introuvable.");
        }
    }

    public void desactiver(int id) {
        Annonce a = trouverParId(id);
        if (a != null) {
            a.setEtat(EtatAnnonce.INACTIVE);
            System.out.println("✔ Annonce #" + id + " désactivée.");
        } else {
            System.out.println("✘ Annonce introuvable.");
        }
    }

    public void modifierDescription(int id, String desc) {
        Annonce a = trouverParId(id);
        if (a != null) {
            a.setDescription(desc);
            System.out.println("✔ Annonce #" + id + " modifiée.");
        } else {
            System.out.println("✘ Annonce introuvable.");
        }
    }

    public List<Annonce> getAnnoncesActives() {
        List<Annonce> res = new ArrayList<>();
        for (Annonce a : annonces) {
            if (a.getEtat() == EtatAnnonce.ACTIVE) res.add(a);
        }
        return res;
    }
}
