package gestion_stock;

/**
 * La classe Tablette définit les articles de type Tablette du Stock.
 * 
 * @author Falou Seck
 * @version 1.0 (Décembre 2013)
 */

public class Tablette extends Article {

    public Tablette(String marque, String modele, String caracteristiques) {
        super(marque, modele, caracteristiques);

    }

    public String toString() {
        return super.toString() + "Tablette";
    }

}
