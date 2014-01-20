package management;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import objects.MaterialQuantity;
import users.User;

/**
 * 
 * @author fabien pinel
 * 
 */
public class Reservation {

    private User user;

    private MaterialQuantity materialQuant;

    private GregorianCalendar startDate, endDate;

    public Reservation(User user, MaterialQuantity materialQuant,
            GregorianCalendar start, GregorianCalendar end) {

        this.setUser(user);
        this.setMaterialQuantity(materialQuant);
        this.setStartDate(start);
        this.setEndDate(end);
    }

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

    /**
     * Return a String which represents the calendar on the format dd/MM/yyyy.
     * 
     * @author Dorian LIZARRALDE
     * @param calendar
     *            A gregorian calendar.
     * @return
     */
    private String calendarToString(GregorianCalendar calendar) {

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        return formater.format(calendar.getTime());
    }

    /**
     * @author Fabien Pinel
     */
    @Override
    public String toString() {

        return "User: " + user.toString() + "\tObject: "
                + materialQuant.getMat().getName() + "\tQuantity: "
                + materialQuant.getQuantity() + "\tDate d'emprunt: "
                + calendarToString(startDate) + "\tDate de retour: "
                + calendarToString(endDate) + ".";
    }

}
