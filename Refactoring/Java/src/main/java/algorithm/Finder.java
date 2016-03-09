package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> listOfPersons;

	public Finder(List<Person> listOfPersons) {
		this.listOfPersons = listOfPersons;
	}
	
	private PersonPair putThesePersonsInSomeOrder(Person aPerson, Person anotherPerson) {
		PersonPair personPair = new PersonPair();
		if (aPerson.getBirthTime() < anotherPerson.getBirthTime()) {
			personPair.personOne = aPerson;
			personPair.personTwo = anotherPerson;
		} else {
			personPair.personOne = anotherPerson;
			personPair.personTwo = aPerson;
		}
		personPair.millisecondsBetweenDates = personPair.personTwo.getBirthTime() - personPair.personOne.getBirthTime();
		return personPair;
	}

	public PersonPair find(FindDistance findDistanceThingy) {
		List<PersonPair> listOfPairsOfPersons = new ArrayList<PersonPair>();

		for (int i = 0; i < listOfPersons.size() - 1; i++) {
			for (int j = i + 1; j < listOfPersons.size(); j++) {
				PersonPair thisPersonPair = putThesePersonsInSomeOrder(listOfPersons.get(i), listOfPersons.get(j));
				listOfPairsOfPersons.add(thisPersonPair);
			}
		}

		if (listOfPairsOfPersons.size() < 1) {
			return new PersonPair();
		}

		PersonPair answer = listOfPairsOfPersons.get(0);
		for (PersonPair result : listOfPairsOfPersons) {
			switch (findDistanceThingy) {
				case CLOSEST :
					if (result.millisecondsBetweenDates < answer.millisecondsBetweenDates) {
						answer = result;
					}
					break;

				case FURTHEST :
					if (result.millisecondsBetweenDates > answer.millisecondsBetweenDates) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
