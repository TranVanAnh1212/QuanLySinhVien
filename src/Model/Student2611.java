package Model;

import java.util.Objects;

public class Student2611 {
	private String studentId;
	private String studentName;
	private Dates studentBirth;
	private boolean gender;
	private String studentAddress;
	private String studentMajor;
	private double studentGPA;
	
	public Student2611() {
		super();
	}

	public Student2611(String studentId, String studentName, Dates studentBirth, boolean gender, 
			String studentAddress, String studentMajor, double studentGPA) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentBirth = studentBirth;
		this.gender = gender;
		this.studentAddress = studentAddress;
		this.studentMajor = studentMajor;
		this.studentGPA = studentGPA;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Dates getStudentBirth() {
		return studentBirth;
	}

	public void setStudentBirth(Dates studentBirth) {
		this.studentBirth = studentBirth;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentMajor() {
		return studentMajor;
	}

	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}

	public double getStudentGPA() {
		return studentGPA;
	}

	public void setStudentGPA(double studentGPA) {
		this.studentGPA = studentGPA;
	}

	@Override
	public String toString() {
		String isGioiTinh = (this.getGender() == true) ? "Nam" : "Nữ" ;
		return studentId+ ";" + studentName + ";" + isGioiTinh + ";" + studentBirth + ";" + studentAddress + ";" + studentMajor + ";" + studentGPA;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentAddress, studentGPA, gender, studentId, studentMajor, studentBirth, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student2611 other = (Student2611) obj;
		return Objects.equals(studentAddress, other.studentAddress)
				&& Double.doubleToLongBits(studentGPA) == Double.doubleToLongBits(other.studentGPA)
				&& gender == other.gender && Objects.equals(studentId, other.studentId)
				&& Objects.equals(studentMajor, other.studentMajor) && Objects.equals(studentBirth, other.studentBirth)
				&& Objects.equals(studentName, other.studentName);
	}
	
	
	
	
}
