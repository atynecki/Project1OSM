package data;

/**
 * @class MyDate
 * @brief class representing date object contains day, month and year (as numbers)
 */

public class MyDate {
	private int day_;
	private int month_;
	private int year_;
	
	/** default constructors */
	public MyDate(){
		day_ = 1;
		month_ = 1;
		year_ = 1900;
	}
	
	/** parameterized constructors */
	public MyDate(int d, int m, int y){
		day_ = d;
		month_ = m;
		year_ = y;
	}

	/** getters and setters */
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

	/**
	 * @fn toString()
	 * @brief method return object representation in string
	 * @return string representation of object
	 */
	@Override
	public String toString() {
		return day_ + "/" + (month_+1) + "/" + year_;
	}
}
