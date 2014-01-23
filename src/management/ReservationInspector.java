package management;

import java.util.Calendar;
import java.util.GregorianCalendar;

import material.MaterialQuantity;
import user.Student;
import user.User;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class ReservationInspector {

	private Stock stock;
	private static final int MATERIAL_QUANTITY = 5;
	public ReservationInspector(Stock stock) {

		this.stock = stock;
	}

	/**
	 * Create the reservation asked
	 * 
	 * @author Fabien Pinel
	 * @param user
	 * @param mat
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Reservation doReserve(User user, MaterialQuantity mat,
			GregorianCalendar startDate, GregorianCalendar endDate) {

		return user.doReserve(mat, startDate, endDate);
	}


	/**
	 * This method looks if the materiel specified is available for a given
	 * period.
	 * 
	 * @author Fabien Pinel
	 * @param mat
	 *            the material that want to be reserved
	 * @param startDate
	 *            the beginning of the emprunt
	 * @param endDate
	 *            the end of the emprunt
	 * @return true if the material is available during this period false in
	 *         other cases
	 */
	public boolean isAvailable(MaterialQuantity mat, int quantity,
		GregorianCalendar startDate, GregorianCalendar endDate) {
		GregorianCalendar day = new GregorianCalendar();
		day.setTimeInMillis(startDate.getTimeInMillis());
		while (day.compareTo(endDate) <= 0) {
			if (!isAvailableForThisDay(mat, quantity, day)) {
				return false;
			}
			day.add(Calendar.DAY_OF_YEAR, 1);
		}
		return true;
	}

	/**
	 * This method looks if a certain quantity of material is available for a
	 * given date. It's private because only use by isAvailable
	 * 
	 * @author Fabien Pinel
	 * @param materialList
	 *            A list of material
	 * @param startDate
	 *            the beginning of the emprunt period
	 * @param endDate
	 *            the end of the emprunt period
	 * @return
	 */
	private boolean isAvailableForThisDay(MaterialQuantity mat, int quantity,
			GregorianCalendar day) {

		int quantityAvailable = mat.getQuantity();
		for (Reservation reserv : stock.getReservList()) {
			if (reserv.getMaterialQuantity().getMat().equals(mat.getMat())) {
				if (day.compareTo(reserv.getStartDate()) >= 0
						&& day.compareTo(reserv.getEndDate()) <= 0) {
					// day is in the emprunt time
					quantityAvailable -= reserv.getMaterialQuantity()
							.getQuantity();
				}
			}
		}
		return (quantityAvailable >= quantity);
	}

	/**
	 * This method looks when a certain quantity of material is not available.
	 * @ Jean-Philippe Kha
	 * @param mat
	 * @param quantity
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public GregorianCalendar dayWhenMaterialIsNotAvailable(MaterialQuantity mat, int quantity,
			GregorianCalendar startDate, GregorianCalendar endDate){
			GregorianCalendar day = new GregorianCalendar();
			day.setTimeInMillis(startDate.getTimeInMillis());
			while (day.compareTo(endDate) <= 0) {
				if (!isAvailableForThisDay(mat, quantity, day)) {
					day.add(Calendar.DAY_OF_YEAR, -1);
					return day;
				}
				day.add(Calendar.DAY_OF_YEAR, 1);
			}
			return null;
	}
	
	
	/**
	 * This method looks when a certain quantity of material is available.
	 * @ Jean-Philippe Kha
	 * @param mat
	 * @param quantity
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public GregorianCalendar dayWhenMaterialIsAvailable(MaterialQuantity mat, int quantity,
		GregorianCalendar startDate, GregorianCalendar endDate){
			GregorianCalendar day = new GregorianCalendar();
			day.setTimeInMillis(startDate.getTimeInMillis());
			while (day.compareTo(endDate) <= 0) {
				if (isAvailableForThisDay(mat, quantity, day)) {
					//day.add(Calendar.DAY_OF_YEAR, -1);
					return day;
				}
				day.add(Calendar.DAY_OF_YEAR, 1);
			}
			return null;
	}
	
	/**
	 * This method looks if the number of materiel specified is available for a given
	 * period. If the materiel is avaible, return -1. Else, return the number of material available
	 * @author Jean-Philippe Kha
	 * @param mat
	 * @param quantity
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int numberOfMaterialAvailable( MaterialQuantity mat, int quantity,
		GregorianCalendar startDate, GregorianCalendar endDate){
		int minQuantity = -1;
		GregorianCalendar day = new GregorianCalendar();
		day.setTimeInMillis(startDate.getTimeInMillis());
		while (day.compareTo(endDate) <= 0) {
			if (theNumberOfMaterialIsAvailableForThisDay(mat,day)< quantity) {
				minQuantity = theNumberOfMaterialIsAvailableForThisDay(mat,day);
			}
			day.add(Calendar.DAY_OF_YEAR, 1);
		}
		return minQuantity;	
	}

/**
 * This method looks if a certain quantity of material is available for a
 * given date. It's private because only use by numberOfMaterialAvailable
 * @author Jean-Philippe Kha
 * @param mat
 * @param day
 * @return
 */
	private int theNumberOfMaterialIsAvailableForThisDay(MaterialQuantity mat, GregorianCalendar day) {

		int quantityAvailable = mat.getQuantity();
		for (Reservation reserv : stock.getReservList()) {
			if (reserv.getMaterialQuantity().getMat().equals(mat.getMat())) {
				if (day.compareTo(reserv.getStartDate()) >= 0
						&& day.compareTo(reserv.getEndDate()) <= 0) {
					// day is in the emprunt time
					quantityAvailable -= reserv.getMaterialQuantity()
							.getQuantity();
				}
			}
		}
		return quantityAvailable;
	}
	
	/**
	 * This method return the number of day which a person could loan
	 * @author Jean-Philippe Kha
	 * @param mat
	 * @param quantity
	 * @return
	 */
	public int numberOfDayMaterialCanBeLoaned(MaterialQuantity mat, int quantity){
		int quantityAvailable = mat.getQuantity();
		int value = mat.getMat().getObjectValue();
		if( quantityAvailable - quantity >= MATERIAL_QUANTITY){
			return MATERIAL_QUANTITY*value;
		}
		//la fonction sera appele si la quantite est inferieur a la quantite de materiel disponible
		return quantity*value;
	}
	
	/**
	 * This method looks if the student respect rules
	 * @author Jean-Philippe Kha
	 * @param student
	 * @param mat
	 * @param quantity
	 * @return
	 */
	public boolean alreadyHaveThisMaterial(Student student,MaterialQuantity mat){
		for (Reservation reserv : stock.getReservList()) {
			if (reserv.getMaterialQuantity().getMat().equals(mat.getMat())) {
				if(reserv.getUser().equals(student)){
					return true;
				}
			}
		}
		return false;
	}
}

