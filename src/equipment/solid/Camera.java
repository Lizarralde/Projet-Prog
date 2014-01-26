package equipment.solid;

import equipment.Equipment;

/**
 * Model of a camera.
 * 
 * @author Falou SECK
 * 
 */
public class Camera extends Equipment {

    /**
     * Default constructor.
     * 
     * @author Falou SECK
     * @param name
     * @param description
     */
    public Camera(String name, String description) {

        super(name, description);
        this.setValue(10);
    }
}
