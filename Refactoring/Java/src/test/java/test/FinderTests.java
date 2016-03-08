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

	@Before
	public void setup() {
		sue = new Person(50, 0, 1);
		greg = new Person(52, 5, 1);
		sarah = new Person(82, 0, 1);
		mike = new Person(79, 0, 1);
	}

	@Test
	public void emptyListGivesEmptyResults() {
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder(list);

		F result = finder.Find(FT.One);
		assertEquals(null, result.P1);

		assertEquals(null, result.P2);
	}

	@Test
	public void onePersonGivesEmptyResults() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder(list);

		F result = finder.Find(FT.One);

		assertEquals(null, result.P1);
		assertEquals(null, result.P2);
	}

	@Test
	public void twoPeopleGivesClosestTwo() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		F result = finder.Find(FT.One);

		assertEquals(sue, result.P1);
		assertEquals(greg, result.P2);
	}

	@Test
	public void twoPeopleGivesFurthestTwo() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		F result = finder.Find(FT.Two);

		assertEquals(greg, result.P1);
		assertEquals(mike, result.P2);
	}

	@Test
	public void fourPeopleGivesFurthestTwo() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		F result = finder.Find(FT.Two);

		assertEquals(sue, result.P1);
		assertEquals(sarah, result.P2);
	}

	@Test
	public void fourPeopleGivesClosestTwo() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		F result = finder.Find(FT.One);

		assertEquals(sue, result.P1);
		assertEquals(greg, result.P2);
	}

}
