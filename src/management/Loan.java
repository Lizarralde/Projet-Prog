package management;

import java.util.GregorianCalendar;
import user.User;

/**
 * Model of a loan.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Loan {

    // Calendars.
    private GregorianCalendar end, start;

    // Name of the equipment.
    private String name;

    // User.
    private User user;

    // Quantity.
    private int quantity;

    // Getters and setters.
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

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    /**
     * Default constructor.
     * 
     * @param user
     * @param name
     * @param quantity
     * @param start
     * @param end
     */
    public Loan(User user, String name, int quantity, GregorianCalendar start,
            GregorianCalendar end) {

        this.setEnd(end);
        this.setStart(start);
        this.setName(name);
        this.setUser(user);
        this.setQuantity(quantity);
    }

    @Override
    public String toString() {

        return "User : " + this.getUser().toString() + "\tEquipment : "
                + this.getName() + "\tQuantity : " + this.getQuantity()
                + "\tStart : "
                + CalendarController.calendarToString(this.getStart())
                + "\tEnd : "
                + CalendarController.calendarToString(this.getEnd());
    }
}
