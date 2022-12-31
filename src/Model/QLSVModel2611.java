package Model;

import java.util.ArrayList;

import Files.readFromFile2611;
import Files.writeToFile2611;

public class QLSVModel2611 {
	public ArrayList<Student2611> arrSv = null;
	
	public QLSVModel2611() {
		super();
		arrSv = readFromFile2611.read();
	}

	public QLSVModel2611(ArrayList<Student2611> arrSv) {
		super();
		this.arrSv = arrSv;
	}

	public ArrayList<Student2611> getArrSv() {
		return arrSv;
	}
	
	public void insert(Student2611 sv) {
		
		this.arrSv.add(sv);
	}
	
	public void deleteStu(Student2611 sv) {
		arrSv.remove(sv);
	}
	
	public Student2611 search(Student2611 sv, String MaSvTim) {
		int arrSize = arrSv.size();
		for ( int i=0; i<arrSize; i++) {
			if ( arrSv.get(i).getStudentId().equals(MaSvTim)) {
				sv = arrSv.get(i);
				return sv;
			}
		}
		return null;
	}
	
	public void displayStudent() {
		for (Student2611 sv : arrSv) {
			System.out.println(sv);
		}
		System.out.println("===============");
	}
	
	public void UpdateStudent( String studentId, String studentName, Dates studentBirth, boolean gender,
			String studentAddress, String studentMajor, double studentGPA ) {
		int arrLength = arrSv.size();
		for ( int i = 0; i < arrLength; i++) {
			arrSv.get(i).setStudentId(studentId);
			arrSv.get(i).setStudentName(studentName);
			arrSv.get(i).setStudentBirth(studentBirth);
			arrSv.get(i).setGender(gender);
			arrSv.get(i).setStudentAddress(studentAddress);
			arrSv.get(i).setStudentMajor(studentMajor);
			arrSv.get(i).setStudentGPA(studentGPA);
			break;
		}
	}
	
	// Ghi Dữ liệu vào file
	public void writeDataToFile() {
		sortStudentByName2611 sortByName = new sortStudentByName2611();
		int arrLenght = arrSv.size();
		for ( int i = 0; i < arrLenght - 1; i++) {
			for ( int j = i+1; j < arrLenght; j++) {
				sortByName.compare(arrSv.get(i), arrSv.get(j));
			}
		}
		writeToFile2611.write(arrSv);
	}
	
	
}
