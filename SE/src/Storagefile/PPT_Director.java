package Storagefile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PPT_Director extends Person {
	List<Requirement> waitinglist = new ArrayList<Requirement>();

	// constructor
	protected PPT_Director(Date dob, String name) {
		super(dob, name);
	}

	public static void process_requirement() {
		int j = 0;
		System.out.println("Now process requirement！---------------");

		for (int i = 0; i < Requirement.requirementlist.size(); i++) {
			if (Requirement.requirementlist.get(i).getStatus().equals("waiting")) {
				j++;
			}
		}
		if (j == 0) {
			System.out.println("No new requirement to process");
		} else {
			Scanner s = new Scanner(System.in);
			for (int i = 0; i < Requirement.requirementlist.size(); i++) {
				if (Requirement.requirementlist.get(i).getStatus().equals("waiting")) {
					Requirement.requirementlist.get(i).print();
					System.out.println("Please approve or reject or next!");
					String s1 = s.nextLine();
					if (s1.equals("reject")) {
						Requirement.requirementlist.get(i).setStatus("reject");

					} else if (s1.equals("approve")) {
						Requirement.requirementlist.get(i).setStatus("approve");

					} else if (s1.equals("exit")) {
						break;
					} else if (s1.equals("next")){
						
					}else {System.out.println("Please input correct command!");
						i = i - 1;

					}

					if (i == Requirement.requirementlist.size() - 1) {
					}
				}
			}
		}
	}

	public static void save() {
		Requirement.save();
	}
}
