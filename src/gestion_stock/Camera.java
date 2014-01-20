package gestion_stock;

/**
 * La classe CamÃ©ra est la classe pour les caméras.
 * 
 * @author Falou Seck
 * @version 1.0 (Décembre 2013)
 */
public class Camera extends Article {

    public Camera(String marque, String modele, String caracteristiques) {
        super(marque, modele, caracteristiques);

    }

    public String toString() {
        return super.toString() + "Camera";
    }
}
