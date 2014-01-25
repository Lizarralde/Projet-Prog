package ui;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test the Parser class.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestParser {

    static Parser parser;

    @BeforeClass
    public static void newParser() {

        System.out.close();

        try {

            parser = new Parser(new Scanner(new FileInputStream(
                    "./TEST_PARSER.txt")));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    @Test
    public void testGetCalendar() {

        GregorianCalendar calendar;

        calendar = parser.getCalendar();

        assertNull(calendar);

        calendar = parser.getCalendar();

        assertEquals(20, calendar.get(GregorianCalendar.DAY_OF_MONTH));
        assertEquals(8, calendar.get(GregorianCalendar.MONTH));
        assertEquals(1992, calendar.get(GregorianCalendar.YEAR));
    }

    @Test
    public void testGetInput() {

        List<String> words;

        words = parser.getInput();

        assertNotNull(words);

        assertTrue(words.isEmpty());

        words = parser.getInput();

        assertTrue(words.size() == 2);

        assertEquals("Dorian", words.get(0));
        assertEquals("LIZARRALDE", words.get(1));
    }
}
