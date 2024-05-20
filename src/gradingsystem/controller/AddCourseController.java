package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Course;
import gradingsystem.Entities.Departement;
import gradingsystem.Entities.Instructor;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;


public class AddCourseController {

    public static void addCourse(int id, String CourseName, int creditHrs, int departmentIndex, int instructorIndex){
        Course c = new Course(id, CourseName, creditHrs, instructorIndex);
        Departement d = Departement.getDepartement(departmentIndex);
        d.addCourse(c);
    }
    
    public static String addCourseToDatabase(String name, String CreditHrs, String Pid, String Did){
        DBConnector db = new DBConnector();
        
        int cid = db.addCourse(name, CreditHrs, Pid, Did);
        
        
        Course c = new Course(cid, name, Integer.parseInt(CreditHrs), Integer.parseInt(Pid));
        Departement d = Departement.getDepartement(Integer.parseInt(Did));
        d.addCourse(c);
        
        return name;
    }
    
    static public DefaultComboBoxModel getInstructorNames(){
        DefaultComboBoxModel noIdea = new DefaultComboBoxModel();
        ArrayList<Instructor> ds = Instructor.getInstructors();
        for(int i=0; i<ds.size(); i++){
            noIdea.addElement(ds.get(i).getName());
        }
        return noIdea;
    }
    
}
