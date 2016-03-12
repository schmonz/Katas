package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final PersonList listOfPersons;

	public Finder(PersonList listOfPersons) {
		this.listOfPersons = listOfPersons;
	}
	
	public PersonPair findClosest() {
		PersonPair bestAnswerSoFar = new PersonPair();
		
		List<InitializedPersonPair> listOfPairsOfPersons = generateAllPossiblePairsOfPersons();
		if (listOfPairsOfPersons.size() > 0) {	
			bestAnswerSoFar = listOfPairsOfPersons.get(0);
			for (PersonPair eachResult : listOfPairsOfPersons) {
				if (eachResult.getDateDifference() < bestAnswerSoFar.getDateDifference()) {
					bestAnswerSoFar = eachResult;
				}
			}
		}

		return bestAnswerSoFar;
	}
	
	public PersonPair findFurthest() {
		PersonPair bestAnswerSoFar = new PersonPair();
		
		List<InitializedPersonPair> listOfPairsOfPersons = generateAllPossiblePairsOfPersons();
		if (listOfPairsOfPersons.size() > 0) {	
			bestAnswerSoFar = listOfPairsOfPersons.get(0);
			for (PersonPair eachResult : listOfPairsOfPersons) {
				if (eachResult.getDateDifference() > bestAnswerSoFar.getDateDifference()) {
					bestAnswerSoFar = eachResult;
				}
			}
		}

		return bestAnswerSoFar;
	}
	
	private List<InitializedPersonPair> generateAllPossiblePairsOfPersons() {
		List<InitializedPersonPair> listOfPairsOfPersons = new ArrayList<InitializedPersonPair>();

		for (int i = 0; i < listOfPersons.size() - 1; i++) {
			for (int j = i + 1; j < listOfPersons.size(); j++) {
				listOfPairsOfPersons.add(new InitializedPersonPair(listOfPersons.get(i), listOfPersons.get(j)));
			}
		}
		
		return listOfPairsOfPersons;
	}
}
