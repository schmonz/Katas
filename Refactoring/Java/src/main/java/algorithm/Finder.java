package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> listOfPersons;

	public Finder(List<Person> p) {
		listOfPersons = p;
	}

	public F find(FT ft) {
		List<F> tr = new ArrayList<F>();

		for (int i = 0; i < listOfPersons.size() - 1; i++) {
			for (int j = i + 1; j < listOfPersons.size(); j++) {
				F r = new F();
				if (listOfPersons.get(i).getBirthDate().getTime() < listOfPersons.get(j).getBirthDate().getTime()) {
					r.P1 = listOfPersons.get(i);
					r.P2 = listOfPersons.get(j);
				} else {
					r.P1 = listOfPersons.get(j);
					r.P2 = listOfPersons.get(i);
				}
				r.D = r.P2.getBirthDate().getTime() - r.P1.getBirthDate().getTime();
				tr.add(r);
			}
		}

		if (tr.size() < 1) {
			return new F();
		}

		F answer = tr.get(0);
		for (F result : tr) {
			switch (ft) {
				case One :
					if (result.D < answer.D) {
						answer = result;
					}
					break;

				case Two :
					if (result.D > answer.D) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
