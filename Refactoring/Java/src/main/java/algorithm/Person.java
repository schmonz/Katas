package algorithm;

import java.util.Calendar;
import java.util.Date;

public class Person {
	private Date birthDate;
	
	public Person(int year, int monthIndexedFrom1, int dayIndexedFrom1) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, monthIndexedFrom1 - 1);
		cal.set(Calendar.DAY_OF_MONTH, dayIndexedFrom1);
		this.birthDate = cal.getTime();
	}

	public Date getBirthDate() {
		return birthDate;
	}
}

