package data;

public class MyDate {
	private int day_;
	private int month_;
	private int year_;
	
	public MyDate(){
		day_ = 1;
		month_ = 1;
		year_ = 1900;
	}
	
	public MyDate(int d, int m, int y){
		day_ = d;
		month_ = m;
		year_ = y;
	}

	public int getDay_() {
		return day_;
	}

	public void setDay_(int day_) {
		this.day_ = day_;
	}

	public int getMonth_() {
		return month_;
	}

	public void setMonth_(int month_) {
		this.month_ = month_;
	}

	public int getYear_() {
		return year_;
	}

	public void setYear_(int year_) {
		this.year_ = year_;
	}

	@Override
	public String toString() {
		return day_ + "/" + (month_+1) + "/" + year_;
	}
	
	
}
