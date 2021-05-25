package unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
	
	//given
	private String name = "Miller";
	private int zip = 4000;
	private Calendar birthdate = Calendar.getInstance();	
	
	@Test
	void testValidPerson() {
		
		// when
		Person person = new Person(name, zip, birthdate);

		// then
		assertEquals(name, person.getName());
		assertEquals(zip, person.getZip());
		assertEquals(birthdate, person.getBirthdate());
	}
	
	@Test
	void testInvalidPerson() {
			
		//when
		//test invalid name
		assertThrows(IllegalArgumentException.class,
				()-> new Person(null, zip, birthdate));
		

		//test invalid zip codes
		assertThrows(IllegalArgumentException.class,
				()-> new Person(name, 100, birthdate));
		assertThrows(IllegalArgumentException.class,
				()-> new Person(name, 10000, birthdate));

		//test invalid birthdate
		assertThrows(IllegalArgumentException.class,
				()-> new Person(name, zip, null));		
	}
	
	
}
