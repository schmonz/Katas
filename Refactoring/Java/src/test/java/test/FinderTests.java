package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.F;
import algorithm.FT;
import algorithm.Finder;
import algorithm.Thing;

public class FinderTests {

	Thing sue = new Thing();
	Thing greg = new Thing();
	Thing sarah = new Thing();
	Thing mike = new Thing();

	private Date getDateFor(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1900 + year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	@Before
	public void setup() {
		sue.name = "Sue";
		sue.birthDate = getDateFor(50, 0, 1);
		greg.name = "Greg";
		greg.birthDate = getDateFor(52, 5, 1);
		sarah.name = "Sarah";
		sarah.birthDate = getDateFor(82, 0, 1);
		mike.name = "Mike";
		mike.birthDate = getDateFor(79, 0, 1);
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Thing> list = new ArrayList<Thing>();
		Finder finder = new Finder(list);

		F result = finder.Find(FT.One);
		assertEquals(null, result.P1);

		assertEquals(null, result.P2);
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Thing> list = new ArrayList<Thing>();
		list.add(sue);

		Finder finder = new Finder(list);

		F result = finder.Find(FT.One);

		assertEquals(null, result.P1);
		assertEquals(null, result.P2);
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Thing> list = new ArrayList<Thing>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		F result = finder.Find(FT.One);

		assertEquals(sue, result.P1);
		assertEquals(greg, result.P2);
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Thing> list = new ArrayList<Thing>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		F result = finder.Find(FT.Two);

		assertEquals(greg, result.P1);
		assertEquals(mike, result.P2);
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Thing> list = new ArrayList<Thing>();
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
	public void Returns_Closest_Two_For_Four_People() {
		List<Thing> list = new ArrayList<Thing>();
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
