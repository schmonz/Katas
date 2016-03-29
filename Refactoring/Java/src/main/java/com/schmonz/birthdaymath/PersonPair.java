package com.schmonz.birthdaymath;

import java.util.ArrayList;
import java.util.List;

public class PersonPair {
	private Person older;
	private Person sameOrYounger;
	private long millisecondsBetweenBirthDates;

	public PersonPair() {
	}

	public PersonPair(Person aPerson, Person anotherPerson) {
		if (aPerson.getBirthTime() < anotherPerson.getBirthTime()) {
			this.older = aPerson;
			this.sameOrYounger = anotherPerson;
		} else {
			this.older = anotherPerson;
			this.sameOrYounger = aPerson;
		}
		this.millisecondsBetweenBirthDates = this.sameOrYounger.getBirthTime() - this.older.getBirthTime();
	}

	public long getDateDifference() {
		return millisecondsBetweenBirthDates;
	}

	public List<Person> getPeople() {
		List<Person> people = new ArrayList<Person>();
		people.add(older);
		people.add(sameOrYounger);
		return people;
	}
}
