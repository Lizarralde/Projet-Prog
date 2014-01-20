import ui.Terminal;
import data.Data;

/**
 * Entry point of the program.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Program {

    /**
     * @author Dorian LIZARRALDE
     * @param args
     */
    public static void main(String[] args) {

        new Terminal().start(Data.loadUsersList("./data/USERS_LIST.xml"),
                Data.loadMaterialsList("./data/MATERIALS_LIST.xml"));
    }
}
