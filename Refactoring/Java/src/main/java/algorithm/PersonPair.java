package algorithm;

public class PersonPair implements Comparable<PersonPair> {
	public Person older;
	public Person sameOrYounger;
	protected long millisecondsBetweenBirthDates;
	
	public PersonPair() {
	}

	public PersonPair(Person aPerson, Person anotherPerson) {
		if (aPerson.getBirthTime() < anotherPerson.getBirthTime()) {
			this.older = aPerson;
			this.sameOrYounger = anotherPerson;
		} else {
			this.older = anotherPerson;
			this.sameOrYounger = aPerson;
		}
		this.millisecondsBetweenBirthDates = this.sameOrYounger.getBirthTime() - this.older.getBirthTime();
	}
	
	public long getDateDifference() {
		return millisecondsBetweenBirthDates;
	}
	
	@Override
	public int compareTo(PersonPair arg0) {
		if (this.getDateDifference() < arg0.getDateDifference()) {
			return -1;
		} else if (this.getDateDifference() > arg0.getDateDifference()) {
			return 1;
		} else {
			return 0;
		}
	}
}
