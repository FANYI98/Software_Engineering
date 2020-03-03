package storagefile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import staff.Teacher;

//read info from Json file to instantiate classes/teachers info

public class ReadFile{
	//files which contains the info of staff and classes.
	public static final String teacherpath=System.getProperty("user.dir")+"/src/teacher.json";
	public static final String classpath=System.getProperty("user.dir")+"/src/class.json";
	//create list to store teacher/class information
	public static List<Teacher> teacherlist=new ArrayList<Teacher>();
	public static List<Class> classlist=new ArrayList<Class>();
	
	
	public static void readinfo() {
			String s1;
			String s2;
			try {
				
				//read .json into string
				s1 = FileUtils.readFileToString(new File(teacherpath));
				s2 = FileUtils.readFileToString(new File(classpath));
//				change string into json array
				JSONArray jArray1=JSONArray.fromObject(s1);
				JSONArray jArray2=JSONArray.fromObject(s2);
//				System.out.println(jArray1);
//				System.out.println(jArray2);
				//Change json array into teacher/class array
				for(int i=0;i<jArray1.size();i++) {
					JSONObject json=(JSONObject)jArray1.get(i) ;
					Teacher teacher=(Teacher)JSONObject.toBean(json,Teacher.class);
//					teacher.print();
					teacherlist.add(teacher);
				}
//				System.out.println("Teachers' info has been read into teacherlist!");
				for(int i=0;i<jArray2.size();i++) {
					JSONObject json=(JSONObject)jArray2.get(i) ;
					Class class_detail=(Class)JSONObject.toBean(json,Class.class);
//					class_detail.print();
					classlist.add(class_detail);
				}
//				System.out.println("Classes' info has been read into classlist!");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}	
}
