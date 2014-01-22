package management;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DateInspector {

    /**
     * Check if the dates given are okay.
     * 
     * @author Fabien Pinel & Dorian LIZARRALDE
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean checkTheDates(GregorianCalendar startDate,
            GregorianCalendar endDate) {

        GregorianCalendar today = new GregorianCalendar();
        today.set(GregorianCalendar.HOUR_OF_DAY, 0);
        today.set(GregorianCalendar.MINUTE, 0);
        today.set(GregorianCalendar.SECOND, 0);
        today.set(GregorianCalendar.MILLISECOND, 0);

        if (startDate.compareTo(today) < 0 || endDate.compareTo(today) < 0
                || startDate.compareTo(endDate) > 0) {

            System.out.println("One or both of your parameters is/are invalid");

            return false;
        }

        return true;
    }

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
}
