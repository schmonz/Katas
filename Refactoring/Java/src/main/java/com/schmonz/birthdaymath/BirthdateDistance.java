package com.schmonz.birthdaymath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BirthdateDistance {
	private final PersonList listOfPersons;

	public BirthdateDistance(PersonList listOfPersons) {
		this.listOfPersons = listOfPersons;
	}

	public class ClosestPairComparator implements Comparator<PersonPair> {
		@Override
		public int compare(PersonPair o1, PersonPair o2) {
			if (o1.getDateDifference() < o2.getDateDifference()) {
				return -1;
			} else if (o1.getDateDifference() > o2.getDateDifference()) {
				return 1;
			} else {
				return 0;
			}
			// XXX o1.getDateDifference() - o2.getDateDifference()

		}
	}

	public class FurthestPairComparator implements Comparator<PersonPair> {
		@Override
		public int compare(PersonPair o1, PersonPair o2) {
			if (o1.getDateDifference() < o2.getDateDifference()) {
				return 1;
			} else if (o1.getDateDifference() > o2.getDateDifference()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public PersonPair findClosest() {
		return findMostest(new ClosestPairComparator());
	}

	public PersonPair findFurthest() {
		return findMostest(new FurthestPairComparator());
	}

	private PersonPair findMostest(Comparator<PersonPair> pairComparator) {
		PersonPair bestAnswerSoFar = new PersonPair();

		List<PersonPair> listOfPairsOfPersons = generateAllPossiblePairsOfPersons();
		if (listOfPairsOfPersons.size() > 0) {
			bestAnswerSoFar = listOfPairsOfPersons.get(0);
			for (PersonPair eachResult : listOfPairsOfPersons) {
				bestAnswerSoFar = betterOfTwoPairs(pairComparator, eachResult, bestAnswerSoFar);
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

	private PersonPair betterOfTwoPairs(Comparator<PersonPair> pairComparator, PersonPair onePair,
			PersonPair anotherPair) {
		PersonPair[] theseTwo = new PersonPair[] { onePair, anotherPair };
		Arrays.sort(theseTwo, pairComparator);
		return theseTwo[0];
	}
}
