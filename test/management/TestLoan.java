package management;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import user.Student;
import user.User;

/**
 * Test the Loan class.
 * 
 * @author Dorian
 * 
 */
public class TestLoan {

    @Test
    public void testToString() {

        GregorianCalendar end = new GregorianCalendar(2014, 0, 26);
        GregorianCalendar start = new GregorianCalendar(2014, 1, 2);
        String name = new String("Camera");
        User user = new Student("Dorian", "LIZARRALDE", "SI3 - 2013");
        int quantity = 1;

        Loan loan = new Loan(user, name, quantity, start, end);

        assertEquals(
                "User : Dorian LIZARRALDE\tYear : SI3 - 2013\tEquipment : Camera\tQuantity : 1\tStart : 02/02/2014\tEnd : 26/01/2014",
                loan.toString());
    }
}
