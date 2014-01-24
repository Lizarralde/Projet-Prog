import java.util.List;

import config.Config;
import management.Loan;
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

        Config.load("./config/CONFIG.txt");

        new Terminal((List<Equipment>) Data.load("./data/EQUIPMENT_LIST.xml"),
                (List<Loan>) Data.load("./data/LOANS_LIST.xml"),
                (List<Loan>) Data.load("./data/ON_HOLD_LIST.xml"),
                (List<User>) Data.load("./data/USERS_LIST.xml")).start();
    }
}
