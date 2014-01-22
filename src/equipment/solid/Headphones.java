package equipment.solid;

import equipment.Equipment;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Headphones extends Equipment {

    public Headphones(String nom, String descriptif) {

        super(nom, descriptif);
        this.setDamage(1);
    }
}
