package mvc;

import java.awt.event.*;

import javax.swing.JFrame;
//realizuje interakcjê z u¿ytkownikiem, aktualizuje model i podmienia widok
public class AppController implements ActionListener{
	private AppModel cModel = null;
	private AppView cView = null;
	
	public AppController (AppModel model, AppView view){
		this.cModel = model;
		this.cView = view;
		this.cModel.setController(this);
	}
	
	@Override
	public void actionPerformed (ActionEvent e){
		int id = e.getModifiers();
		if(e.getActionCommand().equals("Zamknij")){
			System.exit(0);
		}
		else if(e.getActionCommand().equals("Anuluj")){
			if(e.getSource().equals(cView.getAppButtonPatientCancel()))
				cView.cleanPatientView();
			if(e.getSource().equals(cView.getAppButtonExaminationCancel()))
				cView.cleanExaminationView();
		}
	}
	public void updateView(){
		
	}
}
