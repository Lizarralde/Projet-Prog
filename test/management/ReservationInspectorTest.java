package management;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import material.MaterialQuantity;
import material.TypeOS;
import material.solid.Phone;

import org.junit.BeforeClass;
import org.junit.Test;

import user.Student;
import user.User;

public class ReservationInspectorTest {

    User user = new Student("LIZARRALDE", "Dorian", "SI3 - 2013");
    MaterialQuantity material = new MaterialQuantity(new Phone("iPad",
            "Description of the iPad", TypeOS.IOS), 3);
    GregorianCalendar start = new GregorianCalendar(2013, 11, 1);
    GregorianCalendar end = new GregorianCalendar(2013, 11, 5);
    Reservation reservation = new Reservation(user, material, start, end);
    ArrayList<MaterialQuantity> listStock = new ArrayList<MaterialQuantity>();
    Stock stock = new Stock(listStock);
    ReservationInspector inspector = new ReservationInspector(stock);
    

	@Test
	public void testDayWhenMaterialIsNotAvailable() {
		assertEquals(inspector.dayWhenMaterialIsNotAvailable(material, 4, start, end),start);
	}

	@Test
	public void testDayWhenMaterialIsAvailable() {
		assertEquals(inspector.dayWhenMaterialIsAvailable(material, 1, start, end),start);
	}

	@Test
	public void testNumberOfMaterialAvailable() {
		assertEquals(inspector.numberOfMaterialAvailable(material, start, end),3);
	}

	@Test
	public void testNumberOfDayMaterialCanBeLoaned() {
		assertEquals(inspector.numberOfDayMaterialCanBeLoaned(material, 3),2);
		assertEquals(inspector.numberOfDayMaterialCanBeLoaned(material, 1),7);
	}

	@Test
	public void testAlreadyHaveThisMaterial() {
		assertFalse(inspector.alreadyHaveThisMaterial(user, material));
		user.doReserve(material, start, end);
	}

}
