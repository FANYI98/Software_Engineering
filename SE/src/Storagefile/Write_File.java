package Storagefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import net.sf.json.JSONArray;
import Storagefile.Read_File;
//write class/teacher info to Json file
public class Write_File {
	public static void writeinfo() {
		JSONArray iArray1=JSONArray.fromObject(Read_File.teacherlist);
//		System.out.println(iArray1);		
		JSONArray iArray2=JSONArray.fromObject(Read_File.classlist);
//		System.out.println(iArray2);
		
		try {
			FileWriter fw1 = new FileWriter(Read_File.teacherpath);
	        BufferedWriter bw1 = new BufferedWriter(fw1);
	        iArray1.write(bw1);
	        bw1.close();
	        System.out.println("Save teachers' changes into file!");
	        
	        FileWriter fw2 = new FileWriter(Read_File.classpath);
	        BufferedWriter bw2 = new BufferedWriter(fw2);
	        iArray2.write(bw2);
	        bw2.close();
	        System.out.println("Save classess' changes into file!");
	        
	        Read_File.teacherlist.clear();
	        Read_File.teacherlist.clear();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}  		
	}
}
