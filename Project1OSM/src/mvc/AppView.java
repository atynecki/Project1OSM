package mvc;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
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
	private JLabel appLabelName = new JLabel("Imiê:");
	private JLabel appLabelSurname = new JLabel("Nazwisko:");
	private JLabel appLabelID = new JLabel("Pesel:");
	private JLabel appLabelSex = new JLabel("P³eæ:");
	private JLabel appLabelInsurance = new JLabel("Ubezpieczenie:");
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
	private JLabel appLabelDate = new JLabel("Data:");
	//text field
	private JTextField appTextFieldDate = new JTextField(15);
	//calender
	private JCalendar dateCalendar = new JCalendar();
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
	private JButton appButtonListDelete = new JButton("Usuñ");
	
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
		appExaminationPanel.setLayout(new BoxLayout(appExaminationPanel, BoxLayout.PAGE_AXIS));
		
		JPanel appDatePanel = new JPanel();
		appDatePanel.setLayout(new GridLayout(0,3));
		appDatePanel.add(appLabelDate);
		appDatePanel.add(appTextFieldDate);
		//TODO dorzuciæ kontrolkê od JCalender
		
		appExaminationPanel.add(appDatePanel);
		
		appExaminationPanel.add(appCheckBoxHBS);
		appExaminationPanel.add(appCheckBoxHIV);
		appExaminationPanel.add(appCheckBoxHCV);
		
		JPanel appActionPanel2 = new JPanel();
		appActionPanel2.setLayout(new FlowLayout());
		appButtonExaminationSave.setEnabled(false);
		appActionPanel2.add(appButtonExaminationSave);
		appActionPanel2.add(appButtonExaminationCancel);
		appExaminationPanel.add(appActionPanel2);
		
		//set patients list view panel
		appPatientsListPanel.setLayout(new BorderLayout());
		
		String [] columnNames = { "Imiê i Nazwisko", "PESEL", "P³eæ", "Ubezpieczenie", "Badanie"};
		Object [] [] data = {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null}
		};

		appTableList.setModel(new DefaultTableModel(data,columnNames));
		appPatientsListPanel.add(appTableList);
		appScrollPaneList.setViewportView(appTableList);
		appPatientsListPanel.add(appScrollPaneList);
		
		JPanel appActionPanel3 = new JPanel();
		appActionPanel3.setLayout(new FlowLayout());
		appActionPanel3.add(appButtonListAdd);
		appActionPanel3.add(appButtonListDelete);
		appPatientsListPanel.add(appActionPanel3, BorderLayout.PAGE_END);
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
	}
	
	//VIEW CHANGE FUNCTIONS
	//TODO dokoñczyæ
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
	//TODO dokoñczyæ
	public void cleanExaminationView() {
		appTextFieldDate.setText("");
	}
	
	public void setSaveButtonEnable() {
		appButtonPatientSave.setEnabled(true);
		appButtonExaminationSave.setEnabled(true);
	}

}
