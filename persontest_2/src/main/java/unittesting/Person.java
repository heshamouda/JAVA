package unittesting;

import java.util.Calendar;

public class Person {
	private String name;
	private int zip;
	private final Calendar birthdate;

	public static final String EXC_MSG_ILLEGAL_NAME = "illegal name";
	public static final String EXC_MSG_ILLEGAL_ZIP = "illegal ZIP code";
	public static final String EXC_MSG_ILLEGAL_BIRTHDATE = "illegal birthdate";

	/**
	 * A person is distinguished by his/her name, postal code and birth date.
	 * 
	 * @param name      Name of person, must not be null nor empty nor longer than
	 *                  30 characters.
	 * @param zip       valid Swiss postal code (1000 <= zip <= 9999).
	 * @param birthdate a birth date, must not be null, must not be in the future.
	 * @throws java.lang.IllegalArgumentException
	 */
	public Person(String name, int zip, Calendar birthdate) {
		if (name == null || name.length() <= 1 || name.length() >= 30) {
			throw new IllegalArgumentException(EXC_MSG_ILLEGAL_NAME);
		}
		if (zip < 1000 || zip > 9999) {
			throw new IllegalArgumentException(EXC_MSG_ILLEGAL_ZIP);
		} // birthdate not be null , nor in the future
		if (birthdate == null || birthdate.after(Calendar.getInstance())) {

			throw new IllegalArgumentException(EXC_MSG_ILLEGAL_BIRTHDATE);
		}

		this.name = name;
		this.zip = zip;

		// make the birthdate immutable
		this.birthdate = (Calendar) birthdate.clone();
	}

	/**
	 * @return the person's name. Never null nor empty.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the postal code of the persons residence, valid Swiss postal code.
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * @return the person's birth date, never null, not in the future.
	 */
	public Calendar getBirthdate() {
		return (Calendar) birthdate.clone();
	}

	/**
	 * @return the person's age, never negative
	 */
	public int getAge() {
		Calendar today = Calendar.getInstance();
		//to correctly calculate age when birthday has not been yet celebrated
		int factor = 0; 

		// check if birthday has been celebrated this year
		if(today.get(Calendar.DAY_OF_YEAR) < birthdate.get(Calendar.DAY_OF_YEAR)) {
			factor = -1; //birthday not celebrated
		}
		return today.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR) + factor;
	}
}