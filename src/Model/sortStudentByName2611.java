package Model;

import java.util.Comparator;

public class sortStudentByName2611 implements Comparator<Student2611> {

	@Override
	public int compare(Student2611 sv1, Student2611 sv2) {
		return sv1.getStudentName().compareTo(sv2.getStudentName());
	}

}
