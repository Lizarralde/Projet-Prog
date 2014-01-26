package equipment;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the Equipment class.
 * 
 * @author Jean-Philippe KHA
 * 
 */
public class TestEquipment {

    private Equipment equipment = new Equipment("Camera", "Description");

    @Test
    public void testMaterial() {

        assertNotNull(equipment);
    }

    @Test
    public void testGetObjectValue() {

        assertEquals(equipment.getValue(), 15);
    }

}
