package gestion_stock;

/**
 * La classe Caméra est la classe pour les cam�ras.
 * 
 * @author Falou Seck
 * @version 1.0 (D�cembre 2013)
 */
public class Camera extends Article {

    public Camera(String marque, String modele, String caracteristiques) {
        super(marque, modele, caracteristiques);

    }

    public String toString() {
        return super.toString() + "Camera";
    }
}
