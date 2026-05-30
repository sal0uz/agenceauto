package agence.ui;

import agence.modele.*;
import agence.modele.enums.*;
import agence.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner sc = new Scanner(System.in);

    private final GestionPersonnes gestionPersonnes = new GestionPersonnes();
    private final GestionVoitures gestionVoitures = new GestionVoitures();
    private final GestionAnnonces gestionAnnonces = new GestionAnnonces();
    private final GestionDemandes gestionDemandes = new GestionDemandes();
    private final GestionTransactions gestionTransactions = new GestionTransactions();

    //  LANCEMENT

    public void lancer() {
        chargerDonneesDemo();
        boolean continuer = true;
        while (continuer) {
            afficherMenuPrincipal();
            int choix = lireInt("Votre choix : ");
            switch (choix) {
                case 1 -> menuPersonnes();
                case 2 -> menuVoitures();
                case 3 -> menuAnnonces();
                case 4 -> menuDemandes();
                case 5 -> menuTransactions();
                case 6 -> menuRecherche();
                case 0 -> continuer = false;
                default -> System.out.println("✘ Choix invalide.");
            }
        }
        System.out.println("\nAu revoir !");
    }

    //  MENUS

    private void afficherMenuPrincipal() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     AGENCE AUTO – MENU PRINCIPAL      ║");
        System.out.println("╠ ═════════════════════════════════════ ╣");
        System.out.println("║  1. Gestion des personnes             ║");
        System.out.println("║  2. Gestion des voitures              ║");
        System.out.println("║  3. Gestion des annonces              ║");
        System.out.println("║  4. Gestion des demandes              ║");
        System.out.println("║  5. Transactions & Médiation          ║");
        System.out.println("║  6. Recherche                         ║");
        System.out.println("║  0. Quitter                           ║");
        System.out.println("╚ ══════════════════════════════════════╝");
    }

    // ── PERSONNES ──
    private void menuPersonnes() {
        System.out.println("\n--- Gestion des Personnes ---");
        System.out.println("1. Ajouter Vendeur  2. Ajouter Acheteur  3. Ajouter Agent");
        System.out.println("4. Lister tous      5. Modifier          6. Supprimer");
        int c = lireInt("Choix : ");
        switch (c) {
            case 1 -> {
                System.out.print("Nom: "); String nom = sc.nextLine();
                System.out.print("Prénom: "); String prenom = sc.nextLine();
                System.out.print("Téléphone: "); String tel = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                gestionPersonnes.ajouter(new Vendeur(nom, prenom, tel, email));
            }
            case 2 -> {
                System.out.print("Nom: "); String nom = sc.nextLine();
                System.out.print("Prénom: "); String prenom = sc.nextLine();
                System.out.print("Téléphone: "); String tel = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                gestionPersonnes.ajouter(new Acheteur(nom, prenom, tel, email));
            }
            case 3 -> {
                System.out.print("Nom: "); String nom = sc.nextLine();
                System.out.print("Prénom: "); String prenom = sc.nextLine();
                System.out.print("Téléphone: "); String tel = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Matricule: "); String mat = sc.nextLine();
                gestionPersonnes.ajouter(new Agent(nom, prenom, tel, email, mat));
            }
            case 4 -> {
                List<Personne> liste = gestionPersonnes.listerTous();
                if (liste.isEmpty()) System.out.println("Aucune personne enregistrée.");
                else liste.forEach(System.out::println);
            }
            case 5 -> {
                int id = lireInt("ID de la personne à modifier : ");
                System.out.print("Nouveau nom: "); String nom = sc.nextLine();
                System.out.print("Nouveau prénom: "); String prenom = sc.nextLine();
                System.out.print("Nouveau téléphone: "); String tel = sc.nextLine();
                System.out.print("Nouvel email: "); String email = sc.nextLine();
                gestionPersonnes.modifierPersonne(id, nom, prenom, tel, email);
            }
            case 6 -> {
                int id = lireInt("ID de la personne à supprimer : ");
                gestionPersonnes.supprimer(id);
            }
        }
    }

    // ── VOITURES ──
    private void menuVoitures() {
        System.out.println("\n--- Gestion des Voitures ---");
        System.out.println("1. Ajouter  2. Lister  3. Modifier prix/km  4. Supprimer  5. Détail");
        int c = lireInt("Choix : ");
        switch (c) {
            case 1 -> {
                List<Vendeur> vendeurs = gestionPersonnes.getVendeurs();
                if (vendeurs.isEmpty()) { System.out.println("✘ Ajoutez d'abord un vendeur."); return; }
                System.out.println("Vendeurs disponibles :"); vendeurs.forEach(System.out::println);
                int vid = lireInt("ID Vendeur : ");
                Vendeur vendeur = (Vendeur) gestionPersonnes.trouverParId(vid);
                if (vendeur == null) { System.out.println("✘ Vendeur introuvable."); return; }
                System.out.print("Marque: "); String marque = sc.nextLine();
                System.out.print("Modèle: "); String modele = sc.nextLine();
                int annee = lireInt("Année: ");
                double prix = lireDouble("Prix (MAD): ");
                int km = lireInt("Kilométrage: ");
                System.out.println("Carburant: 1.ESSENCE 2.DIESEL 3.HYBRIDE 4.ELECTRIQUE");
                int carb = lireInt("Choix carburant: ");
                Carburant[] carbs = Carburant.values();
                Carburant carburant = carbs[Math.max(0, Math.min(carb - 1, carbs.length - 1))];
                gestionVoitures.ajouter(new Voiture(marque, modele, annee, prix, km, carburant, vendeur));
            }
            case 2 -> {
                List<Voiture> liste = gestionVoitures.listerTous();
                if (liste.isEmpty()) System.out.println("Aucune voiture enregistrée.");
                else liste.forEach(System.out::println);
            }
            case 3 -> {
                int id = lireInt("ID Voiture : ");
                double prix = lireDouble("Nouveau prix (MAD): ");
                int km = lireInt("Nouveau kilométrage: ");
                gestionVoitures.modifierVoiture(id, prix, km);
            }
            case 4 -> { int id = lireInt("ID Voiture : "); gestionVoitures.supprimer(id); }
            case 5 -> {
                int id = lireInt("ID Voiture : ");
                Voiture v = gestionVoitures.trouverParId(id);
                if (v != null) System.out.println(v);
                else System.out.println("✘ Introuvable.");
            }
        }
    }

    // ── ANNONCES ──
    private void menuAnnonces() {
        System.out.println("\n--- Gestion des Annonces ---");
        System.out.println("1. Créer  2. Lister toutes  3. Lister actives  4. Modifier  5. Désactiver");
        int c = lireInt("Choix : ");
        switch (c) {
            case 1 -> {
                List<Voiture> voitures = gestionVoitures.listerTous();
                if (voitures.isEmpty()) { System.out.println("✘ Ajoutez d'abord une voiture."); return; }
                voitures.stream().filter(Voiture::isDisponible).forEach(System.out::println);
                int vid = lireInt("ID Voiture : ");
                Voiture v = gestionVoitures.trouverParId(vid);
                if (v == null) { System.out.println("✘ Voiture introuvable."); return; }
                System.out.print("Description de l'annonce : "); String desc = sc.nextLine();
                gestionAnnonces.ajouter(new Annonce(desc, v));
            }
            case 2 -> {
                List<Annonce> liste = gestionAnnonces.listerTous();
                if (liste.isEmpty()) System.out.println("Aucune annonce.");
                else liste.forEach(System.out::println);
            }
            case 3 -> {
                List<Annonce> actives = gestionAnnonces.getAnnoncesActives();
                if (actives.isEmpty()) System.out.println("Aucune annonce active.");
                else actives.forEach(System.out::println);
            }
            case 4 -> {
                int id = lireInt("ID Annonce : ");
                System.out.print("Nouvelle description : "); String desc = sc.nextLine();
                gestionAnnonces.modifierDescription(id, desc);
            }
            case 5 -> { int id = lireInt("ID Annonce : "); gestionAnnonces.desactiver(id); }
        }
    }

    // ── DEMANDES ──
    private void menuDemandes() {
        System.out.println("\n--- Gestion des Demandes ---");
        System.out.println("1. Nouvelle demande  2. Lister  3. Changer état");
        int c = lireInt("Choix : ");
        switch (c) {
            case 1 -> {
                List<Acheteur> acheteurs = gestionPersonnes.getAcheteurs();
                if (acheteurs.isEmpty()) { System.out.println("✘ Ajoutez d'abord un acheteur."); return; }
                acheteurs.forEach(System.out::println);
                int aid = lireInt("ID Acheteur : ");
                Acheteur a = (Acheteur) gestionPersonnes.trouverParId(aid);
                if (a == null) { System.out.println("✘ Acheteur introuvable."); return; }
                System.out.print("Critères (ex: Marque=Toyota, Prix max=150000): "); String crit = sc.nextLine();
                gestionDemandes.ajouter(new Demande(a, crit));
            }
            case 2 -> {
                List<Demande> liste = gestionDemandes.listerTous();
                if (liste.isEmpty()) System.out.println("Aucune demande.");
                else liste.forEach(System.out::println);
            }
            case 3 -> {
                int id = lireInt("ID Demande : ");
                System.out.println("États: 1.EN_ATTENTE 2.EN_COURS 3.SATISFAITE 4.ANNULEE");
                int e = lireInt("Choix état : ");
                EtatDemande[] etats = EtatDemande.values();
                if (e >= 1 && e <= etats.length)
                    gestionDemandes.changerEtat(id, etats[e - 1]);
            }
        }
    }

    // ── TRANSACTIONS ──
    private void menuTransactions() {
        System.out.println("\n--- Transactions & Médiation ---");
        System.out.println("1. Créer transaction  2. Planifier RDV  3. Finaliser  4. Annuler  5. Lister  6. Frais");
        int c = lireInt("Choix : ");
        switch (c) {
            case 1 -> {
                List<Annonce> actives = gestionAnnonces.getAnnoncesActives();
                if (actives.isEmpty()) { System.out.println("✘ Aucune annonce active."); return; }
                actives.forEach(System.out::println);
                int anId = lireInt("ID Annonce : ");
                Annonce annonce = gestionAnnonces.trouverParId(anId);
                if (annonce == null) { System.out.println("✘ Annonce introuvable."); return; }

                List<Acheteur> acheteurs = gestionPersonnes.getAcheteurs();
                acheteurs.forEach(System.out::println);
                int acId = lireInt("ID Acheteur : ");
                Acheteur acheteur = (Acheteur) gestionPersonnes.trouverParId(acId);

                List<Agent> agents = gestionPersonnes.getAgents();
                agents.forEach(System.out::println);
                int agId = lireInt("ID Agent : ");
                Agent agent = (Agent) gestionPersonnes.trouverParId(agId);

                if (acheteur == null || agent == null) { System.out.println("✘ Personne introuvable."); return; }
                gestionTransactions.ajouter(new Transaction(annonce, acheteur, agent));
            }
            case 2 -> {
                int id = lireInt("ID Transaction : ");
                int y = lireInt("Année RDV: "), m = lireInt("Mois: "), j = lireInt("Jour: ");
                gestionTransactions.planifierRendezVous(id, LocalDate.of(y, m, j));
            }
            case 3 -> { int id = lireInt("ID Transaction : "); gestionTransactions.finaliser(id); }
            case 4 -> { int id = lireInt("ID Transaction : "); gestionTransactions.annuler(id); }
            case 5 -> {
                List<Transaction> liste = gestionTransactions.listerTous();
                if (liste.isEmpty()) System.out.println("Aucune transaction.");
                else liste.forEach(System.out::println);
            }
            case 6 -> gestionTransactions.afficherFrais();
        }
    }

    // ── RECHERCHE ──
    private void menuRecherche() {
        System.out.println("\n--- Recherche ---");
        System.out.println("1. Par marque  2. Par prix maximum  3. Par carburant  4. Recherche multicritères");
        int c = lireInt("Choix : ");
        switch (c) {
            case 1 -> {
                System.out.print("Marque : "); String marque = sc.nextLine();
                List<Voiture> res = gestionVoitures.rechercherParMarque(marque);
                if (res.isEmpty()) System.out.println("Aucun résultat pour \"" + marque + "\".");
                else res.forEach(System.out::println);
            }
            case 2 -> {
                double max = lireDouble("Prix maximum (MAD) : ");
                List<Voiture> res = gestionVoitures.rechercherParPrixMax(max);
                if (res.isEmpty()) System.out.println("Aucun résultat.");
                else res.forEach(System.out::println);
            }
            case 3 -> {
                Carburant[] carbs = Carburant.values();
                for (int i = 0; i < carbs.length; i++) {
                    System.out.println((i + 1) + ". " + carbs[i]);
                }
                int choix = lireInt("Choix carburant : ");
                if (choix >= 1 && choix <= carbs.length) {
                    List<Voiture> res = gestionVoitures.rechercherParCarburant(carbs[choix - 1]);
                    if (res.isEmpty()) System.out.println("Aucun résultat pour " + carbs[choix - 1] + ".");
                    else res.forEach(System.out::println);
                } else {
                    System.out.println("✘ Choix invalide.");
                }
            }
            case 4 -> {
                System.out.print("Marque (laisser vide pour tous) : "); String marque = sc.nextLine();
                double max = lireDouble("Prix maximum (0 pour sans limite) : ");
                Carburant[] carbs = Carburant.values();
                for (int i = 0; i < carbs.length; i++) {
                    System.out.println((i + 1) + ". " + carbs[i]);
                }
                int choix = lireInt("Choix carburant (0 pour tous) : ");
                Carburant carburant = (choix >= 1 && choix <= carbs.length) ? carbs[choix - 1] : null;
                List<Voiture> res = gestionVoitures.rechercher(marque.isBlank() ? null : marque, max, carburant);
                if (res.isEmpty()) System.out.println("Aucun résultat.");
                else res.forEach(System.out::println);
            }
            default -> System.out.println("✘ Choix invalide.");
        }
    }

    //  DONNÉES DE DÉMONSTRATION

    private void chargerDonneesDemo() {
        System.out.println(">>> Chargement des données de démonstration...");

        Vendeur v1 = new Vendeur("Alami", "Hassan", "0661001001", "hassan@mail.com");
        Vendeur v2 = new Vendeur("Benali", "Fatima", "0662002002", "fatima@mail.com");
        Acheteur a1 = new Acheteur("Chraibi", "Youssef", "0663003003", "youssef@mail.com");
        Acheteur a2 = new Acheteur("Douiri", "Zineb", "0664004004", "zineb@mail.com");
        Agent ag1 = new Agent("Elidrissi", "Khalid", "0665005005", "khalid@agence.com", "AGT-001");

        gestionPersonnes.ajouter(v1);
        gestionPersonnes.ajouter(v2);
        gestionPersonnes.ajouter(a1);
        gestionPersonnes.ajouter(a2);
        gestionPersonnes.ajouter(ag1);

        Voiture voit1 = new Voiture("Toyota", "Yaris", 2020, 120000, 45000, Carburant.ESSENCE, v1);
        Voiture voit2 = new Voiture("Dacia", "Sandero", 2019, 95000, 70000, Carburant.DIESEL, v2);
        Voiture voit3 = new Voiture("Renault", "Clio", 2021, 135000, 30000, Carburant.HYBRIDE, v1);

        gestionVoitures.ajouter(voit1);
        gestionVoitures.ajouter(voit2);
        gestionVoitures.ajouter(voit3);

        Annonce ann1 = new Annonce("Toyota Yaris en excellent état, entretien régulier.", voit1);
        Annonce ann2 = new Annonce("Dacia Sandero diesel économique, idéale city.", voit2);

        gestionAnnonces.ajouter(ann1);
        gestionAnnonces.ajouter(ann2);

        gestionDemandes.ajouter(new Demande(a1, "Marque=Toyota, Prix max=130000"));
        gestionDemandes.ajouter(new Demande(a2, "Carburant=DIESEL, Prix max=100000"));

        System.out.println(">>> Données chargées avec succès !\n");
    }


    //  UTILITAIRES

    private int lireInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                return val;
            } catch (NumberFormatException e) {
                System.out.println("✘ Entrez un nombre entier valide.");
            }
        }
    }

    private double lireDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("✘ Entrez un nombre valide.");
            }
        }
    }
}
