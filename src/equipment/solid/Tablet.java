package equipment.solid;

import equipment.MatOS;
import equipment.OS;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Tablet extends MatOS {

    public Tablet(String name, String description, OS typeOS) {

        super(name, description, typeOS);
        this.setDamage(7);
    }
}
