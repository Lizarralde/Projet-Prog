package gestion_stock;

/**
 * La classe Gestionnaire définit les gestionnaires du stock.
 * 
 * @author Falou Seck
 * @version 1.0 (Décembre 2013)
 */

public class Gestionnaire extends Utilisateur {

    private static int nombreGestionnaires;

    public Gestionnaire(String nom, String prenom) {
        super(nom, prenom);
        nombreGestionnaires++;

    }

    public String toString() {
        return super.toString() + " Gestionnaire";
    }
}
