package data;

import static org.junit.Assert.*;

import java.util.List;

import objects.MaterialQuantity;

import org.junit.Test;

import users.User;

/**
 * Test the Data Class.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestData {

    /**
     * @author Dorian LIZARRALDE
     */
    @Test
    public void testLoadUsersList() {

        List<User> users = Data.loadUsersList("./data/TEST_USERS_LIST.xml");

        // Not a null object.
        assertNotNull(users);

        // Good size.
        assertEquals(7, users.size());

        // Good data.
        assertEquals("SIMOND", users.get(2).getName());
        assertEquals("Hugo", users.get(2).getForname());
    }

    /**
     * @author Dorian LIZARRALDE
     */
    @Test
    public void testLoadMaterialList() {

        List<MaterialQuantity> materials = Data
                .loadMaterialsList("./data/TEST_MATERIALS_LIST.xml");

        // Not a null object.
        assertNotNull(materials);

        // Good size.
        assertEquals(4, materials.size());

        // Good data.
        assertEquals("Nokia 850", materials.get(2).getMat().getName());
        assertEquals(2, materials.get(2).getQuantity());
    }
}
