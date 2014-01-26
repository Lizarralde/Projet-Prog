package equipment.solid;

import equipment.ComputingDevice;
import equipment.OS;

/**
 * Model of a tablet.
 * 
 * @author Falou SECK
 * 
 */
public class Tablet extends ComputingDevice {

    /**
     * Default constructor.
     * 
     * @author Falou SECK
     * @param name
     * @param description
     * @param os
     */
    public Tablet(String name, String description, OS os) {

        super(name, description, os);
        this.setValue(7);
    }
}
