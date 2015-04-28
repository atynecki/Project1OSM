package mvc;

import java.util.*;
import data.*;

/**
 * @class AppModel
 * @brief class representing all application date, application state and allows access to them.
 * Contains list of patients and controller class
 */

public class AppModel {
	private ArrayList<Patient> patient_list_ = new ArrayList<Patient>();
	private AppController controller_;
	
	/** default constructors */
	public AppModel (){
		patient_list_.clear();
		controller_ = null;
	}
	
	/** getters and setters */
	public void setPatient_(Patient patient) {
		this.patient_list_.add(patient);
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

	/**
	 * @fn erasePatient()
	 * @brief remove patient from list at index
	 * @param index
	 */
	public void erasePatient(int index){
		patient_list_.remove(index);
	}
	
	/**
	 * @fn replacePatientAt()
	 * @brief replace patient data with new patient at index
	 * @param index
	 * @param new patient data
	 */
	public void replacePatientAt(int index, Patient new_patient){
		patient_list_.set(index, new_patient);
	}
	
	/**
	 * @fn hasPatient()
	 * @brief check if patient is on the list
	 * @param patient data to check
	 * @return true if patient is on the list 
	 */
	public Boolean hasPatient(Patient p){
		for(Patient patient: patient_list_){
			if(patient.equals(p))
				return true;
		}
		return false;
	}
	
	/**
	 * @fn clearPatientList()
	 * @brief clear patient list
	 */
	public void clearPatientList(){
		patient_list_.clear();
	}
}
