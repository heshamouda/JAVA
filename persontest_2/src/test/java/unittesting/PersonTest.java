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
		
		//given
		int zip= 4000;
		Calendar birthdate = Calendar.getInstance();
		
		//when
		assertThrows(IllegalArgumentException.class,
				()-> new Person(null, zip, birthdate));
		//then
	}
}
