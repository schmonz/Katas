package algorithm;
public class PersonPair {
	public Person older;
	public Person sameOrYounger;
	public long millisecondsBetweenBirthDates;
	
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
		
	}
}
