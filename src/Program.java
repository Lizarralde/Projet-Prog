import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.Config;
import ui.Parser;
import ui.Terminal;

/**
 * Entry point of the program.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Program {

    public static void main(String[] args) {

        List<String> locations = new ArrayList<String>();

        // Load the configuration file.
        Config.load("./config/CONFIG.txt");

        locations.add("./data/EQUIPMENT_LIST.xml");
        locations.add("./data/LOANS_LIST.xml");
        locations.add("./data/ON_HOLD_LIST.xml");
        locations.add("./data/USERS_LIST.xml");

        // Start the application.
        new Terminal(new Parser(new Scanner(System.in)), locations).start();
    }
}
