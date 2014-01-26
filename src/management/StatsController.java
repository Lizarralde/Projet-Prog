package management;

import java.util.List;

import user.User;
import equipment.Equipment;

/**
 * Deliver services related to the equipment.
 * 
 * @author Falou SECK
 * 
 */
public class StatsController {

    /**
     * Return the user with the highest number of loans.
     * 
     * @author Falou SECK
     * @param users
     *            A list of users.
     * @return The greatest borrower.
     */
    public static User greatestBorrower(List<User> users) {

        if (!users.isEmpty()) {

            User result = users.get(0);

            for (User u : users) {

                if (result.getNumberOfLoans() < u.getNumberOfLoans()) {

                    result = u;
                }
            }

            return result;
        }

        return null;
    }

    /**
     * Return the equipment with the highest number of repair.
     * 
     * @author Falou SECK
     * @param equipment
     *            A list of equipment.
     * @return The most damaged equipment.
     */
    public static Equipment mostDamagedEquipment(List<Equipment> equipment) {

        if (!equipment.isEmpty()) {

            Equipment result = equipment.get(0);

            for (Equipment e : equipment) {

                if (result.getNumberOfRepair() < e.getNumberOfRepair()) {

                    result = e;
                }
            }

            return result;
        }

        return null;
    }

    /**
     * Return the equipment with the highest number of loans.
     * 
     * @author Falou SECK
     * @param equipment
     *            A list of equipment.
     * @return The most loaned equipment.
     */
    public static Equipment mostLoanedEquipment(List<Equipment> equipment) {

        if (!equipment.isEmpty()) {

            Equipment result = equipment.get(0);

            for (Equipment e : equipment) {

                if (result.getNumberOfLoans() < e.getNumberOfLoans()) {

                    result = e;
                }
            }

            return result;
        }

        return null;
    }
}
