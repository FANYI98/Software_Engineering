package staff;

import java.util.ArrayList;
import java.util.List;

import person.Date;
import person.Person;
import storagefile.Requirement;
import test.TestProducerequire;

public class PTTDirector extends Person {
	List<Requirement> waitinglist = new ArrayList<Requirement>();

	// constructor
	protected PTTDirector(Date dob, String name) {
		super(dob, name);
	}
	//process the "waiting" requirements with approve/reject
	public static void processRequirement() {
		int j = 0;
		System.out.println("Now process requirement...");
		System.out.println("-------------------------");

		//count the number of "waiting" requirements
		for (int i = 0; i < Requirement.requirementlist.size(); i++) {
			if (Requirement.requirementlist.get(i).getStatus().equals("waiting")) {
				j++;
			}
		}
		if (j == 0) {
			System.out.println("No new requirement to process!");
		} else {

			for (int i = 0; i < Requirement.requirementlist.size(); i++) {
				if (Requirement.requirementlist.get(i).getStatus().equals("waiting")) {
					Requirement.requirementlist.get(i).print();
					System.out.println("-------------------------------------------------------------");
					System.out.println("Please input approve|reject|exit|next(skip this requirement)!");
					String s1 = TestProducerequire.s.nextLine();
					if (s1.equals("reject")) {
						Requirement.requirementlist.get(i).setStatus("reject");

					} else if (s1.equals("approve")) {
						Requirement.requirementlist.get(i).setStatus("approve");

					} else if (s1.equals("exit")) {
						break;
					} else if (s1.equals("next")) {

					} else {
						//reprocess present requirements without skip if input wrong command
						System.out.println("Please input correct command!");
						i = i - 1;
					}
					if (i == Requirement.requirementlist.size() - 1) {
					}
				}
			}

		}
	}
}
