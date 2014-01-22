package ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import equipment.Equipment;
import ldapbeans.util.scanner.PackageHelper;
import management.CalendarController;
import management.StockController;
import management.Loan;
import management.Stock;
import user.Administrator;
import user.User;

/**
 * Headquarter of the application. Identifie the user. Retrieve his reservation.
 * Make it happened or not depend on the manager verification.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Terminal {

    private Parser parser;

    private User user;

    private Stock stock;

    private StockController inspector;

    /**
     * @author Dorian LIZARRALDE
     * @return
     */
    public Parser getParser() {

        return parser;
    }

    public void setParser(Parser parser) {

        this.parser = parser;
    }

    /**
     * @author Dorian LIZARRALDE
     * @return
     */
    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public Stock getStock() {

        return stock;
    }

    public void setStock(Stock stock) {

        this.stock = stock;
    }

    public StockController getInspector() {

        return inspector;
    }

    public void setInpector(StockController inspector) {

        this.inspector = inspector;
    }

    /**
     * Default constructor.
     * 
     * @author Dorian LIZARRALDE
     */
    public Terminal() {

        this.setParser(new Parser());
    }

    /**
     * Start the application. The user has to identifie himself to make a
     * reservation.
     * 
     * @author Dorian LIZARRALDE
     */
    public void start(List<Equipment> equipment, List<Loan> loan,
            List<User> user) {

        // Keep the default stock for futur use.
        stock = new Stock(mat);

        // Create a manager who will certificate the reservations.
        inspector = new StockController(stock);

        // Welcome
        welcome();

        // Wait for the user to identifie himself.
        while ((user = parser.getID(users)) == null) {

            System.out.println("Sorry, we were unable to find you.");
        }

        // The user is now identified.
        System.out.println("You are now identified as " + user.toString());

        // The user can make a reservation.
        theApplication();
    }

    /**
     * 
     * @author fabien Pinel
     */
    public void theApplication() {

        System.out
                .println("Type your command. If you need help, you can use the command 'help'");

        while (!processCommand(parser.getInput())) {

        }

        System.out.println("Thank you for using our application. Good bye.");
    }

    /**
     * Display a welcome text and ask for the user to identifie himself.
     * 
     * @author Dorian LIZARRALDE
     */
    public void welcome() {

        System.out.println("Welcome to our reservation application.");

        System.out
                .println("What is your ID ? Type your name followed by your forname.");
    }

    /**
     * Execute the command associate the user input.
     * 
     * @author Dorian LIZARRALDE
     * @param words
     * @return
     */
    public boolean processCommand(List<String> words) {

        boolean wantToQuit = false;

        // The user has actually typed something.
        if (!words.isEmpty()) {

            switch (words.get(0)) {

            // The user want to reserve something.
            case "reserve":
                reserve();
                break;

            case "add":
                if (user instanceof Administrator) {

                    Collection<Class<?>> classes = null;

                    // Find all classes in the package "objects.test" but not in
                    // its sub-package.
                    try {

                        classes = PackageHelper.getInstance().getClasses(
                                "objects.test", false, null);

                        for (Class<?> c : classes) {

                            System.out.println(c.getName());
                        }
                    } catch (ClassNotFoundException e) {

                        e.printStackTrace();
                    }
                }
                break;

            // The user want to display the help.
            case "help":
                help();
                break;

            // The user want to quit.
            case "quit":
                wantToQuit = true;
                break;
            }
        }

        return wantToQuit;
    }

    /**
     * Display an help text.
     * 
     * @author Dorian LIZARRALDE
     */
    public void help() {

        System.out
                .println("You can use our application to reserve a material.");

        System.out
                .println("Your command words are : reserve, add, display, help, quit");
    }

    /**
     * THis method asks the user to choose an object in the list and is played
     * again and again until the choice is okay.
     * 
     * @author Fabien Pinel & Dorian LIZARRALDE
     * @return
     */
    public int chooseAnObject() {

        int i = -1;

        System.out.println("Please write the number of the object you want: ");

        System.out.println(stock.toString());

        List<String> words = parser.getInput();

        if (!words.isEmpty()) {

            i = Integer.parseInt(words.get(0));
        }

        if (i < 0 || i > stock.getMaterialStock().size() - 1) {

            System.out.println("Incorrect. Please enter a correct number.");

            return chooseAnObject();
        }

        return i;
    }

    /**
     * Ask for a quantity and play the method until the quantity is okay.
     * 
     * @author Fabien Pinel & Dorian LIZARRALDE
     * @param quantityAvailable
     * @return
     */
    public int enterAQuantity(int quantityAvailable) {

        int quantity = -1;

        System.out.println("Enter the quantity you want :");

        List<String> words = parser.getInput();

        if (!words.isEmpty()) {

            quantity = Integer.parseInt(words.get(0));
        }

        if (quantity <= 0 || quantity > quantityAvailable) {

            System.out.println("Incorrect. Please enter a correct number.");

            return enterAQuantity(quantityAvailable);
        }

        return quantity;
    }

    /**
     * Propose to the user to do a reservation.
     * 
     * @author fabien Pinel & Dorian LIZARRALDE
     */
    public boolean reserve() {

        int reponse;

        GregorianCalendar startDate = null;

        GregorianCalendar endDate = null;

        int quantity;

        boolean dateOk = false;

        // Load the materials from the stock
        List<Equipment> mat = stock.getMaterialStock();

        reponse = this.chooseAnObject();

        /*
         * quantity = this.enterAQuantity(mat.get(reponse).getQuantity());
         * 
         * while (!dateOk) {
         * 
         * System.out
         * .println("Enter your start date. The format is dd/MM/yyyy.");
         * 
         * startDate = parser.getADate();
         * 
         * System.out
         * .println("Enter your end date. The format is dd/MM/yyyy.");
         * 
         * endDate = parser.getADate();
         * 
         * dateOk = CalendarController.checkTheDates(startDate, endDate); }
         * 
         * if (inspector.isAvailable(mat.get(reponse), startDate, endDate)) {
         * 
         * System.out .println(
         * "The manager said that there are enough materials avaible for your reservation."
         * );
         * 
         * List<Equipment> monObjetAReserver = new ArrayList<Equipment>();
         * 
         * //
         * 
         * Loan res = inspector.doReserve(user, monObjetAReserver, startDate,
         * endDate);
         * 
         * if (res != null) {
         * 
         * stock.getReservList().add(res);
         * 
         * System.out .println("Reservation effectuée." +
         * System.getProperty("line.separator") +
         * "Affichage de la reservation :" +
         * System.getProperty("line.separator") + res.toString());
         * 
         * return true; } else {
         * 
         * System.out
         * .println("The manager said you are not able to do this reservation."
         * );
         * 
         * return false; } }
         */

        System.out
                .println("The manager didn't find enough materials avaible for your reservation.");

        return false;
    }
}
