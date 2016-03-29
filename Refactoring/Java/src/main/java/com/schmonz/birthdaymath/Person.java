package com.schmonz.birthdaymath;

import java.util.GregorianCalendar;

public class Person {
	private long birthTime;

	public Person(int year, int monthIndexedFrom1, int dayIndexedFrom1) {
		this.birthTime = new GregorianCalendar(year, monthIndexedFrom1 - 1, dayIndexedFrom1).getTimeInMillis();
	}

	public long getBirthTime() {
		return birthTime;
	}
}
