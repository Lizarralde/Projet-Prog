package ui;

import java.util.GregorianCalendar;

public class CalendarInspector {

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
}
