package user;

import java.util.GregorianCalendar;

import management.CalendarController;
import management.Loan;
import management.StockController;

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
     * @author Dorian LIZARRALDE
     * @param firstName
     * @param lastName
     * @param year
     */
    public Student(String firstName, String lastName, String year) {

        super(firstName, lastName);
        this.setYear(year);
    }

    @Override
    public boolean isAllowedToBorrow(Loan loan, StockController stockController) {

        if (stockController.numberOfLoans(this) < 1) {

            if (loan.getQuantity() < 2) {

                if (CalendarController.differenceDate(loan.getStart(),
                        loan.getEnd()) < 8) {

                    if (CalendarController.differenceDate(
                            new GregorianCalendar(), loan.getStart()) < 8) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {

        return super.toString() + "\tYear : " + this.getYear();
    }
}
