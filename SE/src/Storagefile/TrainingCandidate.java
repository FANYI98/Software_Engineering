package storagefile;


import java.util.ArrayList;
import java.util.List;

import staff.Teacher;

public class TrainingCandidate {
	//find the suitable teacher for given requirements according to major
	public static List<Teacher> produceCandidate(Requirement r) {
		List<Teacher> candidatelist = new ArrayList<Teacher>();
		String major = r.getClass_info().getMajor();
		for (int j = 0; j < ReadFile.teacherlist.size(); j++) {
			if (ReadFile.teacherlist.get(j).getMajor().equalsIgnoreCase(major)) {
				candidatelist.add(ReadFile.teacherlist.get(j));
			}
		}
		return candidatelist;
	}
	
	
	
	
}
