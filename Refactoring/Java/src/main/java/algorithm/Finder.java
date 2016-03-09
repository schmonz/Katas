package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> listOfPersons;

	public Finder(List<Person> listOfPersons) {
		this.listOfPersons = listOfPersons;
	}
	
	public PersonPair find(FindDistance findDistanceThingy) {
		List<InitializedPersonPair> listOfPairsOfPersons = new ArrayList<InitializedPersonPair>();

		for (int i = 0; i < listOfPersons.size() - 1; i++) {
			for (int j = i + 1; j < listOfPersons.size(); j++) {
				listOfPairsOfPersons.add(new InitializedPersonPair(listOfPersons.get(i), listOfPersons.get(j)));
			}
		}

		if (listOfPairsOfPersons.size() < 1) {
			return new PersonPair();
		}

		PersonPair bestAnswer = listOfPairsOfPersons.get(0);
		for (PersonPair eachResult : listOfPairsOfPersons) {
			switch (findDistanceThingy) {
				case CLOSEST :
					if (eachResult.getDateDifference() < bestAnswer.getDateDifference()) {
						bestAnswer = eachResult;
					}
					break;

				case FURTHEST :
					if (eachResult.getDateDifference() > bestAnswer.getDateDifference()) {
						bestAnswer = eachResult;
					}
					break;
			}
		}

		return bestAnswer;
	}
}
