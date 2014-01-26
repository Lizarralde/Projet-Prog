package management;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import data.Data;
import equipment.Equipment;
import user.Student;
import user.User;

public class ReservationInspectorTest {

    GregorianCalendar end = new GregorianCalendar(2014, 1, 2);
    GregorianCalendar start = new GregorianCalendar(2014, 0, 26);
    String name = "Camera";
    User user = new Student("LIZARRALDE", "Dorian", "SI3 - 2013");

    Loan loan = new Loan(user, name, 1, start, end);

    @SuppressWarnings("unchecked")
    Stock stock = new Stock(
            (List<Equipment>) Data.load("./data/TEST_EQUIPMENT_LIST.xml"),
            (List<Loan>) Data.load("./data/TEST_LOANS_LIST.xml"),
            (List<Loan>) Data.load("./data/TEST_ON_HOLD_LIST.xml"));

    StockController stockController = new StockController(stock);

    @Test
    public void testDayWhenMaterialIsNotAvailable() {

        assertEquals(new GregorianCalendar(2014, 1, 2),
                stockController.dayWhenMaterialIsNotAvailable(loan));
    }

    @Test
    public void testDayWhenMaterialIsAvailable() {

        assertEquals(new GregorianCalendar(2014, 0, 26),
                stockController.dayWhenMaterialIsAvailable(loan));
    }

    @Test
    public void testNumberOfMaterialAvailable() {

        assertEquals(1, stockController.numberOfMaterialAvailable(loan));
    }

    @Test
    public void testNumberOfDayMaterialCanBeLoaned() {

        assertEquals(1, stockController.numberOfDayMaterialCanBeLoaned(loan));
    }
}
