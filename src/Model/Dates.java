package Model;

public class Dates {
	private int day;
	private int month;
	private int year;
	
	public Dates() {
		super();
	}

	public Dates(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	
	public String getBirthDay(int day, int month, int year) {
//		return day + "/" + month + "/" + year;
		return this.getDay()  + "/" + this.getMonth() + "/" + this.getYear();
	}
	
}
