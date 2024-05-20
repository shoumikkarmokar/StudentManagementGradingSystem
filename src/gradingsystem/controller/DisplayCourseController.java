package gradingsystem.controller;

import gradingsystem.Entities.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Hossam
 */

public class DisplayCourseController {
    static public ArrayList<String> getCourses(int selectedDepartment){
        Departement d = Departement.getDepartement(selectedDepartment);
        ArrayList<Course> cs = d.getCourses();
        ArrayList<String> ss = new ArrayList<>();
        for(int i=0; i<cs.size(); i++){
            ss.add(cs.get(i).getName());
        }
        return ss;
    }
    
    static public ArrayList<String[]> getGradedCourse(int selectedStudent){
        Student s = Student.getStudent(selectedStudent);
        if(s.getGradedcourses() == null){
            return new ArrayList<>();
        }
        ArrayList<GradedCourse> gcs = s.getGradedcourses();
        ArrayList<String[]> ss = new ArrayList<>();
        for(int i=0; i<gcs.size(); i++){
            String[] str = {gcs.get(i).getCourse().getName(), "" + gcs.get(i).getGrade()};
            ss.add(str);
        }
        return ss;
    }
    
}
