package equipment.solid;

import equipment.ComputingDevice;
import equipment.OS;

/**
 * Model of a phone.
 * 
 * @author Falou SECK
 * 
 */
public class Phone extends ComputingDevice {

    /**
     * Default constructor.
     * 
     * @param name
     * @param description
     * @param os
     */
    public Phone(String name, String description, OS os) {

        super(name, description, os);
    }
}
