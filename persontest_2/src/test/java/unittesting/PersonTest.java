package unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

	// given
	private String name = "Miller";
	private int zip = 4000;
	private Calendar birthdate = Calendar.getInstance();
	private Person person;

	@BeforeEach
	void setup() {
		//create person of age 50
		birthdate.add(Calendar.YEAR, -50);
		person = new Person(name, zip, birthdate);
	}

	@Test
	void testValidPerson() {

		// then
		assertEquals(name, person.getName());
		assertEquals(zip, person.getZip());
		assertEquals(birthdate, person.getBirthdate());
	}

	@Test
	void testInvalidPerson() {
		 
		// test invalid name
		assertThrows(IllegalArgumentException.class, () -> new Person(null, zip, birthdate));

		// test invalid zip codes
		assertThrows(IllegalArgumentException.class, () -> new Person(name, 100, birthdate));
		assertThrows(IllegalArgumentException.class, () -> new Person(name, 10000, birthdate));

		// test invalid birthdate
		assertThrows(IllegalArgumentException.class, () -> new Person(name, zip, null));
	}

	@Test
	void testGetAge() {
		assertEquals(50, person.getAge());
		
		Calendar b2 = Calendar.getInstance();
		b2.add(Calendar.YEAR, -1);	
		Person p2 = new Person(name, zip, b2);			
		assertEquals(1, p2.getAge());
	}
}
