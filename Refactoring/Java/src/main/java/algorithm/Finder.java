package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> listOfPersons;

	public Finder(List<Person> listOfPersons) {
		this.listOfPersons = listOfPersons;
	}
	
	private PersonPair olderFollowedBySameOrYounger(Person aPerson, Person anotherPerson) {
		PersonPair personPair = new PersonPair();
		if (aPerson.getBirthTime() < anotherPerson.getBirthTime()) {
			personPair.older = aPerson;
			personPair.sameOrYounger = anotherPerson;
		} else {
			personPair.older = anotherPerson;
			personPair.sameOrYounger = aPerson;
		}
		personPair.millisecondsBetweenBirthDates = personPair.sameOrYounger.getBirthTime() - personPair.older.getBirthTime();
		return personPair;
	}

	public PersonPair find(FindDistance findDistanceThingy) {
		List<PersonPair> listOfPairsOfPersons = new ArrayList<PersonPair>();

		for (int i = 0; i < listOfPersons.size() - 1; i++) {
			for (int j = i + 1; j < listOfPersons.size(); j++) {
				listOfPairsOfPersons.add(olderFollowedBySameOrYounger(listOfPersons.get(i), listOfPersons.get(j)));
			}
		}

		if (listOfPairsOfPersons.size() < 1) {
			return new PersonPair();
		}

		PersonPair answer = listOfPairsOfPersons.get(0);
		for (PersonPair result : listOfPairsOfPersons) {
			switch (findDistanceThingy) {
				case CLOSEST :
					if (result.millisecondsBetweenBirthDates < answer.millisecondsBetweenBirthDates) {
						answer = result;
					}
					break;

				case FURTHEST :
					if (result.millisecondsBetweenBirthDates > answer.millisecondsBetweenBirthDates) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
