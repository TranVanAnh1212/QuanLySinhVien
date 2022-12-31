package Model;

import java.util.Comparator;

public class sortStudentByID2611 implements Comparator<Student2611> {

	@Override
	public int compare(Student2611 sv1, Student2611 sv2) {
		return sv1.getStudentId().compareTo(sv2.getStudentId());
	}
	
}
