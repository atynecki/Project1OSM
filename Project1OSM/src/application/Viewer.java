package application;

import java.awt.EventQueue;
import java.util.*;

import mvc.*;
import data.*;

public class Viewer {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				/*Patient patient1 = new Patient("jan", "kowalski", 902359632, false, 0);
				Date exam_data = new Date(115,5,11);
				Examination exam1 = new Examination(true, true, true, exam_data);
				PatientList list = new PatientList(patient1, exam1);
				System.out.println("patient numer: " + list.getPatients_number_());
				System.out.println(patient1.toString());
				System.out.println(exam1.toString());*/
				AppView app = new AppView();
				app.setVisible(true);
			}
		});

	}

}
