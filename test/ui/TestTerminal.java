package ui;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import management.Loan;

import org.junit.Test;

import config.Config;
import user.User;
import data.Data;
import equipment.Equipment;

/**
 * Test the Terminal Class
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestTerminal {

    @SuppressWarnings("unchecked")
    @Test
    public void theTest() throws FileNotFoundException {

        System.out.close();

        Config.load("./config/CONFIG.txt");

        Terminal terminal = new Terminal(new Parser(new Scanner(
                new FileInputStream("./TEST_TERMINAL.txt"))),
                (List<Equipment>) Data.load("./data/TEST_EQUIPMENT_LIST.xml"),
                (List<Loan>) Data.load("./data/TEST_LOANS_LIST.xml"),
                (List<Loan>) Data.load("./data/TEST_ON_HOLD_LIST.xml"),
                (List<User>) Data.load("./data/TEST_USERS_LIST.xml"));

        terminal.start();

        assertEquals(
                terminal.getStockController().getStock().getOnHold().get(0)
                        .toString(),
                "User : Dorian LIZARRALDE\tYear : SI3 - 2013\tEquipment : Camera\tQuantity : 1\tStart : 26/01/2014\tEnd : 02/02/2014");
    }
}
