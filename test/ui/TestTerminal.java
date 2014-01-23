package ui;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.List;

import management.CalendarController;

import org.junit.BeforeClass;
import org.junit.Test;

import user.User;
import data.Data;
import equipment.EquipmentSet;

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
    @SuppressWarnings("unchecked")
    @Test
    public void theTest() {

        System.out.close();

        List<User> users = (List<User>) Data.load("./data/TEST_USERS_LIST.xml");

        List<EquipmentSet> materials = (List<EquipmentSet>) Data
                .load("./data/TEST_MATERIALS_LIST.xml");

        terminal.start(users, materials);

        assertNotNull(terminal.getUser());
        assertEquals("LIZARRALDE Dorian", terminal.getUser().toString());

        assertEquals(3, terminal.chooseAnObject());

        assertEquals(1, terminal.enterAQuantity(3));

        GregorianCalendar calendar = new GregorianCalendar();

        assertFalse(CalendarController.checkTheDates(new GregorianCalendar(
                1992, 8, 20), calendar));
        assertFalse(CalendarController.checkTheDates(calendar,
                new GregorianCalendar(1992, 8, 20)));
        assertTrue(CalendarController.checkTheDates(calendar, calendar));
    }
}
