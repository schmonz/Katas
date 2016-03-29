package com.schmonz.birthdaymath;

import java.util.GregorianCalendar;

public class Person {
	private long birthTime;

	public Person(GregorianCalendar gregorianCalendar) {
		this.birthTime = gregorianCalendar.getTimeInMillis();
	}

	public long getBirthTime() {
		return birthTime;
	}
}
