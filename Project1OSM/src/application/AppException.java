package application;

import javax.swing.JOptionPane;

public class AppException extends Exception{
	private static final long serialVersionUID = 1L;
	public AppException(){
		super();	
	}
	public AppException(String s){
		super(s);
	}
	
	public void show_exception(){
		JOptionPane.showMessageDialog(null, this.getMessage(), "Application error", JOptionPane.ERROR_MESSAGE);
	}
}
