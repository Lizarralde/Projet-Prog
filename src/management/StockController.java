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

    public Loan doReserve(User user, List<Equipment> mat,
            GregorianCalendar startDate, GregorianCalendar endDate) {

        return null;
    }

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
