package mvc;
import data.*;

import java.awt.event.*;

import javax.swing.JFrame;
//realizuje interakcjê z u¿ytkownikiem, aktualizuje model i podmienia widok
public class AppController implements ActionListener, MouseListener{
	private AppModel cModel = null;
	private AppView cView = null;
	
	public AppController (AppModel model, AppView view){
		this.cModel = model;
		this.cView = view;
		this.cModel.setController(this);
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
					cModel.setPatient_(new_patient);
					cView.setPatientToList(cModel.getPatient_(cModel.getPatients_number_()-1),cModel.getPatients_number_()-1);
				}
				
				else if(actionSource.equals(cView.getAppButtonExaminationSave())){
					
				}
				break;
			
			case "Dodaj":
				cView.setSaveButtonEnable();
			
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
				
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object actionSource = e.getSource();
		if(actionSource == cView.getAppTableList()){
			int row_number = 0;
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
