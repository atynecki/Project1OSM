package data;

/**
 * @class Person
 * @brief class representing person object contains personal information (name, surname, ID number, sex, type of insurance)
 */

public class Person {
	protected String name_;
	protected String surname_;
	protected String ID_num_;
	protected Boolean sex_;
	protected int insurance_;
	
	/** default constructors */
	public Person(){
		name_ = null;
		surname_ = null;
		ID_num_ = null;
		sex_ = false;
		insurance_ = 0;
	}
	
	/** parameterized constructors */
	public Person(String name, String last_name, String ID_num, Boolean sex, int insurance){
		name_ = name;
		surname_ = last_name;
		ID_num_ = ID_num;
		sex_ = sex;
		insurance_ = insurance;
	}
	
	/** getters and setters */
	public String getName_() {
		return name_;
	}

	public void setName_(String name_) {
		this.name_ = name_;
	}

	public String getLast_name_() {
		return surname_;
	}

	public void setLast_name_(String last_name_) {
		this.surname_ = last_name_;
	}

	public String getID_num_() {
		return ID_num_;
	}

	public void setID_num_(String iD_num_) {
		ID_num_ = iD_num_;
	}

	public Boolean getSex_() {
		return sex_;
	}

	public void setSex_(Boolean sex_) {
		this.sex_ = sex_;
	}

	public int getInsurance_() {
		return insurance_;
	}

	public void setInsurance_(int insurance_) {
		this.insurance_ = insurance_;
	}
	
	/**
	 * @fn equals()
	 * @brief method for compare personal information
	 * @param person data to compare
	 * @return true if person match
	 */
	public boolean equals(Person p){
		if(p==null || this.name_!=p.name_ || this.surname_!=p.surname_ || this.ID_num_!=p.ID_num_ || this.sex_!=p.sex_ || this.insurance_!=p.insurance_)
			return false;
		return true;
	}
	
	/**
	 * @fn toString()
	 * @brief method return object representation in string
	 * @return string representation of object
	 */
	@Override
	public String toString(){
		return ("[" + name_ + " " + surname_ + " "+ ID_num_ + "]");
	}
}
