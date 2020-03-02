package Storagefile;

import java.util.Scanner;

public class Class_Director extends Person {
	// constructor
	protected Class_Director(Date dob, String name) {
		super(dob, name);
	}

	public static void produce_requirement() {
		Class class_info = new Class();
		Requirement r = new Requirement(class_info);
		r.setStatus("waiting");
		// Requirement requirement=new Requirement(class_info);
		Scanner s = new Scanner(System.in);
		System.out.println("Please input the class title:");
		class_info.setTitle(s.nextLine());
		System.out.println("Please input the class location:");
		class_info.setLocation(s.nextLine());
		System.out.println("Please input the class Time:");
		class_info.setTime(s.nextLine());
		System.out.println("Please input the class major:");
		class_info.setMajor(s.nextLine());
		System.out.println("Please input the class brief intoduction:");
		class_info.setBrief_intro(s.nextLine());

		System.out.println("Do you want to save change:(Y to save)");

		if (s.nextLine().equalsIgnoreCase("Y")) {
			Requirement.requirementlist.add(r);
			Requirement.save();
			System.out.println("Your exchange has been saved!");

		} else {
			System.out.println("Don't save!");
			Requirement.requirementlist.clear();
		}

	}

	public static void change_requirement() {
		Requirement.read();
		Scanner s = new Scanner(System.in);
		int q = 0;

		for (int n = 0; n < Requirement.requirementlist.size(); n++) {
			if (Requirement.requirementlist.get(n).getStatus().equals("reject"))
				q++;
		}

		if (q == 0) {
			System.out.println("No requirement has been rejected!");
			Requirement.requirementlist.clear();
			
		} else {

			for (int i = 0; i < Requirement.requirementlist.size(); i++) {
				if (Requirement.requirementlist.get(i).getStatus().equals("reject")) {
					Requirement.requirementlist.get(i).print();
					System.out.println("This requirement is rejected! Please change!");
					System.out.println("Please input the class title:");
					Requirement.requirementlist.get(i).getClass_info().setTitle(s.nextLine());
					System.out.println("Please input the class location:");
					Requirement.requirementlist.get(i).getClass_info().setLocation(s.nextLine());
					System.out.println("Please input the class Time:");
					Requirement.requirementlist.get(i).getClass_info().setTime(s.nextLine());
					System.out.println("Please input the class major:");
					Requirement.requirementlist.get(i).getClass_info().setMajor(s.nextLine());
					System.out.println("Please input the class brief intoduction:");
					Requirement.requirementlist.get(i).getClass_info().setBrief_intro(s.nextLine());
					Requirement.requirementlist.get(i).setStatus("waiting");

				}
			}
			System.out.println("Do you want to save change:(Y)");
			if (s.nextLine().equalsIgnoreCase("Y")) {
				System.out.println("Your exchange has been saved!");
				Requirement.save();
			} else {
				System.out.println("Requirements' not save!");
				Requirement.requirementlist.clear();

			}

		}
	}
}
