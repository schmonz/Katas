package com.schmonz.birthdaymath.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.schmonz.birthdaymath.BirthdateDistance;
import com.schmonz.birthdaymath.Person;
import com.schmonz.birthdaymath.PersonList;
import com.schmonz.birthdaymath.PersonPair;

public class BirthdateDistanceTests {

	private Person oldest, secondOldest, secondYoungest, youngest;

	@Before
	public void setup() {
		oldest = new Person(1950, 1, 1);
		secondOldest = new Person(1952, 6, 1);
		secondYoungest = new Person(1979, 1, 1);
		youngest = new Person(1982, 1, 1);
	}

	@Test
	public void emptyListGivesEmptyResults() {
		PersonPair pairOfPersons = new BirthdateDistance(new PersonList()).findClosest();
		assertHasTheseTwoPeople(pairOfPersons, null, null);
	}

	@Test
	public void onePersonGivesEmptyResults() {
		PersonPair pairOfPersons = new BirthdateDistance(new PersonList(oldest)).findClosest();
		assertHasTheseTwoPeople(pairOfPersons, null, null);
	}

	@Test
	public void twoPeopleGivesClosestTwo() {
		PersonPair pairOfPersons = new BirthdateDistance(new PersonList(oldest, secondOldest)).findClosest();
		assertHasTheseTwoPeople(pairOfPersons, oldest, secondOldest);
	}

	@Test
	public void twoPeopleGivesFurthestTwo() {
		PersonPair pairOfPersons = new BirthdateDistance(new PersonList(secondYoungest, secondOldest)).findFurthest();
		assertHasTheseTwoPeople(pairOfPersons, secondOldest, secondYoungest);
	}

	@Test
	public void fourPeopleGivesFurthestTwo() {
		PersonPair pairOfPersons = new BirthdateDistance(new PersonList(oldest, youngest, secondYoungest, secondOldest))
				.findFurthest();
		assertHasTheseTwoPeople(pairOfPersons, oldest, youngest);
	}

	@Test
	public void fourPeopleGivesClosestTwo() {
		PersonPair pairOfPersons = new BirthdateDistance(new PersonList(oldest, youngest, secondYoungest, secondOldest))
				.findClosest();
		assertHasTheseTwoPeople(pairOfPersons, oldest, secondOldest);
	}

	private void assertHasTheseTwoPeople(PersonPair pairOfPersons, Person a, Person b) {
		assertEquals(a, pairOfPersons.getOlder());
		assertEquals(b, pairOfPersons.getSameOrYounger());
	}
}
