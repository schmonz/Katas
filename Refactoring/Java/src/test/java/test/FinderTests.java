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
		
		assertEquals(null, result.P1);
		assertEquals(null, result.P2);
	}

	@Test
	public void onePersonGivesEmptyResults() {
		List<Person> list = makeList(sue);

		F result = new Finder(list).find(FT.One);

		assertEquals(null, result.P1);
		assertEquals(null, result.P2);
	}

	@Test
	public void twoPeopleGivesClosestTwo() {
		List<Person> list = makeList(sue, greg);
		
		F result = new Finder(list).find(FT.One);

		assertEquals(sue, result.P1);
		assertEquals(greg, result.P2);
	}

	@Test
	public void twoPeopleGivesFurthestTwo() {
		List<Person> list = makeList(mike, greg);

		F result = new Finder(list).find(FT.Two);

		assertEquals(greg, result.P1);
		assertEquals(mike, result.P2);
	}

	@Test
	public void fourPeopleGivesFurthestTwo() {
		List<Person> list = makeList(sue, sarah, mike, greg);
		
		F result = new Finder(list).find(FT.Two);

		assertEquals(sue, result.P1);
		assertEquals(sarah, result.P2);
	}

	@Test
	public void fourPeopleGivesClosestTwo() {
		List<Person> list = makeList(sue, sarah, mike, greg);

		F result = new Finder(list).find(FT.One);

		assertEquals(sue, result.P1);
		assertEquals(greg, result.P2);
	}

}
