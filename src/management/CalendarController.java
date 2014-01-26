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
     * Return a String which represents the calendar on the format dd/MM/yyyy.
     * 
     * @author Dorian LIZARRALDE
     * @param calendar
     *            A gregorian calendar.
     * @return
     */
    public static String calendarToString(GregorianCalendar calendar) {

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        return formater.format(calendar.getTime());
    }

    /**
     * Check the validity using the calendars parameters.
     * 
     * @author Dorian LIZARRALDE
     * @param start
     * @param end
     * @return
     */
    public static boolean checkCalendars(GregorianCalendar start,
            GregorianCalendar end) {

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
        calendar.set(GregorianCalendar.MINUTE, 0);
        calendar.set(GregorianCalendar.SECOND, 0);
        calendar.set(GregorianCalendar.MILLISECOND, 0);

        if (0 >= calendar.compareTo(start) && 0 >= start.compareTo(end)) {

            return true;
        }

        return false;
    }

    /**
     * Return the difference between two date.
     * 
     * @author Jean-Philippe KHA
     * @param start
     * @param end
     * @return
     */
    public static int differenceDate(GregorianCalendar start,
            GregorianCalendar end) {

        long result = end.getTimeInMillis() - start.getTimeInMillis();

        return (int) (result / (24 * 60 * 60 * 1000));
    }
}
