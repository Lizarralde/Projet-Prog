package ui;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.List;

import objects.MaterialQuantity;

import org.junit.BeforeClass;
import org.junit.Test;

import users.User;

import data.Data;

/**
 * Test the Terminal Class
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestTerminal {

    static Terminal terminal;

    @BeforeClass
    public static void setReader() {

        terminal = new Terminal();

        try {

            terminal.getParser().setReader(
                    new FileInputStream("./data/TEST_TERMINAL.txt"));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    /**
     * @author Dorian LIZARRALDE
     */
    @Test
    public void theTest() {

        System.out.close();

        List<User> users = Data.loadUsersList("./data/TEST_USERS_LIST.xml");

        List<MaterialQuantity> materials = Data
                .loadMaterialsList("./data/TEST_MATERIALS_LIST.xml");

        terminal.start(users, materials);

        assertNotNull(terminal.getUser());
        assertEquals("LIZARRALDE Dorian", terminal.getUser().toString());

        assertEquals(3, terminal.chooseAnObject());

        assertEquals(1, terminal.enterAQuantity(3));

        assertEquals(
                0,
                terminal.askADate("Test askDate").compareTo(
                        new GregorianCalendar(1992, 8, 20)));

        GregorianCalendar calendar = new GregorianCalendar();

        assertFalse(terminal.checkTheDates(new GregorianCalendar(1992, 8, 20),
                calendar));
        assertFalse(terminal.checkTheDates(calendar, new GregorianCalendar(
                1992, 8, 20)));
        assertTrue(terminal.checkTheDates(calendar, calendar));
    }
}
