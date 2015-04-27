package data;

public class Patient extends Person {
	private String patient_name_;
	private Examination exam_;
	
	public Patient(){
		super();
		patient_name_ = null;
		exam_ = null;
	}
	
	public Patient(String name, String last_name, String ID_num, Boolean sex, int insurance){
		super(name, last_name, ID_num, sex, insurance);
		patient_name_ = name + last_name;
		exam_ = null;
	}
	
	public Patient(Patient p, Examination e){
		super(p.name_, p.surname_, p.ID_num_, p.sex_, p.insurance_);
		patient_name_ = p.name_ + " " + p.surname_;
		exam_ = e;
	}
	
	public String getPatient_name_() {
		return patient_name_;
	}

	public void setPatient_name_() {
		this.patient_name_ = name_ + " " + surname_;
	}
	
	public Examination getExam_() {
		return exam_;
	}

	public void setExam_(Examination exam_) {
		this.exam_ = exam_;
	}
	
	/** method for compare ID number of patients */
	public boolean equals(Patient p){
		if(p==null || !(this.ID_num_.equals(p.ID_num_)))
			return false;
		return true;
	}
}
