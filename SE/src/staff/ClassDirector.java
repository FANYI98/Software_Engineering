package staff;

import person.Date;
import person.Person;
import storagefile.Class;
import storagefile.Requirement;
import test.TestProducerequire;

public class ClassDirector extends Person {
	// constructor
	protected ClassDirector(Date dob, String name) {
		super(dob, name);
	}
	//add new requirements
	public static void produceRequirement() {
		System.out.println("-------------------------------------");
		Class class_info = new Class();
		Requirement r = new Requirement(class_info);
		r.setStatus("waiting");
		System.out.println("Please input the class title:");
		class_info.setTitle(TestProducerequire.s.nextLine());
		System.out.println("Please input the class location:");
		class_info.setLocation(TestProducerequire.s.nextLine());
		System.out.println("Please input the class Time:");
		class_info.setTime(TestProducerequire.s.nextLine());
		System.out.println("Please input the class major:");
		class_info.setMajor(TestProducerequire.s.nextLine());
		System.out.println("Please input the class brief intoduction:");
		class_info.setBrief_intro(TestProducerequire.s.nextLine());
		//whether save the requirement or not
		//if yes, the requirement will be written into requirementlist with status "waiting", for PPT process
		System.out.println("Do you want to save change:(Y to save)");

		if (TestProducerequire.s.nextLine().equalsIgnoreCase("Y")) {
			Requirement.requirementlist.add(r);
			Requirement.save();
			System.out.println("Your exchange has been saved!");
			System.out.println(".......................................");
			r.print();

		} else {
			System.out.println("Don't save!");
			Requirement.requirementlist.clear();
		}

	}

	//change the requirements which have been rejected by PTT
	public static void changeRequirement() {
		Requirement.read();
		int q = 0;
		//count the requirements rejected
		for (int n = 0; n < Requirement.requirementlist.size(); n++) {
			if (Requirement.requirementlist.get(n).getStatus().equals("reject"))
				q++;
		}
		
		if (q == 0) {
			System.out.println("No requirement has been rejected!");
			Requirement.requirementlist.clear();
			
		} else {
			//change the requirement info,and change status to "waiting", for PTT process again 
			for (int i = 0; i < Requirement.requirementlist.size(); i++) {
				if (Requirement.requirementlist.get(i).getStatus().equals("reject")) {
					Requirement.requirementlist.get(i).print();
					System.out.println("............................................");
					System.out.println("This requirement is rejected! Please change!");
					System.out.println("............................................");
					System.out.println("Please input the class title:");
					Requirement.requirementlist.get(i).getClass_info().setTitle(TestProducerequire.s.nextLine());
					System.out.println("Please input the class location:");
					Requirement.requirementlist.get(i).getClass_info().setLocation(TestProducerequire.s.nextLine());
					System.out.println("Please input the class Time:");
					Requirement.requirementlist.get(i).getClass_info().setTime(TestProducerequire.s.nextLine());
					System.out.println("Please input the class major:");
					Requirement.requirementlist.get(i).getClass_info().setMajor(TestProducerequire.s.nextLine());
					System.out.println("Please input the class brief intoduction:");
					Requirement.requirementlist.get(i).getClass_info().setBrief_intro(TestProducerequire.s.nextLine());
					Requirement.requirementlist.get(i).setStatus("waiting");

				}
			}
			System.out.println("Do you want to save change:(Y to save; else don't save)");
			if (TestProducerequire.s.nextLine().equalsIgnoreCase("Y")) {
				System.out.println("Your exchange has been saved!");
				Requirement.save();
			} else {
				System.out.println("Requirements' not save!");
				Requirement.requirementlist.clear();

			}

		}
	}
}
