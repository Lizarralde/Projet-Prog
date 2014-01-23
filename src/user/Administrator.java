package user;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Administrator extends User {

    public Administrator(String firstName, String lastName) {

        super(firstName, lastName);
    }

    @Override
    public boolean isAllowedToBorrow() {

        return true;
    }
}
