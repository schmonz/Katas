package com.schmonz.birthdaymath.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;
import java.util.List;

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
		oldest = new Person(new GregorianCalendar(1950, 0, 1));
		secondOldest = new Person(new GregorianCalendar(1952, 5, 1));
		secondYoungest = new Person(new GregorianCalendar(1979, 0, 1));
		youngest = new Person(new GregorianCalendar(1982, 0, 1));
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
		List<Person> assumingSorted;
		if (null == pairOfPersons) {
			fail("null PersonPair");
		} else {
			assumingSorted = pairOfPersons.getPeople();
			if (null == a || null == b) {
				assertNull(a);
				assertNull(b);
			} else if (a.equals(assumingSorted.get(0)) && b.equals(assumingSorted.get(1))) {
				assertEquals("sorted as expected!", 77, 77);
			} else if (b.equals(assumingSorted.get(0)) && a.equals(assumingSorted.get(1))) {
				assertEquals("sorted backwards but good!", 88, 88);
			} else {
				fail("not right");
			}
		}
	}
}
