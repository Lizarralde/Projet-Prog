package user;

/**
 * Model of a student.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Student extends User {

    // Year of activity.
    private String year;

    // Getters and setters.
    public String getYear() {

        return year;
    }

    public void setYear(String year) {

        this.year = year;
    }

    /**
     * Default constructor.
     * 
     * @param firstName
     * @param lastName
     * @param year
     */
    public Student(String firstName, String lastName, String year) {

        super(firstName, lastName);
        this.setYear(year);
    }

    @Override
    public boolean isAllowedToBorrow() {

        return true;
    }

    @Override
    public String toString() {

        return super.toString() + "\tYear : " + this.getYear();
    }
}
