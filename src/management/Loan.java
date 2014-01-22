package management;

import java.util.GregorianCalendar;
import java.util.List;

import equipment.Equipment;
import user.User;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Loan {

    private GregorianCalendar endDate, startDate;

    private List<Equipment> materialQuant;

    private User user;

    public GregorianCalendar getEndDate() {

        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {

        this.endDate = endDate;
    }

    public GregorianCalendar getStartDate() {

        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {

        this.startDate = startDate;
    }

    public List<Equipment> getMaterialQuantity() {

        return materialQuant;
    }

    public void setMaterialQuantity(List<Equipment> materialQuant) {

        this.materialQuant = materialQuant;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public Loan(User user, List<Equipment> materialQuant,
            GregorianCalendar start, GregorianCalendar end) {

        this.setEndDate(end);
        this.setStartDate(start);
        this.setMaterialQuantity(materialQuant);
        this.setUser(user);
    }

    /*
     * @Override public String toString() {
     * 
     * return "User: " + user.toString() + "\tObject: " +
     * materialQuant.getMat().getName() + "\tQuantity: " +
     * materialQuant.getQuantity() + "\tDate d'emprunt: " +
     * CalendarController.calendarToString(startDate) + "\tDate de retour: " +
     * CalendarController.calendarToString(endDate) + "."; }
     */

}
