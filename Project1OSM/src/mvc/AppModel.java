package mvc;

import data.*;

//reprezentuje dane oraz stan aplikacji i zapewnia do nich dostêp
public class AppModel {
	private Patient patient_;
	private Examination exam_;
	private PatientList patients_list_;
	private AppController controller = null;
	
	public void setController(AppController c){
		this.controller = c;
	}
}
