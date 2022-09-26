package unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {

	// given
	private final static String VALID_NAME = "Miller";
	private final static int VALID_ZIP = 4000;

	// birthdate should not be static
	private final Calendar VALID_BIRTHDATE = Calendar.getInstance();
	private final static int AGE = 15;
	private Person person = null;

	@BeforeEach
	void setup() {
		// create person of AGE
		VALID_BIRTHDATE.add(Calendar.YEAR, -AGE);
		person = new Person(VALID_NAME, VALID_ZIP, VALID_BIRTHDATE);
	}

	@Test
	void testValidPersonData() {
		// then
		assertEquals(VALID_NAME, person.getName());
		assertEquals(VALID_ZIP, person.getZip());
		assertEquals(VALID_BIRTHDATE, person.getBirthdate());
	}

	@Test
	void testGetAge() {
		assertEquals(AGE, person.getAge());

		Calendar b2 = Calendar.getInstance();
		b2.add(Calendar.YEAR, -1);
		Person p2 = new Person(VALID_NAME, VALID_ZIP, b2);
		assertNotEquals(1, p2.getAge());
	}

	@ParameterizedTest
	@ValueSource(ints = { Person.MIN_NAME_LEN, (Person.MIN_NAME_LEN + Person.MAX_NAME_LEN) / 2, Person.MAX_NAME_LEN })
	void testPersonConstrWithValidName(int len) {
		// test name
		var name = StringUtils.repeat("a", len);
		person = new Person(name, VALID_ZIP, VALID_BIRTHDATE);
		assertEquals(name, person.getName());
	}

	@ParameterizedTest
	@ValueSource(ints = { Person.MIN_NAME_LEN - 1, (Person.MIN_NAME_LEN * Person.MAX_NAME_LEN) * 2,
			Person.MAX_NAME_LEN + 1, Person.MAX_NAME_LEN + 100 })
	void testPersonConstrWithInvalidName(int len) {
		// test invalid name
		var name = StringUtils.repeat("a", len);
		assertThrows(IllegalArgumentException.class, () -> new Person(name, VALID_ZIP, VALID_BIRTHDATE));

	}

	@Test
	void testPersonCondtrWithNullName() {
		// test invalid name: for null or empty name
		Throwable result = assertThrows(IllegalArgumentException.class,
				() -> new Person(null, VALID_ZIP, VALID_BIRTHDATE));
		assertEquals(Person.EXC_MSG_ILLEGAL_NAME, result.getMessage());
	}

	@ParameterizedTest
	@ValueSource(ints = { Person.MIN_ZIP, Person.MIN_ZIP + 1, (Person.MIN_ZIP + Person.MAX_ZIP) / 2, Person.MAX_ZIP - 1,
			Person.MAX_ZIP })
	void testPersonConstrWithValidZip(int zip) {
		// test zip code values
		person = new Person(VALID_NAME, zip, VALID_BIRTHDATE);
		assertEquals(zip, person.getZip());
	}

	@ParameterizedTest
	@ValueSource(ints = { Person.MIN_ZIP - 1, Person.MIN_ZIP - 1000, (-Person.MIN_ZIP - Person.MAX_ZIP) / 2,
			Person.MAX_ZIP + 1, Person.MAX_ZIP + 1000 })
	void testPersonConstrWithInvalidZip(int zip) {
		// test zip code
		assertThrows(IllegalArgumentException.class, () -> new Person(VALID_NAME, zip, VALID_BIRTHDATE));
	}

	@ParameterizedTest
	@MethodSource("createValidBirthdates")
	void testPersonConstrWithValidBirthdate(Calendar birthdate) {
		// test birthdate
		person = new Person(VALID_NAME, VALID_ZIP, birthdate);
		assertEquals(birthdate, person.getBirthdate());
	}

	static Stream<Arguments> createValidBirthdates() {
		var now = Calendar.getInstance();
		var dayBefore = (Calendar) now.clone();
		dayBefore.add(Calendar.DAY_OF_YEAR, -1);
		var adultPerson = (Calendar) now.clone();
		adultPerson.add(Calendar.YEAR, -23);

		return Stream.of(Arguments.of(now), Arguments.of(dayBefore), Arguments.of(adultPerson));
	}

	@ParameterizedTest
	@NullSource
	@MethodSource("createInvalidBirthdates")
	void testPersonConstrWithInvalidBirthdate(Calendar birthdate) {
		// test birthdate
		assertThrows(IllegalArgumentException.class, () -> new Person(VALID_NAME, VALID_ZIP, birthdate));
	}

	static Stream<Arguments> createInvalidBirthdates() {
		var now = Calendar.getInstance();
		var dayAfter = (Calendar) now.clone();
		dayAfter.add(Calendar.DAY_OF_YEAR, 1);
		var dayInTheFuture = (Calendar) now.clone();
		dayInTheFuture.add(Calendar.YEAR, 23);

		return Stream.of(Arguments.of(dayAfter), Arguments.of(dayInTheFuture));
	}

	@Test
	void testPersonWithInvalidBirthdate() {
		// test invalid birthdate
		assertThrows(IllegalArgumentException.class, () -> new Person(VALID_NAME, VALID_ZIP, null));
		Calendar future = Calendar.getInstance();
		future.add(Calendar.YEAR, 10);
		assertThrows(IllegalArgumentException.class, () -> new Person(VALID_NAME, VALID_ZIP, future));
	}

	/**
	 * Test that the constructor encapsulates the passed reference data "birthdate".
	 * That means that it creates a clone of birthdate.
	 */
	@Test
	void testImmutableConstructor() {
		Calendar birtdate = Calendar.getInstance();

		// now change the local birthdate, this should not modify the birthdate.
		// stored in the person instance
		birtdate.add(Calendar.YEAR, -10);

		// since we changed the local birthdate, this must NOT be equal to
		// the birthdate of the constructor
		assertNotEquals(person.getBirthdate(), birtdate);
	}

	/**
	 * This method tests if the getBirthdate encapsulates returned birthdate field
	 * To provide encapsulation, it must return a clone not a reference to the
	 * internal birthdate field.
	 */
	@Test
	void testImmutableGetbirthdate() {

		Calendar birthdate = person.getBirthdate();

		// now changes the local birthdate, if getMethod returns a clone,
		// this should not modify the birthdate stored in the person instance.
		birthdate.add(Calendar.YEAR, -10);

		// the birthdate in the person must still be unchanged.
		assertNotEquals(birthdate, person.getBirthdate());
	}
}
