package material.solid;

import material.MatOS;
import material.TypeOS;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Tablet extends MatOS {

    public Tablet(String name, String description, TypeOS typeOS) {

        super(name, description, typeOS);
        super.damage = 7;
        super.setObjectValue(1);
    }
}
