package algorithm;

import java.util.Calendar;
import java.util.Date;

public class Person {
	private Date birthDate;
	
	public Person(int yearsSince1900, int monthIndexedFrom0, int dayIndexedFrom1) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1900 + yearsSince1900);
		cal.set(Calendar.MONTH, monthIndexedFrom0);
		cal.set(Calendar.DAY_OF_MONTH, dayIndexedFrom1);
		this.birthDate = cal.getTime();
	}

	public Date getBirthDate() {
		return birthDate;
	}
}

