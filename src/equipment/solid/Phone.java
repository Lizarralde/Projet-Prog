package equipment.solid;

import equipment.MatOS;
import equipment.OS;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Phone extends MatOS {

    public Phone(String name, String description, OS typeOS) {

        super(name, description, typeOS);
        this.setDamage(4);
    }
}
