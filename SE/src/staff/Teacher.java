package staff;

import person.Date;
import person.Person;

public class Teacher extends Person{
	private String major;
	private int id;
	//constructor
	public Teacher(int id, Date dob, String name, String major) {
		super(dob, name);
		this.major=major;
		this.id=id;
	}
	protected Teacher() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void print() {

		System.out.println(getName() + " :" +String.format("%02d/%02d/%4d", this.getDob().getDay(), this.getDob().getMonth(), this.getDob().getYear())+" "+major);
	}
}
