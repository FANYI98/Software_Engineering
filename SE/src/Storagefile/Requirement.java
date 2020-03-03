package storagefile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Requirement {
	public static final String requirementpath=System.getProperty("user.dir")+"/src/requirement.json";
	//create list to requirements' info
	public static List<Requirement> requirementlist=new ArrayList<Requirement>();
	private Class class_info;
	private String status=null;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//contributor
	public Requirement(Class class_info) {
		this.class_info=class_info;
		this.status=null;
	}
	public Requirement() {
	}
	public Class getClass_info() {
		return class_info;
	}
	public void setClass_info(Class class_info) {
		this.class_info = class_info;
	}
	
	
	public static void save() {	
		JSONArray iArray=JSONArray.fromObject(Requirement.requirementlist);
//		System.out.println(iArray);
		
		try {
			FileWriter fw1 = new FileWriter(Requirement.requirementpath);
	        BufferedWriter bw1 = new BufferedWriter(fw1);
	        iArray.write(bw1);
	        bw1.close();
//	        System.out.println("Save requirements' info!");   
	        
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			 Requirement.requirementlist.clear();
		}
	}
	
	public static void read() {
		String s;
		try {
			s = FileUtils.readFileToString(new File(requirementpath));
			JSONArray jArray1=JSONArray.fromObject(s);
//			System.out.println(jArray1);

			
			for(int i=0;i<jArray1.size();i++) {
				JSONObject json=(JSONObject)jArray1.get(i) ;
				Requirement requirement_detail=(Requirement)JSONObject.toBean(json,Requirement.class);
				requirementlist.add(requirement_detail);
			}
//			System.out.println("Requirement' info has been read into requirementlist!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
}	
	public void print() {
		class_info.print();
		System.out.println("Status: "+status);
	}
	
}
