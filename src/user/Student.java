package user;

import java.util.GregorianCalendar;

import management.Reservation;
import management.ReservationInspector;
import material.MaterialQuantity;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Student extends User {

	private String year;
	private ReservationInspector inspector;

	/**
	 * Default constructor.
	 * 
	 * @author Dorian LIZARRALDE
	 * @param name
	 *            Name of the student.
	 * @param forname
	 *            Forname of the student.
	 * @param year
	 *            Year of the student.
	 */
	public Student(String name, String forname, String year) {

		super(name, forname);

		this.year = year;
	}

	/**
	 * Return the year of the student.
	 * 
	 * @author Dorian LIZARRALDE
	 * @return
	 */
	public String getYear() {

		return year;
	}

	/**
	 * Set the year of the student.
	 * 
	 * @author Dorian LIZARRALDE
	 * @param year
	 */
	public void setYear(String year) {

		this.year = year;
	}

	@Override
	public Reservation doReserve(MaterialQuantity mat,
			GregorianCalendar startDate, GregorianCalendar endDate) {

		if(mat.getQuantity()>1){
			System.out.println("You are a student, you can't loan more than 1 material");
			return null;
		}

		GregorianCalendar today = new GregorianCalendar();
		if(!inspector.alreadyHaveThisMaterial(this, mat)){


			// A student can't make a reservation 7 days ahead.
			if (((startDate.getTimeInMillis() - today.getTimeInMillis()) / (1000 * 60 * 60 * 24)) < 7) {

				// A student can't make a reservation of more than 7 days.
				if (((endDate.getTimeInMillis() - startDate.getTimeInMillis()) / (1000 * 60 * 60 * 24)) < 7) {

					return new Reservation(this, mat, startDate, endDate);
				}
			}
		}
		return null;
	}
}
