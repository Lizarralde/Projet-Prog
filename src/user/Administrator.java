package user;

import java.util.GregorianCalendar;
import java.util.List;

import management.CalendarController;
import management.Loan;
import management.StockController;
import ui.Terminal;

/**
 * Model of an administrator.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Administrator extends User {

    /**
     * Default constructor.
     * 
     * @author Dorian LIZARRALDE
     * @param firstName
     * @param lastName
     */
    public Administrator(String firstName, String lastName) {

        super(firstName, lastName);
    }

    public boolean processCommand(Terminal terminal, List<String> words) {

        boolean leave = false;

        leave = super.processCommand(terminal, words);

        if (!words.isEmpty()) {

            switch (words.get(0)) {

            case "add":
                terminal.add();
                break;

            case "display":
                terminal.display();
                break;

            case "remove":
                terminal.remove();
                break;

            case "repair":
                terminal.repair();
                break;

            case "stats":
                terminal.stats();
                break;

            case "validate":
                terminal.validate();
                break;
            }
        }

        return leave;
    }

    @Override
    public String help() {

        return "Your command words are : add, borrow, display, help, leave, remove, repair, stats, validate";
    }

    @Override
    public boolean isAllowedToBorrow(Loan loan, StockController stockController) {

        if (stockController.numberOfLoans(this) < 7) {

            if (loan.getQuantity() < 25) {

                if (CalendarController.differenceDate(loan.getStart(),
                        loan.getEnd()) < 15) {

                    if (CalendarController.differenceDate(
                            new GregorianCalendar(), loan.getStart()) < 15) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {

        return super.toString() + "\tAdministrator";
    }
}
