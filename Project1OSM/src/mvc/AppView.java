package mvc;

import data.*;
import application.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;

//wyœwietla graficzn¹ informacji zawartych w modelu

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
	private JLabel appLabelName = new JLabel("Imiê:", JLabel.CENTER);
	private JLabel appLabelSurname = new JLabel("Nazwisko:", JLabel.CENTER);
	private JLabel appLabelID = new JLabel("Pesel:", JLabel.CENTER);
	private JLabel appLabelSex = new JLabel("P³eæ:", JLabel.CENTER);
	private JLabel appLabelInsurance = new JLabel("Ubezpieczenie:", JLabel.CENTER);
	//text fields
	private JTextField appTextFieldName = new JTextField(15);
	private JTextField appTextFieldSurname = new JTextField(15);
	private JTextField appTextFieldID = new JTextField(15);
	//radio buttons
	private JRadioButton appRadioButtonWoman = new JRadioButton("Kobieta");
	private JRadioButton appRadioButtonMan = new JRadioButton("Mê¿czyzna");
	//combo box
	private JComboBox<String> appComboBoxInsurance = new JComboBox<String>();
	//action buttons
	private JButton appButtonPatientSave = new JButton("Zapisz");
	private JButton appButtonPatientCancel = new JButton("Anuluj");
	
	//examination panel components
	//label
	private JLabel appLabelDate = new JLabel("Data [day/month/year]:", JLabel.CENTER);
	private JLabel appLabelExamDate = new JLabel("", JLabel.CENTER);
	private JLabel appExaminationResult = new JLabel("Wynik:", JLabel.CENTER);
	//calendar frame
	JFrame appCalendarFrame = new JFrame("Ustaw date");
	private JCalendar dateCalendar = new JCalendar();
	private JButton appButtonDateSet = new JButton("Ustaw");
	//check boxes
	private JCheckBox appCheckBoxHBS = new JCheckBox("HBS");
	private JCheckBox appCheckBoxHIV = new JCheckBox("HIV");
	private JCheckBox appCheckBoxHCV = new JCheckBox("HCV");
	//action buttons
	private JButton appCalendarIcon = new JButton("Ustaw date", new ImageIcon("images/JCalendarIcon.gif"));
	private JButton appButtonExaminationSave = new JButton("Zapisz");
	private JButton appButtonExaminationCancel = new JButton("Anuluj");
	
	//patients list components
	//table
	private String [] columnNames = { "Imiê i Nazwisko", "PESEL", "P³eæ", "Ubezpieczenie", "Badanie"};
	private Object [] [] data = new Object[0] [5];
	DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
	private JTable appTableList = new JTable(tableModel)
	{
		 private static final long serialVersionUID = 1L;
		 
		@Override
		public Class<?> getColumnClass(int column)
		{
			switch (column)
			{
				case 0:
					return String .class;
				case 1: 
					return String.class;
				case 2: 
					return Character.class;
				case 3:
					return String.class;
				default:
					return Boolean.class;
			}
		}
		
		@Override
		public boolean isCellEditable(int row, int column){
			return false;
		}
	};
	private JScrollPane appScrollPaneList = new JScrollPane(appTableList);
	//action buttons
	private JButton appButtonListAdd = new JButton("Dodaj");
	private JButton appButtonListDelete = new JButton("Usuñ");
	//patient number labels & text
	private JLabel appLabelPatientsNumber = new JLabel("Liczba pacjentów:");
	private JTextField appTextFieldPatientsNumber = new JTextField(4);
	
	public AppView(){
		
		//set main view
		this.setTitle("Rejestracja wyników badañ");
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
		appPatientsListPanel.setBorder(BorderFactory.createTitledBorder("Lista pacjentów"));
		
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
		
		JPanel appActionBar2 = new JPanel();
		appActionBar2.setLayout(new FlowLayout());
		appButtonExaminationSave.setEnabled(false);
		appActionBar2.add(appButtonExaminationSave);
		appActionBar2.add(appButtonExaminationCancel);
		appExaminationPanel.add(appActionBar2,BorderLayout.PAGE_END);
		
		JPanel appExaminationAllDataPanel = new JPanel();
		appExaminationAllDataPanel.setLayout(new GridLayout(0,2));
		appExaminationPanel.add(appExaminationAllDataPanel);
		
		// TODO wyœrodkowanie checkboxów
		JPanel appExaminationResultPanel = new JPanel();
		appExaminationResultPanel.setLayout(new GridLayout(4,1));
		appExaminationResultPanel.add(appExaminationResult);
		appExaminationResultPanel.add(appCheckBoxHBS);
		appExaminationResultPanel.add(appCheckBoxHIV);
		appExaminationResultPanel.add(appCheckBoxHCV);
		appExaminationAllDataPanel.add(appExaminationResultPanel,0);
		
		JPanel appExaminationDatePanel = new JPanel();
		appExaminationDatePanel.setLayout(new GridLayout(4,0));
		appExaminationDatePanel.add(appLabelDate, 0);
		appLabelExamDate.setText(readCalendarDate().toString());
		appLabelExamDate.setFont(new Font("Arial", Font.BOLD, 22));
		appExaminationDatePanel.add(appLabelExamDate,1);
		appExaminationDatePanel.add(appCalendarIcon);
		
		appExaminationAllDataPanel.add(appExaminationDatePanel);
			
		//set patients list view panel
		appPatientsListPanel.setLayout(new BorderLayout());
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


	public JTable getAppTableList() {
		return appTableList;
	}

	//SET CONTROLLER 
	public void setController(AppController c) {
		appMenuItem.addActionListener(c);
		appButtonPatientSave.addActionListener(c);
		appButtonPatientCancel.addActionListener(c);
		appButtonExaminationSave.addActionListener(c);
		appButtonExaminationCancel.addActionListener(c);
		appButtonListAdd.addActionListener(c);
		appButtonListDelete.addActionListener(c);
		appRadioButtonMan.addActionListener(c);
		appRadioButtonWoman.addActionListener(c);
		appButtonDateSet.addActionListener(c);
		appTableList.addMouseListener(c);
		appCalendarIcon.addActionListener(c);
	}
	
	//BUTTONS VIEWS
	public void setPatientSaveButtonEnable() {
		appButtonPatientSave.setEnabled(true);
	}
	
	public void setExaminationSaveButtonEnable() {
		appButtonExaminationSave.setEnabled(true);
	}
	
	public void setListDeleteButtonDisable(){
		appButtonListDelete.setEnabled(false);
	}
	
	//VIEW METHODS
	// Patient View
	public Patient readPatientView() throws AppException {
		Patient newPatient = new Patient();
		if(utils.isText(appTextFieldName.getText()))
			newPatient.setName_(appTextFieldName.getText());
		else {
			throw new AppException("Podano b³êdne imiê");
		}
		if(utils.isText(appTextFieldSurname.getText()))
			newPatient.setLast_name_(appTextFieldSurname.getText());
		else {
			throw new AppException("Podano b³êdne nazwisko");
		}
		String id_num = appTextFieldID.getText();
		if(utils.isNumber(id_num)){
			if(id_num.length() == 11)
				newPatient.setID_num_(id_num);
			else {
				throw new AppException("Podano z krótki numer PESEL");
			}
		}
		else {
			throw new AppException("Podano z³y numer PESEL");
		}
		if(appRadioButtonMan.isSelected())
			newPatient.setSex_(false);
		else if(appRadioButtonWoman.isSelected())
			newPatient.setSex_(true);
		else {
			throw new AppException("Proszê wybraæ p³eæ");
		}
		newPatient.setInsurance_(appComboBoxInsurance.getSelectedIndex());
		return newPatient;
	}
	
	public void setPatientView(Patient p){
		appTextFieldName.setText(p.getName_());
		appTextFieldSurname.setText(p.getLast_name_());
		appTextFieldID.setText(p.getID_num_());
		if(p.getSex_() == false){
			appRadioButtonMan.setEnabled(true);
			appRadioButtonMan.setSelected(true);
			appRadioButtonWoman.setEnabled(false);
		}
		else if(p.getSex_() == true){
			appRadioButtonWoman.setEnabled(true);
			appRadioButtonWoman.setSelected(true);
			appRadioButtonMan.setEnabled(false);
		}
		appComboBoxInsurance.setSelectedIndex(p.getInsurance_());
	}
	
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
	
	//Examination view
	public MyDate readCalendarDate(){
		MyDate current_date = new MyDate();
		current_date.setDay_(dateCalendar.getDayChooser().getDay());
		current_date.setMonth_(dateCalendar.getMonthChooser().getMonth());
		current_date.setYear_(dateCalendar.getYearChooser().getYear());
		
		return current_date;
	}
	
	public void setCalendarDate(MyDate date){
		appLabelExamDate.setText(date.toString());
	}
	
	public Examination readExaminationView(){
		Examination newExamination = new Examination();
		newExamination.setTest_data_(readCalendarDate());
		newExamination.setHBS_detect_(appCheckBoxHBS.isSelected());
		newExamination.setHCV_detect_(appCheckBoxHCV.isSelected());
		newExamination.setHIV_detect_(appCheckBoxHIV.isSelected());
		return newExamination;
	}
	
	public void setExaminationView (Examination exam){
		if(exam.getHBS_detect_() == true)
			appCheckBoxHBS.setSelected(true);
		else
			appCheckBoxHBS.setSelected(false);
		
		if(exam.getHCV_detect_() == true)
			appCheckBoxHCV.setSelected(true);
		else
			appCheckBoxHCV.setSelected(false);
		
		if(exam.getHIV_detect_() == true)
			appCheckBoxHIV.setSelected(true);
		else
			appCheckBoxHIV.setSelected(false);
		setCalendarDate(exam.getTest_data_());
	}
	
	public void cleanExaminationView() {
		appCheckBoxHBS.setSelected(false);
		appCheckBoxHCV.setSelected(false);
		appCheckBoxHIV.setSelected(false);
	}
	
	//Patient List View
	public void repaintPatientList(ArrayList<Patient> patient_list){
		if(patient_list.isEmpty()){
			appTextFieldPatientsNumber.setText(String.valueOf(0));
			return;
		}
			
		for(int i = 0; i < patient_list.size(); i++ ){
			appTableList.setValueAt(patient_list.get(i).getPatient_name_(), i, 0);
			appTableList.setValueAt(patient_list.get(i).getID_num_(), i, 1);
			if(patient_list.get(i).getSex_() == true)
				appTableList.setValueAt("K", i, 2);
			else if(patient_list.get(i).getSex_() == false)
				appTableList.setValueAt("M", i, 2);
			if(patient_list.get(i).getInsurance_() == 0)
				appTableList.setValueAt("NFZ", i, 3);
			else if(patient_list.get(i).getInsurance_() == 1)
				appTableList.setValueAt("Prywatne", i, 3);
			else if(patient_list.get(i).getInsurance_() == 2)
				appTableList.setValueAt("Brak", i, 3);
			if(patient_list.get(i).getExam_() == null)
				appTableList.setValueAt(false, i, 4);
			else 
				appTableList.setValueAt(true, i, 4);
			
			appButtonListDelete.setEnabled(true);
			appTextFieldPatientsNumber.setText(String.valueOf(i+1));
		}
		
	}
	
	public void addRowToPatientList(){
		tableModel.addRow(new Object[] {null, null, null, null, null});
	}
	
	public void removeRowFromPatientList(){
		tableModel.removeRow(tableModel.getRowCount()-1);
	}
	
	public void setExamCheckBoxSelected (int patient_num){
		appTableList.setValueAt(true, patient_num, 4);
	}
	
	public void clearPatientList(){
		appTableList.removeAll();
	}
	
	public void clearListSelection() {
		appTableList.clearSelection();
	}
	
	public void createCalendarFrame(){
		appCalendarFrame.setSize(300,300);
		appCalendarFrame.setResizable(false);
		appCalendarFrame.setLocationRelativeTo(null);
		appCalendarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		appCalendarFrame.setVisible(true);
		JPanel appCalendarPanel = new JPanel();
		appCalendarPanel.setLayout(new BorderLayout(0, 0));
		appCalendarPanel.add(dateCalendar, BorderLayout.CENTER);
		appCalendarPanel.add(appButtonDateSet, BorderLayout.PAGE_END);
		appCalendarFrame.add(appCalendarPanel);
	}
	
	public void closeCalendarFrame(){
		appCalendarFrame.dispose();
	}

}
