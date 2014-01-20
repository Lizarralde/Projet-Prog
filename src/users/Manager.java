package users;

import java.util.Calendar;
import java.util.GregorianCalendar;

import management.Reservation;
import management.Stock;
import objects.MaterialQuantity;

/**
 * @author Fabien Pinel
 * 
 */
public class Manager {

    private Stock stock;

    public Manager(Stock stock) {

        this.stock = stock;
    }

    /**
     * Create the reservation asked
     * 
     * @author Fabien Pinel
     * @param user
     * @param mat
     * @param startDate
     * @param endDate
     * @return
     */
    public Reservation doReserve(User user, MaterialQuantity mat,
            GregorianCalendar startDate, GregorianCalendar endDate) {

        return user.doReserve(mat, startDate, endDate);
    }

    /**
     * This method looks if the materiel specified is available for a given
     * period.
     * 
     * @author Fabien Pinel
     * @param mat
     *            the material that want to be reserved
     * @param startDate
     *            the beginning of the emprunt
     * @param endDate
     *            the end of the emprunt
     * @return true if the material is available during this period false in
     *         other cases
     */
    public boolean isAvailable(MaterialQuantity mat, int quantity,
            GregorianCalendar startDate, GregorianCalendar endDate) {
        GregorianCalendar day = new GregorianCalendar();
        day.setTimeInMillis(startDate.getTimeInMillis());
        while (day.compareTo(endDate) <= 0) {
            if (!isAvailableForThisDay(mat, quantity, day)) {
                return false;
            }
            day.add(Calendar.DAY_OF_YEAR, 1);
        }
        return true;
    }

    /**
     * This method looks if a certain quantity of material is available for a
     * given date. It's private because only use by isAvailable
     * 
     * @author Fabien Pinel
     * @param materialList
     *            A list of material
     * @param startDate
     *            the beginning of the emprunt period
     * @param endDate
     *            the end of the emprunt period
     * @return
     */
    private boolean isAvailableForThisDay(MaterialQuantity mat, int quantity,
            GregorianCalendar day) {

        int quantityAvailable = mat.getQuantity();
        for (Reservation reserv : stock.getReservList()) {
            if (reserv.getMaterialQuantity().getMat().equals(mat.getMat())) {
                if (day.compareTo(reserv.getStartDate()) >= 0
                        && day.compareTo(reserv.getEndDate()) <= 0) {
                    // day is in the emprunt time
                    quantityAvailable -= reserv.getMaterialQuantity()
                            .getQuantity();
                }
            }
        }
        return (quantityAvailable >= quantity);
    }
}
