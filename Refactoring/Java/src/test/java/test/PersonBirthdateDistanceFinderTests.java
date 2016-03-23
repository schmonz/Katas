package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import algorithm.Person;
import algorithm.PersonBirthdateDistanceFinder;
import algorithm.PersonList;
import algorithm.PersonPair;

public class PersonBirthdateDistanceFinderTests {

	private Person sue, greg, sarah, mike;

	@Before
	public void setup() {
		sue = new Person(1950, 1, 1);
		greg = new Person(1952, 6, 1);
		sarah = new Person(1982, 1, 1);
		mike = new Person(1979, 1, 1);
	}

	@Test
	public void emptyListGivesEmptyResults() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList());
		PersonPair pairOfPersons = finder.findClosest();
		assertHasTheseTwoPeople(pairOfPersons, null, null);
	}

	@Test
	public void onePersonGivesEmptyResults() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(sue));
		PersonPair pairOfPersons = finder.findClosest();
		assertHasTheseTwoPeople(pairOfPersons, null, null);
	}

	@Test
	public void twoPeopleGivesClosestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(sue, greg));
		PersonPair pairOfPersons = finder.findClosest();
		assertHasTheseTwoPeople(pairOfPersons, sue, greg);
	}

	@Test
	public void twoPeopleGivesFurthestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(mike, greg));
		PersonPair pairOfPersons = finder.findFurthest();
		assertHasTheseTwoPeople(pairOfPersons, greg, mike);
	}

	@Test
	public void fourPeopleGivesFurthestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(
				new PersonList(sue, sarah, mike, greg));
		PersonPair pairOfPersons = finder.findFurthest();
		assertHasTheseTwoPeople(pairOfPersons, sue, sarah);
	}

	@Test
	public void fourPeopleGivesClosestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(
				new PersonList(sue, sarah, mike, greg));
		PersonPair pairOfPersons = finder.findClosest();
		assertHasTheseTwoPeople(pairOfPersons, sue, greg);
	}

	private void assertHasTheseTwoPeople(PersonPair pairOfPersons, Person a, Person b) {
		assertEquals(a, pairOfPersons.older);
		assertEquals(b, pairOfPersons.sameOrYounger);
	}
}
