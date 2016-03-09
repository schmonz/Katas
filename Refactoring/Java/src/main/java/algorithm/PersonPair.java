package algorithm;

public class PersonPair {
	public Person older;
	public Person sameOrYounger;
	protected long millisecondsBetweenBirthDates;
	
	public long getDateDifference() {
		return millisecondsBetweenBirthDates;
	}
}
