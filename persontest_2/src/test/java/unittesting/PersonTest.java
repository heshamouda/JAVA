package unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testPerson() {

		// given
		String name = "Miller";
		int zip = 4000;
		Calendar birthdate = Calendar.getInstance();

		// when
		Person person = new Person(name, zip, birthdate);

		// then
		assertEquals(name, person.getName());
		assertEquals(zip, person.getZip());
		assertEquals(birthdate, person.getBirthdate());
	}
}
