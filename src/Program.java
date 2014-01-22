import java.util.List;

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

        new Terminal().start(
                (List<Equipment>) Data.load("./data/EQUIPMENT_LIST.xml"),
                (List<Loan>) Data.load("./data/LOAN_LIST.xml"),
                (List<User>) Data.load("./data/USER_LIST.xml"));
    }
}
