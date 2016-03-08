package algorithm;

import java.util.Date;

public class Person {
	private Date birthDate;
	
	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}

