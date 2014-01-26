package user;

import java.util.GregorianCalendar;

import management.CalendarController;
import management.Loan;
import management.StockController;

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
     * @author Dorian LIZARRALDE
     * @param firstName
     * @param lastName
     * @param field
     */
    public Teacher(String firstName, String lastName, String field) {

        super(firstName, lastName);
        this.setField(field);
    }

    @Override
    public boolean isAllowedToBorrow(Loan loan, StockController stockController) {

        if (stockController.numberOfLoans(this) < 4) {

            if (loan.getQuantity() < 25) {

                if (CalendarController.differenceDate(loan.getStart(),
                        loan.getEnd()) < 8) {

                    if (CalendarController.differenceDate(
                            new GregorianCalendar(), loan.getStart()) < 15) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {

        return super.toString() + "\tField : " + this.getField();
    }
}
