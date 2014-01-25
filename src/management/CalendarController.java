package management;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class CalendarController {

    public static String calendarToString(GregorianCalendar calendar) {

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        return formater.format(calendar.getTime());
    }
}
