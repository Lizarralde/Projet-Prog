package user;

import java.util.List;

import management.Loan;
import management.StockController;
import ui.Terminal;

/**
 * Model of a user.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class User {

    // First name.
    private String firstName;

    // Last name.
    private String lastName;

    private int numberOfLoans;

    // Getters and setters.
    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public int getNumberOfLoans() {

        return numberOfLoans;
    }

    public void setNumberOfLoans(int numberOfLoans) {

        this.numberOfLoans = numberOfLoans;
    }

    /**
     * Default constructor.
     * 
     * @author Dorian LIZARRALDE
     * @param firstName
     * @param lastName
     */
    public User(String firstName, String lastName) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setNumberOfLoans(0);
    }

    /**
     * Process using the user input.
     * 
     * @author Dorian LIZARRALDE
     * @param words
     * @return
     */
    public boolean processCommand(Terminal terminal, List<String> words) {

        boolean leave = false;

        if (!words.isEmpty()) {

            switch (words.get(0)) {

            case "borrow":
                terminal.borrow();
                break;

            case "help":
                terminal.help();
                break;

            case "leave":
                terminal.store();
                leave = true;
                break;
            }
        }

        return leave;
    }

    /**
     * Help.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public String help() {

        return "Your command words are : borrow, help, leave";
    }

    /**
     * Return if a user is allowed to borrow using the loan parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param stockController
     * @return
     */
    public boolean isAllowedToBorrow(Loan loan, StockController stockController) {

        return false;
    }

    @Override
    public String toString() {

        return this.getFirstName() + " " + this.getLastName();
    }
}
