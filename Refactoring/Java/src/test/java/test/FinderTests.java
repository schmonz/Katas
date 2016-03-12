package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import algorithm.Finder;
import algorithm.Person;
import algorithm.PersonList;
import algorithm.PersonPair;

public class FinderTests {

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
		Finder finder = new Finder(new PersonList());
		PersonPair result = finder.findClosest();
		assertHasTheseTwoPeople(result, null, null);
	}

	@Test
	public void onePersonGivesEmptyResults() {
		Finder finder = new Finder(new PersonList(sue));
		PersonPair result = finder.findClosest();
		assertHasTheseTwoPeople(result, null, null);
	}

	@Test
	public void twoPeopleGivesClosestTwo() {
		Finder finder = new Finder(new PersonList(sue, greg));
		PersonPair result = finder.findClosest();
		assertHasTheseTwoPeople(result, sue, greg);
	}

	@Test
	public void twoPeopleGivesFurthestTwo() {
		Finder finder = new Finder(new PersonList(mike, greg));
		PersonPair result = finder.findFurthest();
		assertHasTheseTwoPeople(result, greg, mike);
	}

	@Test
	public void fourPeopleGivesFurthestTwo() {
		Finder finder = new Finder(new PersonList(sue, sarah, mike, greg));
		PersonPair result = finder.findFurthest();
		assertHasTheseTwoPeople(result, sue, sarah);
	}

	@Test
	public void fourPeopleGivesClosestTwo() {
		Finder finder = new Finder(new PersonList(sue, sarah, mike, greg));
		PersonPair result = finder.findClosest();
		assertHasTheseTwoPeople(result, sue, greg);
	}

}
