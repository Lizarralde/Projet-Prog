package material.solid;

import material.MatOS;
import material.TypeOS;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Phone extends MatOS {

    public Phone(String name, String description, TypeOS typeOS) {

        super(name, description, typeOS);
        super.damage = 4;
        super.setObjectValue(7);
    }
}
