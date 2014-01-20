package ui;

import java.util.GregorianCalendar;
import java.util.List;

import management.Reservation;
import management.Stock;
import objects.MaterialQuantity;
import users.Manager;
import users.User;

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

    private Manager manager;

    /**
     * Default constructor.
     * 
     * @author Dorian LIZARRALDE
     */
    public Terminal() {

        parser = new Parser();
    }

    /**
     * @author Dorian LIZARRALDE
     * @return
     */
    public Parser getParser() {

        return parser;
    }

    /**
     * @author Dorian LIZARRALDE
     * @return
     */
    public User getUser() {

        return user;
    }

    /**
     * Start the application. The user has to identifie himself to make a
     * reservation.
     * 
     * @author Dorian LIZARRALDE
     */
    public void start(List<User> users, List<MaterialQuantity> mat) {

        // Keep the default stock for futur use.
        stock = new Stock(mat);

        // Create a manager who will certificate the reservations.
        manager = new Manager(stock);

        // Welcome
        welcome();

        // Wait for the user to identifie himself.
        while (!getID(users)) {

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
     * Get the ID of the user and try to find him on the users list. If the ID
     * is on this list, the user is now identified.
     * 
     * @author Dorian LIZARRALDE
     * @param users
     * @return
     */
    public boolean getID(List<User> users) {

        // Get the ID of the user.
        List<String> words = parser.getInput();

        // The user has to give his name and forname.
        if (words.size() > 1) {

            // Try to find him on the users list.
            for (User user : users) {

                if (user.getName().equalsIgnoreCase(words.get(0))
                        && user.getForname().equalsIgnoreCase(words.get(1))) {

                    // The user has been found.
                    this.user = user;

                    return true;
                }
            }
        }

        // The user has not been found.
        return false;
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

        System.out.println("Your command words are : reserve, help, quit");
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

        List<String> words;

        do {

            words = parser.getInput();

            if (!words.isEmpty()) {

                i = Integer.parseInt(words.get(0));
            }
        } while (i < 0 || i > stock.getMaterialStock().size() - 1);

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
     * Ask for a date.
     * 
     * @author Fabien Pinel & Dorian LIZARRALDE
     * @return the date entered by the user
     */
    public GregorianCalendar askADate(String whichOne) {

        GregorianCalendar calendar;

        do {

            System.out.println(whichOne);

            calendar = parser.getADate();
        } while (calendar == null);

        return calendar;
    }

    /**
     * Check if the dates given are okay.
     * 
     * @author Fabien Pinel & Dorian LIZARRALDE
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean checkTheDates(GregorianCalendar startDate,
            GregorianCalendar endDate) {

        GregorianCalendar today = new GregorianCalendar();
        today.set(GregorianCalendar.HOUR_OF_DAY, 0);
        today.set(GregorianCalendar.MINUTE, 0);
        today.set(GregorianCalendar.SECOND, 0);
        today.set(GregorianCalendar.MILLISECOND, 0);

        if (startDate.compareTo(today) < 0 || endDate.compareTo(today) < 0
                || startDate.compareTo(endDate) > 0) {

            System.out.println("One or both of your parameters is/are invalid");

            return false;
        }

        return true;
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
        List<MaterialQuantity> mat = stock.getMaterialStock();

        reponse = this.chooseAnObject();

        quantity = this.enterAQuantity(mat.get(reponse).getQuantity());

        while (!dateOk) {

            startDate = askADate("Enter your start date. The format is dd/MM/yyyy.");

            endDate = askADate("Enter your end date. The format is dd/MM/yyyy.");

            dateOk = this.checkTheDates(startDate, endDate);
        }

        if (manager.isAvailable(mat.get(reponse), quantity, startDate, endDate)) {

            System.out
                    .println("The manager said that there are enough materials avaible for your reservation.");

            MaterialQuantity monObjetAReserver = new MaterialQuantity(mat.get(
                    reponse).getMat(), quantity);

            Reservation res = manager.doReserve(user, monObjetAReserver,
                    startDate, endDate);

            if (res != null) {

                stock.getReservList().add(res);

                System.out
                        .println("Reservation effectuée."
                                + System.getProperty("line.separator")
                                + "Affichage de la reservation :"
                                + System.getProperty("line.separator")
                                + res.toString());

                return true;
            } else {

                System.out
                        .println("The manager said you are not able to do this reservation.");

                return false;
            }
        }

        System.out
                .println("The manager didn't find enough materials avaible for your reservation.");

        return false;
    }
}
