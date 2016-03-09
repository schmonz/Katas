package algorithm;
public class InitializedPersonPair extends PersonPair {
	
	public InitializedPersonPair(Person aPerson, Person anotherPerson) {
		if (aPerson.getBirthTime() < anotherPerson.getBirthTime()) {
			this.older = aPerson;
			this.sameOrYounger = anotherPerson;
		} else {
			this.older = anotherPerson;
			this.sameOrYounger = aPerson;
		}
		this.millisecondsBetweenBirthDates = this.sameOrYounger.getBirthTime() - this.older.getBirthTime();
	}
	
}
