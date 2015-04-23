package data;

public class Person {
	protected String name_;
	protected String last_name_;
	protected String ID_num_;
	protected Boolean sex_;
	protected int insurance_;
	
	public Person(){
		name_ = null;
		last_name_ = null;
		ID_num_ = null;
		sex_ = false;
		insurance_ = 0;
	}
	
	public Person(String name, String last_name, String ID_num, Boolean sex, int insurance){
		name_ = name;
		last_name_ = last_name;
		ID_num_ = ID_num;
		sex_ = sex;
		insurance_ = insurance;
	}
	
	public String getName_() {
		return name_;
	}

	public void setName_(String name_) {
		this.name_ = name_;
	}

	public String getLast_name_() {
		return last_name_;
	}

	public void setLast_name_(String last_name_) {
		this.last_name_ = last_name_;
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
	
	/** method for compare ID number of person */
	public boolean equals(Person p){
		if(this.ID_num_.equals(p.ID_num_))
			return true;
		else
			return false;
	}
	
	/** methods return object representation w String text */
	public String toString(){
		return ("[" + name_ + last_name_ + ID_num_ + "]");
	}
}
