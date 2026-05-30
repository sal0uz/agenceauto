package agence.service;

import agence.modele.Personne;
import agence.modele.Vendeur;
import agence.modele.Acheteur;
import agence.modele.Agent;

import java.util.ArrayList;
import java.util.List;

public class GestionPersonnes implements Gerable<Personne> {

    private List<Personne> personnes = new ArrayList<>();

    @Override
    public void ajouter(Personne p) {
        personnes.add(p);
        System.out.println("✔ " + p.getRole() + " ajouté(e) : " + p.getPrenom() + " " + p.getNom());
    }

    @Override
    public List<Personne> listerTous() {
        return personnes;
    }

    @Override
    public Personne trouverParId(int id) {
        for (Personne p : personnes) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public void supprimer(int id) {
        Personne p = trouverParId(id);
        if (p != null) {
            personnes.remove(p);
            System.out.println("✔ Personne #" + id + " supprimée.");
        } else {
            System.out.println("✘ Personne #" + id + " introuvable.");
        }
    }

    public List<Vendeur> getVendeurs() {
        List<Vendeur> res = new ArrayList<>();
        for (Personne p : personnes) {
            if (p instanceof Vendeur) res.add((Vendeur) p);
        }
        return res;
    }

    public List<Acheteur> getAcheteurs() {
        List<Acheteur> res = new ArrayList<>();
        for (Personne p : personnes) {
            if (p instanceof Acheteur) res.add((Acheteur) p);
        }
        return res;
    }

    public List<Agent> getAgents() {
        List<Agent> res = new ArrayList<>();
        for (Personne p : personnes) {
            if (p instanceof Agent) res.add((Agent) p);
        }
        return res;
    }

    public void modifierPersonne(int id, String nom, String prenom, String tel, String email) {
        Personne p = trouverParId(id);
        if (p != null) {
            p.setNom(nom);
            p.setPrenom(prenom);
            p.setTelephone(tel);
            p.setEmail(email);
            System.out.println("✔ Personne #" + id + " modifiée.");
        } else {
            System.out.println("✘ Personne #" + id + " introuvable.");
        }
    }
}
