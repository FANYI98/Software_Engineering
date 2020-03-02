package Storagefile;

public class Class {
	private Teacher teacher;
	private String title;
	private String location;
	private String time;
	private String brief_intro;
	private String major;
	
	//contributor
	public Class(String title, String location,String time,Teacher teacher,String brief_intro,String major) {
		this.title=title;
		this.location=location;
		this.time=time;
		this.teacher=teacher;
		this.brief_intro=brief_intro;
		this.major=major;
				
	}
	public Class() {
		
	}
	

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBrief_intro() {
		return brief_intro;
	}

	public void setBrief_intro(String brief_intro) {
		this.brief_intro = brief_intro;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	public void print() {
		System.out.println("-------------------------------------------");

		System.out.println("Title:"+title+" "+" Location:"+location+ " Time:"+time);
		System.out.print("Teacher: ");
		if (this.teacher!=null)
		teacher.print();
		System.out.println("Brief intro: "+brief_intro);
		System.out.println("Major: "+major);
		
	}
}
