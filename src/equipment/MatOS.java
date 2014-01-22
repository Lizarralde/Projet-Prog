package equipment;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class MatOS extends Equipment {

    private OS typeOS;

    public OS getTypeOS() {

        return typeOS;
    }

    public void setTypeOS(OS typeOS) {

        this.typeOS = typeOS;
    }

    public MatOS(String name, String description, OS typeOS) {

        super(name, description);
        this.setDamage(5);
        this.setTypeOS(typeOS);
    }
}
