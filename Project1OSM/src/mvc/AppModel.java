package mvc;

import java.util.*;

import data.*;

//reprezentuje dane oraz stan aplikacji i zapewnia do nich dostêp
public class AppModel {
	private ArrayList<Patient> patient_list_ = new ArrayList<Patient>();
	private int patients_number_;
	private AppController controller_;
	
	public AppModel (){
		patients_number_ = 0;
		patient_list_.clear();
		controller_ = null;
	}
	
	/// GETTERS END SETTERS
	public int getPatients_number_() {
		return patients_number_;
	}

	public void setPatient_(Patient patient) {
		this.patient_list_.add(patient);
		patients_number_++;
	}
	
	public Patient getPatient_(int index) {
		return patient_list_.get(index);
	}

	public void setExam_(Examination exam, int p_index) {
		this.patient_list_.get(p_index).setExam_(exam);
	}
	
	public Examination getExam_(int p_index) {
		return patient_list_.get(p_index).getExam_();
	}

	public ArrayList<Patient> getPatient_list_() {
		return patient_list_;
	}

	public void setPatient_list_(ArrayList<Patient> patient_list_) {
		this.patient_list_ = patient_list_;
	}
	
	public void setController(AppController c){
		this.controller_ = c;
	}

	/// METHODS
	public void erasePatient(int index){
		patient_list_.remove(index);
		patients_number_--;
	}
	
	//TODO przetestowaæ dla podobnych pol
	public Boolean hasPatient(Patient p){
		for(Patient patient :patient_list_){
			if(patient.equals(p));
				return true;
		}
		return false;
	}
	
	public void clearPatientList(){
		patient_list_.clear();
		patients_number_ = 0;
	}
}
