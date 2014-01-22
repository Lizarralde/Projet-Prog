package equipment.solid;

import equipment.ComputingDevice;
import equipment.OS;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Phone extends ComputingDevice {

    public Phone(String name, String description, OS typeOS) {

        super(name, description, typeOS);
        this.setDamage(4);
    }
}
