package user;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class User {

    private String firstName;

    private String lastName;

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

    public User(String firstName, String lastName) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public boolean isAllowedToBorrow() {

        return false;
    }

    @Override
    public String toString() {

        return this.getFirstName() + " " + this.getLastName();
    }
}
