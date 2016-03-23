package com.schmonz.birthdaymath.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.schmonz.birthdaymath.Person;
import com.schmonz.birthdaymath.PersonBirthdateDistanceFinder;
import com.schmonz.birthdaymath.PersonList;
import com.schmonz.birthdaymath.PersonPair;

public class PersonBirthdateDistanceFinderTests {

	private Person oldest, secondOldest, youngest, secondYoungest;

	@Before
	public void setup() {
		oldest = new Person(1950, 1, 1);
		secondOldest = new Person(1952, 6, 1);
		youngest = new Person(1982, 1, 1);
		secondYoungest = new Person(1979, 1, 1);
	}

	@Test
	public void emptyListGivesEmptyResults() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList());
		PersonPair pairOfPersons = finder.findClosest();
		assertHasTheseTwoPeople(pairOfPersons, null, null);
	}

	@Test
	public void onePersonGivesEmptyResults() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(oldest));
		PersonPair pairOfPersons = finder.findClosest();
		assertHasTheseTwoPeople(pairOfPersons, null, null);
	}

	@Test
	public void twoPeopleGivesClosestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(oldest, secondOldest));
		PersonPair pairOfPersons = finder.findClosest();
		assertHasTheseTwoPeople(pairOfPersons, oldest, secondOldest);
	}

	@Test
	public void twoPeopleGivesFurthestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(secondYoungest, secondOldest));
		PersonPair pairOfPersons = finder.findFurthest();
		assertHasTheseTwoPeople(pairOfPersons, secondOldest, secondYoungest);
	}

	@Test
	public void fourPeopleGivesFurthestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(
				new PersonList(oldest, youngest, secondYoungest, secondOldest));
		PersonPair pairOfPersons = finder.findFurthest();
		assertHasTheseTwoPeople(pairOfPersons, oldest, youngest);
	}

	@Test
	public void fourPeopleGivesClosestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(
				new PersonList(oldest, youngest, secondYoungest, secondOldest));
		PersonPair pairOfPersons = finder.findClosest();
		assertHasTheseTwoPeople(pairOfPersons, oldest, secondOldest);
	}

	private void assertHasTheseTwoPeople(PersonPair pairOfPersons, Person a, Person b) {
		assertEquals(a, pairOfPersons.getOlder());
		assertEquals(b, pairOfPersons.getSameOrYounger());
	}
}
