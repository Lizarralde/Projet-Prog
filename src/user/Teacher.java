package user;

/**
 * Model of a teacher.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Teacher extends User {

    // Field of activity.
    private String field;

    // Getters and setters.
    public String getField() {

        return field;
    }

    public void setField(String field) {

        this.field = field;
    }

    /**
     * Default constructor.
     * 
     * @param firstName
     * @param lastName
     * @param field
     */
    public Teacher(String firstName, String lastName, String field) {

        super(firstName, lastName);
        this.setField(field);
    }

    @Override
    public boolean isAllowedToBorrow() {

        return true;
    }

    @Override
    public String toString() {

        return super.toString() + "\tField : " + this.getField();
    }
}
