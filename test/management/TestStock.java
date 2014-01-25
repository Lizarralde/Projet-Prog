package management;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import data.Data;
import equipment.Equipment;

/**
 * Test the Stock class.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestStock {

    @SuppressWarnings("unchecked")
    @Test
    public void testToString() {

        Stock stock = new Stock(
                (List<Equipment>) Data.load("./data/TEST_EQUIPMENT_LIST.xml"),
                (List<Loan>) Data.load("./data/TEST_LOANS_LIST.xml"),
                (List<Loan>) Data.load("./data/TEST_ON_HOLD_LIST.xml"));

        assertEquals(
                "Initial stock : " + System.getProperty("line.separator")
                        + "Name : Camera\tQuantity : 1"
                        + System.getProperty("line.separator")
                        + "Name : Headphones\tQuantity : 1"
                        + System.getProperty("line.separator")
                        + "Name : Phone\tQuantity : 1"
                        + System.getProperty("line.separator")
                        + "Name : Tablet\tQuantity : 1"
                        + System.getProperty("line.separator") + "Loans : "
                        + System.getProperty("line.separator") + "On hold : "
                        + System.getProperty("line.separator"),
                stock.toString());
    }
}
