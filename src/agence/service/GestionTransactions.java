package agence.service;

import agence.modele.RendezVous;
import agence.modele.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionTransactions implements Gerable<Transaction> {

    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void ajouter(Transaction t) {
        transactions.add(t);
        System.out.println("✔ Transaction #" + t.getId() + " créée.");
    }

    @Override
    public List<Transaction> listerTous() {
        return transactions;
    }

    @Override
    public Transaction trouverParId(int id) {
        for (Transaction t : transactions) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    @Override
    public void supprimer(int id) {
        Transaction t = trouverParId(id);
        if (t != null) transactions.remove(t);
    }

    public void finaliser(int id) {
        Transaction t = trouverParId(id);
        if (t != null) {
            t.finaliser();
            System.out.println("✔ Transaction #" + id + " finalisée. Frais: " +
                               String.format("%.2f", t.getFraisMediation()) + " MAD");
        } else {
            System.out.println("✘ Transaction introuvable.");
        }
    }

    public void annuler(int id) {
        Transaction t = trouverParId(id);
        if (t != null) {
            t.annuler();
            System.out.println("✔ Transaction #" + id + " annulée.");
        } else {
            System.out.println("✘ Transaction introuvable.");
        }
    }

    public void planifierRendezVous(int id, LocalDate date) {
        Transaction t = trouverParId(id);
        if (t != null) {
            t.setRendezVous(new RendezVous(date, "Agence Auto"));
            System.out.println("✔ Rendez-vous planifié le " + date + " pour transaction #" + id);
        } else {
            System.out.println("✘ Transaction introuvable.");
        }
    }

    public void afficherFrais() {
        System.out.println("\n=== Récapitulatif des frais de médiation ===");
        double total = 0;
        for (Transaction t : transactions) {
            System.out.println("  Transaction #" + t.getId() + " : " +
                               String.format("%.2f", t.getFraisMediation()) + " MAD (" + t.getEtat() + ")");
            total += t.getFraisMediation();
        }
        System.out.println("  TOTAL : " + String.format("%.2f", total) + " MAD");
    }
}
