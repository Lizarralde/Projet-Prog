package management;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import equipment.EquipmentSet;
import equipment.OS;
import equipment.solid.Phone;
import user.Student;
import user.User;

/**
 * Test the Reservation class.
 * 
 * @author Dorian
 * 
 */
public class TestReservation {

    /**
     * @author Dorian LIZARRALDE
     */
    @Test
    public void testToString() {

        User user = new Student("LIZARRALDE", "Dorian", "SI3 - 2013");
        EquipmentSet material = new EquipmentSet(new Phone("iPad",
                "Description of the iPad", OS.IOS), 3);
        GregorianCalendar start = new GregorianCalendar(2013, 11, 1);
        GregorianCalendar end = new GregorianCalendar(2013, 11, 5);

        Loan reservation = new Loan(user, material, start, end);

        // Not null.
        assertNotNull(reservation.toString());

        // Good String.
        assertEquals(
                "User: LIZARRALDE Dorian\tObject: iPad\tQuantity: 3\tDate d'emprunt: 01/12/2013\tDate de retour: 05/12/2013.",
                reservation.toString());
    }
}
