package com.schmonz.birthdaymath;

import java.util.ArrayList;
import java.util.List;

public class PersonBirthdateDistanceFinder {
	private final PersonList listOfPersons;

	public PersonBirthdateDistanceFinder(PersonList listOfPersons) {
		this.listOfPersons = listOfPersons;
	}

	public PersonPair findClosest() {
		final int WANT_SMALLER_DATE_DIFFERENCE = -1;
		return findMostest(WANT_SMALLER_DATE_DIFFERENCE);
	}

	public PersonPair findFurthest() {
		final int WANT_LARGER_DATE_DIFFERENCE = 1;
		return findMostest(WANT_LARGER_DATE_DIFFERENCE);
	}

	private PersonPair findMostest(int desiredResultOfCompareTo) {
		PersonPair bestAnswerSoFar = new PersonPair();

		List<PersonPair> listOfPairsOfPersons = generateAllPossiblePairsOfPersons();
		if (listOfPairsOfPersons.size() > 0) {
			bestAnswerSoFar = listOfPairsOfPersons.get(0);
			for (PersonPair eachResult : listOfPairsOfPersons) {
				bestAnswerSoFar = betterOfTwoPairs(desiredResultOfCompareTo, eachResult, bestAnswerSoFar);
			}
		}

		return bestAnswerSoFar;
	}

	private List<PersonPair> generateAllPossiblePairsOfPersons() {
		List<PersonPair> listOfPairsOfPersons = new ArrayList<PersonPair>();

		for (int i = 0; i < listOfPersons.size() - 1; i++) {
			for (int j = i + 1; j < listOfPersons.size(); j++) {
				listOfPairsOfPersons.add(new PersonPair(listOfPersons.get(i), listOfPersons.get(j)));
			}
		}

		return listOfPairsOfPersons;
	}

	private PersonPair betterOfTwoPairs(int desiredResultOfCompareTo, PersonPair onePair, PersonPair anotherPair) {
		if (desiredResultOfCompareTo == onePair.compareTo(anotherPair)) {
			return onePair;
		} else {
			return anotherPair;
		}
	}
}
