package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import algorithm.PersonBirthdateDistanceFinder;
import algorithm.Person;
import algorithm.PersonList;
import algorithm.PersonPair;

public class PersonBirthdateDistanceFinderTests {

	private Person sue, greg, sarah, mike;
	
	private void assertHasTheseTwoPeople(PersonPair result, Person a, Person b) {
		assertEquals(a, result.older);
		assertEquals(b, result.sameOrYounger);
	}

	@Before
	public void setup() {
		sue		= new Person(1950, 1, 1);
		greg	= new Person(1952, 6, 1);
		sarah	= new Person(1982, 1, 1);
		mike	= new Person(1979, 1, 1);
	}

	@Test
	public void emptyListGivesEmptyResults() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList());
		PersonPair result = finder.findClosest();
		assertHasTheseTwoPeople(result, null, null);
	}

	@Test
	public void onePersonGivesEmptyResults() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(sue));
		PersonPair result = finder.findClosest();
		assertHasTheseTwoPeople(result, null, null);
	}

	@Test
	public void twoPeopleGivesClosestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(sue, greg));
		PersonPair result = finder.findClosest();
		assertHasTheseTwoPeople(result, sue, greg);
	}

	@Test
	public void twoPeopleGivesFurthestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(mike, greg));
		PersonPair result = finder.findFurthest();
		assertHasTheseTwoPeople(result, greg, mike);
	}

	@Test
	public void fourPeopleGivesFurthestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(sue, sarah, mike, greg));
		PersonPair result = finder.findFurthest();
		assertHasTheseTwoPeople(result, sue, sarah);
	}

	@Test
	public void fourPeopleGivesClosestTwo() {
		PersonBirthdateDistanceFinder finder = new PersonBirthdateDistanceFinder(new PersonList(sue, sarah, mike, greg));
		PersonPair result = finder.findClosest();
		assertHasTheseTwoPeople(result, sue, greg);
	}

}
