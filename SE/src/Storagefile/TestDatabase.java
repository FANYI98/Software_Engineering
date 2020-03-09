//package storagefile;
//
//import person.Date;
//import staff.Teacher;
//
//public class TestDatabase {
// public static void main (String args[]) {
//
//  Teacher t1 = new Teacher(1,new Date(1,2,1997),"Tom","programmer");
//  Teacher t2 = new Teacher(2,new Date(2,3,1988),"Anna","security");
//  Teacher t3 = new Teacher(3,new Date(4,5,1997),"John","programmer");
//  Teacher t4 = new Teacher(4,new Date(6,7,1997),"Susan","math");  
//  ReadFile.teacherlist.add(t1);
//  ReadFile.teacherlist.add(t2);
//  ReadFile.teacherlist.add(t3);
//  ReadFile.teacherlist.add(t4); 
//  
//  Class c1 = new Class("AP","MainBuilding","Tuesday 11-12",null,"This Brief Info","Programmer");
//  ReadFile.classlist.add(c1);
//  
//  WriteFile.writeInfo();
//  
//  
//  System.out.println();
//  System.out.println("Read from Files========================");
//
//  Read_File.readinfo();
//
//  for (int i=0;i< Read_File.teacherlist.size();i++) {
//	  Teacher teacher=Read_File.teacherlist.get(i);
//	  if (teacher.getId()==1) {
//		  teacher.print();
//		  teacher.setMajor("Artist");
//		  System.out.println("change id");
//		  teacher.print();
//		  break;
//	  }
//  }
//  Write_File.writeinfo();
//  System.out.println("refresh teachers info-----------------------------");
////  Read_File.readinfo();
//
//
// }
//}