package Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import Model.Dates;
import Model.Student2611;
import View.QLSVview2611;

public class readFromFile2611 {
	private static String fileName = "Student.txt";
	public static ArrayList<Student2611> read() {
		ArrayList<Student2611> arrStu = new ArrayList<>();
		try ( BufferedReader br = new BufferedReader( new FileReader(fileName))) {
			String line; // khai báo 1 biến để lưu trữ dl ở từng dòng
			while ( true ) {
				line = br.readLine();
				if ( line == null) {
					break;
				}
				
				String[] txt = line.split(";");
				
				String studentId = txt[0];
				String studentName = txt[1]; 
				boolean gender = ( txt[2].equals("Nam")) ? true : false;
				String[] birthString = txt[3].split("/");
				int day = Integer.parseInt( birthString[0]);
				int month = Integer.parseInt( birthString[1]);
				int year = Integer.parseInt(birthString[2]);			
				Dates studentBirth = new Dates(day, month, year);
				String studentAddress = txt[4];
				String studentMajor = txt[5];
				double studentGPA = Double.parseDouble( txt[6]);
				
				arrStu.add( new Student2611(studentId, studentName, studentBirth, gender, studentAddress, studentMajor, studentGPA));
//				view2611.addRowTable(studentId, studentName, studentBirth, gender, studentAddress, studentMajor, studentGPA);
				
			}
			
			
		} catch ( IOException e) {
			e.printStackTrace();
		}
		return arrStu;
	}
	
}
