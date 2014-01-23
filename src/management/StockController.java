package management;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import equipment.Equipment;
import user.User;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class StockController {

    private Stock stock;

    public Stock getStock() {

        return stock;
    }

    public void setStock(Stock stock) {

        this.stock = stock;
    }

    public StockController(Stock stock) {

        this.setStock(stock);
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
    public Loan doReserve(User user, List<Equipment> mat,
            GregorianCalendar startDate, GregorianCalendar endDate) {

        return user.isAllowedToLoan(mat, startDate, endDate);
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
    public boolean isAvailable(List<Equipment> mat,
            GregorianCalendar startDate, GregorianCalendar endDate) {
        GregorianCalendar day = new GregorianCalendar();
        day.setTimeInMillis(startDate.getTimeInMillis());
        while (day.compareTo(endDate) <= 0) {
            if (!isAvailableForThisDay(mat, day)) {
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
    private boolean isAvailableForThisDay(List<Equipment> mat,
            GregorianCalendar day) {

        int quantityAvailable = mat.size();
        for (Loan reserv : stock.getLoans()) {
            if (reserv.getEquipment().get(1).equals(mat.get(1))) {
                if (day.compareTo(reserv.getStart()) >= 0
                        && day.compareTo(reserv.getEnd()) <= 0) {
                    // day is in the emprunt time
                    quantityAvailable -= reserv.getEquipment().size();
                }
            }
        }
        return (quantityAvailable >= mat.size());
    }
}
