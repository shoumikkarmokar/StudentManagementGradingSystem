package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.GradedCourse;
import gradingsystem.Entities.Student;
import java.util.ArrayList;

/**
 *
 * @author Hossam
 */
public class CalculateGPAController {
    public static String calculateGPA(int selectedStudent){
        double gradeSum = 0;
        Student s = Student.getStudent(selectedStudent);
        
        ArrayList<GradedCourse> gcs = s.getGradedcourses();
        if(gcs != null && !gcs.isEmpty()){
            for(GradedCourse gc: gcs){
                gradeSum += gc.getGrade();
            }
            gradeSum /= gcs.size();
            gradeSum = Math.round(gradeSum*100); 
            s.setGpa((float)(gradeSum/100));
            
            DBConnector db = new DBConnector();
            db.updateStudentGPA(selectedStudent, Float.parseFloat((gradeSum/100) + ""));
            
            return (gradeSum/100) + "";       
        }
        return 0.0 + "";
    }
}
