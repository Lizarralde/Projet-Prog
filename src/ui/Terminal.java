package ui;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import config.Config;
import data.Data;
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
            List<Loan> onHold, List<User> users) {

        this.setParser(new Parser(new Scanner(System.in)));
        this.setStockController(new StockController(new Stock(equipment, loans,
                onHold)));

        System.out.println("Connection. Format : 'First Name' 'Last Name'");

        this.setUser(this.connect(users));
    }

    public User connect(List<User> users) {

        List<String> words = this.getParser().getInput();

        if (words.size() > 1) {

            for (User u : users) {

                if (u.getFirstName().equalsIgnoreCase(words.get(0))
                        && u.getLastName().equalsIgnoreCase(words.get(1))) {

                    return u;
                }
            }
        }

        return null;
    }

    public void start() {

        if (this.getUser() == null) {

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
                store();
                leave = true;
                break;

            case "remove":
                this.remove();
                break;

            case "validate":
                this.validate();
                break;
            }
        }

        return leave;
    }

    private void store() {

        Data.store(this.getStockController().getStock().getEquipment(),
                "./data/EQUIMENT_LIST.xml");

        Data.store(this.getStockController().getStock().getLoans(),
                "./data/LOANS_LIST.xml");

        Data.store(this.getStockController().getStock().getOnHold(),
                "./data/ON_HOLD_LIST.xml");
    }

    public void add() {

        Object[] classes;

        int index = -1;

        System.out.println("Select your new equipment.");

        try {

            classes = PackageHelper.getInstance()
                    .getClasses("equipment.solid", false, null).toArray();

        } catch (ClassNotFoundException e) {

            System.out.println("No equipment found.");

            return;
        }

        for (int i = 0; i < classes.length; i++) {

            System.out.println("Index : " + i + "\tName : "
                    + ((Class<?>) classes[i]).getSimpleName());
        }

        index = this.getInt(index, classes.length);

        this.getStockController().getStock().getEquipment()
                .add(this.newEquipment((Class<?>) classes[index]));

        System.out.println("Equipment added");
    }

    public Equipment newEquipment(Class<?> c) {

        return null;
    }

    public int getInt(int index, int length) {

        List<String> words = parser.getInput();

        if (!words.isEmpty()) {

            try {

                index = Integer.parseInt(words.get(0));

                if (index >= 0 || index < length) {

                    return index;
                }
            } catch (NumberFormatException e) {

            }
        }

        System.out.println("Incorrect number.");

        return this.getInt(index, length);
    }

    public void borrow() {

        GregorianCalendar end, start;

        Loan loan;

        String name;

        int index = -1;

        int quantity = -1;

        System.out.println("Select your equipment.");

        System.out.println(this.getStockController().getStock().toString());

        index = this.getInt(index, this.getStockController().getStock()
                .getEquipment().size());

        name = this.getStockController().getStock().getNames().get(index);

        System.out.println("Quantity : ");

        quantity = this.getInt(quantity, this.getStockController().getStock()
                .getQuantity(name));

        System.out.println("Start : ");

        start = this.getParser().getCalendar();

        System.out.println("End : ");

        end = this.getParser().getCalendar();

        loan = new Loan(user, name, quantity, start, end);

        if (Config.property.getProperty("Mode").equals("Manual")) {

            this.getStockController().getStock().getOnHold().add(loan);

            System.out.println("Your loan has been put on hold.");
        } else {

            modeAuto(loan);
        }
    }

    public void modeAuto(Loan loan) {

    }

    public void display() {

        System.out.println("Initial stock : ");

        System.out.println(this.getStockController().getStock().toString());

        System.out.println("Loans : ");

        System.out.println(this.getStockController().getStock().getLoans()
                .toString());

        System.out.println("On hold : ");

        System.out.println(this.getStockController().getStock().getOnHold()
                .toString());
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
}
