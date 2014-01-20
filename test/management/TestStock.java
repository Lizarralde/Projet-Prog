package management;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import data.Data;

/**
 * Test the Stock class.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestStock {

    /**
     * @author Dorian LIZARRALDE
     */
    @Test
    public void testToString() {

        Stock stock = new Stock(
                Data.loadMaterialsList("./data/TEST_MATERIALS_LIST.xml"));

        assertEquals(
                "0. HTC One (Description of the HTC One) - 5"
                        + System.getProperty("line.separator")
                        + "1. Dr Dre (Description of the Dr Dre) - 24"
                        + System.getProperty("line.separator")
                        + "2. Nokia 850 (Description of the Nokia 850) - 2"
                        + System.getProperty("line.separator")
                        + "3. iPad (Description of the HTC One) - 5"
                        + System.getProperty("line.separator"),
                stock.toString());
    }
}
