package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final PersonList listOfPersons;

	public Finder(PersonList listOfPersons) {
		this.listOfPersons = listOfPersons;
	}
	
	public PersonPair findClosest() {
		return find(true);
	}
	
	public PersonPair findFurthest() {
		return find(false);
	}
	
	private PersonPair find(boolean wantClosest) {
		List<InitializedPersonPair> listOfPairsOfPersons = new ArrayList<InitializedPersonPair>();

		for (int i = 0; i < listOfPersons.size() - 1; i++) {
			for (int j = i + 1; j < listOfPersons.size(); j++) {
				listOfPairsOfPersons.add(new InitializedPersonPair(listOfPersons.get(i), listOfPersons.get(j)));
			}
		}

		if (listOfPairsOfPersons.isEmpty()) {
			return new PersonPair();
		}

		PersonPair bestAnswer = listOfPairsOfPersons.get(0);
		for (PersonPair eachResult : listOfPairsOfPersons) {
			if ((wantClosest && eachResult.getDateDifference() < bestAnswer.getDateDifference())
			|| (!wantClosest && eachResult.getDateDifference() > bestAnswer.getDateDifference())) {
				bestAnswer = eachResult;
			}
		}

		return bestAnswer;
	}
}
