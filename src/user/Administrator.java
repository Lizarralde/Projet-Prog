package user;

/**
 * Model of an administrator.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Administrator extends User {

    /**
     * Default constructor.
     * 
     * @param firstName
     * @param lastName
     */
    public Administrator(String firstName, String lastName) {

        super(firstName, lastName);
    }

    @Override
    public boolean isAllowedToBorrow() {

        return true;
    }
}
