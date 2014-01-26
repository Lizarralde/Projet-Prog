package management;

import java.util.Calendar;
import java.util.GregorianCalendar;

import user.User;

/**
 * Deliver services related to the stock.
 * 
 * @author Jean-Philippe KHA
 * 
 */
public class StockController {

    // Stock.
    private Stock stock;

    private static final int MATERIAL_QUANTITY = 5;

    // Getters and setters.
    public Stock getStock() {

        return stock;
    }

    public void setStock(Stock stock) {

        this.stock = stock;
    }

    /**
     * Default constructor.
     * 
     * Jean-Philippe KHA
     * 
     * @param stock
     */
    public StockController(Stock stock) {

        this.setStock(stock);
    }

    /**
     * This method looks if the materiel specified is available for a given
     * period.
     * 
     * @author Jean-Philippe KHA
     * @param loan
     * @return
     */
    public boolean isAvailable(Loan loan) {

        GregorianCalendar calendar = (GregorianCalendar) loan.getStart()
                .clone();

        while (0 >= calendar.compareTo(loan.getEnd())) {

            if (!isAvailableForThisDay(loan, calendar)) {

                return false;
            }

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        return true;
    }

    /**
     * This method looks if a certain quantity of material is available for a
     * given date. It's private because only use by isAvailable.
     * 
     * @author Jean-Philippe KHA
     * @param loan
     * @param calendar
     * @return
     */
    public boolean isAvailableForThisDay(Loan loan, GregorianCalendar calendar) {

        int quantity = this.getStock().getQuantity(loan.getName());

        for (Loan l : this.getStock().getLoans()) {

            if (l.getName().equals(loan.getName())) {

                if (0 >= l.getStart().compareTo(calendar)
                        && l.getEnd().compareTo(calendar) >= 0) {

                    quantity -= l.getQuantity();
                }
            }
        }

        return quantity >= loan.getQuantity();
    }

    /**
     * This method looks when a certain quantity of material is not available.
     * 
     * @author Jean-Philippe KHA
     * @param loan
     * @return
     */
    public GregorianCalendar dayWhenMaterialIsNotAvailable(Loan loan) {

        GregorianCalendar calendar = (GregorianCalendar) loan.getStart()
                .clone();

        while (0 >= calendar.compareTo(loan.getEnd())) {

            if (!isAvailableForThisDay(loan, calendar)) {

                return calendar;
            }

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        return loan.getEnd();
    }

    /**
     * This method looks when a certain quantity of material is available.
     * 
     * @author Jean-Philippe KHA
     * @param loan
     * @return
     */
    public GregorianCalendar dayWhenMaterialIsAvailable(Loan loan) {

        GregorianCalendar calendar = (GregorianCalendar) loan.getStart()
                .clone();

        while (0 >= calendar.compareTo(loan.getEnd())) {

            if (isAvailableForThisDay(loan, calendar)) {

                return calendar;
            }

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        return loan.getEnd();
    }

    /**
     * This method looks if the number of materiel specified is available for a
     * given period.
     * 
     * @author Jean-Philippe KHA
     * @param loan
     * @return
     */
    public int numberOfMaterialAvailable(Loan loan) {

        GregorianCalendar calendar = (GregorianCalendar) loan.getStart()
                .clone();

        int quantity = loan.getQuantity();

        while (0 >= calendar.compareTo(loan.getEnd())) {

            if (theNumberOfMaterialIsAvailableForThisDay(loan, calendar) < quantity) {

                quantity = theNumberOfMaterialIsAvailableForThisDay(loan,
                        calendar);
            }

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        return quantity;
    }

    /**
     * This method looks if a certain quantity of material is available for a
     * given date. It's private because only use by numberOfMaterialAvailable.
     * 
     * @author Jean-Philippe KHA
     * @param loan
     * @param calendar
     * @return
     */
    private int theNumberOfMaterialIsAvailableForThisDay(Loan loan,
            GregorianCalendar calendar) {

        int quantity = this.getStock().getQuantity(loan.getName());

        for (Loan l : this.getStock().getLoans()) {

            if (l.getName().equals(loan.getName())) {

                if (0 >= l.getStart().compareTo(calendar)
                        && l.getEnd().compareTo(calendar) >= 0) {

                    quantity -= l.getQuantity();
                }
            }
        }

        return quantity;
    }

    /**
     * This method return the number of day which a person could loan.
     * 
     * @author Jean-Philippe KHA
     * @param loan
     * @return
     */
    public int numberOfDayMaterialCanBeLoaned(Loan loan) {

        int quantity = this.getStock().getQuantity(loan.getName());

        int value = this.getStock().getValue(loan.getName());

        if (quantity - loan.getQuantity() >= MATERIAL_QUANTITY) {

            return value;
        }

        if (1 >= value / loan.getQuantity()) {

            return 1;
        }

        return value / loan.getQuantity();
    }

    /**
     * This method looks if the student respect rules
     * 
     * @author Jean-Philippe KHA
     * @param user
     * @return
     */
    public int numberOfLoans(User user) {

        int counter = 0;

        for (Loan loan : this.getStock().getLoans()) {

            if (loan.getUser().getFirstName()
                    .equalsIgnoreCase(user.getFirstName())
                    && loan.getUser().getLastName()
                            .equalsIgnoreCase(user.getLastName())) {

                counter++;
            }
        }

        return counter;
    }
}
