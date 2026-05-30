package agence.modele;

import java.time.LocalDate;

public class RendezVous {

    private LocalDate date;
    private String lieu;

    public RendezVous(LocalDate date, String lieu) {
        this.date = date;
        this.lieu = lieu;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    @Override
    public String toString() {
        return date + " @ " + lieu;
    }
}
