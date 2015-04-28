package data;

/**
 * @class Patient
 * @brief class representing patient object contains personal information and examination result. 
 * @extend Person class
 */

public class Patient extends Person {
	private String patient_name_;
	private Examination exam_;
	
	/** default constructors */
	public Patient(){
		super();
		patient_name_ = null;
		exam_ = null;
	}
	
	/** parameterized constructors */
	public Patient(Patient p, Examination e){
		super(p.name_, p.surname_, p.ID_num_, p.sex_, p.insurance_);
		patient_name_ = p.name_ + " " + p.surname_;
		exam_ = e;
	}
	
	/** getters and setters */
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
	
	/**
	 * @fn equals()
	 * @brief method for compare ID number of patients
	 * @param patient data to compare
	 * @return true if ID number match
	 */
	public boolean equals(Patient p){
		if(p==null || !(this.ID_num_.equals(p.ID_num_)))
			return false;
		return true;
	}
}
