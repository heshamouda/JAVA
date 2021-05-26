package unittesting;

import java.util.Calendar;

public class Employee extends Person{
private Calendar startDate;
private Double salary;
private String department;

/**
 * A person is characterized by his/her name, postal code and birth date.
 * @param name Name of person, must not be null nor empty nor longer than 30 characters.
 * @param zip valid Swiss postal code (1000 <= zip <= 9999).
 * @param birthdate a birth date, must not be null, must not be in the future.
 * @param startDate must be later than the birthdate of a person
 * @param monthly salary must be bigger than zero
 * @param department cannot be empty or NULL
 * @throws java.lang.IllegalArgumentException
 */
public Employee  (String name, int zip, Calendar birthdate, Calendar startDate ,Double salary, String department) {
	  super (name, zip, birthdate);
	  
	  
	  //Salary must be bigger than zero
	  
	  //startDate must be later than birthdate
	  
	  //department cannot be Empty or NULL
	  
    }
    public double getSalary() { return salary; }
    public Calendar getStartDate() { return (Calendar)startDate.clone(); }
    public String getDepartment() { return department; }

}
