package mvc;

import data.*;
import java.awt.event.*;

/**
 * @class AppController
 * @brief class representing application control. Implements user interaction, model and views update.
 * Contains AppModel, AppView and current patient number.
 * @implements ActionListener, MouseListener
 */

public class AppController implements ActionListener, MouseListener{
	private AppModel cModel = null;
	private AppView cView = null;
	private int current_patient_number;
	
	/** parameterized constructors */
	public AppController (AppModel model, AppView view){
		this.cModel = model;
		this.cView = view;
		this.cModel.setController(this);
		current_patient_number = -1;
	}
	
	/**
	 * @fn actionPerformed()
	 * @brief action event handler
	 * @param action event
	 */
	@Override
	public void actionPerformed (ActionEvent e) {
		String actionCommand = e.getActionCommand();
		Object actionSource = e.getSource();
		
		switch(actionCommand){
			case "Zamknij":
				System.exit(0);
				break;
			
			case "Anuluj":
				if(actionSource.equals(cView.getAppButtonPatientCancel()))
					cView.cleanPatientView();
				current_patient_number = -1;
					cView.clearListSelection();
				if(actionSource.equals(cView.getAppButtonExaminationCancel()))
					cView.cleanExaminationView();
				break;
			
			case "Zapisz":
				if(actionSource.equals(cView.getAppButtonPatientSave())){
					try {
						Patient new_patient  = new Patient(cView.readPatientView(),null);
						if(current_patient_number != -1){
							new_patient.setExam_(cModel.getExam_(current_patient_number));
							cModel.replacePatientAt(current_patient_number, new_patient);
							cView.repaintPatientList(cModel.getPatient_list_());
						}
						else {
							if(!cModel.hasPatient(new_patient)){
								cModel.setPatient_(new_patient);
								cView.addRowToPatientList();
								cView.repaintPatientList(cModel.getPatient_list_());
							}
							else{
								cView.setInfoMessageDialog("Pacjent " + new_patient.toString() + " ju¿ istnieje");
							}
						}
					} catch (AppException exception){
						exception.show_exception();
					}
				}
				else if(actionSource.equals(cView.getAppButtonExaminationSave())){
					if(current_patient_number != -1){
						cModel.setExam_(cView.readExaminationView(),current_patient_number);
						cView.setExamCheckBoxSelected(current_patient_number);
					}
					else if(cModel.getPatient_list_().isEmpty()){
						cView.setInfoMessageDialog("Lista pacjentów jest pusta");
					}
					else {
						cView.setInfoMessageDialog("Proszê wybraæ pacjenta z listy");
					}
				}
				break;
			
			case "Dodaj":
				cView.setPatientSaveButtonEnable();
				cView.setExaminationSaveButtonEnable();
				break;
				
			case "Usuñ":
				if(current_patient_number == -1){
					cView.setInfoMessageDialog("Proszê wybraæ pacjenta z listy");
				}
				else {
					cView.cleanPatientView();
					cView.cleanExaminationView();
					cModel.erasePatient(current_patient_number);
					cView.repaintPatientList(cModel.getPatient_list_());
					cView.removeRowFromPatientList();
					current_patient_number = -1;
					if(cModel.getPatient_list_().isEmpty()){
						cView.setListDeleteButtonDisable();
					}
					cView.clearListSelection();
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
				cView.closeCalendarFrame();
				break;
			case "Ustaw date":
				cView.createCalendarFrame();
				break;
				
		}	
	}

	/**
	 * @fn mouseClicked()
	 * @brief mouse clicked event handler
	 * @param mouse clicked event
	 */
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
