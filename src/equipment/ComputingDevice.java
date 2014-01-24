package equipment;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class ComputingDevice extends Equipment {

    private OS os;

    public OS getOS() {

        return os;
    }

    public void setOS(OS os) {

        this.os = os;
    }

    public ComputingDevice(String name, String description, OS os) {

        super(name, description);
        this.setOS(os);
    }

    @Override
    public String toString() {

        return super.toString() + "\tOS : " + this.getOS().toString();
    }
}
