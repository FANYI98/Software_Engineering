package test;

import java.util.Scanner;

import staff.Administrator;
import staff.ClassDirector;
import staff.PTTDirector;
import storagefile.Requirement;

public class TestProducerequire {
	//Receive input from console to interact
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// log in as different positions with passwords(PPT|Class|Adm)
			System.out.println("==========================================================================================");
			System.out.println("Please enter your position:PTT Director|Class Director|Administrator (enter exit to leave)");
			System.out.println("==========================================================================================");
			String s1 = s.nextLine();

			if (s1.equals("PTT Director")) {
				System.out.println("Please enter your password:");
				if (s.nextLine().equals("PTT")) {
					System.out.println("Hi, PTT Director!");
					System.out.println(".........................................");
					while (true) {
						Requirement.read();
						// process requirements
						PTTDirector.processRequirement();
						Requirement.save();
						System.out.println("Any change has been recieved---You could input exit!or press any key to continue!");
						System.out.println("---------------------------------------------------------------------------------");
						if (s.nextLine().equals("exit")) {
							break;
						}
					}

				} else {
					System.out.println("Your password is not working!.");

				}

			} else if (s1.equals("Class Director")) {

				System.out.println("Please enter your password:");
				if (s.nextLine().equals("Class")) {
					System.out.println("Hi, Class Director!");
					System.out.println(".........................................");
					while (true) {
						// select process
						System.out.println("1.add the requirement;2.change reject requirements:input else to exit");
						String s11 = s.nextLine();
						if (s11.equals("1")) {

							Requirement.read();
							System.out.println("-------------------------------------");
							System.out.println("please add the requirement details:");
							ClassDirector.produceRequirement();
							System.out.println("-------------------------------------");

						} else if (s11.equals("2")) {

							ClassDirector.changeRequirement();

						} else
							break;

					}

				} else {
					System.out.println("Your password is not working!.");
				}

			} else if (s1.equals("Administrator")) {

				System.out.println("Please enter your password:");
				if (s.nextLine().equals("Adm")) {
					System.out.println("Hi, Administrator!");
					System.out.println(".........................................");
					while (true) {
						//select process
						System.out.println("1.find suitable teacher;2.asssess training teacher; input else to exit!");
						String s11 = s.nextLine();

						if (s11.equals("1")) {
							Administrator.findTrainingTeacher();
							continue;
						} else if (s11.equals("2")) {
							System.out.println("Please rate the training teacher... ");
							Administrator.processTraining();
						} else {
							break;
						}
					}
				} else {
					System.out.println("Your password is not working!.");
				}

			} else if (s1.equals("exit")) {
				break;
			} else {
				System.out.println("Please enter a correct position.");
			}
		}
		s.close();

	}
}
