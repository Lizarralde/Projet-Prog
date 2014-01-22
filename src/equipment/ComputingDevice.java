package equipment;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class ComputingDevice extends Equipment {

    private OS typeOS;

    public OS getTypeOS() {

        return typeOS;
    }

    public void setTypeOS(OS typeOS) {

        this.typeOS = typeOS;
    }

    public ComputingDevice(String name, String description, OS typeOS) {

        super(name, description);
        this.setTypeOS(typeOS);
        this.setDamage(5);
    }
}
