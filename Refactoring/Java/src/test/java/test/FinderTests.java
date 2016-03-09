package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.F;
import algorithm.FT;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

	private Person sue, greg, sarah, mike;
	
	private List<Person> makeList(Person...persons) {
		List<Person> list = new ArrayList<Person>();
		for (Person person : persons) {
			list.add(person);
		}
		return list;
	}
	
	private void assertResultContainsTheseTwoPeople(F result, Person a, Person b) {
		assertEquals(a, result.P1);
		assertEquals(b, result.P2);
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
		List<Person> list = makeList();
		F result = new Finder(list).find(FT.One);
		assertResultContainsTheseTwoPeople(result, null, null);
	}

	@Test
	public void onePersonGivesEmptyResults() {
		List<Person> list = makeList(sue);
		F result = new Finder(list).find(FT.One);
		assertResultContainsTheseTwoPeople(result, null, null);
	}

	@Test
	public void twoPeopleGivesClosestTwo() {
		List<Person> list = makeList(sue, greg);
		F result = new Finder(list).find(FT.One);
		assertResultContainsTheseTwoPeople(result, sue, greg);
	}

	@Test
	public void twoPeopleGivesFurthestTwo() {
		List<Person> list = makeList(mike, greg);
		F result = new Finder(list).find(FT.Two);
		assertResultContainsTheseTwoPeople(result, greg, mike);
	}

	@Test
	public void fourPeopleGivesFurthestTwo() {
		List<Person> list = makeList(sue, sarah, mike, greg);
		F result = new Finder(list).find(FT.Two);
		assertResultContainsTheseTwoPeople(result, sue, sarah);
	}

	@Test
	public void fourPeopleGivesClosestTwo() {
		List<Person> list = makeList(sue, sarah, mike, greg);
		F result = new Finder(list).find(FT.One);
		assertResultContainsTheseTwoPeople(result, sue, greg);
	}

}
