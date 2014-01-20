package objects;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class MatOS extends Material {

    private TypeOS typeOS;

    public MatOS(String name, String description, TypeOS typeOS) {

        super(name, description);
        this.typeOS = typeOS;
        super.damage=5;
    }

    public TypeOS getTypeOS() {

        return typeOS;
    }

    public void setTypeOS(TypeOS typeOS) {

        this.typeOS = typeOS;
    }
}
