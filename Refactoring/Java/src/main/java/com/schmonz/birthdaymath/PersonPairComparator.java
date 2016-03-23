package com.schmonz.birthdaymath;

import java.util.Comparator;

public class PersonPairComparator implements Comparator<PersonPair> {

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
