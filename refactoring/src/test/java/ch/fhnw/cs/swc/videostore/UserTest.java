/**
 * 
 */
package ch.fhnw.cs.swc.videostore;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class UserTest {

    private static final String NAME = "name";
    private static final String FIRSTNAME = "first name";
    private static final String EMPTYSTRING = "";
    private static final LocalDate DEFAULT_BIRTHDATE = null;

    private Rental rental0;
	private Rental rental1;
	private Rental rental2;
	private Rental rental3;
	private Rental rental4;

	@BeforeAll
	static void setup() {

		System.out.println("Welcome to the video store");

	}

	@BeforeEach
	void initialize(){
		Movie movie0 = new MovieImpl("Lost in Java", Movie.NEW_RELEASE);
		Movie movie1 = new MovieImpl("Pipi Spaghetticode", Movie.CHILDRENS);
		Movie movie2 = new MovieImpl("Telefonbuch Tokyo", Movie.REGULAR);

		rental0 = new Rental(movie0,1);
		rental1 = new Rental(movie1,2);
		rental2 = new Rental(movie2,3);
		rental3 = new Rental(movie0,7);
		rental4 = new Rental(movie1,14);

	}



	@Test
	void testMoni(){
        String surname = "Harris";
        String refStr = "Rental Record for " + surname  
                + "\n\tLost in Java\t3.0\n" +
				"Amount owed is 3.0\nYou earned 1 frequent renter points";

        User user = new User(surname, FIRSTNAME, DEFAULT_BIRTHDATE);
		user.addRental(rental0);

		assertAndPrint(refStr, user.statement(), user.getName());
	}

	@Test
	void testMiller(){
	    String surname = "Miller";
		String refStr = "Rental Record for " + surname  
		        + "\n\tPipi Spaghetticode\t1.5\n" 
		        + "\tTelefonbuch Tokyo\t3.5\n\tLost in Java\t21.0\n" +
				"Amount owed is 26.0\nYou earned 4 frequent renter points";

        User user = new User(surname, FIRSTNAME, DEFAULT_BIRTHDATE);
		user.addRental(rental1);
		user.addRental(rental2);
		user.addRental(rental3);

		assertAndPrint(refStr, user.statement(), user.getName());

	}

	@Test
	void testHeike(){
        String surname = "Jones";
        String refStr = "Rental Record for " + surname  
		        + "\n\tPipi Spaghetticode\t18.0\n" 
                + "\tPipi Spaghetticode\t1.5\n\tTelefonbuch Tokyo\t3.5\n\t" +
				"Lost in Java\t21.0\n\tPipi Spaghetticode\t18.0\n" +
				"Amount owed is 62.0\nYou earned 6 frequent renter points";


        User user = new User(surname, FIRSTNAME, DEFAULT_BIRTHDATE);
		user.addRental(rental4);
		user.addRental(rental1);
		user.addRental(rental2);
		user.addRental(rental3);
		user.addRental(rental4);


		assertAndPrint(refStr, user.statement(), user.getName());

	}

	private void assertAndPrint(String refStr, String result, String name) {
		System.out.println("---------------------");
		System.out.println(result);
		assertEquals(refStr, result, "CustomerTest failed using customer" + name);
		System.out.println("CustomerTest using customer" + name + " passed!");
	}

	@AfterAll
	static void printBye(){
		System.out.println("---------------------");
		System.out.println("... bye bye");
	}

}
