package ui;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import equipment.Equipment;
import ldapbeans.util.scanner.PackageHelper;
import management.StockController;
import management.Loan;
import management.Stock;
import user.User;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Terminal {

    private Parser parser;

    private StockController stockController;

    private User user;

    public Parser getParser() {

        return parser;
    }

    public void setParser(Parser parser) {

        this.parser = parser;
    }

    public StockController getStockController() {

        return stockController;
    }

    public void setStockController(StockController stockController) {

        this.stockController = stockController;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public Terminal(List<Equipment> equipment, List<Loan> loans,
            List<User> users) {

        this.setParser(new Parser(new Scanner(System.in)));
        this.setStockController(new StockController(new Stock(equipment, loans)));

        System.out.println("Connection. Format : 'First Name' 'Last Name'"
                + System.getProperty("line.separator"));

        this.setUser(connect(users));
    }

    public User connect(List<User> users) {

        List<String> words = this.getParser().getInput();

        if (words.size() > 1) {

            for (User u : users) {

                if (u.getLastName().equalsIgnoreCase(words.get(0))
                        && u.getFirstName().equalsIgnoreCase(words.get(1))) {

                    return u;
                }
            }
        }

        return null;
    }

    public void start() {

        if (user == null) {

            System.out
                    .println("Connection failed. We were unable to find you.");

            return;
        }

        System.out.println("Welcome " + this.getUser().toString());

        System.out.println("Type your command. If you need help, type 'help'");

        while (!processCommand(this.getParser().getInput())) {

        }

        System.out.println("Thank you for using our application. Good bye.");
    }

    public boolean processCommand(List<String> words) {

        boolean leave = false;

        if (!words.isEmpty()) {

            switch (words.get(0)) {

            case "add":
                add();
                break;

            case "borrow":
                borrow();
                break;

            case "display":
                display();
                break;

            case "giveBack":
                giveBack();
                break;

            case "help":
                help();
                break;

            case "leave":
                leave = true;
                break;

            case "remove":
                remove();
                break;

            case "validate":
                validate();
                break;
            }
        }

        return leave;
    }

    public void add() {

        Collection<Class<?>> classes;

        try {

            classes = PackageHelper.getInstance().getClasses("equipment.solid",
                    false, null);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    public boolean borrow() {

        int reponse;

        GregorianCalendar startDate = null;

        GregorianCalendar endDate = null;

        int quantity;

        boolean dateOk = false;

        // Load the materials from the stock
        List<Equipment> mat = stockController.getStock().getEquipment();

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

    public void display() {

    }

    public void giveBack() {

    }

    public void help() {

        System.out
                .println("Your command words are : add, borrow, display, giveBack, help, leave, remove, validate");
    }

    public void remove() {

    }

    public void validate() {

    }

    public int chooseAnObject() {

        int i = -1;

        System.out.println("Please write the number of the object you want: ");

        System.out.println(stockController.getStock().toString());

        List<String> words = parser.getInput();

        if (!words.isEmpty()) {

            i = Integer.parseInt(words.get(0));
        }

        if (i < 0 || i > stockController.getStock().getEquipment().size() - 1) {

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
}
