import java.util.List;
import java.util.Scanner;

import config.Config;
import management.Loan;
import ui.Parser;
import ui.Terminal;
import user.User;
import data.Data;
import equipment.Equipment;

/**
 * Entry point of the program.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Program {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // Load the configuration file.
        Config.load("./config/CONFIG.txt");

        // Start the application.
        new Terminal(new Parser(new Scanner(System.in)),
                (List<Equipment>) Data.load("./data/EQUIPMENT_LIST.xml"),
                (List<Loan>) Data.load("./data/LOANS_LIST.xml"),
                (List<Loan>) Data.load("./data/ON_HOLD_LIST.xml"),
                (List<User>) Data.load("./data/USERS_LIST.xml")).start();
    }
}
