package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
	private List<Person> persons;

	public PersonList(Person... persons) {
		this.persons = new ArrayList<Person>();
		for (Person person : persons) {
			this.persons.add(person);
		}
	}

	public int size() {
		return persons.size();
	}

	public Person get(int index) {
		return persons.get(index);
	}

}
