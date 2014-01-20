package users;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import management.Stock;

import objects.Material;
import objects.MaterialQuantity;
import objects.Tablet;
import objects.TypeOS;

import org.junit.Test;

import data.Data;

/**
 * Test the Manager Class as well as the Teacher and Student Classes.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestManager {

    @Test
    public void testDoReserve() {

        Manager manager = new Manager(new Stock(
                Data.loadMaterialsList("./data/TEST_MATERIALS_LIST.xml")));

        User user = new Student("LIZARRALDE", "Dorian", "SI3 - 2013");
        Material material = new Tablet("iPad", "Description of the iPad",
                TypeOS.IOS);
        MaterialQuantity materialQuantity = new MaterialQuantity(material, 2);
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar endDate = new GregorianCalendar(2042, 11, 6);

        // A student can't make a reservation of more than 7 days.
        assertNull(manager.doReserve(user, materialQuantity, today, endDate));
        assertNotNull(manager.doReserve(user, materialQuantity, today, today));

        user = new Teacher("SARMIENTO", "SERGIO", "Communication");

        // A teacher can.
        assertNotNull(manager.doReserve(user, materialQuantity, today, endDate));
    }
}
