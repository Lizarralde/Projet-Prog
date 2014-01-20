package ui;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class TestParser {

    static Parser parser = new Parser();

    /**
     * @author Dorian LIZARRALDE
     */
    @BeforeClass
    public static void setReader() {

        try {

            parser.setReader(new FileInputStream("./data/TEST_PARSER.txt"));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        System.out.close();
    }

    /**
     * @author Dorian LIZARRALDE
     */
    @Test
    public void testGetInput() {

        List<String> words = parser.getInput();

        assertNotNull(words);
        assertTrue(words.isEmpty());

        words = parser.getInput();

        assertTrue(words.size() == 2);

        assertEquals("LIZARRALDE", words.get(0));
        assertEquals("Dorian", words.get(1));
    }

    /**
     * @author Dorian LIZARRALDE
     */
    @Test
    public void testGetADate() {

        GregorianCalendar calendar = parser.getADate();

        // Not null.
        assertNull(calendar);

        calendar = parser.getADate();

        // Not null.
        assertNull(calendar);

        calendar = parser.getADate();

        // Good data.
        assertEquals(1992, calendar.get(GregorianCalendar.YEAR));
        assertEquals(8, calendar.get(GregorianCalendar.MONTH));
        assertEquals(20, calendar.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
