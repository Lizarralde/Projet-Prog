package management;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class CalendarController {

    public static boolean checkTheDates(GregorianCalendar start,
            GregorianCalendar end) {

        GregorianCalendar today = new GregorianCalendar();
        today.set(GregorianCalendar.HOUR_OF_DAY, 0);
        today.set(GregorianCalendar.MINUTE, 0);
        today.set(GregorianCalendar.SECOND, 0);
        today.set(GregorianCalendar.MILLISECOND, 0);

        if (start.compareTo(today) < 0 || end.compareTo(today) < 0
                || start.compareTo(end) > 0) {

            System.out.println("One or both of your parameters is/are invalid");

            return false;
        }

        return true;
    }

    public static String calendarToString(GregorianCalendar calendar) {

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        return formater.format(calendar.getTime());
    }
}
