package user;

/**
 * Model of a user.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class User {

    // First name.
    private String firstName;

    // Last name.
    private String lastName;

    // Getters and setters.
    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    /**
     * Default constructor.
     * 
     * @param firstName
     * @param lastName
     */
    public User(String firstName, String lastName) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    /**
     * Return if a user is allowed to borrow using the loan parameter.
     * 
     * @return
     */
    public boolean isAllowedToBorrow() {

        return false;
    }

    @Override
    public String toString() {

        return this.getFirstName() + " " + this.getLastName();
    }
}
