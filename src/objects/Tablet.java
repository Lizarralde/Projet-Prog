package objects;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Tablet extends MatOS {

    public Tablet(String name, String description, TypeOS typeOS) {

        super(name, description, typeOS);
        super.damage=7;
    }
}
