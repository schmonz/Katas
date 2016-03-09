package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> listOfPersons;

	public Finder(List<Person> listOfPersons) {
		this.listOfPersons = listOfPersons;
	}

	public PersonPair find(FindDistance findDistanceThingy) {
		List<PersonPair> listOfPairsOfPersons = new ArrayList<PersonPair>();

		for (int i = 0; i < listOfPersons.size() - 1; i++) {
			for (int j = i + 1; j < listOfPersons.size(); j++) {
				PersonPair thisPersonPair = new PersonPair();
				if (listOfPersons.get(i).getBirthDate().getTime() < listOfPersons.get(j).getBirthDate().getTime()) {
					thisPersonPair.personOne = listOfPersons.get(i);
					thisPersonPair.personTwo = listOfPersons.get(j);
				} else {
					thisPersonPair.personOne = listOfPersons.get(j);
					thisPersonPair.personTwo = listOfPersons.get(i);
				}
				thisPersonPair.millisecondsBetweenDates = thisPersonPair.personTwo.getBirthDate().getTime() - thisPersonPair.personOne.getBirthDate().getTime();
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
