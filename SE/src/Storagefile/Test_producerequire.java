package Storagefile;

import java.util.Scanner;

public class Test_producerequire {

	private static boolean i;

	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.println("================================");
			System.out.println("Please enter your position:PPT Director|Class Director|Administrator");
			String s1 = s.nextLine();
			if (s1.equals("PPT Director")) {
				System.out.println("Please enter your password:");
				if (s.nextLine().equals("PPT")) {
					while (true) {
						Requirement.read();
						PPT_Director.process_requirement();
						Requirement.save();

						System.out.println("Any change has been recieved---You could input exit!or press any key to continue!");
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
					System.out.println("log in");

					while (true) {

						System.out.println("1.add the requirement;2.change reject requirements: else to exit");
						
						
							String s11 = s.nextLine();
							if (s11.equals("1")) {

								Requirement.read();
								System.out.println("-------------------------------------");
								System.out.println("please add the requirement details:");
								Class_Director.produce_requirement();

							} else if (s11.equals("2")) {

								System.out.println("-------------------------------------");

								Class_Director.change_requirement();

							}else 	break;
						
				
					}

				} else {
					System.out.println("Your password is not working!.");
				}

			} else if (s1.equals("Administrator")) {

				System.out.println("Please enter your password:");
				if (s.nextLine().equals("Adm")) {

					while (true) {

						System.out.println("1.find suitable teacher;2.asssess training teacher; else to exit!");
						String s11 = s.nextLine();

						if (s11.equals("1")) {
							Administrator.find_trainingteacher();
						} else if (s11.equals("2")) {
							System.out.println("Please rate the training teacher ");
							Administrator.process_training();
						} else
							break;

					}
				} else {
					System.out.println("Your password is not working!.");
				}

			} else {
				System.out.println("Please enter a correct position.");
			}

		}

	}
}
