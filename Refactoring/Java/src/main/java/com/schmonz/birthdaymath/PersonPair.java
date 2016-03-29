package com.schmonz.birthdaymath;

import java.util.ArrayList;
import java.util.List;

public class PersonPair {
	private List<Person> people;

	public PersonPair() {
	}

	public PersonPair(Person aPerson, Person anotherPerson) {
		people = new ArrayList<Person>();
		people.add(aPerson);
		people.add(anotherPerson);
	}

	public long getDateDifference() {
		return Math.abs(people.get(0).getBirthTime() - people.get(1).getBirthTime());
	}

	public List<Person> getPeople() {
		return people;
	}
}
