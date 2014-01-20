package material.solid;

import material.Material;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Casque extends Material {

    public Casque(String nom, String descriptif) {

        super(nom, descriptif);
        super.damage = 1;
    }
}
