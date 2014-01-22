package management;

import java.util.GregorianCalendar;

import material.MaterialQuantity;
import ui.CalendarInspector;
import user.Student;
import user.User;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Reservation {

    private User user;

    private MaterialQuantity materialQuant;

    private GregorianCalendar startDate, endDate;

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public MaterialQuantity getMaterialQuantity() {

        return materialQuant;
    }

    public void setMaterialQuantity(MaterialQuantity materialQuant) {

        this.materialQuant = materialQuant;
    }

    public GregorianCalendar getStartDate() {

        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {

        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {

        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {

        this.endDate = endDate;
    }

    public Reservation(User user, MaterialQuantity materialQuant,
            GregorianCalendar start, GregorianCalendar end) {
        this.setUser(user);
        this.setMaterialQuantity(materialQuant);
        this.setStartDate(start);
        this.setEndDate(end);
    }

    @Override
    public String toString() {

        return "User: " + user.toString() + "\tObject: "
                + materialQuant.getMat().getName() + "\tQuantity: "
                + materialQuant.getQuantity() + "\tDate d'emprunt: "
                + CalendarInspector.calendarToString(startDate)
                + "\tDate de retour: "
                + CalendarInspector.calendarToString(endDate) + ".";
    }

}
