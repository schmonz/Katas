package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.Finder;
import algorithm.Person;
import algorithm.PersonPair;

public class FinderTests {

	private Person sue, greg, sarah, mike;
	
	private List<Person> makeList(Person...persons) {
		List<Person> list = new ArrayList<Person>();
		for (Person person : persons) {
			list.add(person);
		}
		return list;
	}
	
	private void assertResultContainsTheseTwoPeople(PersonPair result, Person a, Person b) {
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
		PersonPair result = new Finder(makeList())
				.findClosest();
		assertResultContainsTheseTwoPeople(result, null, null);
	}

	@Test
	public void onePersonGivesEmptyResults() {
		PersonPair result = new Finder(makeList(sue))
				.findClosest();
		assertResultContainsTheseTwoPeople(result, null, null);
	}

	@Test
	public void twoPeopleGivesClosestTwo() {
		PersonPair result = new Finder(makeList(sue, greg))
				.findClosest();
		assertResultContainsTheseTwoPeople(result, sue, greg);
	}

	@Test
	public void twoPeopleGivesFurthestTwo() {
		PersonPair result = new Finder(makeList(mike, greg))
				.findFurthest();
		assertResultContainsTheseTwoPeople(result, greg, mike);
	}

	@Test
	public void fourPeopleGivesFurthestTwo() {
		PersonPair result = new Finder(makeList(sue, sarah, mike, greg))
				.findFurthest();
		assertResultContainsTheseTwoPeople(result, sue, sarah);
	}

	@Test
	public void fourPeopleGivesClosestTwo() {
		PersonPair result = new Finder(makeList(sue, sarah, mike, greg))
				.findClosest();
		assertResultContainsTheseTwoPeople(result, sue, greg);
	}

}
