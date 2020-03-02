package Storagefile;

public class Person {

	private Date dob; // date of birth
	private String name;



	protected Person(Date dob, String name) {
		this.dob = dob;
	
		this.name = name;
	}
	protected Person() {
		
	}
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public void print() {
		System.out.println(name + " :" +dob);
	}
}
