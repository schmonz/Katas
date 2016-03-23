package com.schmonz.birthdaymath;

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

	public Person getOlder() {
		return older;
	}

	public Person getSameOrYounger() {
		return sameOrYounger;
	}
}
