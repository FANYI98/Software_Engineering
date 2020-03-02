package Storagefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.sf.json.JSONArray;

public class Administrator extends Person {
	protected Administrator(Date dob, String name) {
		super(dob, name);
	}

	public static void find_trainingteacher() {
		Requirement.read();
		Read_File.readinfo();
		Scanner s = new Scanner(System.in);
		int q=0;
		
		for(int n=0;n<Requirement.requirementlist.size();n++) {
			if (Requirement.requirementlist.get(n).getStatus().equals("approve"))
				q++;
		}
		
		if (q==0) {
			System.out.println("No requirement need teachers now!");
			Read_File.teacherlist.clear();
			Read_File.classlist.clear();
			Requirement.requirementlist.clear();
		}else {
		for (int i = 0; i < Requirement.requirementlist.size(); i++) {
			List<Teacher> candidatelist = null;
			if (Requirement.requirementlist.get(i).getStatus().equals("approve")) {
				candidatelist = Training.candidate(Requirement.requirementlist.get(i));
				System.out.println("The requirement info:");
				Requirement.requirementlist.get(i).print();
				if(candidatelist.size()==0) {
					System.out.println("No teacher suitable");
					continue;
				}else {
				System.out.println("Below are the teachers suitable:");				
				for (int c = 0; c < candidatelist.size(); c++) {
					System.out.println(c);
					candidatelist.get(c).print();
				}
				System.out.println("Please choose the teacher for training:(number)");
				int s1 = s.nextInt();
				Teacher teacher = candidatelist.get(s1);
				Requirement.requirementlist.get(i).getClass_info().setTeacher(teacher);
				Requirement.requirementlist.get(i).setStatus("training");
				
				System.out.println(teacher.getName() + " has been added into"+
				
						Requirement.requirementlist.get(i).getClass_info().getTitle());
			}	
			}
		}
		Read_File.teacherlist.clear();
		Read_File.classlist.clear();
		Requirement.save();
		System.out.println("Teachers' info has been saved into requirement!");
		}

	}

	public static void process_training() {
		Requirement.read();
		Read_File.readinfo();
		for (int i = 0; i < Requirement.requirementlist.size(); i++) {
			if (Requirement.requirementlist.get(i).getStatus().equals("training")) {
				Requirement.requirementlist.get(i).print();
				System.out.println("Please input pass/fail for the teacher");
				Scanner s = new Scanner(System.in);
				String s2 = s.nextLine();
				if (s2.equals("pass")) {
					Read_File.classlist.add(Requirement.requirementlist.get(i).getClass_info());
					Requirement.requirementlist.remove(Requirement.requirementlist.get(i));
				} else {
					Requirement.requirementlist.get(i).setStatus("approve");
					Requirement.requirementlist.get(i).getClass_info().setTeacher(null);
				}
			}
		}
		Requirement.save();
		Write_File.writeinfo();
	}

}
