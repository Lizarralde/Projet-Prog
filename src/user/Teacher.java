package user;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Teacher extends User {

    private String field;

    public String getField() {

        return field;
    }

    public void setField(String field) {

        this.field = field;
    }

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
