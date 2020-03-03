package staff;

import java.util.List;
import person.Date;
import person.Person;
import storagefile.ReadFile;
import storagefile.Requirement;
import storagefile.TrainingCandidate;
import storagefile.WriteFile;
import test.TestProducerequire;

public class Administrator extends Person {
	// constructor
	protected Administrator(Date dob, String name) {
		super(dob, name);
	}

	// find teachers for requirements with status "approve"
	public static void findTrainingTeacher() {
		Requirement.read();
		ReadFile.readinfo();

		int q = 0; // count the number of requirement in requirementlist with status "approve"

		for (int n = 0; n < Requirement.requirementlist.size(); n++) {
			if (Requirement.requirementlist.get(n).getStatus().equals("approve"))
				q++;
		}
		if (q == 0) {
			System.out.println("No requirement need teachers now!");
			ReadFile.teacherlist.clear();
			ReadFile.classlist.clear();
			Requirement.requirementlist.clear();
		} else {
			for (int i = 0; i < Requirement.requirementlist.size(); i++) {

				// save the teacher having same major with the requirement
				List<Teacher> candidatelist = null;

				if (Requirement.requirementlist.get(i).getStatus().equals("approve")) {

					candidatelist = TrainingCandidate.produceCandidate(Requirement.requirementlist.get(i));
					System.out.println("...............................");
					System.out.println("The requirement info:");
					Requirement.requirementlist.get(i).print();
					System.out.println("...............................");
					if (candidatelist.size() == 0) {
						System.out.println("No teacher is suitable now...");
						continue;
					} else {
						System.out.println("Below are the teachers suitable:");
						for (int c = 0; c < candidatelist.size(); c++) {
							System.out.print(c + "  ");
							candidatelist.get(c).print();
						}
						System.out.println("...............................");
						System.out.println("Please choose the teacher for training:(number)");

						// add the teacher chosen by Administrator to requirement list
						// set the requirement status as "training"
						try {
						String s1 = TestProducerequire.s.nextLine();
						
						Teacher teacher = candidatelist.get(Integer.valueOf(s1));

						Requirement.requirementlist.get(i).getClass_info().setTeacher(teacher);
						Requirement.requirementlist.get(i).setStatus("training");

						System.out.println(teacher.getName() + " has been added into" +

								Requirement.requirementlist.get(i).getClass_info().getTitle());
						}catch(Exception e) {
							System.out.println("Please insert a correct number!!");
							System.out.println("=================================");

						}
					}
				}
			}
			ReadFile.teacherlist.clear();
			ReadFile.classlist.clear();
			Requirement.save();
			System.out.println("Teachers' info has been saved into requirement!");
		}
	}

	public static void processTraining() {
		Requirement.read();
		ReadFile.readinfo();
		int q = 0; // count the number of requirement in requirementlist with status "approve"

		for (int n = 0; n < Requirement.requirementlist.size(); n++) {
			if (Requirement.requirementlist.get(n).getStatus().equals("training"))
				q++;
		}
		if (q == 0) {
			System.out.println("No training teachers now!");
			ReadFile.teacherlist.clear();
			ReadFile.classlist.clear();
			Requirement.requirementlist.clear();
		} else {

			for (int i = 0; i < Requirement.requirementlist.size(); i++) {
				// get requirements with status "training"
				if (Requirement.requirementlist.get(i).getStatus().equals("training")) {
					Requirement.requirementlist.get(i).print();
					// Admin input whether the teacher pass the training
					// if pass, the requirement's info is written into class storage file,
					// and remove if from the requirementlist;
					// if fail, the requirement's status becomes "approve",
					// for Admin to find other teachers suitable
					System.out.println("Please input pass/fail for the teacher");
					String s2 = TestProducerequire.s.nextLine();
					if (s2.equals("pass")) {
						System.out.println("----------------------------------------");
						ReadFile.classlist.add(Requirement.requirementlist.get(i).getClass_info());
						System.out.println("The following class info have been saved!!");
						System.out.println("----------------------------------------");
						Requirement.requirementlist.get(i).getClass_info().print();
						Requirement.requirementlist.remove(Requirement.requirementlist.get(i));
					} else {
						Requirement.requirementlist.get(i).setStatus("approve");
						Requirement.requirementlist.get(i).getClass_info().setTeacher(null);
					}
				}
			}
			Requirement.save();
			WriteFile.writeInfo();
		}
	}

}
