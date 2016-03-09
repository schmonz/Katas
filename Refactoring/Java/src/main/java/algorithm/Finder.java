package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> listOfPersons;

	public Finder(List<Person> p) {
		listOfPersons = p;
	}

	public PersonPair find(FindDistance ft) {
		List<PersonPair> tr = new ArrayList<PersonPair>();

		for (int i = 0; i < listOfPersons.size() - 1; i++) {
			for (int j = i + 1; j < listOfPersons.size(); j++) {
				PersonPair r = new PersonPair();
				if (listOfPersons.get(i).getBirthDate().getTime() < listOfPersons.get(j).getBirthDate().getTime()) {
					r.personOne = listOfPersons.get(i);
					r.personTwo = listOfPersons.get(j);
				} else {
					r.personOne = listOfPersons.get(j);
					r.personTwo = listOfPersons.get(i);
				}
				r.millisecondsBetweenDates = r.personTwo.getBirthDate().getTime() - r.personOne.getBirthDate().getTime();
				tr.add(r);
			}
		}

		if (tr.size() < 1) {
			return new PersonPair();
		}

		PersonPair answer = tr.get(0);
		for (PersonPair result : tr) {
			switch (ft) {
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
