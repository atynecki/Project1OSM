package mvc;
import data.*;

import java.awt.Component;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
//realizuje interakcjê z u¿ytkownikiem, aktualizuje model i podmienia widok
public class AppController implements ActionListener, MouseListener{
	private AppModel cModel = null;
	private AppView cView = null;
	private int current_patient_number;
	
	public AppController (AppModel model, AppView view){
		this.cModel = model;
		this.cView = view;
		this.cModel.setController(this);
		current_patient_number = 0;
	}
	
	@Override
	public void actionPerformed (ActionEvent e){
		String actionCommand = e.getActionCommand();
		Object actionSource = e.getSource();
		
		switch(actionCommand){
			case "Zamknij":
				System.exit(0);
				break;
			
			case "Anuluj":
				if(actionSource.equals(cView.getAppButtonPatientCancel()))
					cView.cleanPatientView();
				if(actionSource.equals(cView.getAppButtonExaminationCancel()))
					cView.cleanExaminationView();
				break;
			
			case "Zapisz":
				if(actionSource.equals(cView.getAppButtonPatientSave())){
					Patient new_patient  = new Patient(cView.readPatientView(),null);
					//TODO sprawdzenie czy pacjent ju¿ istnieje
					//if(!cModel.hasPatient(new_patient)){
						cModel.setPatient_(new_patient);
						cView.addRowToPatientList();
						cView.repaintPatientList(cModel.getPatient_list_());
					//}
					//else{
						//System.out.println("Pacjent istnieje na liœcie");
					//}
				}
				
				else if(actionSource.equals(cView.getAppButtonExaminationSave())){
						cModel.setExam_(cView.readExaminationView(),current_patient_number);
						cView.setExamCheckBoxSelected(current_patient_number);
				}
				break;
			
			case "Dodaj":
				cView.setPatientSaveButtonEnable();
				cView.setExaminationSaveButtonEnable();
				break;
				
			case "Usuñ":
				cView.cleanPatientView();
				cView.cleanExaminationView();
				if(!cModel.getPatient_list_().isEmpty()){
					cModel.erasePatient(current_patient_number);
					cView.repaintPatientList(cModel.getPatient_list_());
					cView.removeRowFromPatientList();
				}
				else{
					//rzuæ wyj¹tkiem
					System.out.println("Lista jest pusta");
				}
				break;
			
			case "Mê¿czyzna":
				if(cView.getAppRadioButtonMan().isSelected() == true)
					cView.getAppRadioButtonWoman().setEnabled(false);
				else if(cView.getAppRadioButtonMan().isSelected() == false)
					cView.getAppRadioButtonWoman().setEnabled(true);
				break;
			
			case "Kobieta":
				if(cView.getAppRadioButtonWoman().isSelected() == true)
					cView.getAppRadioButtonMan().setEnabled(false);
				else if(cView.getAppRadioButtonWoman().isSelected() == false)
					cView.getAppRadioButtonMan().setEnabled(true);
				break;
			
			case "Ustaw":
				cView.setCalendarDate(cView.readCalendarDate());
				break;
				
		}	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == cView.getAppTableList()){
			current_patient_number = cView.getAppTableList().getSelectedRow();
			Patient current_patient = cModel.getPatient_(current_patient_number);
			cView.setPatientView(current_patient);
			if(current_patient.getExam_() !=null)
				cView.setExaminationView(current_patient.getExam_());
			else
				cView.cleanExaminationView();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
