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

    private GregorianCalendar end, start;

    private List<Equipment> equipment;

    private User user;

    public GregorianCalendar getEnd() {

        return end;
    }

    public void setEnd(GregorianCalendar end) {

        this.end = end;
    }

    public GregorianCalendar getStart() {

        return start;
    }

    public void setStart(GregorianCalendar start) {

        this.start = start;
    }

    public List<Equipment> getEquipment() {

        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {

        this.equipment = equipment;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public Loan(GregorianCalendar end, GregorianCalendar start,
            List<Equipment> equipment, User user) {

        this.setEnd(end);
        this.setStart(start);
        this.setEquipment(equipment);
        this.setUser(user);
    }

    @Override
    public String toString() {

        return "User : " + user.toString() + "\tEquipment : "
                + equipment.get(0).toString() + "\tQuantity : "
                + equipment.size() + "\tStart : "
                + CalendarController.calendarToString(start) + "\tEnd : "
                + CalendarController.calendarToString(end);
    }
}
