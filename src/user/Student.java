package user;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Student extends User {

    private String year;

    public String getYear() {

        return year;
    }

    public void setYear(String year) {

        this.year = year;
    }

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
