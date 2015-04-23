package mvc;

import data.*;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

//wy�wietla graficzn� informacji zawartych w modelu
public class AppView extends JFrame{
	
	//menu view components
	private JMenuBar appMenuBar = new JMenuBar();
	private JMenu appMenu = new JMenu("Aplikacja");
	private JMenuItem appMenuItem = new JMenuItem("Zamknij");
	
	//main window panels
	private JPanel appLeftPanel = new JPanel();
	private JPanel appRightPanel = new JPanel();
	private JPanel appPatientPanel = new JPanel();
	private JPanel appExaminationPanel = new JPanel();
	private JPanel appPatientsListPanel = new JPanel();
	
	//patient panel components
	//labels
	private JLabel appLabelName = new JLabel("Imi�:");
	private JLabel appLabelSurname = new JLabel("Nazwisko:");
	private JLabel appLabelID = new JLabel("Pesel:");
	private JLabel appLabelSex = new JLabel("P�e�:");
	private JLabel appLabelInsurance = new JLabel("Ubezpieczenie:");
	//text fields
	private JTextField appTextFieldName = new JTextField(15);
	private JTextField appTextFieldSurname = new JTextField(15);
	private JTextField appTextFieldID = new JTextField(15);
	//radio buttons
	private JRadioButton appRadioButtonWoman = new JRadioButton("Kobieta");
	private JRadioButton appRadioButtonMan = new JRadioButton("M�czyzna");
	//combo box
	private JComboBox<String> appComboBoxInsurance = new JComboBox<String>();
	//action buttons
	private JButton appButtonPatientSave = new JButton("Zapisz");
	private JButton appButtonPatientCancel = new JButton("Anuluj");
	
	//examination panel components
	//label
	private JLabel appLabelDate = new JLabel("Data [day/month/year]:");
	private JLabel appLabelExamDate = new JLabel();
	//calender
	private JCalendar dateCalendar = new JCalendar();
	private MyDate currentDate = new MyDate();
	//check boxes
	private JCheckBox appCheckBoxHBS = new JCheckBox("HBS");
	private JCheckBox appCheckBoxHIV = new JCheckBox("HIV");
	private JCheckBox appCheckBoxHCV = new JCheckBox("HCV");
	//action buttons
	private JButton appButtonExaminationSave = new JButton("Zapisz");
	private JButton appButtonExaminationCancel = new JButton("Anuluj");
	
	//patients list components
	//table
	private JScrollPane appScrollPaneList = new JScrollPane();
	private JTable appTableList = new JTable();
	/*{
		public Class<?> getColumnClass(int column)
		{
			switch (column)
			{
				case 0: 
				case 3: 
					return String.class;
				case 1: 
					return Character.class;
				default:
					return Boolean.class;
			}
		}
	};*/
	//action buttons
	private JButton appButtonListAdd = new JButton("Dodaj");
	private JButton appButtonListDelete = new JButton("Usu�");
	//patient number labels & text
	private JLabel appLabelPatientsNumber = new JLabel("Liczba pacjent�w:");
	private JTextField appTextFieldPatientsNumber = new JTextField(4);
	
	public AppView(){
		
		//set main view
		this.setTitle("Rejestracja wynik�w bada�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		//set menu view
		appMenuBar.add(appMenu);
		appMenu.add(appMenuItem);
		setJMenuBar(appMenuBar);
		
		//set main view panels
		appPatientPanel.setBorder(BorderFactory.createTitledBorder("Dane pacjenta"));
		appExaminationPanel.setBorder(BorderFactory.createTitledBorder("Badanie"));
		appPatientsListPanel.setBorder(BorderFactory.createTitledBorder("Lista pacjent�w"));
		
		GridLayout appPanelsLayout = new GridLayout(1,2);
		this.setLayout(appPanelsLayout);
		this.add(appLeftPanel);
		this.add(appRightPanel);

		GridLayout appLeftPanelLayout = new GridLayout(2,1);
		appLeftPanel.setLayout(appLeftPanelLayout);
		appLeftPanel.add(appPatientPanel);
		appLeftPanel.add(appExaminationPanel);
		
		GridLayout appRightPanelLayout = new GridLayout(1,1);
		appRightPanel.setLayout(appRightPanelLayout);
		appRightPanel.add(appPatientsListPanel);
		
		//set patient view panel
		appPatientPanel.setLayout(new BorderLayout());
		
		JPanel appPatientDataPanel = new JPanel();
		appPatientDataPanel.setLayout(new GridLayout(0,2,2,20));
		
		appPatientDataPanel.add(appLabelName);
		appPatientDataPanel.add(appTextFieldName);
		appPatientDataPanel.add(appLabelSurname);
		appPatientDataPanel.add(appTextFieldSurname);
		appPatientDataPanel.add(appLabelID);
		appPatientDataPanel.add(appTextFieldID);
		
		appPatientDataPanel.add(appLabelSex);
		JPanel appSexPanel = new JPanel();
		appSexPanel.setLayout(new FlowLayout());
		appSexPanel.add(appRadioButtonWoman);
		appSexPanel.add(appRadioButtonMan);
		appPatientDataPanel.add(appSexPanel);
		
		appPatientDataPanel.add(appLabelInsurance);
		String[] insurance = new String[3];
		insurance[0] = "NFZ";
		insurance[1] = "Prywatne";
		insurance[2] = "Brak";
		appComboBoxInsurance.setModel(new DefaultComboBoxModel<String>(insurance));
		appComboBoxInsurance.setSelectedIndex(2);
		appPatientDataPanel.add(appComboBoxInsurance);
		
		appPatientPanel.add(appPatientDataPanel, BorderLayout.CENTER);
		
		JPanel appActionBar1 = new JPanel();
		appActionBar1.setLayout(new FlowLayout());
		appButtonPatientSave.setEnabled(false);
		appActionBar1.add(appButtonPatientSave);
		appActionBar1.add(appButtonPatientCancel);
		appPatientPanel.add(appActionBar1, BorderLayout.PAGE_END);
		
		//set examination view panel
		appExaminationPanel.setLayout(new BorderLayout());
		
		JPanel appSelectDatePanel = new JPanel();
		appSelectDatePanel.setLayout(new FlowLayout());
		appSelectDatePanel.add(appLabelDate);
		currentDate = readCalendarDate();
		appLabelExamDate.setText(currentDate.toString());
		appSelectDatePanel.add(appLabelExamDate);
		appExaminationPanel.add(appSelectDatePanel, BorderLayout.PAGE_START);
		appExaminationPanel.add(dateCalendar, BorderLayout.LINE_END);
			
		//poprawi� ten layout
		JLabel appExaminationResult = new JLabel("Wykryto:");
		JPanel appExaminationDataPanel = new JPanel();
		appExaminationDataPanel.setLayout(new BoxLayout(appExaminationDataPanel, BoxLayout.Y_AXIS));
		appExaminationDataPanel.add(appExaminationResult);
		appExaminationDataPanel.add(appCheckBoxHBS);
		appExaminationDataPanel.add(appCheckBoxHIV);
		appExaminationDataPanel.add(appCheckBoxHCV);
		appExaminationPanel.add(new JLabel(), BorderLayout.LINE_START);
		appExaminationPanel.add(appExaminationDataPanel, BorderLayout.CENTER);
		
		JPanel appActionBar2 = new JPanel();
		appActionBar2.setLayout(new FlowLayout());
		appButtonExaminationSave.setEnabled(false);
		appActionBar2.add(appButtonExaminationSave);
		appActionBar2.add(appButtonExaminationCancel);
		appExaminationPanel.add(appActionBar2,BorderLayout.PAGE_END);
		
		//set patients list view panel
		appPatientsListPanel.setLayout(new BorderLayout());
		
		String [] columnNames = { "Imi� i Nazwisko", "PESEL", "P�e�", "Ubezpieczenie", "Badanie"};
		Object [] [] data = new Object[30] [5];

		appTableList.setModel(new DefaultTableModel(data,columnNames));
		appPatientsListPanel.add(appTableList);
		appScrollPaneList.setViewportView(appTableList);
		appPatientsListPanel.add(appScrollPaneList);
		
		JPanel appActionPanel3 = new JPanel();
		JPanel appPatientNumberPanel = new JPanel();
		JPanel appActionBar3 = new JPanel();
		appActionPanel3.setLayout(new FlowLayout());
		appActionPanel3.add(appButtonListAdd);
		appButtonListDelete.setEnabled(false);
		appActionPanel3.add(appButtonListDelete);
		appPatientNumberPanel.setLayout(new FlowLayout());
		appPatientNumberPanel.add(appLabelPatientsNumber);
		appPatientNumberPanel.add(appTextFieldPatientsNumber);
		appTextFieldPatientsNumber.setText("0");
		appActionBar3.setLayout(new BorderLayout());
		appActionBar3.add(appActionPanel3, BorderLayout.LINE_START);
		appActionBar3.add(appPatientNumberPanel, BorderLayout.LINE_END);
		appPatientsListPanel.add(appActionBar3, BorderLayout.PAGE_END);
	}
	

	//GETTERS
	public JButton getAppButtonPatientSave() {
		return appButtonPatientSave;
	}

	public JButton getAppButtonPatientCancel() {
		return appButtonPatientCancel;
	}

	public JButton getAppButtonExaminationSave() {
		return appButtonExaminationSave;
	}

	public JButton getAppButtonExaminationCancel() {
		return appButtonExaminationCancel;
	}
	
	public JRadioButton getAppRadioButtonWoman() {
		return appRadioButtonWoman;
	}

	public JRadioButton getAppRadioButtonMan() {
		return appRadioButtonMan;
	}


	//SET CONTROLLER 
	public void setController(ActionListener c) {
		appMenuItem.addActionListener(c);
		appButtonPatientSave.addActionListener(c);
		appButtonPatientCancel.addActionListener(c);
		appButtonExaminationSave.addActionListener(c);
		appButtonExaminationCancel.addActionListener(c);
		appButtonListAdd.addActionListener(c);
		appButtonListDelete.addActionListener(c);
		appRadioButtonMan.addActionListener(c);
		appRadioButtonWoman.addActionListener(c);
		//appTableList.addMouseListener((MouseListener) c);
		//dateCalendar.addMouseListener((MouseListener) c);
	}
	
	//VIEW CHANGE FUNCTIONS
	public void cleanPatientView() {
		appTextFieldName.setText("");
		appTextFieldSurname.setText("");
		appTextFieldID.setText("");
		appRadioButtonMan.setEnabled(true);
		appRadioButtonWoman.setEnabled(true);
		appRadioButtonMan.setSelected(false);
		appRadioButtonWoman.setSelected(false);
		appComboBoxInsurance.setSelectedIndex(2);
	}
	
	public void cleanExaminationView() {
		appCheckBoxHBS.setSelected(false);
		appCheckBoxHCV.setSelected(false);
		appCheckBoxHIV.setSelected(false);
	}
	
	public void setSaveButtonEnable() {
		appButtonPatientSave.setEnabled(true);
		appButtonExaminationSave.setEnabled(true);
	}
	
public Patient patientCreate() {
		Patient newPatient = new Patient();
		if(utils.isText(appTextFieldName.getText()))
			newPatient.setName_(appTextFieldName.getText());
		else {
			//rzuc wyjatkiem
		}
		if(utils.isText(appTextFieldSurname.getText()))
			newPatient.setLast_name_(appTextFieldSurname.getText());
		else {
			//rzuc wyjatkiem
		}
		String id_num = appTextFieldID.getText();
		if(utils.isNumber(id_num)){
			if(id_num.length() == 11)
				newPatient.setID_num_(id_num);
			else {
				//rzuc wyjatkiem
			}
		}
		else {
			//rzuc wyjatkiem
		}
		if(appRadioButtonMan.isSelected())
			newPatient.setSex_(false);
		else if(appRadioButtonWoman.isSelected())
			newPatient.setSex_(true);
		else {
			//rzuc wyjatkiem
		}
		newPatient.setInsurance_(appComboBoxInsurance.getSelectedIndex());
		return newPatient;
	}

public MyDate readCalendarDate(){
	MyDate current_date = new MyDate();
	current_date.setDay_(dateCalendar.getDayChooser().getDay());
	current_date.setMonth_(dateCalendar.getMonthChooser().getMonth());
	current_date.setYear_(dateCalendar.getYearChooser().getYear());
	
	return current_date;
}
public Examination examinationCreate(){
	Examination newExamination = new Examination();
	newExamination.setTest_data_(readCalendarDate());
	newExamination.setHBS_detect_(appCheckBoxHBS.isSelected());
	newExamination.setHCV_detect_(appCheckBoxHCV.isSelected());
	newExamination.setHIV_detect_(appCheckBoxHIV.isSelected());
	return newExamination;
}

public void setPatientToList(Patient patient, int patient_num){
	appTableList.setValueAt(patient.getPatient_name_(), patient_num, 0);
	appTableList.setValueAt(patient.getID_num_(), patient_num, 1);
	if(patient.getSex_() == true)
		appTableList.setValueAt("K", patient_num, 2);
	else if(patient.getSex_() == false)
		appTableList.setValueAt("M", patient_num, 2);
	if(patient.getInsurance_() == 0)
		appTableList.setValueAt("NFZ", patient_num, 3);
	else if(patient.getInsurance_() == 1)
		appTableList.setValueAt("Prywatne", patient_num, 3);
	else if(patient.getInsurance_() == 2)
		appTableList.setValueAt("Brak", patient_num, 3);
	//TODO zrobi� �eby by� widoczny checkbox
	appTableList.setValueAt(patient.getExamination_check_box(), patient_num, 4);
	
	appButtonListDelete.setEnabled(true);
	appTextFieldPatientsNumber.setText(String.valueOf(patient_num+1));
}

}
