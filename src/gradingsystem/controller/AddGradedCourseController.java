package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Course;
import gradingsystem.Entities.Departement;
import gradingsystem.Entities.GradedCourse;
import gradingsystem.Entities.Student;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class AddGradedCourseController {
    static public DefaultComboBoxModel getCourse(int selectedStudent){
        Student s = Student.getStudent(selectedStudent);
        Departement d = s.getDepartment();
        ArrayList<Course> cs = d.getCourses();
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        for(int i=0; i<cs.size(); i++){
            cbm.addElement(cs.get(i).getName());
        }
        return cbm;
    }
    
    static public void addCourse(int selectedStudent, int selectedCourse, float grade){
        Student s = Student.getStudent(selectedStudent);
        Departement d = s.getDepartment();
        Course c = d.getCourse(selectedCourse);
        
        GradedCourse gc = new GradedCourse(selectedCourse, selectedStudent, grade);
    }
    
    public static void addGradedCourseToDatabase(String Pid, String Cid, String Grade){
        DBConnector db = new DBConnector();
        
        db.addGradedCourse(Pid, Cid, Grade);
        
        Student s = Student.getStudent(Integer.parseInt(Pid));
        
        Departement d = s.getDepartment();
        Course c = d.getCourse(Cid);
        
        GradedCourse gc = new GradedCourse(Integer.parseInt(Cid), Integer.parseInt(Pid), Float.parseFloat(Grade));
    }
}
