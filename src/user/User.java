package user;

import java.util.GregorianCalendar;

import management.Reservation;

import material.MaterialQuantity;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class User {

    private String name;

    private String forname;
    
    private int numberOfLoan;

    /**
     * Default constructor.
     * 
     * @author Dorian LIZARRALDE
     * @param name
     *            Name of the user.
     * @param forname
     *            Forname of the user.
     */
    public User(String name, String forname) {

        this.name = name;
        this.forname = forname;
        this.numberOfLoan=0;
    }

    /**
     * Return the name of the user.
     * 
     * @author Dorian LIZARRALDE
     * @return
     */
    public String getName() {

        return name;
    }

    /**
     * Set the name of the user.
     * 
     * @author Dorian LIZARRALDE
     * @param name
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Return the forname of the user.
     * 
     * @author Dorian LIZARRALDE
     * @return
     */
    public String getForname() {

        return forname;
    }

    /**
     * Set the forname of the user.
     * 
     * @author Dorian LIZARRALDE
     * @param forname
     */
    public void setForname(String forname) {

        this.forname = forname;
    }

    @Override
    public String toString() {

        return getName() + " " + getForname();
    }

    /**
     * Create the reservation associate to the user indacations. Some rules can
     * apply on the validation of a reservation. A user who is not identified
     * can't do a reservation.
     * 
     * @author Dorian LIZARRALDE
     * @param mat
     * @param startDate
     * @param endDate
     * @return
     */
    public Reservation doReserve(MaterialQuantity mat,
            GregorianCalendar startDate, GregorianCalendar endDate) {

        return null;
    }

    /**
     * @return the numberOfLoan
     */
    public int getNumberOfLoan() {
        return numberOfLoan;
    }

    /**
     * @param numberOfLoan the numberOfLoan to set
     */
    public void setNumberOfLoan(int numberOfLoan) {
        this.numberOfLoan = numberOfLoan;
    }
}
