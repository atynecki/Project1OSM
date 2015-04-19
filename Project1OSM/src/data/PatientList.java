package data;

import java.util.*;

public class PatientList {
	private LinkedHashMap <Patient, Examination> patient_list_ = new LinkedHashMap <Patient, Examination>();
	private int patients_number_ = 0;
	
	public PatientList(){
		patients_number_ = 0;		
	}
	
	public PatientList(Patient p, Examination e){
		patient_list_.put(p,e);
		patients_number_++;
	}
	
	public int getPatients_number_() {
		return patients_number_;
	}
	
	public void addPatient(Patient p, Examination e){
		patient_list_.put(p,e);
		if(e != null)
			e.setExamination_flag_();
		patients_number_++;
	}
	
	public void erasePatient(Patient p){
		patient_list_.remove(p);
		patients_number_--;
	}
	
	public Boolean hasPatient(Patient p){
		if(patient_list_.containsKey(p))
			return true;
		else
			return false;
	}
	
	public void clearPatientList(){
		patient_list_.clear();
	}
	
	public Patient getPatientData(int ID_num){
		for(Patient p : patient_list_.keySet()){
			if(p.getID_num_() == ID_num)
				return p;
		}
		return null;
	}
}
