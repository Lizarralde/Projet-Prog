package equipment;

/**
 * Model of an equipment using an operating system.
 * 
 * @author Falou SECK
 * 
 */
public class ComputingDevice extends Equipment {

    // Operating system.
    private OS os;

    // Getters and setters.
    public OS getOS() {

        return os;
    }

    public void setOS(OS os) {

        this.os = os;
    }

    /**
     * Default constructor.
     * 
     * @param name
     * @param description
     * @param os
     */
    public ComputingDevice(String name, String description, OS os) {

        super(name, description);
        this.setOS(os);
    }

    @Override
    public String toString() {

        return super.toString() + "\tOS : " + this.getOS().toString();
    }
}
