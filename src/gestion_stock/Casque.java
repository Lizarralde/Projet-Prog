package gestion_stock;

/**
 * La classe Casque définit les articles de type Casque.
 * 
 * @author Falou Seck
 * @version 1.0 (Décembre 2013)
 */
public class Casque extends Article {

    public Casque(String marque, String modele, String caracteristiques) {
        super(marque, modele, caracteristiques);

    }

    public String toString() {
        return super.toString() + "Casque";
    }
}
