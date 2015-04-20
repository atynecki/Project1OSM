package data;

public class Patient extends Person {
	private String patient_name_;
	private Examination exam_;
	
	public Patient(){
		super();
		patient_name_ = null;
	}
	
	public Patient(String name, String last_name, Integer ID_num, Boolean sex, int insurance){
		super(name, last_name, ID_num, sex, insurance);
		patient_name_ = name + last_name;
		exam_ = null;
	}
	
	public Patient(Patient p, Examination e){
		super(p.name_, p.last_name_, p.ID_num_, p.sex_, p.insurance_);
		patient_name_ = p.name_ + p.last_name_;
		exam_ = e;
	}
	
	public String getPatient_name_() {
		return patient_name_;
	}

	public void setPatient_name_(String patient_name_) {
		this.patient_name_ = patient_name_;
	}
	
	public Examination getExam_() {
		return exam_;
	}

	public void setExam_(Examination exam_) {
		this.exam_ = exam_;
	}
	
	//@Override
	/** method for compare ID number of patients */
	public boolean equals(Patient p){
		if(this.ID_num_.equals(p.ID_num_))
			return true;
		else
			return false;
	}
}
