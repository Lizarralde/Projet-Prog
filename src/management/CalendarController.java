package management;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Deliver services related to calendar.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class CalendarController {

    /**
     * Return the string using the calendar parameter.
     * 
     * @param calendar
     * @return
     */
    public static String calendarToString(GregorianCalendar calendar) {

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        return formater.format(calendar.getTime());
    }
}
