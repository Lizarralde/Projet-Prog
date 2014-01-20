import java.util.List;

import objects.MaterialQuantity;
import ui.Terminal;
import users.User;
import data.Data;

/**
 * Entry point of the program.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Program {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        new Terminal()
                .start((List<User>) Data.load("./data/USERS_LIST.xml"),
                        (List<MaterialQuantity>) Data
                                .load("./data/MATERIALS_LIST.xml"));
    }
}
