package Storagefile;


import java.util.ArrayList;
import java.util.List;

public class Training {
	public static List<Teacher> candidate(Requirement r) {
		List<Teacher> candidatelist = new ArrayList<Teacher>();
		String major = r.getClass_info().getMajor();
		for (int j = 0; j < Read_File.teacherlist.size(); j++) {
			if (Read_File.teacherlist.get(j).getMajor().equals(major)) {
				candidatelist.add(Read_File.teacherlist.get(j));
			}
		}
		return candidatelist;
	}
	
	
	
	
}
