package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Student;

public class RemoveGradedCourseController {
    public static boolean removeGradedCourse(int selectedStudent, int selectedCourse){
        Student s = Student.getStudent(selectedStudent);
        
        DBConnector db = new DBConnector();
        
        boolean remove = db.removeGradedCourse(selectedStudent, selectedCourse);
        
        if(remove){
            s.removeGradedCourse(selectedCourse);
            return true;
        }
        return false;
    } 
}
