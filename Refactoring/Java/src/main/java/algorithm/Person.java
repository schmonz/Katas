package algorithm;

import java.util.Calendar;

public class Person {
	private long birthTime;
	
	public Person(int year, int monthIndexedFrom1, int dayIndexedFrom1) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, monthIndexedFrom1 - 1);
		cal.set(Calendar.DAY_OF_MONTH, dayIndexedFrom1);
		this.birthTime = cal.getTime().getTime();
	}

	public long getBirthTime() {
		return birthTime;
	}
}

