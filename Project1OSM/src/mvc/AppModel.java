package mvc;

import data.*;

//reprezentuje dane oraz stan aplikacji i zapewnia do nich dostêp
public class AppModel extends PatientList{
	private Patient patient_;
	private Examination exam_;
	private AppController controller;
	
	public AppModel (){
		super();
		patient_ = null;
		exam_ = null;
		controller = null;
	}
	public Patient getPatient_() {
		return patient_;
	}


	public void setPatient_(Patient patient_) {
		this.patient_ = patient_;
	}


	public Examination getExam_() {
		return exam_;
	}


	public void setExam_(Examination exam_) {
		this.exam_ = exam_;
	}


	public void setController(AppController c){
		this.controller = c;
	}
	
	public boolean isText (String line){
		for(int i=0; i<line.length(); i++){
			if(!(Character.isLetter(line.charAt(i))))
					return false;
		}
		return true;
	}
	
	public boolean isNumber (String line){
		for(int i=0; i<line.length(); i++){
			if(!(Character.isDigit(line.charAt(i))))
					return false;
		}
		return true;
	}
}
