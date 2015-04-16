package data;

public class Patient {
	private String name_;
	private String last_name_;
	private Double ID_num_;
	private Boolean sex_;
	private int insurance_;
	
	public Patient(){
		name_ = null;
		last_name_ = null;
		ID_num_ = 0.0;
		sex_ = false;
		insurance_ = 0;
	}
	
	public Patient(String name, String last_name, Double ID_num, Boolean sex, int insurance){
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

	public Double getID_num_() {
		return ID_num_;
	}

	public void setID_num_(Double iD_num_) {
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
	
	/** method for compare ID number of patients */
	public boolean equals(Patient p){
		if(this.ID_num_.equals(p.ID_num_))
			return true;
		else
			return false;
	}
}
