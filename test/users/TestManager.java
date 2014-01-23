package users;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.List;

import management.ReservationInspector;
import management.Stock;

import material.Material;
import material.MaterialQuantity;
import material.TypeOS;
import material.solid.Tablet;

import org.junit.Test;

import user.Student;
import user.Teacher;
import user.User;
import data.Data;

/**
 * Test the Manager Class as well as the Teacher and Student Classes.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestManager {

    @SuppressWarnings("unchecked")
    @Test
    public void testDoReserve() {

        ReservationInspector inspector = new ReservationInspector(new Stock(
                (List<MaterialQuantity>) Data
                        .load("./data/TEST_MATERIALS_LIST.xml")));

        User user = new Student("LIZARRALDE", "Dorian", "SI3 - 2013");
        Material material = new Tablet("iPad", "Description of the iPad",
                TypeOS.IOS);
        MaterialQuantity materialQuantity = new MaterialQuantity(material, 2);
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar endDate = new GregorianCalendar(2042, 11, 6);

        // A student can't make a reservation of more than 7 days.
        assertNull(inspector.doReserve(user, materialQuantity, today, endDate));
        assertNotNull(inspector.doReserve(user, materialQuantity, today, today));

        user = new Teacher("SARMIENTO", "SERGIO", "Communication");

        // A teacher can.
        assertNotNull(inspector.doReserve(user, materialQuantity, today,
                endDate));
    }
}
