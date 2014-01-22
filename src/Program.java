import java.util.List;

import ui.Terminal;
import user.User;
import data.Data;
import equipment.MaterialQuantity;

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
