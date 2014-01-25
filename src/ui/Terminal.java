package ui;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import config.Config;
import data.Data;
import equipment.Equipment;
import ldapbeans.util.scanner.PackageHelper;
import management.StockController;
import management.Loan;
import management.Stock;
import user.User;

/**
 * Interface with the user.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Terminal {

    // Parser.
    private Parser parser;

    // Stock controller.
    private StockController stockController;

    // User.
    private User user;

    // Getters and setters.
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

    /**
     * Default constructor.
     * 
     * @param equipment
     * @param loans
     * @param onHold
     * @param users
     */
    public Terminal(Parser parser, List<Equipment> equipment, List<Loan> loans,
            List<Loan> onHold, List<User> users) {

        this.setParser(parser);
        this.setStockController(new StockController(new Stock(equipment, loans,
                onHold)));

        System.out.println("Connection. Format : 'First Name' 'Last Name'");

        this.setUser(this.connect(users));
    }

    /**
     * Connect the user using the list parameter.
     * 
     * @param users
     * @return
     */
    public User connect(List<User> users) {

        // User input.
        List<String> words = this.getParser().getInput();

        if (words.size() > 1) {

            for (User u : users) {

                // If the user is in the list, the connection succeed.
                if (u.getFirstName().equalsIgnoreCase(words.get(0))
                        && u.getLastName().equalsIgnoreCase(words.get(1))) {

                    return u;
                }
            }
        }

        return null;
    }

    /**
     * Launch the application.
     * 
     */
    public void start() {

        if (this.getUser() == null) {

            System.out
                    .println("Connection failed. We were unable to find you.");

            return;
        }

        // Greetings.
        System.out.println("Welcome " + this.getUser().toString());

        System.out.println("Type your command. If you need help, type 'help'");

        // Loop.
        while (!processCommand(this.getParser().getInput())) {

        }

        System.out.println("Thank you for using our application. Good bye.");
    }

    /**
     * Process using the user input.
     * 
     * @param words
     * @return
     */
    public boolean processCommand(List<String> words) {

        boolean leave = false;

        if (!words.isEmpty()) {

            switch (words.get(0)) {

            case "add":
                this.add();
                break;

            case "borrow":
                this.borrow();
                break;

            case "display":
                this.display();
                break;

            case "giveBack":
                this.giveBack();
                break;

            case "help":
                this.help();
                break;

            case "leave":
                leave = true;
                break;

            case "remove":
                this.remove();
                break;

            case "store":
                this.store();
                break;

            case "validate":
                this.validate();
                break;
            }
        }

        return leave;
    }

    /**
     * Add an equipment.
     * 
     */
    public void add() {

        Object[] classes;

        int index = -1;

        System.out.println("Select your new equipment.");

        try {

            // Retrieve all classes in the package 'equipment.solid'.
            classes = PackageHelper.getInstance()
                    .getClasses("equipment.solid", false, null).toArray();

        } catch (ClassNotFoundException e) {

            System.out.println("No equipment found.");

            return;
        }

        // Display.
        for (int i = 0; i < classes.length; i++) {

            System.out.println("Index : " + i + "\tName : "
                    + ((Class<?>) classes[i]).getSimpleName());
        }

        index = this.getInt(index, classes.length);

        // Add the equipment.
        this.getStockController().getStock().getEquipment()
                .add(this.newEquipment((Class<?>) classes[index]));

        System.out.println("Equipment added");
    }

    /**
     * Return the index using the size of a list.
     * 
     * @param index
     * @param length
     * @return
     */
    public int getInt(int index, int length) {

        // User input.
        List<String> words = this.getParser().getInput();

        if (!words.isEmpty()) {

            try {

                index = Integer.parseInt(words.get(0));

                // Index out of bounds.
                if (index >= 0 || index < length) {

                    return index;
                }
            } catch (NumberFormatException e) {

            }
        }

        System.out.println("Incorrect number.");

        return this.getInt(index, length);
    }

    /**
     * Create a new equipment using the class parameter.
     * 
     * @param c
     * @return
     */
    public Equipment newEquipment(Class<?> c) {

        return null;
    }

    /**
     * Borrow an equipment from the stock.
     * 
     */
    public void borrow() {

        GregorianCalendar end, start;

        Loan loan;

        String name;

        int index = -1;

        int quantity = -1;

        System.out.println("Select your equipment.");

        // Display the initial stock.
        List<String> names = this.getStockController().getStock().getNames();

        for (int i = 0; i < names.size(); i++) {

            System.out.println("Index : "
                    + i
                    + "\tName : "
                    + names.get(i)
                    + "\tQuantity : "
                    + this.getStockController().getStock()
                            .getQuantity(names.get(i)));
        }

        index = this.getInt(index, this.getStockController().getStock()
                .getEquipment().size());

        name = this.getStockController().getStock().getNames().get(index);

        System.out.println("Quantity : ");

        // Get the quantity.
        quantity = this.getInt(quantity, this.getStockController().getStock()
                .getQuantity(name));

        System.out.println("Start : ");

        start = this.getParser().getCalendar();

        System.out.println("End : ");

        end = this.getParser().getCalendar();

        // Create the associate loan.
        loan = new Loan(this.getUser(), name, quantity, start, end);

        if (Config.property.getProperty("Mode").equals("Manual")) {

            this.getStockController().getStock().getOnHold().add(loan);

            System.out.println("Your loan has been put on hold.");
        } else {

            modeAuto(loan);
        }
    }

    /**
     * Process automatically using the loan parameter.
     * 
     * @param loan
     */
    public void modeAuto(Loan loan) {

    }

    /**
     * Display all Intel related to the stock.
     * 
     */
    public void display() {

        System.out.print(this.getStockController().getStock().toString());
    }

    public void giveBack() {

    }

    /**
     * Help.
     * 
     */
    public void help() {

        System.out
                .println("Your command words are : add, borrow, display, giveBack, help, leave, remove, store, validate");
    }

    /**
     * Store all Intel related to the stock.
     * 
     */
    private void store() {

        Data.store(this.getStockController().getStock().getEquipment(),
                "./data/EQUIPMENT_LIST.xml");

        Data.store(this.getStockController().getStock().getLoans(),
                "./data/LOANS_LIST.xml");

        Data.store(this.getStockController().getStock().getOnHold(),
                "./data/ON_HOLD_LIST.xml");
    }

    public void remove() {

        int index = -1;

        System.out
                .println("Select the equipment to remove. If you want to leave, type '0'.");

        for (int i = 0; i < this.getStockController().getStock().getEquipment()
                .size(); i++) {

            System.out.println("Index : "
                    + (i + 1)
                    + "\t"
                    + this.getStockController().getStock().getEquipment()
                            .get(i));
        }

        index = this.getInt(index, this.getStockController().getStock()
                .getEquipment().size() + 1) - 1;

        if (index == -1) {

            return;
        }

        this.getStockController()
                .getStock()
                .getEquipment()
                .remove(this.getStockController().getStock().getEquipment()
                        .get(index));
    }

    /**
     * Ask the user to validate the lost of loans on hold.
     * 
     */
    public void validate() {

        // Temporary list of deletion.
        List<Loan> deletion = new ArrayList<Loan>();

        List<String> words;

        System.out.println("Validate. Format 'yes' 'no'");

        for (Loan l : this.getStockController().getStock().getOnHold()) {

            System.out.println(l.toString());

            // User input.
            words = this.getParser().getInput();

            if (!words.isEmpty()) {

                switch (words.get(0)) {

                case "yes":
                    this.getStockController().getStock().getLoans().add(l);
                    deletion.add(l);
                    System.out.println("Loan added.");
                    break;

                case "no":
                    deletion.add(l);
                    System.out.println("Loan deleted");
                    break;
                }
            }
        }

        // Delete all loans on hold of the list of deletion.
        for (Loan l : deletion) {

            this.getStockController().getStock().getOnHold().remove(l);
        }
    }
}
