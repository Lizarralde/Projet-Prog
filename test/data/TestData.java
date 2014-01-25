package data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import equipment.Equipment;
import user.User;

/**
 * Test the Data class.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestData {

    @SuppressWarnings("unchecked")
    @Test
    public void testLoadEquipment() {

        List<Equipment> equipment = (List<Equipment>) Data
                .load("./data/TEST_EQUIPMENT_LIST.xml");

        assertNotNull(equipment);

        assertEquals(4, equipment.size());

        assertEquals("Camera", equipment.get(0).getName());
        assertEquals("Description", equipment.get(0).getDescription());

        assertEquals("Headphones", equipment.get(1).getName());
        assertEquals("Description", equipment.get(1).getDescription());

        assertEquals("Phone", equipment.get(2).getName());
        assertEquals("Description", equipment.get(2).getDescription());

        assertEquals("Tablet", equipment.get(3).getName());
        assertEquals("Description", equipment.get(3).getDescription());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testLoadUsers() {

        List<User> users = (List<User>) Data.load("./data/TEST_USERS_LIST.xml");

        assertNotNull(users);

        assertEquals(3, users.size());

        assertEquals("Jean-Philippe", users.get(0).getFirstName());
        assertEquals("KHA", users.get(0).getLastName());

        assertEquals("Dorian", users.get(1).getFirstName());
        assertEquals("LIZARRALDE", users.get(1).getLastName());

        assertEquals("Mamadou Falou", users.get(2).getFirstName());
        assertEquals("SECK", users.get(2).getLastName());
    }
}
