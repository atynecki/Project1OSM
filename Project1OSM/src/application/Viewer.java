/**
 * @name Viewer
 * @author Artur Tynecki
 * @brief simple program used to save the examination results 
 * @version 1.0
 *
 * @section DESCRIPTION
 * It is simple application enabling a create a list of patients with their examinations results. It contains patient data window, 
 * examination result window and patients list window. Application allows add patient with examination result to list, erase patient form list, 
 * update patient data. Graphical User Interface based on MCV (Model-View-Controller) pattern. 
 */

package application;
import java.awt.EventQueue;
import mvc.*;

/**
 * @class Viewer(main class)
 * @brief class with main for run application; set model, view and controller
 */
public class Viewer {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				AppModel model = new AppModel();
				AppView view = new AppView();
				AppController controller = new AppController(model, view);
				view.setController(controller);
				view.setVisible(true);
			}
		});

	}

}
