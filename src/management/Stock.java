package management;

import java.util.ArrayList;
import java.util.List;

import equipment.Equipment;

/**
 * Model of a stock.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Stock {

    // Initial stock.
    private List<Equipment> equipment;

    // Loans and loans on hold.
    private List<Loan> loans, onHold;

    // Getters and setters.
    public List<Equipment> getEquipment() {

        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {

        this.equipment = equipment;
    }

    public List<Loan> getLoans() {

        return loans;
    }

    public void setLoans(List<Loan> loans) {

        this.loans = loans;
    }

    public List<Loan> getOnHold() {

        return onHold;
    }

    public void setOnHold(List<Loan> onHold) {

        this.onHold = onHold;
    }

    /**
     * Default constructor.
     * 
     * @param equipment
     * @param loans
     * @param onHold
     */
    public Stock(List<Equipment> equipment, List<Loan> loans, List<Loan> onHold) {

        this.setEquipment(equipment);
        this.setLoans(loans);
        this.setOnHold(onHold);
    }

    /**
     * Return the list of all different names in the initial stock.
     * 
     * @return
     */
    public List<String> getNames() {

        List<String> names = new ArrayList<String>();

        for (Equipment e : this.getEquipment()) {

            if (!names.contains(e.getName())) {

                names.add(e.getName());
            }
        }

        return names;
    }

    /**
     * Return the quantity of equipment using the name parameter.
     * 
     * @param name
     * @return
     */
    public int getQuantity(String name) {

        int counter = 0;

        for (Equipment e : this.getEquipment()) {

            if (name.equals(e.getName())) {

                counter++;
            }
        }

        return counter;
    }

    @Override
    public String toString() {

        List<String> names = this.getNames();

        String stock = new String();

        stock += "Initial stock : " + System.getProperty("line.separator");

        for (String s : names) {

            stock += "Name : " + s + "\tQuantity : " + this.getQuantity(s)
                    + System.getProperty("line.separator");
        }

        stock += "Loans : " + System.getProperty("line.separator");

        for (Loan l : this.getLoans()) {

            stock += l.toString() + System.getProperty("line.separator");
        }

        stock += "On hold : " + System.getProperty("line.separator");

        for (Loan l : this.getOnHold()) {

            stock += l.toString() + System.getProperty("line.separator");
        }

        return stock;
    }
}
