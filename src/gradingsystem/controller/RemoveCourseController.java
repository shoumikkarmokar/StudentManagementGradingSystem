package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Departement;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

public class RemoveCourseController {
    public static boolean removeCourse(int selectedDept, int selectedCourse){
        Departement d = Departement.getDepartement(selectedDept);
        
        DBConnector db = new DBConnector();
        
        boolean remove = db.removeCourse(selectedCourse);
        
        if(remove){
            d.removeCourse(selectedCourse);
            return true;
        }
        return false;
    }
}
