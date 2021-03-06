package ui;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import config.Config;

/**
 * Test the Terminal Class
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestTerminal {

    @Test
    public void testBorrow() throws FileNotFoundException {

        System.out.close();

        List<String> locations = new ArrayList<String>();

        Config.load("./config/TEST_CONFIG.txt");

        locations.add("./data/TEST_EQUIPMENT_LIST.xml");
        locations.add("./data/TEST_LOANS_LIST.xml");
        locations.add("./data/TEST_ON_HOLD_LIST.xml");
        locations.add("./data/TEST_USERS_LIST.xml");

        Terminal terminal = new Terminal(new Parser(new Scanner(
                new FileInputStream("./TEST_TERMINAL.txt"))), locations);

        terminal.start();

        assertEquals(
                terminal.getStockController().getStock().getOnHold().get(0)
                        .toString(),
                "User : Dorian LIZARRALDE\tYear : SI3 - 2013\tEquipment : Camera\tQuantity : 1\tStart : 26/01/2014\tEnd : 02/02/2014");
    }
}
