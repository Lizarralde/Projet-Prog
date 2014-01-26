package equipment.solid;

import equipment.Equipment;

/**
 * Model of headphones.
 * 
 * @author Falou SECK
 * 
 */
public class Headphones extends Equipment {

    /**
     * Default constructor.
     * 
     * @author Falou SECK
     * @param name
     * @param description
     */
    public Headphones(String name, String description) {

        super(name, description);
        this.setValue(15);
    }
}
