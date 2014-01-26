package ui;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import config.Config;
import data.Data;
import equipment.Equipment;
import equipment.OS;
import equipment.State;
import ldapbeans.util.scanner.PackageHelper;
import management.CalendarController;
import management.StatsController;
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

    private List<String> locations;

    // Parser.
    private Parser parser;

    // Stock controller.
    private StockController stockController;

    // User.
    private User user;

    // Getters and setters.
    public List<String> getLocations() {

        return locations;
    }

    public void setLocations(List<String> locations) {

        this.locations = locations;
    }

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
     * @author Dorian LIZARRALDE
     * @param parser
     * @param loactions
     */
    @SuppressWarnings("unchecked")
    public Terminal(Parser parser, List<String> locations) {

        this.setLocations(locations);
        this.setParser(parser);
        this.setStockController(new StockController(new Stock(
                (List<Equipment>) Data.load(this.getLocations().get(0)),
                (List<Loan>) Data.load(this.getLocations().get(1)),
                (List<Loan>) Data.load(this.getLocations().get(2)))));

        System.out.println("Connection. Format : 'First Name' 'Last Name'");

        this.setUser(this.connect((List<User>) Data.load(this.getLocations()
                .get(3))));
    }

    /**
     * Connect the user using the list parameter.
     * 
     * @author Dorian LIZARRALDE
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
     * @author Dorian LIZARRALDE
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

        this.giveBack();
        this.give();

        System.out.println("Type your command. If you need help, type 'help'");

        // Loop.
        while (!processCommand(this.getParser().getInput())) {

        }

        System.out.println("Thank you for using our application. Good bye.");
    }

    /**
     * 
     * @author Falou SECK
     * 
     */
    public void giveBack() {

        Random random = new Random();

        for (Loan l : this.getStockController().getStock().getLoans()) {

            if (CalendarController.calendarToString(l.getEnd()).equals(
                    CalendarController
                            .calendarToString(new GregorianCalendar()))) {

                for (Equipment e : this.getStockController().getStock()
                        .getEquipment()) {

                    if (l.getName().equals(e.getName())
                            && l.getID().equals(e.getLoanID())) {

                        if (random.nextDouble() < Double
                                .parseDouble(Config.property
                                        .getProperty("Durability"))) {

                            e.setState(State.BROKEN);
                        }

                        e.setLoanID(null);

                        e.setNumberOfLoans(e.getNumberOfLoans() + 1);
                    }
                }

                l.getUser()
                        .setNumberOfLoans(l.getUser().getNumberOfLoans() + 1);

                System.out.println("The user " + l.getUser().toString()
                        + " give back the equiment " + l.getName() + ".");
            }
        }
    }

    /**
     * 
     * @author Falou SECK
     * 
     */
    public void give() {

        int quantity;

        for (Loan l : this.getStockController().getStock().getLoans()) {

            if (CalendarController.calendarToString(l.getStart()).equals(
                    CalendarController
                            .calendarToString(new GregorianCalendar()))) {

                quantity = l.getQuantity();

                for (Equipment e : this.getStockController().getStock()
                        .getEquipment()) {

                    if (0 < quantity && l.getName().equals(e.getName())
                            && e.getState().equals(State.FUNCTIONAL)
                            && e.getLoanID() == null) {

                        e.setLoanID(l.getID());

                        quantity--;
                    }
                }

                System.out.println("The user " + l.getUser().toString()
                        + " get the equiment " + l.getName() + ".");

                System.out.println(quantity + " equipment missing.");
            }
        }
    }

    /**
     * Process using the user input.
     * 
     * @param words
     * @return
     */
    public boolean processCommand(List<String> words) {

        return this.getUser().processCommand(this, words);
    }

    /**
     * Add an equipment.
     * 
     * @author Dorian LIZARRALDE
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
     * @author Dorian LIZARRALDE
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
     * @author Dorian LIZARRALDE
     * @param c
     * @return
     */
    public Equipment newEquipment(Class<?> c) {

        Equipment equipment = null;

        String description = new String();

        String name = new String();

        System.out.println("Name : ");

        name = this.getParser().getInputLine();

        System.out.println("Description : ");

        description = this.getParser().getInputLine();

        if (c.getConstructors()[0].getParameterTypes().length < 3) {

            try {

                equipment = (Equipment) c.getConstructors()[0].newInstance(
                        name, description);
            } catch (InstantiationException e) {

                e.printStackTrace();
            } catch (IllegalAccessException e) {

                e.printStackTrace();
            } catch (IllegalArgumentException e) {

                e.printStackTrace();
            } catch (InvocationTargetException e) {

                e.printStackTrace();
            } catch (SecurityException e) {

                e.printStackTrace();
            }
        } else {

            System.out.println("OS : ");

            OS[] os = OS.values();

            int index = -1;

            for (int i = 0; i < os.length; i++) {

                System.out.println("Index : " + i + "\t" + os[i].toString());
            }

            index = this.getInt(index, os.length);

            try {

                equipment = (Equipment) c.getConstructors()[0].newInstance(
                        name, description, os[index]);
            } catch (InstantiationException e) {

                e.printStackTrace();
            } catch (IllegalAccessException e) {

                e.printStackTrace();
            } catch (IllegalArgumentException e) {

                e.printStackTrace();
            } catch (InvocationTargetException e) {

                e.printStackTrace();
            } catch (SecurityException e) {

                e.printStackTrace();
            }
        }

        return equipment;
    }

    /**
     * Borrow an equipment from the stock.
     * 
     * @author Dorian LIZARRALDE
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
     * @author Jean-Philippe KHA
     * @param loan
     */
    public void modeAuto(Loan loan) {

        if (user.isAllowedToBorrow(loan, this.getStockController())) {

            if (CalendarController.checkCalendars(loan.getStart(),
                    loan.getEnd())) {

                if (this.getStockController().isAvailable(loan)
                        && CalendarController.differenceDate(loan.getStart(),
                                loan.getEnd()) < this.getStockController()
                                .numberOfDayMaterialCanBeLoaned(loan)) {

                    System.out
                            .println("Your loan has been automatically validated.");

                    this.getStockController().getStock().getLoans().add(loan);

                    System.out.println("Loan added : ");

                    System.out.println(loan.toString());
                } else {

                    System.out
                            .println("Your loan is not valid. You claim to much equipment.");

                    int quantity = this.getStockController()
                            .numberOfMaterialAvailable(loan);

                    System.out.print("You could have claimed " + quantity
                            + loan.getName() + ".");

                    int period = this.getStockController()
                            .numberOfDayMaterialCanBeLoaned(loan);

                    System.out.println("For a period of " + period + " days");

                    GregorianCalendar start = this.getStockController()
                            .dayWhenMaterialIsAvailable(loan);

                    if (start != null) {

                        System.out.println("Or wait until "
                                + CalendarController.calendarToString(start));

                        GregorianCalendar end = this.getStockController()
                                .dayWhenMaterialIsNotAvailable(loan);

                        System.out.print(" to "
                                + CalendarController.calendarToString(end));
                    }
                }
            } else {

                System.out.println("Wrong parameters : \tCalendars.");
            }
        } else {

            System.out.println("You are not allowed to make this loan.");
        }
    }

    /**
     * Display all Intel related to the stock.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public void display() {

        System.out.print(this.getStockController().getStock().toString());
    }

    /**
     * Help.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public void help() {

        System.out.println(this.getUser().help());
    }

    /**
     * Store all Intel related to the stock.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public void store() {

        Data.store(this.getStockController().getStock().getEquipment(), this
                .getLocations().get(0));

        Data.store(this.getStockController().getStock().getLoans(), this
                .getLocations().get(1));

        Data.store(this.getStockController().getStock().getOnHold(), this
                .getLocations().get(2));
    }

    /**
     * Remove an equipment.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public void remove() {

        int index = -1;

        System.out
                .println("Select the equipment to remove. If you don't want to, type '0'.");

        for (int i = 0; i < this.getStockController().getStock().getEquipment()
                .size(); i++) {

            System.out.println("Index : "
                    + (i + 1)
                    + "\t"
                    + this.getStockController().getStock().getEquipment()
                            .get(i).toString());
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

        System.out.println("Equipment removed.");
    }

    /**
     * Repair all broken equipment.
     * 
     * @author Falou SECK
     * 
     */
    public void repair() {

        for (Equipment e : this.getStockController().getStock().getEquipment()) {

            if (e.getState().equals(State.BROKEN)) {

                e.setState(State.FUNCTIONAL);

                e.setNumberOfRepair(e.getNumberOfRepair() + 1);
            }
        }

        System.out.println("Your stock has been repaired.");
    }

    /**
     * Return all the Stats related to the equipment.
     * 
     * @author Falou SECK
     * 
     */
    @SuppressWarnings("unchecked")
    public void stats() {

        System.out.println("Greatest borrower : ");

        if (StatsController.greatestBorrower((List<User>) Data.load(this
                .getLocations().get(3))) != null) {

            System.out.println(StatsController.greatestBorrower(
                    (List<User>) Data.load(this.getLocations().get(3)))
                    .toString());
        }

        System.out.println("Most damaged equipment : ");

        if (StatsController.mostDamagedEquipment(this.getStockController()
                .getStock().getEquipment()) != null) {

            System.out.println(StatsController.mostDamagedEquipment(
                    this.getStockController().getStock().getEquipment())
                    .toString());
        }

        System.out.println("Most loaned equipment : ");

        if (StatsController.mostLoanedEquipment(this.getStockController()
                .getStock().getEquipment()) != null) {

            System.out.println(StatsController.mostLoanedEquipment(
                    this.getStockController().getStock().getEquipment())
                    .toString());
        }
    }

    /**
     * Ask the user to validate the list of loans on hold.
     * 
     * @author Dorian LIZARRALDE
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
