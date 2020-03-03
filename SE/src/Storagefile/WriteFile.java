package storagefile;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import net.sf.json.JSONArray;
import storagefile.ReadFile;

//write classlist/teacherlist info to Json file
public class WriteFile {
	public static void writeInfo() {
		//change list into json array
		JSONArray iArray1=JSONArray.fromObject(ReadFile.teacherlist);
//		System.out.println(iArray1);		
		JSONArray iArray2=JSONArray.fromObject(ReadFile.classlist);
//		System.out.println(iArray2);
		
		try {
			//write json array into file
			FileWriter fw1 = new FileWriter(ReadFile.teacherpath);
	        BufferedWriter bw1 = new BufferedWriter(fw1);
	        iArray1.write(bw1);
	        bw1.close();
//	        System.out.println("Save teachers' changes into file!");
	        
	        FileWriter fw2 = new FileWriter(ReadFile.classpath);
	        BufferedWriter bw2 = new BufferedWriter(fw2);
	        iArray2.write(bw2);
	        bw2.close();
//	        System.out.println("Save classess' changes into file!");
	        
	        ReadFile.teacherlist.clear();
	        ReadFile.classlist.clear();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}  		
	}
}
