package equipment.solid;

import equipment.ComputingDevice;
import equipment.OS;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Tablet extends ComputingDevice {

    public Tablet(String name, String description, OS typeOS) {

        super(name, description, typeOS);
        this.setDamage(7);
    }
}
