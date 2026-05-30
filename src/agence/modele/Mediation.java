package agence.modele;

public class Mediation {

    public static final double TAUX = 0.03;

    public static double calculerFrais(double montant) {
        return montant * TAUX;
    }
}
