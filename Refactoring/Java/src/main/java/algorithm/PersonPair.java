package algorithm;
public class PersonPair {
	public Person older;
	public Person sameOrYounger;
	private long millisecondsBetweenBirthDates;
	
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
	
	public PersonPair() {
		// XXX is this an EmptyPersonPair subclass?
	}
	
	public long getDateDifference() {
		return millisecondsBetweenBirthDates;
	}
}
