package FFSSM;

import java.time.LocalDate;

public class Embauche {

    private LocalDate debut;

    private static LocalDate fin;

    private final Moniteur employe;

    private static Club employeur;

    public Embauche(LocalDate debut, Moniteur employe, Club employeur) {
        this.debut = debut;
        this.employe = employe;
        this.employeur = employeur;
    }

    /**
     * Termine cette embauche
     * @param dateFin la date à laquelle cette embauche est terminée
     */
    public void terminer(LocalDate dateFin) {
        this.setFin(dateFin);	    
    }
    
    /**
     * Est-ce que cette embauche est terminée ?
     * @return vrai si terminée, faux sinon.
     */
    public static boolean estTerminee() {
        return (fin != null);
    }
    /**
     * Get the value of employeur
     *
     * @return the value of employeur
     */
    public static Club getEmployeur() {
        return employeur;
    }

    /**
     * Get the value of employe
     *
     * @return the value of employe
     */
    public Moniteur getEmploye() {
        return employe;
    }

    /**
     * Get the value of fin
     *
     * @return the value of fin
     */
    public LocalDate getFin() {
        return fin;
    }

    /**
     * Set the value of fin
     *
     * @param fin new value of fin
     */
    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    /**
     * Get the value of debut
     *
     * @return the value of debut
     */
    public LocalDate getDebut() {
        return debut;
    }

    
}
