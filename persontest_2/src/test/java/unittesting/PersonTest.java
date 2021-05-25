package unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

	// given
	private final static String VALID_NAME = "Miller";
	private final static int VALID_ZIP = 4000;
	private final Calendar VALID_BIRTHDATE = Calendar.getInstance();
	private Person person;

	@BeforeEach
	void setup() {
		//create person of age 50
		VALID_BIRTHDATE.add(Calendar.YEAR, -50);
		person = new Person(VALID_NAME, VALID_ZIP, VALID_BIRTHDATE);
	}

	@Test
	void testValidPerson() {

		// then
		assertEquals(VALID_NAME, person.getName());
		assertEquals(VALID_ZIP, person.getZip());
		assertEquals(VALID_BIRTHDATE, person.getBirthdate());
	}

	@Test
	void testInvalidPerson() {
		 
		// test invalid name
		assertThrows(IllegalArgumentException.class, () -> new Person(null, VALID_ZIP, VALID_BIRTHDATE));

		// test invalid zip codes
		assertThrows(IllegalArgumentException.class, () -> new Person(VALID_NAME, 100, VALID_BIRTHDATE));
		assertThrows(IllegalArgumentException.class, () -> new Person(VALID_NAME, 10000, VALID_BIRTHDATE));

		// test invalid birthdate
		assertThrows(IllegalArgumentException.class, () -> new Person(VALID_NAME, VALID_ZIP, null));
	}

	@Test
	void testGetAge() {
		assertEquals(50, person.getAge());
		
		Calendar b2 = Calendar.getInstance();
		b2.add(Calendar.YEAR, -1);	
		Person p2 = new Person(VALID_NAME, VALID_ZIP, b2);			
		assertEquals(1, p2.getAge());
	}
}
