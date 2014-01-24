package management;

import java.util.ArrayList;
import java.util.List;

import equipment.Equipment;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Stock {

    private List<Equipment> equipment;

    private List<Loan> loans, onHold;

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

    public Stock(List<Equipment> equipment, List<Loan> loans, List<Loan> onHold) {

        this.setEquipment(equipment);
        this.setLoans(loans);
        this.setOnHold(onHold);
    }

    public List<String> getNames() {

        List<String> names = new ArrayList<String>();

        for (Equipment e : this.getEquipment()) {

            if (!names.contains(e.getName())) {

                names.add(e.getName());
            }
        }

        return names;
    }

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

        for (int i = 0; i < names.size(); i++) {

            stock += "Index : " + i + "\tName : " + names.get(i)
                    + "\tQuantity : " + this.getQuantity(names.get(i))
                    + System.getProperty("line.separator");
        }

        return stock;
    }
}
