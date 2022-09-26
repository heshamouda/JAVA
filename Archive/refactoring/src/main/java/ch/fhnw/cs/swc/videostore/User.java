package ch.fhnw.cs.swc.videostore;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the client of a movie store.
 * 
 */
public class User {

    /** Maximum name length. */
    public static final int MAX_NAME_LENGTH = 40;
    /** Maximum age of user. */
    public static final int MAX_USER_AGE = 120;
    /** Exception text: invalid name. */
    public static final String ILLEGAL_NAME = "invalid name value";
    /** Exception text: id of this User has not been set. */
    public static final String NO_ID = "id of this User has not been set";
    /** Exception text: missing name (null value). */
    public static final String MISSING_NAME = "missing name (null value)";
    /** Exception text: illegal change of user's id. */
    public static final String ILLEGAL_ID_CHANGE = "illegal change of user's id";
    /** Invalid date of birth. */
    public static final String ILLEGAL_BIRTHDATE = "illegal birthdate";

    /** Flag indicating whether object has been initialized. */
    private boolean initialized = false;

    /** Unique identification for this user object. */
    private int id;
    /** The user's family name. */
    private String name = "Unnamed";
    /** The user's first name. */
    private String firstName = "Unnamed";
    /** The user's date of birth is used to check age ratings. */
    private LocalDate birthdate;

    /**
     * A list of rentals of the user.
     */
    private List<Rental> rentals = new LinkedList<Rental>();

    /**
     * Create a new user with the given name information.
     * 
     * @param aName the user's family name.
     * @param aFirstName the user's first name.
     * @param aBirthdate the users birthdate, must not be in the future, 
     *        and less than 120 years old, if null, then current date is taken.
     * @throws IllegalArgumentException The name must neither be <code>null</code>.
     * @throws MovieRentalException If the name is empty ("") or longer than MAX_NAME_LENGTH
     *             characters.
     */
    public User(String aName, String aFirstName, LocalDate aBirthdate) {
        setName(aName);
        setFirstName(aFirstName);
        setBirthdate(aBirthdate == null ? LocalDate.now() : aBirthdate);
    }

    /**
     * Checks if name is valid.
     * 
     * @param aName the name of the user.
     */
    private void checkName(String aName) {
        if (aName != null) {
            if ((aName.length() == 0) || (aName.length() > MAX_NAME_LENGTH)) {
                throw new MovieRentalException(ILLEGAL_NAME);
            }
        } else {
            throw new IllegalArgumentException(MISSING_NAME);
        }
    }

    /**
     * @return The user's unique identification number.
     * @throws IllegalStateException when trying to retrieve id before it was set.
     */
    public int getId() {
        if (initialized) {
            return id;
        } else {
            throw new IllegalStateException(NO_ID);
        }
    }

    /**
     * @param anID set the user's unique identification number.
     * @throws IllegalStateException when trying to re-set id.
     */
    public void setId(int anID) {
        if (initialized) {
            throw new IllegalStateException(ILLEGAL_ID_CHANGE);
        } else {
            initialized = true;
            id = anID;
        }
    }

    /**
     * @return get a list of the user's rentals.
     */
    public List<Rental> getRentals() {
        return rentals;
    }

    /**
     * @param someRentals set the user's rentals.
     */
    public void setRentals(List<Rental> someRentals) {
        this.rentals = someRentals;
    }

    /**
     * @return The user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param aName set the user's family name.
     * @throws NullPointerException The name must neither be <code>null</code>.
     * @throws MovieRentalException If the name is emtpy ("") or longer than 40 characters.
     */
    public void setName(String aName) {
        checkName(aName);
        name = aName;
    }

    /**
     * @return get the user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param aFirstName set the user's family name.
     * @throws NullPointerException The first name must not be <code>null</code>.
     * @throws MovieRentalException If the name is emtpy ("") or longer than 40 characters.
     */
    public void setFirstName(String aFirstName) {
        checkName(aFirstName);
        firstName = aFirstName;
    }

    /**
     * @return user's birth date.
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Set a users date of birth.
     * 
     * @param aBirthdate must not be in the future.
     */
    public void setBirthdate(LocalDate aBirthdate) {
    	LocalDate now = LocalDate.now();
    	aBirthdate = aBirthdate == null ? now : aBirthdate;
    	if (now.isBefore(aBirthdate) || now.minusYears(MAX_USER_AGE).isAfter(aBirthdate)) {
    		throw new IllegalArgumentException(ILLEGAL_BIRTHDATE);
    	}
        birthdate = aBirthdate;
    }
    
    @Override
    public boolean equals(Object o) {
        boolean result = this == o;
        if (!result) {
            if (o instanceof User) {
                User other = (User) o;
                result = getId() == other.getId();
                result &= getName().equals(other.getName());
                result &= getFirstName().equals(other.getFirstName());
                result &= getBirthdate().equals(other.getBirthdate());
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = (initialized) ? getId() : 0;
        result = 19 * result + getName().hashCode();
        result = 19 * result + getFirstName().hashCode();
        return result;
    }

    /**
     * check if user has rentals.
     * 
     * @return true if found
     */
    public boolean hasRentals() {
        return !rentals.isEmpty();
    }

    /**
     * add a new rental to the user.
     * 
     * @param rental the rental
     * @return number of rentals of the user
     */
    public int addRental(Rental rental) {
        rentals.add(rental);
        return rentals.size();
    }
    
    public String statement() {

        double totalAmount = 0; 
        int frequentRenterPoints = 0; 

        String result = "Rental Record for " + getName() + "\n"; 

        for(Rental each : rentals) {
            double thisAmount = 0; 
            // determine amounts for each line 
            switch (each.getMovie().getPriceCode()) { 
                case Movie.REGULAR: 
                    thisAmount += 2; 
                    if (each.getDaysRented() > 2) 
                        thisAmount += (each.getDaysRented() - 2) * 1.5; 
                    break; 
                case Movie.NEW_RELEASE: 
                    thisAmount += each.getDaysRented() * 3; 
                    break; 
                case Movie.CHILDRENS: 
                    thisAmount += 1.5; 
                    if (each.getDaysRented() > 3) 
                        thisAmount += (each.getDaysRented() - 3) * 1.5; 
                    break; 
            } 
            // add frequent renter points 
            frequentRenterPoints ++; 
            // add bonus for a two day new release rental 
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&  each.getDaysRented() > 1) frequentRenterPoints ++; 
            // show figures for this rental 
            result += "\t" + each.getMovie().getTitle()+ "\t" + String.valueOf(thisAmount) + "\n"; 
            totalAmount += thisAmount; 
        } 

        // add footer lines 
        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n"; 
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points"; 
        return result; 
    }   

    
}
